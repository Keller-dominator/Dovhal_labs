
import java.util.Collection;
import java.util.Set;
import java.util.Arrays;
import java.util.Iterator;

public class SweetsCollection<T> implements Set<Sweets> {

    private int size;
    private double increasePercent = 1.3;
    private Object[] elements = new Object[15];
    public SweetsCollection(){
        size = 0;
    }
    public SweetsCollection(Sweets o){
        size = 1;
        elements[0] = o;
    }
    public SweetsCollection(Collection<? extends Sweets> o){
        size = 0;
        addAll(o);
    }
    private void increaseSize(){
        Object[] temporary = elements;
        elements = new Object[(int)(elements.length*increasePercent)];
        size = 0;
        for(Object t:temporary){
            add((Sweets)t);
        }
    }
    @Override
    public void clear(){
        for (int i = 0; i<elements.length; i++){
            elements[i] = null;
        }
        size = 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public boolean contains(Object o){
        for (int i = 0; i<elements.length; i++){
            if (elements[i] == o){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean containsAll(Collection<?> c){
        MyIterator iterator = (MyIterator)c.iterator();
        while (iterator.hasNext()) {
            if (!contains(iterator.next())){
                return false;
            }
        }
        return true;
    }
    @Override
    public Object[] toArray(){
        return Arrays.copyOf(elements, size);
    }
    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            return (E[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;

    }
    @Override
    public boolean add(Sweets e){
        if (!contains(e)) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    size++;
                    elements[i] = e;
                    return true;
                }
            }
            increaseSize();
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    size++;
                    elements[i] = e;
                    return true;
                }
            }
        }
        return false;
    }
    private int lastNotEmpty(){
        int i = elements.length-1;
        while (elements[i]==null) { i--; }
        return i+1;
        }
    @Override
    public boolean remove(Object o){
        if(size==0){
            return false;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i]==o){
                size--;
                elements[i]=elements[lastNotEmpty()];
                elements[lastNotEmpty()]= null;
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends Sweets> c){
        MyIterator iterator = (MyIterator)c.iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    add((Sweets)iterator.next());
                }
            }
            increaseSize();
        }
        return true;
    }
    @Override
    public boolean retainAll(Collection<?> c){
        boolean flag = false;
            for (Object i: elements) {
                if (!c.contains(i)){
                    flag |= remove(i);
                }
        }
        return flag;
    }
    @Override
    public boolean removeAll(Collection<?> c){
        boolean flag = false;
        for (Object o:c){
            flag |= remove(o);
        }
        return flag;
    }
    @Override
    public Iterator<Sweets> iterator(){
        return new MyIterator();
    }
    private class MyIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index<lastNotEmpty();
        }

        @Override
        public Object next() {
            while (hasNext()){
                if(elements[index] == null) {
                    index++;
                }
                else{
                    return elements[index++];
                }
            }
            return null;
        }
    }
}

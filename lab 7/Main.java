public class Main {

    public static void main(String[] args) {

        Sweets roasting = new Vegetable("Грильяж", 18);
        Sweets souffle = new Vegetable("Суфле", 16);
        Sweets fudge = new Vegetable("Помадка", 40);
        Sweets truffle = new Vegetable("Трюфель", 25);
        Sweets fondant = new Vegetable("Помадные", 41);
        Sweets marzipan = new Vegetable("Марципановые", 77);
        Sweets jelly = new Vegetable("Желейные", 0);
        Sweets pralines = new Vegetable("Пралиновые", 15);
        Sweets liquor = new Vegetable("Ликерные", 16);

        SweetsCollection<Sweet> plate = new SweetsCollection<>();
        SweetsCollection<Sweet> plate2 = new SweetsCollection<>(truffle);

        plate2.add(truffle);
        plate2.add(fudge);
        plate2.add(jelly);

        plate.add(roasting);
        plate.add(fondant);
        plate.add(marzipan);
        plate.add(liquor);
        plate.add(souffle);
        plate.add(pralines);
        plate.add(pralines);
        plate.add(pralines);
        plate.add(pralines);
        plate.add(pralines);
        plate.add(pralines);
        plate.remove(roasting);
        plate.add(jelly);

        SweetsCollection<Sweet> plate3 = new SweetsCollection<>(plate2);
        plate3.remove(liquor);
        plate3.remove(fondant);

        System.out.println("Тарелка конфет");
        for (Sweet i: plate) {
            i.print();
        }

        System.out.println("Тарелка конфет 2");
        for (Sweet i: plate2) {
            i.print();
        }

        System.out.println("Тарелка конфет 3");


        for (Sweet i: plate3) {
            i.print();
        }
        System.out.println("Чи входять всі елементи plate3 в plate2: " + plate2.containsAll(plate3));
        System.out.println("Чи входять всі елементи plate2 в plate: " + plate.containsAll(plate2));

        salad.removeAll(plate2);

        System.out.println("З тарілки видалено всі інгредієнти тарілки 2");
        for (Sweet i: plate) {
            i.print();
        }

        plate.addAll(plate3);

        System.out.println("До тарілки додано всі інгредієнти тарілки 3");
        for (Sweet i: plate) {
            i.print();
        }

        plate.retainAll(plate3);

        System.out.println("З тарілки видалено все, що не входить у тарілки 3");
        for (Sweet i: plate) {
            i.print();
        }
        System.out.printf("Розміри тарілок:\n1-ший: %5d\n2-гий: %5d\n3-тій: %5d\n",plate.size(),plate2.size(),plate3.size());
    }
}

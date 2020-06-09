package Lab4;

import java.util.Arrays;


public class Lab4 {

    public static void main(String[] args) {
        Plane Plane1 = new Plane ("Військовий", 35, 4, "жовтогарячий", 2);
        Plane Plane2 = new Plane ("Пасажирський", 20, 6, "зелений", 125);
        Plane Plane3 = new Plane ("Поштовий", 60, 2, "жовтий", 2);
        Plane Plane4 = new Plane ("Військовий", 25, 3, "зелений", 6);
        Plane Plane5 = new Plane ("Пасажирський", 45, 4, "фіолетовий", 225);
        Plane Array[] = {Plane1, Plane2, Plane3, Plane4, Plane5};
        Arrays.sort(Array, new ByType());
        System.out.println("Сортування літаків за типом у алфавітному порядку (у порядку зростання):");
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i].Type);
        }
        System.out.println("Сортування літаків за кількістю двигунів у спадаючому порядку:");
        Arrays.sort(Array, new ByAmount());
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i].AmountOfEngines);
        }
    }
}
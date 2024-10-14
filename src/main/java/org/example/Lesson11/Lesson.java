package org.example.Lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    public static void monthList() {

        List<String> month = new ArrayList<>();
        month.add("May");
        month.add("April");
        month.add("December");

        System.out.println(month);
    }
    public static void checkCash() {
        int cash = 100;
        //Тернарный оператор (if)
        String result = cash > 60 ? "Покупка успешна":"Недостаточно средств";

        System.out.println(result);
    }
    int[] numbers = {3, 5 , 6 ,12};
    public void cycleFor () {
        for(int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]);
        }
    }

    public static void namesList() {
        List<String> names = new ArrayList<>();
        names.add("Петя");
        names.add("Вася");
        names.add("Лена");
        names.add("Ибрагим");

        //Цикл for each
        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names.get(i));
        }
        for (String s:names) {
            System.out.println(s);
        }
    }
    public static void whileDo() {
        int cash = 100;

        while (cash > 0) {
            System.out.println("Ещё не все потратила");
            cash = cash - 20;
            System.out.println("В кармане денег - " + cash);
        };
        System.out.println("Осталось денег - " + cash);
    }

    public static void doWhile() {
        int cash = 0;
        do {
            System.out.println("Работаю....");
            cash = cash + 34;
            System.out.println("В кармане денег - " + cash);
        } while (cash < 100);

        System.out.println("Накопил - " + cash);
    }

}

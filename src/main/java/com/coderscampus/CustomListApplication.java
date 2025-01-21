package com.coderscampus;

public class CustomListApplication {
    public static void main(String[] args) {
        list1();
        System.out.println();
        list2();
    }

    private static void list1() {
        System.out.println("List 1");
        System.out.println("------");
        String[] surNameArray = {
                "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
                "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez",
                "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker"
        };

        CustomList<String> surnames = new CustomArrayList<>();

        for (String newSurname : surNameArray) {
            surnames.add(newSurname);
        }

        System.out.println("Size: " + surnames.getSize());
        for (int i = 0; i < surnames.getSize(); i++) {
            System.out.println(surnames.get(i));
        }
    }

    private static void list2() {
        System.out.println("List 2");
        System.out.println("------");

        CustomList<String> droneList = new CustomArrayList<>();

        for (int i = 1; i <= 100; i++) {
            droneList.add("drone " + i);
        }

        System.out.println("Size: " + droneList.getSize());
        for (int i = 0; i < droneList.getSize(); i++) {
            System.out.println(droneList.get(i));
        }
    }
}
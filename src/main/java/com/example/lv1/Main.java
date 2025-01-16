package com.example.lv1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk();
        kiosk.start();

    }
}

// MenuItem 클래스: 메뉴 아이템 속성을 정의
class MenuItem {
    private String name;
    private double price;
    private String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + "   | W " + price + " | " + description;
    }
}

// Menu 클래스: MenuItem을 관리하는 클래스
class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public void displayMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("0. 종료      | 종료");
    }

    public MenuItem getMenuItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public int getSize() {
        return items.size();
    }
}

// Kiosk 클래스: 프로그램의 흐름 제어
class Kiosk {
    private Menu menu;

    public Kiosk() {
        menu = new Menu();
        initializeMenu();
    }

    private void initializeMenu() {
        menu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.displayMenu();
            System.out.print("번호를 입력하세요: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menu.getSize()) {
                MenuItem selected = menu.getMenuItem(choice - 1);
                System.out.println(selected.getName() + "를 선택하셨습니다.\n");
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
            }
        }
        scanner.close();
    }
}

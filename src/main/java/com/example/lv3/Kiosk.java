package com.example.lv3;

import java.util.Scanner;

public class Kiosk {
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
            System.out.println("1. 메뉴 추가\n2. 메뉴 보기\n0. 종료");
            System.out.print("번호를 입력하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice == 1) {
                System.out.print("메뉴 이름: ");
                String name = scanner.nextLine();

                System.out.print("메뉴 가격: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // 버퍼 비우기

                System.out.print("메뉴 설명: ");
                String description = scanner.nextLine();

                menu.addMenuItem(new MenuItem(name, price, description));
                System.out.println("메뉴가 추가되었습니다.\n");

            } else if (choice == 2) {
                menu.displayMenu();
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
            }
        }
        // 메모리 누수 방지
        scanner.close();
    }
}

package com.example.lv5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk() {
        this.menus = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("[ MAIN MENU ]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
                }
                System.out.println("0. 종료 | 종료");

                System.out.print("메뉴를 선택하세요: ");
                int mainChoice = Integer.parseInt(scanner.nextLine());
                if (mainChoice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if (mainChoice >= 1 && mainChoice <= menus.size()) {
                    Menu selectedMenu = menus.get(mainChoice - 1);
                    selectedMenu.showMenuItems();

                    System.out.print("메뉴를 선택하세요: ");
                    int itemChoice = Integer.parseInt(scanner.nextLine());
                    if (itemChoice == 0) {
                        continue; // 뒤로가기
                    }

                    if (itemChoice >= 1 && itemChoice <= selectedMenu.getMenuItems().size()) {
                        MenuItem selectedItem = selectedMenu.getMenuItems().get(itemChoice - 1);
                        System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() +
                                " | " + selectedItem.getDescription());
                    } else {
                        System.out.println("올바른 메뉴 번호를 입력해주세요.");
                    }
                } else {
                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println("예기치 못한 오류가 발생했습니다: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

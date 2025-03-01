package com.example.lv5;

public class Main {
    public static void main(String[] args) {
        // Menu 생성
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuItem(new MenuItem("Coke", 2.5, "시원한 콜라"));
        drinkMenu.addMenuItem(new MenuItem("Sprite", 2.5, "청량한 스프라이트"));
        drinkMenu.addMenuItem(new MenuItem("Water", 1.0, "생수"));

        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.addMenuItem(new MenuItem("Ice Cream", 3.0, "바닐라 아이스크림"));
        dessertMenu.addMenuItem(new MenuItem("Brownie", 4.5, "초콜릿 브라우니"));

        // Kiosk 생성 및 실행
        Kiosk kiosk = new Kiosk();
        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(drinkMenu);
        kiosk.addMenu(dessertMenu);
        kiosk.start();
    }
}

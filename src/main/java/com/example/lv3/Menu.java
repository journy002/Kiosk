package com.example.lv3;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

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
        System.out.println("0. 종료 | 종료");
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

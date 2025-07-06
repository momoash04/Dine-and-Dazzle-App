package com.example.adv_software_project;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<MenuItem> menuItems;

    public Category(String name) {
        this.name = name;
        this.menuItems = new ArrayList<>();
    }

    public Category(String name, List<MenuItem> menuItems) {
        this.name = name;
        this.menuItems = new ArrayList<>(menuItems);
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public MenuItem findMenuItem(String name) {
        for (MenuItem item : menuItems) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}

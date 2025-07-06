package com.example.adv_software_project;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Category> categories;

    public Menu() {
        this.categories = new ArrayList<>();
    }

    public void addMenuItem(String categoryName, MenuItem item) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                category.addMenuItem(item);
                return;
            }
        }
        Category newCategory = new Category(categoryName);
        newCategory.addMenuItem(item);
        categories.add(newCategory);
    }

    public List<MenuItem> getItemsByCategory(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return category.getMenuItems();
            }
        }
        return new ArrayList<>();
    }

    public void displayMenu() {
        int i=1;
        for (Category category : categories) {
            System.out.println(category.getName()+":");
            for (MenuItem menuItem : category.getMenuItems()) {
                System.out.println(i+") "+menuItem.getName()+": "+menuItem.getPrice());
                i++;
            }
            System.out.println("");
        }
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category findCategories(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        return null;
    }
}


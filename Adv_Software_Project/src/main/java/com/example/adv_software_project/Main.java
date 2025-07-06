package com.example.adv_software_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    List<User> users = new ArrayList<User>();
    User u = new User("sallam","1234");
    users.add(u);
    users.add(new User("abdo","1111"));
    users.add(new User("boudy","2222"));

    Menu menu = new Menu();
    menu.addMenuItem("Chicken Burgers",new MenuItem("crunchy chicken",30));
    menu.addMenuItem("Chicken Burgers",new MenuItem("grilled chicken",30));
    menu.addMenuItem("Chicken Burgers",new MenuItem("chicken wrap ",35));
    menu.addMenuItem("Chicken Burgers",new MenuItem("santa fe chicken",40));
    menu.addMenuItem("Chicken Burgers",new MenuItem("hot bird (spicy)",45));

    menu.addMenuItem("Beef Burgers",new MenuItem("cheese burger",30));
    menu.addMenuItem("Beef Burgers",new MenuItem("cowboy barbeque",35));
    menu.addMenuItem("Beef Burgers",new MenuItem("cheese madness",40));
    menu.addMenuItem("Beef Burgers",new MenuItem("D&D burger",45));
    menu.addMenuItem("Beef Burgers",new MenuItem("mushroom lover",50));

    menu.addMenuItem("Side Items",new MenuItem("fries",10));
    menu.addMenuItem("Side Items",new MenuItem("tenders",20));
    menu.addMenuItem("Side Items",new MenuItem("wedges",15));
    menu.addMenuItem("Side Items",new MenuItem("cheesy dynamite",25));
    menu.addMenuItem("Side Items",new MenuItem("onion rings",10));

    menu.addMenuItem("Add-Ons",new MenuItem("cheese sause",5));
    menu.addMenuItem("Add-Ons",new MenuItem("barbeque",5));
    menu.addMenuItem("Add-Ons",new MenuItem("turkey bacon",10));
    menu.addMenuItem("Add-Ons",new MenuItem("D&D sauce",15));
    menu.addMenuItem("Add-Ons",new MenuItem("jalapeno",10));

    menu.displayMenu();

    u.incrementQuantity(menu.findCategories("Chicken Burgers").findMenuItem("grilled chicken"));
    u.incrementQuantity(menu.findCategories("Side Items").findMenuItem("fries"));
    u.incrementQuantity(menu.findCategories("Add-Ons").findMenuItem("D&D sauce"));

    u.getCart();
    u.pay();
    u.getPastOrders();
    }
}

package com.example.adv_software_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class MenuController {
    private User user;

    public MenuController() {
        user = UserSession.getInstance().getLoggedInUser() ;
    }
    private Scene currentScene;
    public void setCurrentScene(Scene scene) {
        this.currentScene = scene;
    }

    public void setUser(User user) {
        this.user = UserSession.getInstance().getLoggedInUser() ;
    }
    @FXML
    public Button Pay;
    @FXML
    public Label TotalPrice;
    @FXML
    public Pane creditpay;
    @FXML
    public RadioButton Cash;
    @FXML
    public RadioButton Credit;
    @FXML
    public Label Total;
    @FXML
    public VBox cartVbox;
    @FXML
    public ScrollPane cartScrollPane;
    @FXML
    public Label MenuItemName;
    @FXML
    public Label MenuItemQuantity;
    @FXML
    public Label MenuItemPrice;
    @FXML
    public Label Cart;
    @FXML
    public Label Chbrgr;
    @FXML
    public Label Grilled;
    @FXML
    public Label Crunchy;
    @FXML
    public Label Wrap;
    @FXML
    public Label Santafe;
    @FXML
    public Label Hotbird;
    @FXML
    public Label Cheese;
    @FXML
    public Label Cowboy;
    @FXML
    public Label Madness;
    @FXML
    public Label DD;
    @FXML
    public Label Mushroom;
    @FXML
    public Label Fries;
    @FXML
    public Label Tenders;
    @FXML
    public Label Wedges;
    @FXML
    public Label Dynamite;
    @FXML
    public Label Rings;
    @FXML
    public Label Cheesesauce;
    @FXML
    public Label Bbq;
    @FXML
    public Label Turkey;
    @FXML
    public Label Dsauce;
    @FXML
    public Label Jalapeneo;

    @FXML
    private Button commonElement;

    @FXML
    private void switchToHome(MouseEvent event) {
        try {
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Close the current stage (homepage)
            currentStage.close();

            // Create a new stage (login page)
            Stage HomeStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("User-Homepage.fxml"));
            Parent HomeRoot = loader.load();
            // Create the login page scene

            Scene loginScene =  new Scene(HomeRoot);

            // Set the title and scene for the login stage
            HomeStage.setTitle("Dine&Dazzle");
            Image logo = new Image(getClass().getResourceAsStream("images/logo.png"));
            HomeStage.getIcons().add(logo);
            HomeStage.setScene(loginScene);

            // Show the new login stage
            HomeStage.show();

        } catch (Exception e) {
            // Catch and log the exception, showing an error message
            e.printStackTrace();
            // Optionally, show a dialog to the user
            showError("An error occurred while switching scenes: " + e.getMessage());
        }
    }
    @FXML
    private void Beef (MouseEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Beef.fxml"));
            Parent beef = loader.load();

            // Get the controller and set the user and scene
            MenuController menuController = loader.getController();
            menuController.setUser(user);
            menuController.setCurrentScene(new Scene(beef));

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(menuController.currentScene);
            stage.show();

            // Update labels after scene change
            menuController.beefupdateMenuLabels();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Chicken (MouseEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Chicken.fxml"));
            Parent chicken = loader.load();

            // Get the controller and set the user and scene
            MenuController menuController = loader.getController();
            menuController.setUser(user);
            menuController.setCurrentScene(new Scene(chicken)); // Set the scene here

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(menuController.currentScene); // Use the stored scene
            stage.show();

            // Update labels after scene change
            menuController.chickenupdateMenuLabels();
            ;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Sideitems (MouseEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Side-Items.fxml"));
            Parent side = loader.load();

            // Get the controller and set the user and scene
            MenuController menuController = loader.getController();
            menuController.setUser(user);
            menuController.setCurrentScene(new Scene(side));

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(menuController.currentScene);
            stage.show();

            // Update labels after scene change
            menuController.SideupdateMenuLabels();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Addons (MouseEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Add-Ons.fxml"));
            Parent addons = loader.load();

            // Get the controller and set the user and scene
            MenuController menuController = loader.getController();
            menuController.setUser(user);
            menuController.setCurrentScene(new Scene(addons));

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(menuController.currentScene);
            stage.show();

            // Update labels after scene change
            menuController.AddsupdateMenuLabels();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showError(String message) {
        // Here you could create an alert or another mechanism to show the error to the user.
        System.err.println(message);
    }
    @FXML
    private void PaytoHome(MouseEvent event) {
        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        // Close the current stage (homepage)
        currentStage.close();
        Stage loadingStage = new Stage();
        loadingStage.initModality(Modality.APPLICATION_MODAL);
        loadingStage.initStyle(StageStyle.UNDECORATED);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Loading.fxml"));
        Parent loading = null;
        try {
            loading = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene loadingScene = new Scene(loading);
        loadingStage.setScene(loadingScene);

        // Show the loading popup
        loadingStage.show();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Switch to homepage
                javafx.application.Platform.runLater(() -> {
                    loadingStage.close();

                    try {
                        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

                        // Close the current stage (homepage)
                        currentStage.close();

                        // Create a new stage (login page)
                        Stage HomeStage = new Stage();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("User-Homepage.fxml"));
                        Parent HomeRoot = loader.load();
                        // Create the login page scene

                        Scene HomeScene = new Scene(HomeRoot);

                        // Set the title and scene for the login stage
                        HomeStage.setTitle("Dine&Dazzle");
                        Image logo = new Image(getClass().getResourceAsStream("images/logo.png"));
                        HomeStage.getIcons().add(logo);
                        HomeStage.setScene(HomeScene);

                        // Show the new login stage
                        HomeStage.show();
                        List<OrderItem> cart = user.getCart();
                        cart.clear();

                    } catch (Exception e) {
                        // Catch and log the exception, showing an error message
                        e.printStackTrace();
                        // Optionally, show a dialog to the user
                        showError("An error occurred while switching scenes: " + e.getMessage());
                    }
                });
            }
        },1000);
    }
    @FXML
    private void Cart (MouseEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
            Parent cart = loader.load();

            // Get the controller and set the user and scene
            MenuController menuController = loader.getController();
            menuController.setUser(user);
            menuController.setCurrentScene(new Scene(cart));

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(menuController.currentScene);
            stage.show();

            // Update labels after scene change
            menuController.CartupdateMenuLabels();
            menuController.returncart();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   private void CartupdateMenuLabels(){
       double sum = 0;
       List<OrderItem> cart = user.getCart();
       if (cart != null) {
           for (OrderItem orderItem : cart) {
               int quantity = orderItem.getQuantity();
               double price = orderItem.getMenuItem().getPrice();
               sum = (quantity*price) + sum ;
               System.out.println("Passed by");
           }
           Total.setText(String.valueOf(sum));


       }
   }
   private void PayPrice(){
        double sum = 0;
        List<OrderItem> cart = user.getCart();
        if (cart != null) {
            for (OrderItem orderItem : cart) {
                int quantity = orderItem.getQuantity();
                double price = orderItem.getMenuItem().getPrice();
                sum = (quantity*price) + sum ;
                System.out.println("Passed by");
            }
            TotalPrice.setText(String.valueOf(sum));


        }
    }
   @FXML
   private void returncart(){
       double sum = 0;
       List<OrderItem> cart = user.getCart();
       // Clear the VBox to avoid duplicating items on multiple calls
       cartVbox.getChildren().clear();
       if (!cart.isEmpty()) {
           for (OrderItem orderItem : cart) {
               String name = orderItem.getMenuItem().getName();
               int quantity = orderItem.getQuantity();
               double price = orderItem.getMenuItem().getPrice();
               sum = (quantity*price);
               HBox itemBox = new HBox(10); // Spacing of 10 between elements
               itemBox.setStyle("-fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 1; -fx-background-color: #f2f2f2;");
               // Create labels for item details
               MenuItemName = new Label("Name: " + name);
               MenuItemQuantity = new Label("Quantity: " + quantity);
               MenuItemPrice = new Label("Price: " + sum);
               MenuItemName.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
               MenuItemQuantity.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
               MenuItemPrice.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
               // Add labels to the HBox
               itemBox.getChildren().addAll(MenuItemName, MenuItemQuantity, MenuItemPrice);

               // Add the HBox to the VBox
               cartVbox.getChildren().add(itemBox);
           }
           cartScrollPane.setContent(cartVbox);
       }
       else if(cart.isEmpty()){
           HBox noitems = new HBox(10);
           noitems.setStyle("-fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 1; -fx-background-color: #f2f2f2;");
           Label zeroitems = new Label();
           zeroitems.setText("No items in your cart :(");
           zeroitems.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
           noitems.setAlignment(Pos.CENTER);
           noitems.getChildren().add(zeroitems);
           cartVbox.getChildren().add(noitems);
           cartVbox.setAlignment(Pos.CENTER);
           cartScrollPane.setContent(cartVbox);
       }

    }
    @FXML
    private void ShowCashPayment(MouseEvent event){
        if(Cash.isSelected()){
            Credit.setSelected(false);
            creditpay.setVisible(false);
        }
        else{
            Cash.setSelected(false);
            creditpay.setVisible(true);
            Credit.setSelected(true);
        }
    }
    @FXML
    private void ShowCreditPayment(MouseEvent event){
        if(Credit.isSelected()){
            Cash.setSelected(false);
            creditpay.setVisible(true);
        }
        else{
            Cash.setSelected(true);
            creditpay.setVisible(false);
            Credit.setSelected(false);
        }
    }
    @FXML
    private void Payment (MouseEvent event){
        try {
            List<OrderItem> cart = user.getCart();
            if(cart.isEmpty()) {
                Pay.setDisable(true);
            }
            else {
                Pay.setDisable(false);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
                Parent Payment = loader.load();

                // Get the controller and set the user and scene
                MenuController menuController = loader.getController();
                menuController.setUser(user);
                menuController.setCurrentScene(new Scene(Payment));

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(menuController.currentScene);
                stage.show();

                // Update labels after scene change
                menuController.PayPrice();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addItem (MouseEvent event){

    }


public void chickenupdateMenuLabels() {
    // Get the current scene
    Scene currentScene = Grilled.getScene();

    // Check if the scene is null (this might happen before any scene is set)
    if (currentScene == null) {
        return; // Or handle it appropriately
    }

    // Initialize a map to store quantities for each menu item
    HashMap<String, Integer> itemQuantities = new HashMap<>();

    // Get the cart from the user
    int sum = 0;
    List<OrderItem> cart = user.getCart();
    if (cart != null) {
        for (OrderItem orderItem : cart) {
            String itemName = orderItem.getMenuItem().getName();
            int quantity = orderItem.getQuantity();
            sum = quantity + sum ;
            itemQuantities.put(itemName, itemQuantities.getOrDefault(itemName, 0) + quantity);
        }
        Cart.setText(String.valueOf(sum));
        Grilled.setText(String.valueOf(itemQuantities.getOrDefault("Grilled Chicken", 0)));
        Crunchy.setText(String.valueOf(itemQuantities.getOrDefault("Crunchy Chicken", 0)));
        Wrap.setText(String.valueOf(itemQuantities.getOrDefault("Chicken Wrap", 0)));
        Santafe.setText(String.valueOf(itemQuantities.getOrDefault("Santafe Chicken", 0)));
        Hotbird.setText(String.valueOf(itemQuantities.getOrDefault("Hotbird Chicken", 0)));
    }
}
        public void beefupdateMenuLabels() {
            // Get the current scene
            Scene currentScene = Chbrgr.getScene();

            // Check if the scene is null (this might happen before any scene is set)
            if (currentScene == null) {
                return; // Or handle it appropriately
            }

            // Initialize a map to store quantities for each menu item
            HashMap<String, Integer> itemQuantities = new HashMap<>();

            // Get the cart from the user
            int sum = 0;
            List<OrderItem> cart = user.getCart();
            if (cart != null) {
                for (OrderItem orderItem : cart) {
                    String itemName = orderItem.getMenuItem().getName();
                    int quantity = orderItem.getQuantity();
                    sum = quantity + sum ;
                    itemQuantities.put(itemName, itemQuantities.getOrDefault(itemName, 0) + quantity);
                }
                Cart.setText(String.valueOf(sum));
                Chbrgr.setText(String.valueOf(itemQuantities.getOrDefault("Cheese burger", 0)));
                Cowboy.setText(String.valueOf(itemQuantities.getOrDefault("Cowboy Barbeque", 0)));
                Madness.setText(String.valueOf(itemQuantities.getOrDefault("Cheese Madness burger", 0)));
                DD.setText(String.valueOf(itemQuantities.getOrDefault("D&D burger", 0)));
                Mushroom.setText(String.valueOf(itemQuantities.getOrDefault("Mushroom burger", 0)));
            }
        }
        public void SideupdateMenuLabels() {
            // Get the current scene
            Scene currentScene = Fries.getScene();

            // Check if the scene is null (this might happen before any scene is set)
            if (currentScene == null) {
                return; // Or handle it appropriately
            }

            // Initialize a map to store quantities for each menu item
            HashMap<String, Integer> itemQuantities = new HashMap<>();

            // Get the cart from the user
            int sum = 0;
            List<OrderItem> cart = user.getCart();
            if (cart != null) {
                for (OrderItem orderItem : cart) {
                    String itemName = orderItem.getMenuItem().getName();
                    int quantity = orderItem.getQuantity();
                    sum = quantity + sum ;
                    itemQuantities.put(itemName, itemQuantities.getOrDefault(itemName, 0) + quantity);
                }
                Cart.setText(String.valueOf(sum));
                Fries.setText(String.valueOf(itemQuantities.getOrDefault("Fries", 0)));
                Tenders.setText(String.valueOf(itemQuantities.getOrDefault("Tenders", 0)));
                Wedges.setText(String.valueOf(itemQuantities.getOrDefault("Wedges", 0)));
                Dynamite.setText(String.valueOf(itemQuantities.getOrDefault("Dynamite", 0)));
                Rings.setText(String.valueOf(itemQuantities.getOrDefault("Rings", 0)));
            }
        }
            public void AddsupdateMenuLabels() {
                // Get the current scene
                Scene currentScene = Dsauce.getScene();

                // Check if the scene is null (this might happen before any scene is set)
                if (currentScene == null) {
                    return; // Or handle it appropriately
                }

                // Initialize a map to store quantities for each menu item
                HashMap<String, Integer> itemQuantities = new HashMap<>();

                // Get the cart from the user
                int sum = 0;
                List<OrderItem> cart = user.getCart();
                if (cart != null) {
                    for (OrderItem orderItem : cart) {
                        String itemName = orderItem.getMenuItem().getName();
                        int quantity = orderItem.getQuantity();
                        sum = quantity + sum ;
                        itemQuantities.put(itemName, itemQuantities.getOrDefault(itemName, 0) + quantity);
                    }
                    Cart.setText(String.valueOf(sum));
                    Cheesesauce.setText(String.valueOf(itemQuantities.getOrDefault("Cheesesauce", 0)));
                    Bbq.setText(String.valueOf(itemQuantities.getOrDefault("Bbq", 0)));
                    Turkey.setText(String.valueOf(itemQuantities.getOrDefault("Turkey", 0)));
                    Dsauce.setText(String.valueOf(itemQuantities.getOrDefault("Dsauce", 0)));
                    Jalapeneo.setText(String.valueOf(itemQuantities.getOrDefault("Jalapeneo", 0)));
                }

            }

    @FXML
    private void incrementChbrgr() {
        MenuItem chbrgrItem = new MenuItem("Cheese burger", 190);
        user.incrementQuantity(chbrgrItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void decrementChbrgr() {
        MenuItem chbrgrItem = new MenuItem("Cheese burger", 190);
        user.decrementQuantity(chbrgrItem);
        beefupdateMenuLabels();
    }
    @FXML
    private void incrementCowboy() {
        MenuItem cowboyItem = new MenuItem("Cowboy Barbeque", 170.0);
        user.incrementQuantity(cowboyItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void decrementCowboy() {
        MenuItem cowboyItem = new MenuItem("Cowboy Barbeque", 170.0);
        user.decrementQuantity(cowboyItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void incrementMadness() {
        MenuItem madnessItem = new MenuItem("Cheese Madness burger", 150.0);
        user.incrementQuantity(madnessItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void decrementMadness() {
        MenuItem madnessItem = new MenuItem("Cheese Madness burger", 150.0);
        user.decrementQuantity(madnessItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void incrementDD() {
        MenuItem ddItem = new MenuItem("D&D burger", 180.0); // Assuming price is 180 L.E.
        user.incrementQuantity(ddItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void decrementDD() {
        MenuItem ddItem = new MenuItem("D&D burger", 180.0);
        user.decrementQuantity(ddItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void incrementMushroom() {
        MenuItem mushroomItem = new MenuItem("Mushroom burger", 210.0); // Assuming price is 210 L.E.
        user.incrementQuantity(mushroomItem);
        beefupdateMenuLabels();
    }

    @FXML
    private void decrementMushroom() {
        MenuItem mushroomItem = new MenuItem("Mushroom burger", 210.0);
        user.decrementQuantity(mushroomItem);
        beefupdateMenuLabels();
    }
    @FXML
    private void incrementGrilled() {
        MenuItem grilledItem = new MenuItem("Grilled Chicken", 150);
        user.incrementQuantity(grilledItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void decrementGrilled() {
        MenuItem grilledItem = new MenuItem("Grilled Chicken", 150);
        user.decrementQuantity(grilledItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void incrementCrunchy() {
        MenuItem crunchyItem = new MenuItem("Crunchy Chicken", 180);
        user.incrementQuantity(crunchyItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void decrementCrunchy() {
        MenuItem crunchyItem = new MenuItem("Crunchy Chicken", 180);
        user.decrementQuantity(crunchyItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void incrementWrap() {
        MenuItem wrapItem = new MenuItem("Chicken Wrap", 110);
        user.incrementQuantity(wrapItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void decrementWrap() {
        MenuItem wrapItem = new MenuItem("Chicken Wrap", 110);
        user.decrementQuantity(wrapItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void incrementSantafe() {
        MenuItem santafeItem = new MenuItem("Santafe Chicken", 160);
        user.incrementQuantity(santafeItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void decrementSantafe() {
        MenuItem santafeItem = new MenuItem("Santafe Chicken", 160);
        user.decrementQuantity(santafeItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void incrementHotbird() {
        MenuItem hotbirdItem = new MenuItem("Hotbird Chicken", 190);
        user.incrementQuantity(hotbirdItem);
        chickenupdateMenuLabels();
    }

    @FXML
    private void decrementHotbird() {
        MenuItem hotbirdItem = new MenuItem("Hotbird Chicken", 190);
        user.decrementQuantity(hotbirdItem);
        chickenupdateMenuLabels();
    }
    @FXML
    private void incrementCheesesauce() {
        MenuItem cheesesauceItem = new MenuItem("Cheesesauce", 25.0);
        user.incrementQuantity(cheesesauceItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void decrementCheesesauce() {
        MenuItem cheesesauceItem = new MenuItem("Cheesesauce", 25.0);
        user.decrementQuantity(cheesesauceItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void incrementBbq() {
        MenuItem bbqItem = new MenuItem("Bbq", 20.0); // Replace 180.0 with the actual price
        user.incrementQuantity(bbqItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void decrementBbq() {
        MenuItem bbqItem = new MenuItem("Bbq", 20.0); // Replace 180.0 with the actual price
        user.decrementQuantity(bbqItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void incrementTurkey() {
        MenuItem turkeyItem = new MenuItem("Turkey", 50.0); // Replace 110.0 with the actual price
        user.incrementQuantity(turkeyItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void decrementTurkey() {
        MenuItem turkeyItem = new MenuItem("Turkey", 50.0); // Replace 110.0 with the actual price
        user.decrementQuantity(turkeyItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void incrementDsauce() {
        MenuItem dsauceItem = new MenuItem("Dsauce", 30.0); // Replace 160.0 with the actual price
        user.incrementQuantity(dsauceItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void decrementDsauce() {
        MenuItem dsauceItem = new MenuItem("Dsauce", 30.0); // Replace 160.0 with the actual price
        user.decrementQuantity(dsauceItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void incrementJalapeneo() {
        MenuItem jalapeneoItem = new MenuItem("Jalapeneo", 40.0); // Replace 190.0 with the actual price
        user.incrementQuantity(jalapeneoItem);
        AddsupdateMenuLabels();
    }

    @FXML
    private void decrementJalapeneo() {
        MenuItem jalapeneoItem = new MenuItem("Jalapeneo", 40.0); // Replace 190.0 with the actual price
        user.decrementQuantity(jalapeneoItem);
        AddsupdateMenuLabels();
    }
    @FXML
    private void incrementFries() {
        MenuItem friesItem = new MenuItem("Fries", 50.0); // Replace 150.0 with the actual price
        user.incrementQuantity(friesItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void decrementFries() {
        MenuItem friesItem = new MenuItem("Fries", 50.0); // Replace 150.0 with the actual price
        user.decrementQuantity(friesItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void incrementTenders() {
        MenuItem tendersItem = new MenuItem("Tenders", 80.0); // Replace 180.0 with the actual price
        user.incrementQuantity(tendersItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void decrementTenders() {
        MenuItem tendersItem = new MenuItem("Tenders", 80.0); // Replace 180.0 with the actual price
        user.decrementQuantity(tendersItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void incrementWedges() {
        MenuItem wedgesItem = new MenuItem("Wedges", 60.0); // Replace 110.0 with the actual price
        user.incrementQuantity(wedgesItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void decrementWedges() {
        MenuItem wedgesItem = new MenuItem("Wedges", 60.0); // Replace 110.0 with the actual price
        user.decrementQuantity(wedgesItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void incrementDynamite() {
        MenuItem dynamiteItem = new MenuItem("Dynamite", 90.0); // Replace 160.0 with the actual price
        user.incrementQuantity(dynamiteItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void decrementDynamite() {
        MenuItem dynamiteItem = new MenuItem("Dynamite", 90.0); // Replace 160.0 with the actual price
        user.decrementQuantity(dynamiteItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void incrementRings() {
        MenuItem ringsItem = new MenuItem("Rings", 70.0); // Replace 190.0 with the actual price
        user.incrementQuantity(ringsItem);
        SideupdateMenuLabels();
    }

    @FXML
    private void decrementRings() {
        MenuItem ringsItem = new MenuItem("Rings", 70.0); // Replace 190.0 with the actual price
        user.decrementQuantity(ringsItem);
        SideupdateMenuLabels();
    }

}
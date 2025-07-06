package com.example.adv_software_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.function.Consumer;

public class HelloController {
    private Consumer<User> onLoginCallback;
    @FXML
    private TextField usernameField;
    @FXML
    private Label ErrorName;
    @FXML
    private Label ErrorPass;
    @FXML
    private Label ErrorEmail;
    @FXML
    private Label ErrorPhone;
    @FXML
    private Label Erroraddress;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField Name;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField NewPasswordField;

    private User user = UserSession.getInstance().getLoggedInUser(); // Declare the user field
    @FXML
    private CheckBox show;
    @FXML
    private Button hotline;


    @FXML
    private void showPopup(MouseEvent event) {
        // Create a popup window
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Hotline Information");

        // Add content to the popup
        Label hotlineLabel = new Label("Hotline: 123-456-7890");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popupStage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(hotlineLabel, closeButton);
        layout.setStyle("-fx-padding: 10; -fx-alignment: center;");

        Scene popupScene = new Scene(layout, 250, 150);
        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }

    @FXML
    public void togglevisiblePassword(MouseEvent event) {
            if (show.isSelected()) {
                // Show password as plain text
                passwordTextfield.setText(passwordField.getText());
                passwordTextfield.setVisible(true);
                passwordField.setVisible(false);
            } else {
                // Hide password
                passwordField.setText(passwordTextfield.getText());
                passwordField.setVisible(true);
                passwordTextfield.setVisible(false);
            }
    }

    @FXML
    private void reservetoHome(MouseEvent event) {
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
   private void handlesignup(MouseEvent event) {
       String name = Name.getText().trim();
       String password = NewPasswordField.getText().trim();
       String phoneNumber = phoneNumberField.getText().trim();
       String email = emailField.getText().trim();
       String address = addressField.getText().trim();

       if(name.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || address.isEmpty()) {
           if (name.isEmpty()) {
               System.out.println("Username cannot be empty!");
               ErrorName.setVisible(true);

           }
           else{
               ErrorName.setVisible(false);
           }
           if (password.isEmpty()) {
               System.out.println("Password cannot be empty!");
               ErrorPass.setVisible(true);

           }
           else {
               ErrorPass.setVisible(false);
           }
           if (phoneNumber.isEmpty()) {
               System.out.println("Phone number cannot be empty!");
               ErrorPhone.setVisible(true);
           }
           else{
               ErrorPhone.setVisible(false);
           }
           if (email.isEmpty()) {
               System.out.println("Email cannot be empty!");
               ErrorEmail.setVisible(true);
           }
           else{
               ErrorEmail.setVisible(false);
           }
           if (address.isEmpty()) {
               System.out.println("Address cannot be empty!");
               Erroraddress.setVisible(true);
           }
           else{
               Erroraddress.setVisible(false);
           }
           return;
       }
       else{
           ErrorName.setVisible(false);
           ErrorPass.setVisible(false);
           ErrorPhone.setVisible(false);
           Erroraddress.setVisible(false);
           ErrorEmail.setVisible(false);
       }
       switchToLogin(event);
   }

    @FXML
    private void handleLogin(MouseEvent event) {
        // Get the text from the fields
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        if(username.isEmpty() || password.isEmpty()) {

            if (username.isEmpty()) {
                System.out.println("Username cannot be empty!");
                ErrorName.setVisible(true);

            }
            else{
                ErrorName.setVisible(false);
            }
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty!");
                ErrorPass.setVisible(true);

            }
            else {
                ErrorPass.setVisible(false);
            }
            return;
        }
        else {
            ErrorName.setVisible(false);
            ErrorPass.setVisible(false);
        }
        // Validate user login (for example, you might verify against a database or a hardcoded list)
        User loggedInUser = new User(username, password);
        // Store the logged-in user in UserSession
        UserSession.getInstance().setLoggedInUser(loggedInUser);

        // Navigate to home
        switchToHome(event);
    }

   @FXML
   private void switchToMenu(MouseEvent event) {
       try {
           User currentUser = UserSession.getInstance().getLoggedInUser();
           if (currentUser == null) {
               System.out.println("No user logged in! Redirecting to login...");
               switchToLogin(event);
               return;
           }

           // Load the Menu FXML file
           FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("Chicken.fxml"));
           Parent menuRoot = menuLoader.load();

           // Pass the user to the MenuController
           MenuController menuController = menuLoader.getController();
           menuController.setUser(currentUser);

           // Navigate to the Menu page
           Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
           Scene menuScene = new Scene(menuRoot);
           stage.setScene(menuScene);
           stage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    @FXML
    private void switchToSignup(MouseEvent event) {
        try {
            // Load the Menu FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
            Parent menuRoot = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene menuScene = new Scene(menuRoot);
            stage.setScene(menuScene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showError(String message) {
        // Here you could create an alert or another mechanism to show the error to the user.
        System.err.println(message);
    }
    @FXML
    private void switchToLogin(MouseEvent event) {
        try {
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Close the current stage (homepage)
            currentStage.close();

            // Create a new stage (login page)
            Stage loginStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent loginRoot = loader.load();
            // Create the login page scene

            Scene loginScene =  new Scene(loginRoot);

            // Set the title and scene for the login stage
            loginStage.setTitle("Login Page");
            loginStage.setScene(loginScene);

            // Show the new login stage
            loginStage.show();

        } catch (Exception e) {
            // Catch and log the exception, showing an error message
            e.printStackTrace();
            // Optionally, show a dialog to the user
            showError("An error occurred while switching scenes: " + e.getMessage());
        }
    }
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
    private void switchToReserve(MouseEvent event) {
        try {
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Close the current stage (homepage)
            currentStage.close();

            // Create a new stage (login page)
            Stage loginStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reserve.fxml"));
            Parent ReserveRoot = loader.load();
            // Create the login page scene

            Scene ReserveScene =  new Scene(ReserveRoot);

            // Set the title and scene for the login stage
            loginStage.setTitle("Reserve");
            Image logo = new Image(getClass().getResourceAsStream("images/logo.png"));
            loginStage.getIcons().add(logo);
            loginStage.setScene(ReserveScene);

            // Show the new login stage
            loginStage.show();

        } catch (Exception e) {
            // Catch and log the exception, showing an error message
            e.printStackTrace();
            // Optionally, show a dialog to the user
            showError("An error occurred while switching scenes: " + e.getMessage());
        }
    }
}
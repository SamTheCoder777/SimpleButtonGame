package com.example.javafxlearning;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.RandomAccessFile;


import java.io.IOException;

/**
 *
 * @author samthecoder777
 *
 */
public class HelloApplication extends Application {
    int counter = 0;
    String randomLine;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        File file = new File("C:\\Users\\rowan\\IdeaProjects\\JavaFxLearning\\src\\main\\java\\com\\example\\javafxlearning\\WordList.txt");
        final RandomAccessFile f = new RandomAccessFile(file, "r");
        final long randomLocation = (long) (Math.random() * f.length());
        f.seek(randomLocation);
        f.readLine();



        Scene scene = new Scene(fxmlLoader.load());
        Button btn = (Button) scene.lookup("#myButton");
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double maxY = screenBounds.getHeight() - 400.0;
        double maxX = screenBounds.getWidth() - 400.0;
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.setResizable(false);
        stage.show();
        btn.setLayoutX(450);
        btn.setLayoutY(300);
        System.out.println(maxX);


        btn.setOnMousePressed(e-> {
            btn.disarm();
            double xRandom = Math.random() * (900.0);
            double yRandom = Math.random() * (500.0);
            try {
                randomLine = f.readLine();
            }
            catch(IOException c) {
                c.printStackTrace();
            }

            btn.relocate(xRandom, yRandom);
            if (counter == 0)
                btn.setText("What's wrong? Click me!");
            if (counter == 1)
                btn.setText("Hmm? C'mon, click me");
            if (counter == 2)
                btn.setText("I am getting tired now...");
            if (counter == 3)
                btn.setText("OMG! I am gonna fall asleep...");
            if (counter == 4)
                btn.setText("any time now...");
            if (counter == 5)
                btn.setText("You can do it!");
            if (counter == 6){
                btn.setText("You can do it!");
            }

            if (counter >= 7) {
                btn.setText(randomLine);
            }
            counter+=1;
        });

        scene.setOnMousePressed(e-> {
            stage.setTitle("hi");
            double xRandom = Math.random() * (900.0);
            double yRandom = Math.random() * (500.0);
            try {
                randomLine = f.readLine();
            }
            catch(IOException c) {
                c.printStackTrace();
            }
            btn.relocate(xRandom, yRandom);

            if (counter == 0)
                btn.setText("What's wrong? Click me!");
            if (counter == 1)
                btn.setText("Hmm? C'mon, click me");
            if (counter == 2)
                btn.setText("I am getting tired now...");
            if (counter == 3)
                btn.setText("OMG! I am gonna fall asleep...");
            if (counter == 4)
                btn.setText("any time now...");
            if (counter == 5){

                btn.setText("You can do it!");
            }
            if (counter == 6){
                btn.setText("Close");
                btn.setLayoutX(450);
                btn.setLayoutY(300);
            }

            if (counter >= 7) {
                btn.setText(randomLine);
            }
            counter+=1;
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
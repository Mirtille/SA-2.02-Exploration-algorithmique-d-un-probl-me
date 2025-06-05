/*package com.example.javafx_ihm;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import static javafx.application.Application.launch;

public class TPexo1 extends Application {

    private Rectangle r;
    private double h = 400;
    private double l = 400;
    private double posX = 200;
    private double posY = 200;
    private double cote = 10;

    public void start(Stage stage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, l, h);

        r = new Rectangle(posX, posY, cote, cote);
        r.setFill(Color.RED);
        root.getChildren().add(r);

        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP, Z -> {
                    if (r.getY() - cote >= 0) r.setY(r.getY() - cote);
                }
                case DOWN, S -> {
                    if (r.getY() + cote <= h - cote) r.setY(r.getY() + cote);
                }
                case LEFT, Q -> {
                    if (r.getX() - cote >= 0) r.setX(r.getX() - cote);
                }
                case RIGHT, D -> {
                    if (r.getX() + cote <= l - cote) r.setX(r.getX() + cote);
                }
                default -> {
                }
            }
        });
        stage.setTitle("carre rouge");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/
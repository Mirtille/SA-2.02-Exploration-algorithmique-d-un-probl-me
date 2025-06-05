package com.example.javafx_ihm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class immatriculation extends Application {
    public void start(Stage stage) {
        Pane racine = new Pane();
        Rectangle rectangle = new Rectangle(4, 4, 74, 175);
        rectangle.setFill(Color.DARKBLUE);

        Rectangle rectangle2 = new Rectangle(718, 4, 74, 175);
        rectangle2.setFill(Color.DARKBLUE);

        Circle circle = new Circle(40, 40, 32);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.WHITE);

        Text texte = new Text();
        texte.setFill(Color.WHITE);
        texte.setFont(Font.font("arial",  FontWeight.BOLD, FontPosture.REGULAR, 60));
        texte.setX(25);
        texte.setY(150);
        texte.setText("F");

        Text texte2 = new Text();
        texte2.setFill(Color.BLACK);
        texte2.setFont(Font.font("Arial Narrow",  FontWeight.BOLD, 110));
        texte2.setX(120);
        texte2.setY(130);
        texte2.setText("AB-123-CD");

        Rectangle rectangle3 = new Rectangle(722, 8, 64, 64);
        rectangle3.setFill(Color.TRANSPARENT);
        rectangle3.setStroke(Color.WHITE);

        Text texte3 = new Text();
        texte3.setFill(Color.WHITE);
        texte3.setFont(Font.font("Arial Narrow",  FontWeight.BOLD, 70));
        texte3.setX(715);
        texte3.setY(150);
        texte3.setText("54");

        // Ajout des elements
        racine.getChildren().addAll(rectangle, rectangle2, circle, texte, texte2, rectangle3, texte3);

        // Gestion de la scene
        Scene scene = new Scene(racine, 790, 175);
        stage.setScene(scene);
        stage.setTitle( "Signe!");

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

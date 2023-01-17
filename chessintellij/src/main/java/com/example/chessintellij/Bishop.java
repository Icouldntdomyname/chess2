package com.example.chessintellij;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Bishop extends Piece{

    StackPane s1;
    boolean iswhite;

    public Bishop(boolean iswhite) throws FileNotFoundException {
        this.iswhite = iswhite;

        InputStream stream;

        s1 = new StackPane();

        if (iswhite == true) stream = new FileInputStream("C:\\Users\\piney\\IdeaProjects\\chessintellij\\src\\main\\java\\com\\example\\chessintellij\\wbishop2.png");
        else stream = new FileInputStream("C:\\Users\\piney\\IdeaProjects\\chessintellij\\src\\main\\java\\com\\example\\chessintellij\\bishop2.png");

        Image image1 = new Image(stream);

        ImageView view = new ImageView(image1);

        s1.getChildren().add(view);
    }

    public StackPane getStackPane() {
        return s1;
    }
    public boolean getiswhite() {
        return iswhite;
    }

}

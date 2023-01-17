package com.example.chessintellij;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Board extends Application {

    GridPane grid = new GridPane();

    Piece [] [] pieces = new Piece [8] [8];

    Bishop b = new Bishop(true);
    Knight kn = new Knight(true);
    Rook r = new Rook(true);
    Queen q = new Queen(true);
    King k = new King(true);
    Bishop b2 = new Bishop(true);
    Knight kn2 = new Knight(true);
    Rook r2 = new Rook(true);
    Queen wq = new Queen(false);
    King wk = new King(false);
    Bishop wb2 = new Bishop(false);
    Knight wkn2 = new Knight(false);
    Rook wr2 = new Rook(false);
    Bishop wb = new Bishop(false);
    Knight wkn = new Knight(false);
    Rook wr = new Rook(false);

    public Board() throws FileNotFoundException {
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                Rectangle rec1 = new Rectangle();
                if ((i + j) %2 == 0) {
                    rec1.setFill(Color.GREY);
                    grid.add(rec1, j, i);
                    rec1.setWidth(60);
                    rec1.setHeight(60);
                }
                else {
                    rec1.setFill(Color.RED);
                    grid.add(rec1, j, i);
                    rec1.setWidth(60);
                    rec1.setHeight(60);
                }
            }
        }

        pieces [0] [0] = r;
        pieces [0] [1] = kn;
        pieces [0] [2] = b;
        pieces [0] [3] = q;
        pieces [0] [4] = k;
        pieces [0] [5] = b2;
        pieces [0] [6] = kn2;
        pieces [0] [7] = r2;

        pieces [7] [0] = wr;
        pieces [7] [1] = wkn;
        pieces [7] [2] = wb;
        pieces [7] [3] = wq;
        pieces [7] [4] = wk;
        pieces [7] [5] = wb2;
        pieces [7] [6] = wkn2;
        pieces [7] [7] = wr2;

        for (int i = 0; i < 8; i++) {
            Pawn p = new Pawn(true);
            grid.add(p.getStackPane(), i, 1);
            pieces [1] [i] = p;
        }

        for (int i = 0; i < 8; i++) {
            Pawn p = new Pawn(false);
            grid.add(p.getStackPane(), i,6);
            pieces [6] [i] = p;
        }
    }

    public void getCommand() {

        Scanner in = new Scanner(System.in);

        System.out.print("Please type in the horizontal location of the piece: ");
        int x = in.nextInt();
        System.out.print("Please type in the vertical location of the piece: ");
        int y = in.nextInt();

        if (pieces [x] [y] instanceof Piece) {
            System.out.print("Please type in which tile (vertically) you want to move to: ");
            int move = in.nextInt();

            if (move >= 0 && move <= 7) {
                int move1 = in.nextInt();

                if (move1 >= 0 && move1 <= 7) {
                    System.out.print("Please type in which tile (horizontally) you want to move to: ");
                    Piece pieceinput = pieces [x] [y];

                    grid.getChildren().remove(pieceinput.getStackPane());
                    grid.add(pieceinput.getStackPane(), move, move1);

                    pieces [move] [move1] = pieceinput;

                    pieces [x] [y] = null;
                }
                else {

                }
            }
            else {

            }
        }
    }

    public void start(Stage stage) throws FileNotFoundException {
        for (int i = 0; i <= 7; i++) {
            RowConstraints con = new RowConstraints();
            con.setPrefHeight(50);
            grid.getRowConstraints().add(con);
        }

        Text t = new Text();
        t.setText("a");

        grid.add(t, 10, 10);
        grid.add(r.getStackPane(), 0, 0);
        grid.add(kn.getStackPane(), 1, 0);
        grid.add(b.getStackPane(), 2, 0);
        grid.add(q.getStackPane(), 3, 0);
        grid.add(k.getStackPane(), 4, 0);
        grid.add(r2.getStackPane(), 7, 0);
        grid.add(kn2.getStackPane(), 6, 0);
        grid.add(b2.getStackPane(), 5, 0);
        grid.add(wr.getStackPane(), 0, 7);
        grid.add(wkn.getStackPane(), 1, 7);
        grid.add(wb.getStackPane(), 2, 7);
        grid.add(wq.getStackPane(), 3, 7);
        grid.add(wk.getStackPane(), 4, 7);
        grid.add(wr2.getStackPane(), 7, 7);
        grid.add(wkn2.getStackPane(), 6, 7);
        grid.add(wb2.getStackPane(), 5, 7);

        Scene scene = new Scene(grid, 480, 450);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Chess");

        stage.setScene(scene);

        stage.show();

        getCommand();
    }
    public static void main(String args[]){
        launch(args);
    }
}
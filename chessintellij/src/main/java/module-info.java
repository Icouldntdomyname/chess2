module com.example.chessintellij {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chessintellij to javafx.fxml;
    exports com.example.chessintellij;
}
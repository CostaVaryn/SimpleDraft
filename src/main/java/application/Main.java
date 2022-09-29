package application;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = new AnchorPane();
            root.setPadding(new Insets(5.0));
            Button button = createButton();
            AnchorPane.setBottomAnchor(button, 0.0);
            AnchorPane.setTopAnchor(button, 0.0);
            AnchorPane.setBottomAnchor(button, 0.0);
            AnchorPane.setRightAnchor(button, 0.0);
            AnchorPane.setLeftAnchor(button, 0.0);

            root.getChildren().add(button);
            Scene scene = new Scene(root, 300, 300);
            primaryStage.setTitle("Хабрахабр");
            primaryStage.getIcons().add(new Image(getResource("favicon-16x16.png").toExternalForm()));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private Button createButton() {
        Button result = new Button("Жми");
        result.setTooltip(new Tooltip("Не бойся, жми!"));
        result.setCursor(Cursor.HAND);
        result.setOnMouseClicked(mouseEvent -> {
            new AudioClip(getResource("click.wav").toString()).play();
            showDialog();

        });
        return result;
    }

    private URL getResource(String name) {
        return getClass().getResource(name);
    }

    private void showDialog() {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("Инфо");
        dialog.setHeaderText("Привет мир!");
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
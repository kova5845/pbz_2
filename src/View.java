import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.sound.midi.ControllerEventListener;

public class View extends Application {
    Controller controller = new Controller(this);

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("file");
        Menu addMenu = new Menu("add");
        Menu editMenu = new Menu("edit");
        Menu deleteMenu = new Menu("delete");
        Menu viewMenu = new Menu("view");
        MenuItem newItem = new MenuItem("new");
        newItem.setOnAction((ActionEvent event) -> {

        });
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("DB", "*.db"));
        MenuItem openItem = new MenuItem("open");
        openItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem saveItem = new MenuItem("save");
        saveItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem companyAddItem = new MenuItem("company");
        companyAddItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem workerAddItem = new MenuItem("worker");
        workerAddItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem agentAddItem = new MenuItem("agent");
        agentAddItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem companyEditItem = new MenuItem("company");
        companyEditItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem workerEditItem = new MenuItem("worker");
        workerEditItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem agentEditItem = new MenuItem("agent");
        agentEditItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem companyDeleteItem = new MenuItem("company");
        companyDeleteItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem workerDeleteItem = new MenuItem("worker");
        workerDeleteItem.setOnAction((ActionEvent event) -> {

        });
        MenuItem agentDeleteItem = new MenuItem("agent");
        agentDeleteItem.setOnAction((ActionEvent event) -> {

        });
        menuBar.getMenus().addAll(fileMenu, addMenu, editMenu, deleteMenu, viewMenu);
        fileMenu.getItems().addAll(newItem, openItem, saveItem);
        addMenu.getItems().addAll(companyAddItem, workerAddItem, agentAddItem);
        editMenu.getItems().addAll(companyEditItem, workerEditItem, agentEditItem);
        deleteMenu.getItems().addAll(companyDeleteItem, workerDeleteItem, agentDeleteItem);


        VBox root = new VBox();
        root.getChildren().addAll(menuBar);
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("Лабараторная работа №2");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

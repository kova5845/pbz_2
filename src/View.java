import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.sound.midi.ControllerEventListener;
import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class View extends Application {
    Controller controller;
    Table table;

    @Override
    public void start(Stage primaryStage) {
        controller = new Controller(this);
        controller.connect();
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("file");
        Menu addMenu = new Menu("add");
        Menu editMenu = new Menu("edit");
        Menu deleteMenu = new Menu("delete");
        Menu viewMenu = new Menu("view");
        MenuItem newItem = new MenuItem("new");
        table = new Table();
        newItem.setOnAction((ActionEvent event) -> {

        });
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("DB", "*.db"));
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
        MenuItem viewContracts = new MenuItem("contracts");
        viewContracts.setOnAction((ActionEvent event) -> {
            Dialog dialog = new Dialog(this);
            dialog.findContracts();
            dialog.showDialog(primaryStage);
        });
        MenuItem viewAgents = new MenuItem("agents");
        viewAgents.setOnAction((ActionEvent event) -> {
            Dialog dialog = new Dialog(this);
            dialog.findAgents();
            dialog.showDialog(primaryStage);
        });
        MenuItem viewCategories = new MenuItem("categories");
        viewCategories.setOnAction((ActionEvent event) -> {
            Dialog dialog = new Dialog(this);
            dialog.findCategories();
            dialog.showDialog(primaryStage);
        });

        menuBar.getMenus().addAll(fileMenu, addMenu, editMenu, deleteMenu, viewMenu);
        fileMenu.getItems().addAll(newItem);
        addMenu.getItems().addAll(companyAddItem, workerAddItem, agentAddItem);
        editMenu.getItems().addAll(companyEditItem, workerEditItem, agentEditItem);
        deleteMenu.getItems().addAll(companyDeleteItem, workerDeleteItem, agentDeleteItem);
        viewMenu.getItems().addAll(viewContracts, viewAgents, viewCategories);

        VBox root = new VBox();
//        table.addContract(new Contract(1, "BSUIR",
//                "Kolasa 28", new Date(1999,10, 20),
//                new Date(1999,10, 20), new Date(1999,10, 20)));
        root.getChildren().addAll(menuBar, table.pagination);
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

    public void getContracts(String company, String date){
        table.setData(controller.getContracts(company, date));
    }

    public void getAgents(String company, String date){
        table.setData(controller.getAgents(company, date));
    }

    public void getCategories(String date){
        table.setData(controller.getCategories(date));
    }
}

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
            Dialog dialog = new Dialog(this);
            dialog.editCompany(table.getSelectedItem());
            dialog.showDialog(primaryStage);
        });
        MenuItem workerEditItem = new MenuItem("worker");
        workerEditItem.setOnAction((ActionEvent event) -> {
            Dialog dialog = new Dialog(this);
            dialog.editWorker(table.getSelectedItem());
            dialog.showDialog(primaryStage);
        });
        MenuItem agentEditItem = new MenuItem("agent");
        agentEditItem.setOnAction((ActionEvent event) -> {
            Dialog dialog = new Dialog(this);
            dialog.editAgent(table.getSelectedItem());
            dialog.showDialog(primaryStage);
        });
        MenuItem companyDeleteItem = new MenuItem("company");
        companyDeleteItem.setOnAction((ActionEvent event) -> {
            controller.deleteCompany(table.getSelectedItem());
            table.setData(controller.getCompany());
        });
        MenuItem workerDeleteItem = new MenuItem("worker");
        workerDeleteItem.setOnAction((ActionEvent event) -> {
            controller.deleteWorker(table.getSelectedItem());
            table.setData(controller.getWorker());
        });
        MenuItem agentDeleteItem = new MenuItem("agent");
        agentDeleteItem.setOnAction((ActionEvent event) -> {
            controller.deleteAgent(table.getSelectedItem());
            table.setData(controller.getAgent());
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

        MenuItem viewCompany = new MenuItem("company");
        viewCompany.setOnAction((ActionEvent event) -> {
            table.changeTable(4);
            table.setData(controller.getCompany());
        });
        MenuItem viewAgent = new MenuItem("agent");
        viewAgent.setOnAction((ActionEvent event) -> {
            table.changeTable(6);
            table.setData(controller.getAgent());
        });
        MenuItem viewWorker = new MenuItem("worker");
        viewWorker.setOnAction((ActionEvent event) -> {
            table.changeTable(5);
            table.setData(controller.getWorker());
        });


        menuBar.getMenus().addAll(fileMenu, addMenu, editMenu, deleteMenu, viewMenu);
        fileMenu.getItems().addAll(newItem);
        addMenu.getItems().addAll(companyAddItem, workerAddItem, agentAddItem);
        editMenu.getItems().addAll(companyEditItem, workerEditItem, agentEditItem);
        deleteMenu.getItems().addAll(companyDeleteItem, workerDeleteItem, agentDeleteItem);
        viewMenu.getItems().addAll(viewContracts, viewAgents, viewCategories,
                viewCompany, viewWorker, viewAgent);

        VBox root = new VBox();
        root.getChildren().addAll(menuBar, table.pagination);
        Scene scene = new Scene(root, 752, 500);
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

    public void getCompany(Company company){
        controller.editCompany(company);
        table.setData(controller.getCompany());
    }

    public void getAgent(Company company){
        controller.editAgent(company);
        table.setData(controller.getAgent());
    }

    public void getWorker(Company company){
        controller.editWorker(company);
        table.setData(controller.getWorker());
    }
}

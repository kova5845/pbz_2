import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;


public class Dialog {
    VBox vBox = new VBox();;
    HBox hBox1 = new HBox();
    HBox hBox2 = new HBox();
    Label company = new Label("company: ");
    Label date = new Label("date: ");
    TextField companyField = new TextField();
    DatePicker datePicker = new DatePicker();
    Button button = new Button("find");
    Scene scene;
    Stage window;
    View view;
    public Dialog(View view) {
        this.view = view;
        scene = new Scene(vBox, 200, 300);
        window = new Stage();
        window.setScene(scene);
    }

    public void showDialog(Stage primaryStage) {
        window.setTitle("Поиск");
        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(primaryStage);
        window.show();
    }

    public void findContracts(){
        vBox.getChildren().clear();
        hBox1.getChildren().clear();
        hBox2.getChildren().clear();
        datePicker.setValue(LocalDate.of(2018, 7, 25));
        hBox1.getChildren().addAll(company, companyField);
        hBox2.getChildren().addAll(date, datePicker);
        button.setOnAction((ActionEvent event) -> {
            view.getContracts(companyField.getText(),
                    datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            view.table.changeTable(1);
            this.window.close();
        });
        vBox.getChildren().addAll(hBox1, hBox2, button);
    }

    public void findAgents(){
        vBox.getChildren().clear();
        hBox1.getChildren().clear();
        hBox2.getChildren().clear();
        datePicker.setValue(LocalDate.of(2018, 7, 25));
        hBox1.getChildren().addAll(company, companyField);
        hBox2.getChildren().addAll(date, datePicker);
        button.setOnAction((ActionEvent event) -> {
            view.getAgents(companyField.getText(),
                    datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            view.table.changeTable(2);
            this.window.close();
        });
        vBox.getChildren().addAll(hBox1, hBox2, button);
    }

    public void findCategories(){
        vBox.getChildren().clear();
        hBox2.getChildren().clear();
        datePicker.setValue(LocalDate.of(2018, 7, 25));
        hBox2.getChildren().addAll(date, datePicker);
        button.setOnAction((ActionEvent event) -> {
            view.getCategories(datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            view.table.changeTable(3);
            this.window.close();
        });
        vBox.getChildren().addAll(hBox2, button);
    }
}

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
        scene = new Scene(vBox, 300, 150);
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

    public void editCompany(Company com){
        vBox.getChildren().clear();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        HBox h6 = new HBox();
        Label l2 = new Label("Short name ");
        Label l3 = new Label("Full name ");
        Label l4 = new Label("Address ");
        Label l5 = new Label("Bank details ");
        Label l6 = new Label("Specialisation ");
        TextField f2 = new TextField();
        TextField f3 = new TextField();
        TextField f4 = new TextField();
        TextField f5 = new TextField();
        TextField f6 = new TextField();
        button.setOnAction((ActionEvent event) -> {
            if(!f2.getText().trim().equals("")){
                com.setCompanyName(f2.getText());
            }
            if(!f3.getText().trim().equals("")){
                com.setCompanyFullName(f3.getText());
            }
            if(!f4.getText().trim().equals("")){
                com.setCompanyAddress(f4.getText());
            }
            if(!f5.getText().trim().equals("")){
                com.setBankDetails(Integer.parseInt(f5.getText()));
            }
            if(!f6.getText().trim().equals("")){
                com.setCompanySpecialisation(f6.getText());
            }
            view.getCompany(com);
            view.table.changeTable(4);
            this.window.close();
        });
        h2.getChildren().addAll(l2,f2);
        h3.getChildren().addAll(l3,f3);
        h4.getChildren().addAll(l4,f4);
        h5.getChildren().addAll(l5,f5);
        h6.getChildren().addAll(l6,f6);
        vBox.getChildren().addAll(h2, h3, h4, h5, h6, button);
    }

    public void editAgent(Company com){
        vBox.getChildren().clear();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        Label l2 = new Label("Surname ");
        Label l3 = new Label("Name ");
        Label l4 = new Label("Patronymic ");
        Label l5 = new Label("Passport number ");
        TextField f2 = new TextField();
        TextField f3 = new TextField();
        TextField f4 = new TextField();
        TextField f5 = new TextField();
        button.setOnAction((ActionEvent event) -> {
            if(!f2.getText().trim().equals("")){
                com.setAgentSurname(f2.getText());
            }
            if(!f3.getText().trim().equals("")){
                com.setAgentName(f3.getText());
            }
            if(!f4.getText().trim().equals("")){
                com.setAgentPatronymic(f4.getText());
            }
            if(!f5.getText().trim().equals("")){
                com.setAgentPassportNumber(f5.getText());
            }
            view.getAgent(com);
            view.table.changeTable(6);
            this.window.close();
        });
        h2.getChildren().addAll(l2,f2);
        h3.getChildren().addAll(l3,f3);
        h4.getChildren().addAll(l4,f4);
        h5.getChildren().addAll(l5,f5);
        vBox.getChildren().addAll(h2, h3, h4, h5, button);
    }

    public void editWorker(Company com){
        vBox.getChildren().clear();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        Label l2 = new Label("Surname ");
        Label l3 = new Label("Name ");
        Label l4 = new Label("Patronymic ");
        Label l5 = new Label("Возраст ");
        TextField f2 = new TextField();
        TextField f3 = new TextField();
        TextField f4 = new TextField();
        TextField f5 = new TextField();
        button.setOnAction((ActionEvent event) -> {
            if(!f2.getText().trim().equals("")){
                com.setWorkerSurname(f2.getText());
            }
            if(!f3.getText().trim().equals("")){
                com.setWorkerName(f3.getText());
            }
            if(!f4.getText().trim().equals("")){
                com.setWorkerPatronymic(f4.getText());
            }
            if(!f5.getText().trim().equals("")){
                com.setWorkerAge(Integer.parseInt(f5.getText()));
            }
            view.getWorker(com);
            view.table.changeTable(5);
            this.window.close();
        });
        h2.getChildren().addAll(l2,f2);
        h3.getChildren().addAll(l3,f3);
        h4.getChildren().addAll(l4,f4);
        h5.getChildren().addAll(l5,f5);
        vBox.getChildren().addAll(h2, h3, h4, h5, button);
    }
}

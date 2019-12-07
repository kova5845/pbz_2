import java.sql.Date;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;



public class Table {
    Pagination pagination;
    TableView<Company> table;
    TableColumn<Company, Integer> contractId;
    TableColumn<Company, Integer> companyId;
    TableColumn<Company, String> companyFullName;
    TableColumn<Company, Integer> bankDetails;
    TableColumn<Company, String> companySpecialisation;
    TableColumn<Company, String> companyName;
    TableColumn<Company, String> companyAddress;
    TableColumn<Company, Date> date;
    TableColumn<Company, Date> dateOfStart;
    TableColumn<Company, Date> dateOfFinish;
    TableColumn<Company, Integer> agentId;
    TableColumn<Company, String> agentName;
    TableColumn<Company, String> agentSurname;
    TableColumn<Company, String> agentPatronymic;
    TableColumn<Company, String> agentPassportNumber;
    TableColumn<Company, Integer> workerCategory;
    TableColumn<Company, Integer> insurancePayout;
    TableColumn<Company, Integer> workerId;
    TableColumn<Company, String> workerName;
    TableColumn<Company, String> workerSurname;
    TableColumn<Company, String> workerPatronymic;
    TableColumn<Company, Integer> workerAge;



    int rowsPerPage = 10;
    ObservableList<Company> data = FXCollections.observableArrayList();


    public Table() {
        pagination = new Pagination((data.size() / rowsPerPage + 1), 0);
        table = new TableView<>();
        table.setEditable(true);
        changeTable(1);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public void changeTable(int number) {
        switch(number) {
            case 1:
                table.getColumns().clear();
                contractId = new TableColumn<>("номер контракта");
                contractId.setMinWidth(150);
                contractId.setCellValueFactory(new PropertyValueFactory<Company, Integer>("contractId"));
                companyName = new TableColumn<>("название компании");
                companyName.setMinWidth(150);
                companyName.setCellValueFactory(new PropertyValueFactory<Company, String>("companyName"));
                companyAddress = new TableColumn("адрес компании");
                companyAddress.setMinWidth(150);
                companyAddress.setCellValueFactory(new PropertyValueFactory<Company, String>("companyAddress"));
//                date = new TableColumn("дата");
//                date.setCellValueFactory(new PropertyValueFactory<Company, Date>("date"));
                dateOfStart = new TableColumn("дата начала");
                dateOfStart.setMinWidth(150);
                dateOfStart.setCellValueFactory(new PropertyValueFactory<Company, Date>("dateOfStart"));
                dateOfFinish = new TableColumn("дата окончания");
                dateOfFinish.setMinWidth(150);
                dateOfFinish.setCellValueFactory(new PropertyValueFactory<Company, Date>("dateOfFinish"));
                table.getColumns().addAll(contractId, companyName, companyAddress, dateOfStart, dateOfFinish);
                break;
            case 2:
                table.getColumns().clear();
                agentName = new TableColumn<>("имя");
                agentName.setMinWidth(150);
                agentName.setCellValueFactory(new PropertyValueFactory<Company, String>("agentName"));
                agentSurname = new TableColumn<>("фамилия");
                agentSurname.setMinWidth(150);
                agentSurname.setCellValueFactory(new PropertyValueFactory<Company, String>("agentSurname"));
                agentPatronymic = new TableColumn("отчество");
                agentPatronymic.setMinWidth(150);
                agentPatronymic.setCellValueFactory(new PropertyValueFactory<Company, String>("agentPatronymic"));
                agentPassportNumber = new TableColumn("номер паспорта");
                agentPassportNumber.setMinWidth(150);
                agentPassportNumber.setCellValueFactory(new PropertyValueFactory<Company, String>("agentPassportNumber"));
                companyName = new TableColumn("компания");
                companyName.setMinWidth(150);
                companyName.setCellValueFactory(new PropertyValueFactory<Company, String>("companyName"));
//                date = new TableColumn("дата");
//                date.setCellValueFactory(new PropertyValueFactory<Company, Date>("date"));
//                dateOfStart = new TableColumn("дата начала");
//                dateOfStart.setCellValueFactory(new PropertyValueFactory<Company, Date>("dateOfStart"));
//                dateOfFinish = new TableColumn("дата окончания");
//                dateOfFinish.setCellValueFactory(new PropertyValueFactory<Company, Date>("dateOfFinish"));
                table.getColumns().addAll(agentSurname, agentName, agentPatronymic, agentPassportNumber,
                        companyName);
                break;
            case 3:
                table.getColumns().clear();
                workerCategory = new TableColumn<>("категория сотрудников");
                workerCategory.setMinWidth(150);
                workerCategory.setCellValueFactory(new PropertyValueFactory<Company, Integer>("workerCategory"));
                insurancePayout = new TableColumn<>("страховые выплаты");
                insurancePayout.setCellValueFactory(new PropertyValueFactory<Company, Integer>("insurancePayout"));
//                date = new TableColumn("дата");
//                date.setCellValueFactory(new PropertyValueFactory<Company, Date>("date"));
                table.getColumns().addAll(workerCategory, insurancePayout);
                break;
            case 4:
                table.getColumns().clear();
                companyId = new TableColumn<>("номер компании");
                companyId.setMinWidth(150);
                companyId.setCellValueFactory(new PropertyValueFactory<Company, Integer>("companyId"));
                companyFullName = new TableColumn<>("полное название компании");
                companyFullName.setMinWidth(150);
                companyFullName.setCellValueFactory(new PropertyValueFactory<Company, String>("companyFullName"));
                companyName = new TableColumn<>("название компании");
                companyName.setMinWidth(150);
                companyName.setCellValueFactory(new PropertyValueFactory<Company, String>("companyName"));
                companyAddress = new TableColumn("адрес компании");
                companyAddress.setMinWidth(150);
                companyAddress.setCellValueFactory(new PropertyValueFactory<Company, String>("companyAddress"));
                bankDetails = new TableColumn("банковский номер компании");
                bankDetails.setMinWidth(150);
                bankDetails.setCellValueFactory(new PropertyValueFactory<Company, Integer>("bankDetails"));
                companySpecialisation = new TableColumn("специализация компании");
                companySpecialisation.setMinWidth(150);
                companySpecialisation.setCellValueFactory(new PropertyValueFactory<Company, String>("companySpecialisation"));
                table.getColumns().addAll(companyId, companyName, companyFullName,
                        companyAddress, bankDetails, companySpecialisation);
                break;
            case 5:
                table.getColumns().clear();
                workerId = new TableColumn<>("номер");
                workerId.setMinWidth(150);
                workerId.setCellValueFactory(new PropertyValueFactory<Company, Integer>("workerId"));
                workerSurname = new TableColumn<>("фамилия");
                workerSurname.setMinWidth(150);
                workerSurname.setCellValueFactory(new PropertyValueFactory<Company, String>("workerSurname"));
                workerName = new TableColumn<>("имя");
                workerName.setMinWidth(150);
                workerName.setCellValueFactory(new PropertyValueFactory<Company, String>("workerName"));
                workerPatronymic = new TableColumn("отчество");
                workerPatronymic.setMinWidth(150);
                workerPatronymic.setCellValueFactory(new PropertyValueFactory<Company, String>("workerPatronymic"));
                workerAge = new TableColumn("возраст");
                workerAge.setMinWidth(150);
                workerAge.setCellValueFactory(new PropertyValueFactory<Company, Integer>("workerAge"));
                table.getColumns().addAll(workerId, workerSurname, workerName,
                        workerPatronymic, workerAge);
                break;
            case 6:
                table.getColumns().clear();
                agentId = new TableColumn<>("номер");
                agentId.setMinWidth(150);
                agentId.setCellValueFactory(new PropertyValueFactory<Company, Integer>("agentId"));
                agentSurname = new TableColumn<>("фамилия");
                agentSurname.setMinWidth(150);
                agentSurname.setCellValueFactory(new PropertyValueFactory<Company, String>("agentSurname"));
                agentName = new TableColumn<>("имя");
                agentName.setMinWidth(150);
                agentName.setCellValueFactory(new PropertyValueFactory<Company, String>("agentName"));
                agentPatronymic = new TableColumn("отчество");
                agentPatronymic.setMinWidth(150);
                agentPatronymic.setCellValueFactory(new PropertyValueFactory<Company, String>("agentPatronymic"));
                agentPassportNumber = new TableColumn("номер паспорта");
                agentPassportNumber.setMinWidth(150);
                agentPassportNumber.setCellValueFactory(new PropertyValueFactory<Company, String>("agentPassportNumber"));
                table.getColumns().addAll(agentId, agentSurname, agentName,
                        agentPatronymic, agentPassportNumber);
                break;
        }
    }

    public ArrayList<Company> getData() {
        return new ArrayList<>(data);
    }

    public void setData(ArrayList<Company> data) {
        this.data.clear();
        this.data = FXCollections.observableArrayList(data);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        return new VBox(table);
    }

    public void addContract(Company contract) {
        this.data.add(contract);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public Company getSelectedItem(){
        return table.getSelectionModel().getSelectedItem();
    }
}

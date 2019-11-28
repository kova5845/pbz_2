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
    TableColumn<Company, String> companyName;
    TableColumn<Company, String> companyAddress;
    TableColumn<Company, Date> date;
    TableColumn<Company, Date> dateOfStart;
    TableColumn<Company, Date> dateOfFinish;
    TableColumn<Company, String> agentName;
    TableColumn<Company, String> agentSurname;
    TableColumn<Company, String> agentPatronymic;
    TableColumn<Company, String> agentPassportNumber;
    TableColumn<Company, Integer> workerCategory;
    TableColumn<Company, Integer> insurancePayout;

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
                contractId.setCellValueFactory(new PropertyValueFactory<Company, Integer>("contractId"));
                companyName = new TableColumn<>("название компании");
                companyName.setCellValueFactory(new PropertyValueFactory<Company, String>("companyName"));
                companyAddress = new TableColumn("адрес компании");
                companyAddress.setCellValueFactory(new PropertyValueFactory<Company, String>("companyAddress"));
//                date = new TableColumn("дата");
//                date.setCellValueFactory(new PropertyValueFactory<Company, Date>("date"));
                dateOfStart = new TableColumn("дата начала");
                dateOfStart.setCellValueFactory(new PropertyValueFactory<Company, Date>("dateOfStart"));
                dateOfFinish = new TableColumn("дата окончания");
                dateOfFinish.setCellValueFactory(new PropertyValueFactory<Company, Date>("dateOfFinish"));
                table.getColumns().addAll(contractId, companyName, companyAddress, dateOfStart, dateOfFinish);
                break;
            case 2:
                table.getColumns().clear();
                agentName = new TableColumn<>("имя");
                agentName.setCellValueFactory(new PropertyValueFactory<Company, String>("agentName"));
                agentSurname = new TableColumn<>("фамилия");
                agentSurname.setCellValueFactory(new PropertyValueFactory<Company, String>("agentSurname"));
                agentPatronymic = new TableColumn("отчество");
                agentPatronymic.setCellValueFactory(new PropertyValueFactory<Company, String>("agentPatronymic"));
                agentPassportNumber = new TableColumn("номер паспорта");
                agentPassportNumber.setCellValueFactory(new PropertyValueFactory<Company, String>("agentPassportNumber"));
                companyName = new TableColumn("компания");
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
                workerCategory.setCellValueFactory(new PropertyValueFactory<Company, Integer>("workerCategory"));
                insurancePayout = new TableColumn<>("страховые выплаты");
                insurancePayout.setCellValueFactory(new PropertyValueFactory<Company, Integer>("insurancePayout"));
//                date = new TableColumn("дата");
//                date.setCellValueFactory(new PropertyValueFactory<Company, Date>("date"));
                table.getColumns().addAll(workerCategory, insurancePayout);
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
}

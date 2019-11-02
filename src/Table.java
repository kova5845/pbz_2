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
    TableView<Contract> contractTable;
    TableColumn contractId;
    TableColumn companyName;
    TableColumn companyAddress;
    TableColumn date;
    TableColumn dateOfStart;
    TableColumn dateOfFinish;

    TableView<Agent> agentTable;
    TableColumn agentName;
    TableColumn agentSurname;
    TableColumn agentPatronymic;
    TableColumn companyShortName;

    TableView<WorkerCategory> workerCategoryTable;
    TableColumn workerCategory;
    TableColumn insurancePayout;

    int rowsPerPage = 10;
    ObservableList<Contract> data = FXCollections.observableArrayList();


    public Table() {
        pagination = new Pagination((data.size() / rowsPerPage + 1), 0);
        contractTable = new TableView<>();
        contractTable.setMinSize(400, 300);
        contractId = new TableColumn<>("номер контракта");
        contractId.setCellValueFactory(new PropertyValueFactory<Contract, Integer>("contractId"));
        companyName = new TableColumn<>("название компании");
        companyName.setCellValueFactory(new PropertyValueFactory<Contract, String>("companyName"));
        companyAddress = new TableColumn("адрес компании");
        companyAddress.setCellValueFactory(new PropertyValueFactory<Contract, String>("companyAddress"));
        date = new TableColumn("дата");
        date.setCellValueFactory(new PropertyValueFactory<Contract, Date>("date"));
        dateOfStart = new TableColumn("дата начала");
        dateOfStart.setCellValueFactory(new PropertyValueFactory<Contract, Date>("dateOfStart"));
        dateOfFinish = new TableColumn("дата окончания");
        dateOfFinish.setCellValueFactory(new PropertyValueFactory<Contract, Date>("dateOfFinish"));
        contractTable.getColumns().addAll(contractId, companyName, companyAddress,
                                          date, dateOfStart, dateOfFinish);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public ArrayList<Contract> getData() {
        return new ArrayList<>(data);
    }

    public void setData(ArrayList<Contract> data) {
        this.data = FXCollections.observableArrayList(data);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        contractTable.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        return new VBox(contractTable);
    }

    public void addContract(Contract contract){
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

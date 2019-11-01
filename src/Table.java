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
        table = new TableView<>();
        table.setMinSize(711, 300);
        faculty = new TableColumn<>("факультет");
        faculty.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        department = new TableColumn<>("кафедра");
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        name = new TableColumn("имя");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname = new TableColumn("фамилия");
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        patronymic = new TableColumn("отчество");
        patronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        fio = new TableColumn("ФИО");
        fio.getColumns().addAll(surname, name, patronymic);
        academicRank = new TableColumn("учёное звание");
        academicRank.setCellValueFactory(new PropertyValueFactory<>("academicRank"));
        academicDegree = new TableColumn("учёная степень");
        academicDegree.setCellValueFactory(new PropertyValueFactory<>("academicDegree"));
        experience = new TableColumn("стаж");
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        table.getColumns().addAll(faculty, department, fio, academicRank,
                academicDegree, experience);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public ArrayList<Personal> getData() {
        return new ArrayList<>(data);
    }

    public void setData(ArrayList<Personal> data) {
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

    public void addPerson(Personal per){
        this.data.add(per);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }
}

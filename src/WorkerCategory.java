import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class WorkerCategory {
    private SimpleObjectProperty<Date> date;
    private SimpleStringProperty workerCategory;
    private SimpleIntegerProperty insurancePayout;

    public String getWorkerCategory() {
        return workerCategory.get();
    }

    public SimpleStringProperty workerCategoryProperty() {
        return workerCategory;
    }

    public SimpleIntegerProperty insurancePayoutProperty() {
        return insurancePayout;
    }

    public int getInsurancePayout() {
        return insurancePayout.get();
    }

    public void setWorkerCategory(String workerCategory) {
        this.workerCategory.set(workerCategory);
    }

    public void setInsurancePayout(int insurancePayout) {
        this.insurancePayout.set(insurancePayout);
    }

    public SimpleObjectProperty<Date> dateProperty() {
        return date;
    }

    public Date getDate() {
        return date.get();
    }

    public void setDate(Date date) {
        this.date.set(date);
    }
}

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Contract {
    private SimpleIntegerProperty contractId;
    private SimpleStringProperty companyName;
    private SimpleStringProperty companyAddress;
    private SimpleObjectProperty<Date> date;
    private SimpleObjectProperty<Date> dateOfStart;
    private SimpleObjectProperty<Date> dateOfFinish;

    public Contract(Integer contractId, String companyName, String companyAddress,
                    Date date, Date dateOfStart, Date dateOfFinish){
        this.contractId = new SimpleIntegerProperty(contractId);
        this.companyName = new SimpleStringProperty(companyName);
        this.companyAddress = new SimpleStringProperty(companyAddress);
        this.date = new SimpleObjectProperty<>(date);
        this.dateOfStart = new SimpleObjectProperty<>(dateOfStart);
        this.dateOfFinish = new SimpleObjectProperty<>(dateOfFinish);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public String getCompanyAddress() {
        return companyAddress.get();
    }


    public int getContractId() {
        return contractId.get();
    }

    public void setContractId(int contractId) {
        this.contractId.set(contractId);
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress.set(companyAddress);
    }

    public Date getDateOfStart() {
        return dateOfStart.get();
    }

    public Date getDateOfFinish() {
        return dateOfFinish.get();
    }

    public Date getDate() {
        return date.get();
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart.set(dateOfStart);
    }

    public void setDateOfFinish(Date dateOfFinish) {
        this.dateOfFinish.set(dateOfFinish);
    }

    public void setDate(Date date) {
        this.date.set(date);
    }
}

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Contract {
    private SimpleIntegerProperty contractId;
    private SimpleStringProperty companyName;
    private SimpleStringProperty companyAddress;
    private Date date;
    private Date dateOfStart;
    private Date dateOfFinish;

    public Date getDateOfFinish() {
        return dateOfFinish;
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public String getCompanyAddress() {
        return companyAddress.get();
    }

    public SimpleStringProperty companyNameProperty() {
        return companyName;
    }

    public SimpleStringProperty companyAddressProperty() {
        return companyAddress;
    }

    public SimpleIntegerProperty contractIdProperty() {
        return contractId;
    }

    public int getContractId() {
        return contractId.get();
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public void setDateOfFinish(Date dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
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
        return dateOfStart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

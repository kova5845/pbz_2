import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Company {
    private SimpleIntegerProperty contractId;
    private SimpleStringProperty companyName;
    private SimpleStringProperty companyAddress;
    private SimpleObjectProperty<Date> date;
    private SimpleObjectProperty<Date> dateOfStart;
    private SimpleObjectProperty<Date> dateOfFinish;
    private SimpleStringProperty agentName;
    private SimpleStringProperty agentSurname;
    private SimpleStringProperty agentPatronymic;
    private SimpleStringProperty companyShortName;
    private SimpleIntegerProperty workerCategory;
    private SimpleIntegerProperty insurancePayout;


    public Company(Integer contractId, String companyName, String companyAddress,
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

    public String getCompanyShortName() {
        return companyShortName.get();
    }

    public String getAgentSurname() {
        return agentSurname.get();
    }

    public String getAgentPatronymic() {
        return agentPatronymic.get();
    }

    public String getAgentName() {
        return agentName.get();
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName.set(companyShortName);
    }

    public void setAgentSurname(String agentSurname) {
        this.agentSurname.set(agentSurname);
    }

    public void setAgentPatronymic(String agentPatronymic) {
        this.agentPatronymic.set(agentPatronymic);
    }

    public void setAgentName(String agentName) {
        this.agentName.set(agentName);
    }

    public Integer getWorkerCategory() {
        return workerCategory.get();
    }

    public int getInsurancePayout() {
        return insurancePayout.get();
    }

    public void setWorkerCategory(Integer workerCategory) {
        this.workerCategory.set(workerCategory);
    }

    public void setInsurancePayout(int insurancePayout) {
        this.insurancePayout.set(insurancePayout);
    }
}

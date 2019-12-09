import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Company {
    private SimpleIntegerProperty contractId;
    private SimpleIntegerProperty companyId;
    private SimpleStringProperty companyFullName;
    private SimpleIntegerProperty bankDetails;
    private SimpleStringProperty companySpecialisation;
    private SimpleStringProperty companyName;
    private SimpleStringProperty companyAddress;
    private SimpleObjectProperty<Date> date;
    private SimpleObjectProperty<Date> dateOfStart;
    private SimpleObjectProperty<Date> dateOfFinish;
    private SimpleIntegerProperty agentId;
    private SimpleStringProperty agentName;
    private SimpleStringProperty agentSurname;
    private SimpleStringProperty agentPatronymic;
    private SimpleIntegerProperty agentPassportNumber;
    private SimpleIntegerProperty workerCategory;
    private SimpleIntegerProperty insurancePayout;
    private SimpleIntegerProperty workerId;
    private SimpleStringProperty workerName;
    private SimpleStringProperty workerSurname;
    private SimpleStringProperty workerPatronymic;
    private SimpleIntegerProperty workerAge;


    public Company(){
        this.contractId = new SimpleIntegerProperty();
        this.companyId = new SimpleIntegerProperty();
        this.companyFullName = new SimpleStringProperty();
        this.bankDetails = new SimpleIntegerProperty();
        this.companySpecialisation = new SimpleStringProperty();
        this.companyName = new SimpleStringProperty();
        this.companyAddress = new SimpleStringProperty();
        this.date = new SimpleObjectProperty<>();
        this.dateOfStart = new SimpleObjectProperty<>();
        this.dateOfFinish = new SimpleObjectProperty<>();
        this.agentId = new SimpleIntegerProperty();
        this.agentName = new SimpleStringProperty();
        this.agentSurname = new SimpleStringProperty();
        this.agentPatronymic = new SimpleStringProperty();
        this.agentPassportNumber = new SimpleIntegerProperty();
        this.workerCategory = new SimpleIntegerProperty();
        this.insurancePayout = new SimpleIntegerProperty();
        this.workerId = new SimpleIntegerProperty();
        this.workerName = new SimpleStringProperty();
        this.workerSurname = new SimpleStringProperty();
        this.workerPatronymic = new SimpleStringProperty();
        this.workerAge = new SimpleIntegerProperty();
    }

//    public Company(Integer contractId, String companyName, String companyAddress,
//                   Date date, Date dateOfStart, Date dateOfFinish, String agentName,
//                   String agentSurname, String agentPatronymic, String agentPassportNumber,
//                   Integer workerCategory, Integer insurancePayout){
//        this.contractId = new SimpleIntegerProperty(contractId);
//        this.companyName = new SimpleStringProperty(companyName);
//        this.companyAddress = new SimpleStringProperty(companyAddress);
//        this.date = new SimpleObjectProperty<>(date);
//        this.dateOfStart = new SimpleObjectProperty<>(dateOfStart);
//        this.dateOfFinish = new SimpleObjectProperty<>(dateOfFinish);
//        this.agentName = new SimpleStringProperty(agentName);
//        this.agentSurname = new SimpleStringProperty(agentSurname);
//        this.agentPatronymic = new SimpleStringProperty(agentPatronymic);
//        this.agentPatronymic = new SimpleStringProperty(agentPassportNumber);
//        this.workerCategory = new SimpleIntegerProperty(workerCategory);
//        this.insurancePayout = new SimpleIntegerProperty(insurancePayout);
//    }

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

    public String getAgentSurname() {
        return agentSurname.get();
    }

    public String getAgentPatronymic() {
        return agentPatronymic.get();
    }

    public String getAgentName() {
        return agentName.get();
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

    public void setAgentPassportNumber(int agentPassportNumber) {
        this.agentPassportNumber.set(agentPassportNumber);
    }

    public int getAgentPassportNumber() {
        return agentPassportNumber.get();
    }

    public String getCompanySpecialisation() {
        return companySpecialisation.get();
    }

    public String getCompanyFullName() {
        return companyFullName.get();
    }

    public int getCompanyId() {
        return companyId.get();
    }

    public int getBankDetails() {
        return bankDetails.get();
    }

    public int getAgentId() {
        return agentId.get();
    }

    public void setAgentId(int agentId) {
        this.agentId.set(agentId);
    }

    public void setBankDetails(int bankDetails) {
        this.bankDetails.set(bankDetails);
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName.set(companyFullName);
    }

    public void setCompanyId(int companyId) {
        this.companyId.set(companyId);
    }

    public void setCompanySpecialisation(String companySpecialisation) {
        this.companySpecialisation.set(companySpecialisation);
    }

    public int getWorkerId() {
        return workerId.get();
    }

    public int getWorkerAge() {
        return workerAge.get();
    }

    public String getWorkerSurname() {
        return workerSurname.get();
    }

    public String getWorkerPatronymic() {
        return workerPatronymic.get();
    }

    public String getWorkerName() {
        return workerName.get();
    }

    public void setWorkerSurname(String workerSurname) {
        this.workerSurname.set(workerSurname);
    }

    public void setWorkerPatronymic(String workerPatronymic) {
        this.workerPatronymic.set(workerPatronymic);
    }

    public void setWorkerName(String workerName) {
        this.workerName.set(workerName);
    }

    public void setWorkerId(int workerId) {
        this.workerId.set(workerId);
    }

    public void setWorkerAge(int workerAge) {
        this.workerAge.set(workerAge);
    }
}

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Agent {

    private SimpleStringProperty agentName;
    private SimpleStringProperty agentSurname;
    private SimpleStringProperty agentPatronymic;
    private SimpleStringProperty companyShortName;
    private Date date;
    private Date dateOfStart;
    private Date dateOfFinish;

    public String getCompanyShortName() {
        return companyShortName.get();
    }

    public String getAgentSurname() {
        return agentSurname.get();
    }

    public String getAgentPatronymic() {
        return agentPatronymic.get();
    }

    public SimpleStringProperty companyShortNameProperty() {
        return companyShortName;
    }

    public SimpleStringProperty agentSurnameProperty() {
        return agentSurname;
    }

    public SimpleStringProperty agentPatronymicProperty() {
        return agentPatronymic;
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

    public Date getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public void setDateOfFinish(Date dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
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

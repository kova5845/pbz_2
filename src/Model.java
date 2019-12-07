import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

public class Model {
    ParserSQL parser = new ParserSQL();

    public void connect(){
        parser.connect();
    }

    public ArrayList<Company> getContracts(String company, String date) {
        return parser.getContracts(company, date);
    }
    public ArrayList<Company> getAgents(String company, String date) {
        return parser.getAgents(company, date);
    }
    public ArrayList<Company> getCategories(String date) {
        return parser.getCategories(date);
    }
    public ArrayList<Company> getCompany() {
        return parser.getCompany();
    }

    public ArrayList<Company> getWorker() {
        return parser.getWorker();
    }

    public ArrayList<Company> getAgent() {
        return parser.getAgent();
    }

    public void deleteAgent(Company company){
        parser.deleteAgent(company);
    }

    public void deleteCompany(Company company){
        parser.deleteCompany(company);
    }

    public void deleteWorker(Company company){
        parser.deleteWorker(company);
    }

    public void editCompany(Company company){
        parser.editCompany(company);
    }

    public void editAgent(Company company){
        parser.editAgent(company);
    }

    public void editWorker(Company company){
        parser.editWorker(company);
    }
}


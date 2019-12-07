import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

public class Controller {
    View view;
    Model model;

    public Controller(View view){
        this.view = view;
        this.model = new Model();
    }

    public ArrayList<Company> getContracts(String company, String date){
        return model.getContracts(company, date);
    }

    public ArrayList<Company> getAgents(String company, String date){
        return model.getAgents(company, date);
    }

    public ArrayList<Company> getCategories(String date){
        return model.getCategories(date);
    }

    public ArrayList<Company> getCompany(){
        return model.getCompany();
    }

    public ArrayList<Company> getWorker(){
        return model.getWorker();
    }

    public ArrayList<Company> getAgent(){
        return model.getAgent();
    }

    public void deleteAgent(Company company){
        model.deleteAgent(company);
    }

    public void deleteCompany(Company company){
        model.deleteCompany(company);
    }

    public void deleteWorker(Company company){
        model.deleteWorker(company);
    }

    public void editCompany(Company company){
        model.editCompany(company);
    }

    public void editAgent(Company company){
        model.editAgent(company);
    }

    public void editWorker(Company company){
        model.editWorker(company);
    }

    public void connect(){
        model.connect();
    }

}

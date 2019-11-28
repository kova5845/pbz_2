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

    public void connect(){
        model.connect();
    }

}

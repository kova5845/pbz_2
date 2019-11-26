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

    public ArrayList<Company> getContracts(String company, Date date){
        return model.getContracts(company, date);
    }

    public void setData(ArrayList<Company> data){
        model.setData(data);
    }

    public void connect(){
        model.connect();
    }

}

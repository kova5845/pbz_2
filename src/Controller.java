import java.io.File;
import java.util.ArrayList;

public class Controller {
    View view;
    Model model;

    public Controller(View view){
        this.view = view;
        this.model = new Model();
    }

    public ArrayList<Company> openFile(File file){
        model.openFile(file);
        return model.getData();
    }

    public void saveFile(File file){
        model.saveFile(file);
    }

    public ArrayList<Company> getData(){
        return model.getData();
    }

    public void setData(ArrayList<Company> data){
        model.setData(data);
    }

    public void connect(){
        model.connect();
    }

}

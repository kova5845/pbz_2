import java.io.File;
import java.util.ArrayList;

public class Model {
    ArrayList<Company> data;
    ParserSQL parser = new ParserSQL();

    public void connect(){
        parser.connect();
    }

    public ArrayList<Company> getData() {
        return data;
    }

    public void setData(ArrayList<Company> data) {
        this.data = data;
    }
    public void openFile(File file){

    }

    public void saveFile(File file){

    }

    public void clearData(){
        data.clear();
    }

}


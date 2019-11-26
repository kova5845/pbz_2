import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

public class Model {
    ArrayList<Company> data = new ArrayList<>();
    ParserSQL parser = new ParserSQL();

    public void connect(){
        parser.connect();
    }

    public ArrayList<Company> getContracts(String company, Date date) {
        data.addAll(parser.getContracts(company, date));
        return data;
    }

    public void setData(ArrayList<Company> data) {
        this.data = data;
    }

    public void clearData(){
        data.clear();
    }

}


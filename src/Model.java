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
}


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ParserSQL {
    private static final String user = "root";
    private static final String password = "5845";
    private static final String url = "jdbc:mysql://localhost:3306/insurance?useUnicode=true&serverTimezone=UTC";
    //jdbc:mysql://localhost/db?useUnicode=true&serverTimezone=UTC
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private Company com = new Company();
    private ArrayList<Company> arrayList = new ArrayList<>();


    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        }
        catch ( ClassNotFoundException e ) {
            System.out.println(e);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Company> getContracts(String company, String date){
        arrayList.clear();
        try {
            preparedStatement = connection.prepareStatement("SELECT cm.company_short_name," +
                    " cm.company_addres, cn.contract_id, cn.date_of_start," +
                    " cn.date_of_finish FROM companys cm NATURAL JOIN" +
                    " contracts cn NATURAL JOIN contract_worker_agent_category cwac" +
                    " WHERE cm.company_short_name = ? AND cn.date_of_start < ?" +
                    " AND cn.date_of_finish > ?;");
            preparedStatement.setString(1, company);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, date);
            resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                com.setCompanyName(resultSet.getString("company_short_name"));
                com.setCompanyAddress(resultSet.getString("company_addres"));
                com.setContractId(resultSet.getInt("contract_id"));
                com.setDateOfStart(resultSet.getDate("date_of_start"));
                com.setDateOfFinish(resultSet.getDate("date_of_finish"));
                arrayList.add(com);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<Company> getAgents(String company, String date){
        arrayList.clear();
        try {
            preparedStatement = connection.prepareStatement("SELECT cm.company_short_name," +
                    " ag.agent_name, ag.agent_surname, ag.agent_patronymic, ag.agent_passport_number\n" +
                    "FROM companys cm NATURAL JOIN contracts cn NATURAL JOIN " +
                    "contract_worker_agent_category cwac NATURAL JOIN agents ag\n" +
                    "WHERE cm.company_short_name = ? AND cn.date_of_start < ? AND cn.date_of_finish > ?;");
            preparedStatement.setString(1, company);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, date);
            resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                com.setCompanyName(resultSet.getString("company_short_name"));
                com.setAgentName(resultSet.getString("agent_name"));
                com.setAgentSurname(resultSet.getString("agent_surname"));
                com.setAgentPatronymic(resultSet.getString("agent_patronymic"));
                com.setAgentPassportNumber(resultSet.getString("agent_passport_number"));
                arrayList.add(com);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<Company> getCategories(String date){
        arrayList.clear();
        try {
            preparedStatement = connection.prepareStatement("SELECT wr.worker_name," +
                    " wr.worker_surname, wr.worker_patronymic, ct.category,  ct.payouts_by_category\n" +
                    "FROM contracts cn NATURAL JOIN contract_worker_agent_category cwac" +
                    " NATURAL JOIN categories ct NATURAL JOIN workers wr\n" +
                    "WHERE cn.date_of_start < ? AND cn.date_of_finish > ?;");
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, date);
            resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                com.setWorkerCategory(resultSet.getInt("category"));
                com.setInsurancePayout(resultSet.getInt("payouts_by_category"));
                arrayList.add(com);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}

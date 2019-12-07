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

    public ArrayList<Company> getCompany(){
        arrayList.clear();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM companys;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                com.setCompanyId(resultSet.getInt("company_id"));
                com.setCompanyFullName(resultSet.getString("company_full_name"));
                com.setCompanyName(resultSet.getString("company_short_name"));
                com.setCompanyAddress(resultSet.getString("company_addres"));
                com.setBankDetails(resultSet.getInt("bank_details"));
                com.setCompanySpecialisation(resultSet.getString("company_specialisation"));
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

    public ArrayList<Company> getWorker(){
        arrayList.clear();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM workers;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                com.setWorkerId(resultSet.getInt("worker_id"));
                com.setWorkerName(resultSet.getString("worker_name"));
                com.setWorkerSurname(resultSet.getString("worker_surname"));
                com.setWorkerPatronymic(resultSet.getString("worker_patronymic"));
                com.setWorkerAge(resultSet.getInt("worker_age"));
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

    public ArrayList<Company> getAgent(){
        arrayList.clear();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM agents;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                com.setAgentId(resultSet.getInt("agent_id"));
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

    public void deleteAgent(Company company){
            try {
                preparedStatement = connection.prepareStatement("DELETE  FROM contract_worker_agent_category " +
                        "WHERE agent_id = ?");
                preparedStatement.setInt(1, company.getAgentId());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("DELETE  FROM agents " +
                        "WHERE agent_id = ?");
                preparedStatement.setInt(1, company.getAgentId());
                preparedStatement.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void deleteCompany(Company company){
        try {
            preparedStatement = connection.prepareStatement("DELETE  FROM companys " +
                    "WHERE company_id = ?");
            preparedStatement.setInt(1, company.getCompanyId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWorker(Company company){
        try {
            preparedStatement = connection.prepareStatement("DELETE  FROM contract_worker_agent_category " +
                    "WHERE worker_id = ?");
            preparedStatement.setInt(1, company.getWorkerId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE  FROM workers " +
                    "WHERE worker_id = ?");
            preparedStatement.setInt(1, company.getWorkerId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editCompany(Company company){
        try {
            preparedStatement = connection.prepareStatement("UPDATE companys SET " +
                    "company_id = ?," +
                    "company_full_name = ?," +
                    "company_short_name = ?," +
                    "company_addres = ?," +
                    "bank_details = ?," +
                    "company_specialisation = ?" +
                    "WHERE company_id = ?;");
            preparedStatement.setInt(1, company.getCompanyId());
            preparedStatement.setString(2, company.getCompanyFullName());
            preparedStatement.setString(3, company.getCompanyName());
            preparedStatement.setString(4, company.getCompanyAddress());
            preparedStatement.setInt(5, company.getBankDetails());
            preparedStatement.setString(6, company.getCompanySpecialisation());
            preparedStatement.setInt(7, company.getCompanyId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editAgent(Company company){
        try {
            preparedStatement = connection.prepareStatement("UPDATE agents SET " +
                    "agent_id = ?," +
                    "agent_surname = ?," +
                    "agent_name = ?," +
                    "agent_patronymic = ?," +
                    "agent_passport_number = ?" +
                    "WHERE agent_id = ?;");
            preparedStatement.setInt(1, company.getAgentId());
            preparedStatement.setString(2, company.getAgentSurname());
            preparedStatement.setString(3, company.getAgentName());
            preparedStatement.setString(4, company.getAgentPatronymic());
            preparedStatement.setString(5, company.getAgentPassportNumber());
            preparedStatement.setInt(6, company.getAgentId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editWorker(Company company){
        try {
            preparedStatement = connection.prepareStatement("UPDATE workers SET " +
                    "worker_id = ?," +
                    "worker_surname = ?," +
                    "worker_name = ?," +
                    "worker_patronymic = ?," +
                    "worker_age = ? " +
                    "WHERE worker_id = ?;");
            preparedStatement.setInt(1, company.getWorkerId());
            preparedStatement.setString(2, company.getWorkerSurname());
            preparedStatement.setString(3, company.getWorkerName());
            preparedStatement.setString(4, company.getWorkerPatronymic());
            preparedStatement.setInt(5, company.getWorkerAge());
            preparedStatement.setInt(6, company.getWorkerId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

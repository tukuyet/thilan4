package Phones;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDbUtil {
    private DataSource dataSource;

    public PhoneDbUtil(DataSource theDataSource){
        dataSource = theDataSource;
    }

    public List<Phone> getPhoneList() throws Exception{
        List<Phone> phones = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            String url = "jdbc:mysql://localhost:3306/phone";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "select * from phones";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int id = myRs.getInt("id");
                String phoneName = myRs.getString("phoneName");
                String brand = myRs.getString("brand");
                Double price = myRs.getDouble("price");
                String description = myRs.getString("description");

                Phone tempPhone = new Phone(id, phoneName, brand, price, description);
                phones.add(tempPhone);
            }
            return phones;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try{
            if (myRs != null){
                myRs.close();
            }

            if (myStmt != null){
                myStmt.close();
            }

            if (myConn != null){
                myConn.close();
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public void addPhone(Phone thePhone) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/phone";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "insert into phones" + "(phoneName,brand,price,description)" + "values(?,?,?,?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, thePhone.getPhoneName());
            myStmt.setString(2, thePhone.getBrand());
            myStmt.setDouble(3, thePhone.getPrice());
            myStmt.setString(4, thePhone.getDescription());

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
}

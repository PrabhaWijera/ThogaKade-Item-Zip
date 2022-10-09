package thogakade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThogaKade {

    public static void main(String[] args) {
        String SQL = "Select * From item";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "root", "1234");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            while (rst.next()) {
                String code = rst.getString("code"); //rst.getString(0);
                String description = rst.getString("description");
                double unitPrice  = rst.getDouble("unitPrice");
                double qtyOnHand = rst.getDouble("qtyOnHand");
                System.out.println( code  + "\t" + description  + "\t" + unitPrice  + "\t" + qtyOnHand );
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

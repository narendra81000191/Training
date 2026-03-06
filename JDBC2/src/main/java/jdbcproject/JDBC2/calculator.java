package jdbcproject.JDBC2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.cj.xdevapi.Type;

public class calculator {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driverloaded");
        String uname="user1";
        String password="user@123";
        String url="jdbc:mysql://localhost:3306/cfgdb";
        Connection con =DriverManager.getConnection(url,uname,password);
        System.out.println("connection established");
        
        
        
        String query= "{call addno(?,?,?)}";
        CallableStatement cs= con.prepareCall(query);
        cs.setInt(1, 34);
        cs.setInt(2, 78);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();
        int sum=cs.getInt(3);
        System.out.println("addition of two no."+sum);
        
        //sub
        String query2= "{call addno(?,?,?)}";
        CallableStatement cs2= con.prepareCall(query);
        cs.setInt(1, 34);
        cs.setInt(2, 78);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();
        int sub=cs2.getInt(3);
        System.out.println("subtractionfo tow no."+sub);
        
        
        
        //mul
        String query3= "{call addno(?,?,?)}";
        CallableStatement cs3= con.prepareCall(query);
        cs.setInt(1, 34);
        cs.setInt(2, 78);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();
        int mul=cs3.getInt(3);
        System.out.println("multipily of two no."+mul);
        
        
        
        
        //division 
        String query4= "{call addno(?,?,?)}";
        CallableStatement cs4= con.prepareCall(query);
        cs.setInt(1, 34);
        cs.setInt(2, 78);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();
        int div=cs.getInt(3);
        System.out.println("division of two no."+sum);
        
        
        
        
        
        
        
        
        
        
        
	}

}

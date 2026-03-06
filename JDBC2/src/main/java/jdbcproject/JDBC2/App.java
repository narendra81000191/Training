package jdbcproject.JDBC2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Class.forName("com.mysql.ck.jdbc.Driver");
        System.out.println("driverloaded");
        String uname="user1";
        String password="user@123";
        String url="jdbc:mysql://localhost:3306/cfgdb";
        Connection con =DriverManager.getConnection(url,uname,password);
        System.out.println("connection established");
        String query="{call get_all_student()}";
        CallableStatement  cs=con.prepareCall(query);
        
        
        ResultSet rs=cs.executeQuery();
        System.out.println("statudent data");
        System.out.println("8888888888888888");
        ResultSet MetaData rsmd = rs.getMetaData();
        int count=rsmd.getColumnCount();
        for (int i = 1;i<=count;i++)
        	System.out.println(rsmd.getCatalogName(i)+"   " +rsmd.getColumnTypeName(i));
        System.out.println("******8*888");
        while(rs.next())
        	System.out.println("Stdid:"+ rs.getInt(rsmd.getColumnName(1)));
        System.out.println("Stdid:"+ rs.getString(rsmd.getColumnName(1)));
        System.out.println("Stdid:"+ rs.getDouble(rsmd.getColumnName(1)));
    }
}

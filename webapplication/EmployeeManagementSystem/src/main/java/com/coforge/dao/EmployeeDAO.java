//////package com.coforge.dao;
//////
//////import java.sql.Connection;
//////import java.sql.PreparedStatement;
//////import java.sql.ResultSet;
//////import java.sql.SQLException;
//////import java.sql.Statement;
//////// import java.time.LocalDate; // not used directly here
//////import java.util.ArrayList;
//////import java.util.List;
//////
//////import com.coforge.models.Employee;
//////import com.coforge.util.DButil;
//////
//////public class EmployeeDAO {
//////
//////    public static List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
//////        String quString = "select * from employee";
//////        List<Employee> templistEmployees = new ArrayList<Employee>();
//////        try (Connection connection = DButil.getConnection()) {
//////            Statement statement = connection.createStatement();
//////            ResultSet rSet = statement.executeQuery(quString);
//////            while (rSet.next()) {
//////                Employee employee = new Employee();
//////                employee.setEid(rSet.getLong("eid"));
//////                employee.setEname(rSet.getString("ename"));
//////                employee.setSalary(rSet.getDouble("salary"));
//////                employee.setEmail(rSet.getString("email"));
//////                employee.setMobile(rSet.getString("mobile"));
//////                employee.setDoj(rSet.getDate("doj").toLocalDate());
//////                employee.setDoj(rSet.getDate("dob").toLocalDate());
//////                templistEmployees.add(employee);
//////            }
//////        } catch (ClassNotFoundException | SQLException e) {
//////            e.printStackTrace();
//////        }
//////        return templistEmployees;
//////    }
//////
//////    public static void addEmployee(Employee employee) {
//////        String queryString = "insert into employee(ename,salary,email,mobile,doj,dob)values(?,?,?,?,?,?)";
//////        try (Connection connection = DButil.getConnection()) {
//////        	PreparedStatement pStatement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
//////            // pStatement.setLong(1, employee.getEid());
//////            pStatement.setString(1, employee.getEname());
//////            pStatement.setDouble(2, employee.getSalary());
//////            pStatement.setString(3, employee.getEmail());
//////            pStatement.setString(4, employee.getMobile());
//////            pStatement.setDate(5, java.sql.Date.valueOf(employee.getDob()));
//////            pStatement.setDate(6, java.sql.Date.valueOf(employee.getDoj()));
//////            pStatement.executeUpdate();
//////            System.out.println("row inserted");
//////        } catch (ClassNotFoundException | SQLException e) {
//////            // swallowed as in original
//////        }
//////    }
//////
//////    public void updateEmployee(Employee emp) {
//////    }
//////
//////    public static Employee getEmployeeById(long eid) {
//////        String sql = "SELECT eid, ename, salary, email, mobile, doj, dob FROM employee WHERE eid = ?";
//////        try (Connection connection = DButil.getConnection();
//////             PreparedStatement ps = connection.prepareStatement(sql)) {
//////
//////            ps.setLong(1, eid);
//////
//////            try (ResultSet rs = ps.executeQuery()) {
//////                if (rs.next()) {
//////                    Employee e = new Employee();
//////                    e.setEid(rs.getLong("eid"));
//////                    e.setEname(rs.getString("ename"));
//////                    e.setSalary(rs.getDouble("salary"));
//////                    e.setEmail(rs.getString("email"));
//////                    e.setMobile(rs.getString("mobile"));
//////
//////                    java.sql.Date dojSql = rs.getDate("doj");
//////                    java.sql.Date dobSql = rs.getDate("dob");
//////                    e.setDoj(dojSql != null ? dojSql.toLocalDate() : null);
//////                    e.setDob(dobSql != null ? dobSql.toLocalDate() : null);
//////
//////                    return e;
//////                }
//////            }
//////        } catch (ClassNotFoundException | SQLException ex) {
//////            ex.printStackTrace(); 
//////        }
//////        return null;
//////    }
//////
////////}
////// 
////
////
////
////package com.coforge.dao;
//// 
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.sql.Statement;
////import java.util.ArrayList;
////import java.util.List;
//// 
////import com.coforge.models.Employee;
////import com.coforge.utils.DButil;
//// 
////public class EmployeeDAO {
////	public static List<Employee> getAllEmployees(){
////		String query = "select * from employees";
////		try(Connection con=DButil.getConnection();
////				Statement st = con.createStatement();
////				ResultSet rs = st.executeQuery(query)){
////			List<Employee> empList = new ArrayList<Employee>();
////			while(rs.next()) {
////				Employee emp = new Employee();
////				emp.setEid(rs.getInt("eid"));
////				emp.setEname(rs.getString("ename"));
////				emp.setSalary(rs.getLong("salary"));
////				emp.setEmail(rs.getString("email"));
////				emp.setMobile(rs.getString("mobile"));
////				emp.setDob(rs.getDate("dob").toLocalDate());
////				emp.setDoj(rs.getDate("doj").toLocalDate());
////				empList.add(emp);
////			}
////			return empList;
////		} catch (ClassNotFoundException | SQLException e) {
////					// TODO Auto-generated catch block
////			e.printStackTrace();
////			return null;
////		}
////	}
////	public static Employee addEmployee(Employee employee) {
////		String query = "insert into employees (ename,salary,email,mobile,doj,dob) values (?,?,?,?,?,?)";
////		try(Connection con=DButil.getConnection();
////			PreparedStatement ps = con.prepareStatement(query);){
////			ps.setString(1, employee.getEname());
////			ps.setLong(2, employee.getSalary());
////			ps.setString(3, employee.getEmail());
////			ps.setString(4, employee.getMobile());
////			ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
////			ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));
////			ps.executeUpdate();
////			return employee;
////		} catch (ClassNotFoundException | SQLException e) {
////					// TODO Auto-generated catch block
////			e.printStackTrace();
////			return null;
////		}
////	}
////	public static Employee updateEmployee(Employee employee) {
////		String query = "insert into employees (ename,salary,email,mobile,doj,dob) values (?,?,?,?,?,?)";
////		try(Connection con=DButil.getConnection();
////				PreparedStatement ps = con.prepareStatement(query);){
////			ps.setString(1, employee.getEname());
////			ps.setLong(2, employee.getSalary());
////			ps.setString(3, employee.getEmail());
////			ps.setString(4, employee.getMobile());
////			ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
////			ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));
////			ps.executeUpdate();
////			return employee;
////		} catch (ClassNotFoundException | SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////			return null;
////		}
////	}
////	public static Employee getEmployeeById(int eid) {
////		return null;
////	}
////}
//
// 
package com.coforge.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.coforge.models.Employee;
import com.coforge.utils.DButil;
 
public class EmployeeDAO {
	public static List<Employee> getAllEmployees(){
		String query = "select * from employee";
		try(Connection con=DButil.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)){
			List<Employee> empList = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setSalary(rs.getLong("salary"));
				emp.setEmail(rs.getString("email"));
				emp.setMobile(rs.getString("mobile"));
				emp.setDob(rs.getDate("dob").toLocalDate());
				emp.setDoj(rs.getDate("doj").toLocalDate());
				empList.add(emp);
			}
			return empList;
		} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
//	public static Employee addEmployee(Employee employee) {
//		System.out.println(">>> addEmployee called <<<");
//		String query = "insert into employee (ename,salary,email,mobile,doj,dob) values (?,?,?,?,?,?)";
//		try(Connection con=DButil.getConnection();
//			PreparedStatement ps = con.prepareStatement(query);){
//			ps.setString(1, employee.getEname());
//			ps.setLong(2, employee.getSalary());
//			ps.setString(3, employee.getEmail());
//			ps.setString(4, employee.getMobile());
//			ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
//			ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));
//			ps.executeUpdate();
//			System.out.println(">>> INSERT DONE <<<");
//			return employee;
//			
//			
//		} catch (ClassNotFoundException | SQLException e) {
//					// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//	public static Employee updateEmployee(Employee employee) {
//		String query = "insert into employee (ename,salary,email,mobile,doj,dob) values (?,?,?,?,?,?)";
//		try(Connection con=DButil.getConnection();
//				PreparedStatement ps = con.prepareStatement(query);){
//			ps.setString(1, employee.getEname());
//			ps.setLong(2, employee.getSalary());
//			ps.setString(3, employee.getEmail());
//			ps.setString(4, employee.getMobile());
//			ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
//			ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));
//			ps.executeUpdate();
//			return employee;
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//	public static Employee getEmployeeById(int eid) {
//		return null;
//	}
//}
	
public static Employee addEmployee(Employee employee) {
		String query = "insert into employee (ename,salary,email,mobile,doj,dob) values (?,?,?,?,?,?)";
		try(Connection con=DButil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);){
			ps.setString(1, employee.getEname());
			ps.setLong(2, employee.getSalary());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getMobile());
			ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
			ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));
			ps.executeUpdate();
			return employee;
		} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void updateEmployee(Employee employee) {
		String query = "update employee set ename =?, salary=?, email=?,mobile=?,doj=?,dob=? where eid=?";
		try(Connection con=DButil.getConnection();
				PreparedStatement ps = con.prepareStatement(query);){
			ps.setString(1, employee.getEname());
			ps.setLong(2, employee.getSalary());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getMobile());
			ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
			ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));
			ps.setLong(7, employee.getEid());
			ps.executeUpdate();
			//return employee;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		}
	}
	public static Employee getEmployeeById(long eid) {
		Employee employee = null;
		String query = "select * from employee where eid = ?";
		try(
				Connection connection = DButil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				){
		ps.setLong(1, eid);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			employee = new Employee();
			employee.setEid(rs.getLong("eid"));
			employee.setEname(rs.getString("ename"));
			employee.setSalary(rs.getLong("salary"));
			employee.setEmail(rs.getString("email"));
			employee.setMobile(rs.getString("mobile"));
			employee.setDoj(rs.getDate("doj").toLocalDate());
			employee.setDob(rs.getDate("dob").toLocalDate());
			System.out.println(employee);

			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employee;
	}

public static void deleteEmployee(int eid) {
    String sql = "delete from employee WHERE eid=?";

    try (Connection con = DButil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, eid);
        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static Employee getEmployeeById1(long eid) {
    Employee employee = null;
    String query = "select * from employee where eid = ?";
    try(
        Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
    ){
        ps.setLong(1, eid);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            employee = new Employee();
            employee.setEid(rs.getLong("eid"));
            employee.setEname(rs.getString("ename"));
            employee.setSalary(rs.getLong("salary"));
            employee.setEmail(rs.getString("email"));
            employee.setMobile(rs.getString("mobile"));
            employee.setDoj(rs.getDate("doj").toLocalDate());
            employee.setDob(rs.getDate("dob").toLocalDate());
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
    return employee;
}
public static List<Employee> searchEmployees(String keyword) {
	 
    List<Employee> list = new ArrayList<>();
 
    String sql = "select * from employee " +
                 "where lower(ename) like ? or mobile like ?";
 
    try (Connection con = DButil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
 
        ps.setString(1, "%" + keyword.toLowerCase() + "%");
        ps.setString(2, "%" + keyword + "%");
 
        ResultSet rs = ps.executeQuery();
 
        while (rs.next()) {
            Employee e = new Employee();
            e.setEid(rs.getLong("eid"));
            e.setEname(rs.getString("ename"));
            e.setSalary(rs.getLong("salary"));
            e.setEmail(rs.getString("email"));
            e.setMobile(rs.getString("mobile"));
            e.setDoj(rs.getDate("doj").toLocalDate());
            e.setDob(rs.getDate("dob").toLocalDate());
 
            list.add(e);
        }
 
    } catch (Exception e) {
        e.printStackTrace();
    }
 
    return list;
}


}



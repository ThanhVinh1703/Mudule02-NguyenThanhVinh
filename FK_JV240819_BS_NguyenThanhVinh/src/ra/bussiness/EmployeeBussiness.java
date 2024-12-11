package ra.bussiness;

import ra.entity.Employees;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBussiness {
    public static List<Employees> findAll(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employees> listEmployees = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_employee()}");
            ResultSet rs = callSt.executeQuery();
            listEmployees = new ArrayList<>();
            while (rs.next()) {
                Employees employees = new Employees();
                employees.setEmployeeId(rs.getInt("employee_id"));


        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listEmployees;
    }
}

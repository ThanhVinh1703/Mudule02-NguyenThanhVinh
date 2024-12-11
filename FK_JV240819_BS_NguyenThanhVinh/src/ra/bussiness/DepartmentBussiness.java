package ra.bussiness;

import ra.entity.Departments;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentBussiness {
    public static List<Departments> findAll(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Departments> listDepartments = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_departments()}");
            ResultSet rs = callSt.executeQuery();
            listDepartments = new ArrayList<>();
            while (rs.next()) {
                Departments departments = new Departments();
                departments.setDepartmentId(rs.getInt("department_id"));
                departments.setDepartmentName(rs.getString("department_name"));
                departments.setDepartmentStatus(rs.getBoolean("department_status"));
                listDepartments.add(departments);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listDepartments;
    }

    public static boolean createDepartments(Departments department){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_departments(?,?)}");
            callSt.setString(1,department.getDepartmentName());
            callSt.setBoolean(2,true);
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static boolean UpdateDepartments(Departments department){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_departments(?,?,?)}");
            callSt.setInt(1,department.getDepartmentId());
            callSt.setString(2,department.getDepartmentName());
            callSt.setBoolean(3,true);
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static boolean deleteDepartments(int departmentId){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_departments(?)}");
            callSt.setInt(1,departmentId);
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

}

package ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employees implements IHrManagement{
    private int employeeId;
    private String employeeName;
    private String position;
    private double salary;
    private Date hireDate;

    public Employees() {
    }

    public Employees(int employeeId, String employeeName, String position, double salary, Date hireDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập ID nhân viên: ");
        this.employeeId = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập tên nhân viên: ");
        this.employeeName = scanner.nextLine();

        System.out.println("Nhập vị trí công việc nhân viên: ");
        this.position = scanner.nextLine();

        System.out.println("Nhập mức lương nhân viên:");
        this.salary = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập ngày tuyển dụng nhân vien: ");
        String dateInpute = scanner.nextLine();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            hireDate = sdf.parse(dateInpute);
        }catch (Exception e) {
            System.out.println("Ngày tuyển dụng không hợp lệ ");
            this.hireDate = null;
        }

    }

    @Override
    public void displayData() {
        System.out.printf(" ID nhân viên: %d - Tên nhân viên: %s - Vị trí công việc: %s - Mức lương: %f",this.employeeId, this.employeeName,this.position,this.salary);

    }
}

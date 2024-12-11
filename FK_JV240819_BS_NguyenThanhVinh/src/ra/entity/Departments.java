package ra.entity;

import java.util.Scanner;

public class Departments implements IHrManagement {
    private int departmentId;
    private String departmentName;
    private boolean departmentStatus;

    public Departments() {
    }

    public Departments(int departmentId, String departmentName, boolean departmentStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập ID phòng ban: ");
        this.departmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên phòng ban: ");
        this.departmentName = scanner.nextLine();
        System.out.println("Nhập trạng thái phòng ban:");
        this.departmentStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf(" ID phòng ban: %d - Tên phòng ban: %s - Trạng thái phòng ban: %s",this.departmentId,this.departmentName,this.departmentStatus?"Hoạt động":"Ngừng hoạt động");
    }
}

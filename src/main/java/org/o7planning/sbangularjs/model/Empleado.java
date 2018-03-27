package org.o7planning.sbangularjs.model;
 
public class Empleado {
 
    private Long empId;
    private String empNo;
    private String empName;
    private String empPosition;
 
    public Empleado() {}
 
    public Empleado(EmpleadoForm empForm) {
        this.empId = empForm.getEmpId();
        this.empNo = empForm.getEmpNo();
        this.empName = empForm.getEmpName();
        this.empPosition = empForm.getEmpPosition();
    }
 
    public Empleado(Long empId, String empNo, String empName, String empPosition) {
        this.empId = empId;
        this.empNo = empNo;
        this.empName = empName;
        this.empPosition = empPosition;
    }
 
    public Long getEmpId() {
        return empId;
    } 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getEmpNo() {
        return empNo;
    } 
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
 
    public String getEmpName() {
        return empName;
    } 
    public void setEmpName(String empName) {
        this.empName = empName;
    }
 
    public String getEmpPosition() {
        return empPosition;
    } 
    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    } 
}
package org.o7planning.sbangularjs.model;
 
public class EmpleadoForm {
     
    private Long empId;
    private String empNo;
    private String empName;
    private String empPosition;
 
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
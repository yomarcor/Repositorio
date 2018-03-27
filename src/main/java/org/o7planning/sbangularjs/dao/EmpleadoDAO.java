package org.o7planning.sbangularjs.dao;
  
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
  
import org.o7planning.sbangularjs.model.Empleado;
import org.o7planning.sbangularjs.model.EmpleadoForm;
import org.springframework.stereotype.Repository;
  
@Repository
public class EmpleadoDAO {
  
    private static final Map<Long, Empleado> empMap = new HashMap<Long, Empleado>();
  
    static {
        initEmps();
    }
  
    private static void initEmps() {
        Empleado emp1 = new Empleado(1L, "E01", "Smith", "Clerk");
        Empleado emp2 = new Empleado(2L, "E02", "Allen", "Salesman");
        Empleado emp3 = new Empleado(3L, "E03", "Jones", "Manager");
  
        empMap.put(emp1.getEmpId(), emp1);
        empMap.put(emp2.getEmpId(), emp2);
        empMap.put(emp3.getEmpId(), emp3);
    }
  
    public Long getMaxEmpId() {
        Set<Long> keys = empMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
  
    public Empleado getEmpleado(Long empId) {
        return empMap.get(empId);
    }
  
    public Empleado addEmpleado(EmpleadoForm empForm) {
        Long empId= this.getMaxEmpId()+ 1;
        empForm.setEmpId(empId);
        Empleado newEmp = new Empleado(empForm);  
         
        empMap.put(newEmp.getEmpId(), newEmp);
        return newEmp;
    }
  
    public Empleado updateEmpleado(EmpleadoForm empForm) {
        Empleado emp = this.getEmpleado(empForm.getEmpId());
        if(emp!= null)  {
            emp.setEmpNo(empForm.getEmpNo());
            emp.setEmpName(empForm.getEmpName());
            emp.setEmpPosition(empForm.getEmpPosition());
        }  
        return emp;
    }
  
    public void deleteEmpleado(Long empId) {
        empMap.remove(empId);
    }
  
    public List<Empleado> getAllEmpleados() {
        Collection<Empleado> c = empMap.values();
        List<Empleado> list = new ArrayList<Empleado>();
        list.addAll(c);
        return list;
    } 
}
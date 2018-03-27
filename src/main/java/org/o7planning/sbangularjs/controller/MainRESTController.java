package org.o7planning.sbangularjs.controller;
  
import java.util.List;
  
import org.o7planning.sbangularjs.dao.EmpleadoDAO;
import org.o7planning.sbangularjs.model.Empleado;
import org.o7planning.sbangularjs.model.EmpleadoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
  
@RestController 
public class MainRESTController {
  
    @Autowired
    private EmpleadoDAO EmpleadoDAO;  
  
    // URL:
    // http://localhost:8080/SomeContextPath/Empleados
    // http://localhost:8080/SomeContextPath/Empleados.xml
    // http://localhost:8080/SomeContextPath/Empleados.json
    @RequestMapping(value = "/Empleados", 
		            method = RequestMethod.GET, 
		            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Empleado> getEmpleados() {
        List<Empleado> list = EmpleadoDAO.getAllEmpleados();
        return list;
    }
  
    // URL:
    // http://localhost:8080/SomeContextPath/Empleado/{empId}
    // http://localhost:8080/SomeContextPath/Empleado/{empId}.xml
    // http://localhost:8080/SomeContextPath/Empleado/{empId}.json
    @RequestMapping(value = "/Empleado/{empId}", 
		            method = RequestMethod.GET,
		            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Empleado getEmpleado(@PathVariable("empId") Long empId) 
    {
        return EmpleadoDAO.getEmpleado(empId);
    }
  
    // URL:
    // http://localhost:8080/SomeContextPath/Empleado
    // http://localhost:8080/SomeContextPath/Empleado.xml
    // http://localhost:8080/SomeContextPath/Empleado.json  
    @RequestMapping(value = "/Empleado", 
		            method = RequestMethod.POST, 
		            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Empleado addEmpleado(@RequestBody EmpleadoForm empForm) 
    {  
        System.out.println("(Service Side) Creating Empleado with empNo: " + empForm.getEmpNo());  
        return EmpleadoDAO.addEmpleado(empForm);
    }
  
    // URL:
    // http://localhost:8080/SomeContextPath/Empleado
    // http://localhost:8080/SomeContextPath/Empleado.xml
    // http://localhost:8080/SomeContextPath/Empleado.json
    @RequestMapping(value = "/Empleado", 
    				method = RequestMethod.PUT,
    				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Empleado updateEmpleado(@RequestBody EmpleadoForm empForm) 
    {  
        System.out.println("(Service Side) Editing Empleado with Id: " + empForm.getEmpId());  
        return EmpleadoDAO.updateEmpleado(empForm);
    }
  
    // URL:
    // http://localhost:8080/SomeContextPath/Empleado/{empId}
    @RequestMapping(value = "/Empleado/{empId}", 
		            method = RequestMethod.DELETE, 
		            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmpleado(@PathVariable("empId") Long empId)
    {  
        System.out.println("(Service Side) Deleting Empleado with Id: " + empId);  
        EmpleadoDAO.deleteEmpleado(empId);
    }  
}
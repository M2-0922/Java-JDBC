import java.util.List;

import dao.EmployeeDAO;
import dto.Employee;
import service.EmployeeService;
import service.EmployeeServiceimpl;

public class App {
    public static void main(String[] args) throws Exception {

        EmployeeService employeeService = new EmployeeServiceimpl();

        Employee employee1 = 
            new Employee
            (1,
            "Kubilay",
            "WMAD Instructor",
            0,
            50000);

        Employee employee2 = 
            new Employee
            (2,
            "Francois",
            "WMAD Instructor",
            0,
            60000);
        
        Employee employee3 = 
            new Employee
            (2,
            "Smith",
            "WMAD Instructor",
            0,
            60000);
        
        Employee update_employee1 = 
        	new Employee
        	(2, 
        	"Tom", 
        	"FrontEnd Developer", 
        	1, 
        	65000);
        
		Employee update_employee2 = 
			new Employee
			("BackEnd Developer", 
			75000, 
			"Tom");
		

        // employeeService.addEmployee(employee1);
        // employeeService.addEmployee(employee2);
        // employeeService.deleteEmployee(2);
        // System.out.println(employeeService.findEmployee(1));
		employeeService.addEmployee(employee3);

        List<Employee> employees = employeeService.findAllEmployees();

        for (Employee employee : employees) {
            System.out.println(
                "Employee ID: " + employee.getId() + 
                "| Employee Name " + employee.getName() +
                "| Employee Department " + employee.getDepartment()
            );
        }
        
        employeeService.updateAllEmployee(update_employee1);
      	employeeService.updatePartEmployee(update_employee2);
    }
}

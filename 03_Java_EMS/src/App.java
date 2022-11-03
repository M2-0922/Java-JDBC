import java.util.List;

import dao.EmployeeDAO;
import dto.Employee;
import exception.EmployeeNotFoundException;
import service.EmployeeService;
import service.EmployeeServiceimpl;

public class App {
    public static void main(String[] args) throws Exception {

        try{
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

            // employeeService.addEmployee(employee1);
            // employeeService.addEmployee(employee2);
            // employeeService.deleteEmployee(2);
            // System.out.println(employeeService.findEmployee(1));

            List<Employee> employees = employeeService.findAllEmployees();

            for (Employee employee : employees) {
                System.out.println(
                    "Employee ID: " + employee.getId() + 
                    "| Employee Name " + employee.getName() +
                    "| Employee Department " + employee.getDepartment()
                );
            }

            //update 1 record with id
            Employee employee3 = new Employee(2, "Ben", "Web Design", 1, 500);
            employeeService.updateEmployee(employee3);

            //update all columns of all records
            Employee employee4 = new Employee(0, "John", "Backend Development", 3, 700);
            employeeService.updateAllEmployee(employee4);

            //update some columns of all records
            Employee employee5 = new Employee(0, "Sarry", "Web Development", 0, 800);
            employeeService.updateAllColumnEmployee(employee5, "department","dayAbsent");

        }catch(EmployeeNotFoundException e){
            System.out.println(e.toString());
        }
    }
}

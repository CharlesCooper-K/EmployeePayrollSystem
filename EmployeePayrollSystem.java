package pay;

import java.util.Scanner;

public class EmployeePayrollSystem {
	public static void main(String[] args) {
		// declare and initialize variables
		Scanner input = new Scanner(System.in);
		int choice, employeeId, searchId;
		String name = "";
		String title = "";
		double payRate = 0.0;
		double hoursWorked;
		Employee employees = new Employee();
		PayrollSystem payroll = new PayrollSystem();

		// loop through system
		do {
			System.out.println("\n===== Payroll System =====");
			System.out.println("1. Add Employee\n2. View Employee\n3. Calculate Payroll\n4. Display All Employees\n5. Remove Employee\n6. Exit");
			System.out.print("\nEnter your selection: ");
			choice = input.nextInt();
			
			switch (choice) {
			case 1: 
				// case to create an employee and set values
				System.out.print("Enter Employee Name: ");
				name = input.next();
				employees.setName(name);
				
				System.out.print("Generating Employee Id: ");
				employeeId = (int) (Math.random() * 90000) + 10000;
				System.out.print(employeeId);
				employees.setEmployeeId(employeeId);
				
				System.out.print("\nJob Title: ");
				title = input.next();
				employees.setJobTitle(title);
				
				System.out.print("Pay Rate: ");
				payRate = input.nextDouble();
				employees.setHourlyWage(payRate);
				
				System.out.print("Hours Worked: ");
				hoursWorked = input.nextDouble();
				employees.setHoursWorked(hoursWorked);
				
				payroll.addEmployee(employees);
				break;
				
			case 2:
				// case to select and view employee's information by their id
				System.out.print("Enter Employee Id: ");
				searchId = input.nextInt();
				
				Employee employee = payroll.findEmployee(searchId);
				
				if (employee == null) {
					System.out.println("Invalid Employee Id. Try Again");
					searchId = input.nextInt();
				} else {
					System.out.printf("Employee Name: %s%nEmployee ID: %d%nEmployee Job Title: %s%nEmployee Payrate: %.2f", 
							employees.getName(), employees.getEmployeeId(), employees.getJobTitle(), employees.getHourlyWage());
				}
				break;
				
			case 3:
				// case to calculate and print out payroll
				double totalPayroll = payroll.calculatePayroll();
				
				System.out.printf("Total Payroll: %.2f", totalPayroll);
				break;
				
			case 4:
				// case to display all the employees in the payroll
				payroll.displayPayroll();
				break;
				
			case 5:
				// case to remove an employee
				System.out.print("Enter the Employee ID: ");
				searchId = input.nextInt();
				
				employee = payroll.findEmployee(searchId);

			    if (employee == null) {
			        System.out.println("Invalid Employee Id.");
			    } else {
			        payroll.removeEmployee(searchId);
			        System.out.println("Employee removed successfully.");
			    }
				break;
				
			case 6:
				break;
				
				default:
					System.out.println("Invalid choice");
			}
			// ends loops if inputted by user
		} while (choice !=6);
	}
}

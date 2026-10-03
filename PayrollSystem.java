package pay;

import java.util.ArrayList;

public class PayrollSystem {
	private ArrayList<Employee> employees;
	
	public PayrollSystem() {
		employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void removeEmployee(int employeeId) {
		Employee employee = findEmployee(employeeId);
		
		if (employee != null) {
			employees.remove(employee);
			}
	}
	
	public Employee findEmployee(int employeeId) {
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == employeeId) {
				return employee;
			}
		}
		
		return null;
	}
	
	public double calculatePayroll() {
		double total = 0.0;
		
		for (Employee employee : employees) {
			total += employee.calculateTotalPay();
		}
		
		return total;
	}
	
	public void displayPayroll() {
		for (Employee employee : employees) {
			System.out.printf("Employee ID: %d%nName: %s%nJob Title: %s%nHours Worked: %.2f%nHourly Wage: "
					+ "%.2f%nRegular Pay: %.2f%nOvertime Pay: %.2f%nTotal Pay: %.2f", employee.getEmployeeId(), employee.getName(), employee.getJobTitle(),
					employee.getHoursWorked(), employee.getHourlyWage(), employee.calculateRegularPay(), employee.calculateOvertimePay(), employee.calculateTotalPay());
		}
	}
}

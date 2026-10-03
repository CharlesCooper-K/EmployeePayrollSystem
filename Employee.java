package pay;

public class Employee {

	private int employeeId;
	private String name;
	private String jobTitle;
	private double hourlyWage;
	private double hoursWorked;
	
	public Employee() {
		setEmployeeId(0);
		setName("");
		setJobTitle("");
		setHourlyWage(0.0);
		setHoursWorked(0.0);
	}
	
	public Employee(int employeeId, String name, String jobTitle, double hourlyWage, double hoursWorked) {
		setEmployeeId(employeeId);
		setName(name);
		setJobTitle(jobTitle);
		setHourlyWage(hourlyWage);
		setHoursWorked(hoursWorked);
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}
	
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	public double getHoursWorked() {
		return hoursWorked;
	}
	
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public double calculateRegularPay() {
		double regularHours = Math.min(hoursWorked, 40);
		
	    return hourlyWage * regularHours;
	}
	
	public double calculateOvertimePay() {
		double overtimeHours = Math.max(hoursWorked - 40, 0);
		
		return overtimeHours * (1.5 * hourlyWage);
	}
	
	public double calculateTotalPay() {
		double pay = 0.0;
		
		if (hoursWorked <= 40) {
			pay = calculateRegularPay();
		} else {
			pay = calculateRegularPay() + calculateOvertimePay();
		}
		
		return pay;
	}
}

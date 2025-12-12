import java.util.*;
import java.io.*;

public class PayrollSystem {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {

		addSampleEmployees();

		int choice;
		do {
			System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
			System.out.println("1. Display All Employees");
			System.out.println("2. Add New Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Search Employee");
			System.out.println("6. Generate Payslip");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");

			while (!sc.hasNextInt()) {
				System.out.print("Enter a number: ");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();

			// FIXED: Diganti ke gaya Java 8/11 (Pake colon : dan break)
			// Source code dari repositori aslinya menggunakan arrow di switch-casenya.
			// agar sesuai dengan versi java yang digunakan di kuliah, kami mengubahnya agar
			// kompatibel dengan java 11 (versi Java yang digunakan di Binus).
			switch (choice) {
			case 1:
				displayEmployees();
				break;
			case 2:
				addNewEmployee();
				break;
			case 3:
				updateEmployee();
				break;
			case 4:
				deleteEmployee();
				break;
			case 5:
				searchEmployee();
				break;
			case 6:
				generatePayslip();
				break;
			case 7:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (choice != 7);
	}

	static void addSampleEmployees() {
		employees.add(new NewEmployee(101, "Ravi Kumar", 9876543210L, 40000,
				new BankAccount("SBI", 1234567890L, "SBIN0001234"), 
				"IT", "Laptop",2, "TCS"));
		
		employees.add(new NewEmployee(102, "Priya Sharma", 9876501234L, 35000, 
	            new BankAccount("HDFC", 2234567890L, "HDFC0004321"), 
	            "HR", "Cab", 1, "Infosys"));
	            
	        employees.add(new NewEmployee(103, "Amit Verma", 9123456789L, 50000, 
	            new BankAccount("ICICI", 3234567890L, "ICIC0005678"), 
	            "Finance", "Gym", 3, "Wipro"));
	            
	        employees.add(new NewEmployee(104, "Sneha Patil", 9988776655L, 45000, 
	            new BankAccount("Axis", 4234567890L, "UTIB0007890"), 
	            "Admin", "Canteen", 2, "Capgemini"));
	            
	        employees.add(new NewEmployee(105, "Kiran Reddy", 9012345678L, 42000, 
	            new BankAccount("Union", 5234567890L, "UBIN0006543"), 
	            "Marketing", "Bus", 1, "Tech Mahindra"));
	}

	static void displayEmployees() {
		if (employees.isEmpty()) {
			System.out.println("No employees to display!");
			return;
		}
		for (Employee e : employees) {
			e.display();
		}
	}

	static void addNewEmployee() {
		System.out.print("Employee ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Mobile No: "); long mobile = sc.nextLong(); sc.nextLine();
        System.out.print("Salary: "); double salary = sc.nextDouble(); sc.nextLine();
        
        // REFACTORED: Grouping input Bank
        System.out.print("Bank Name: "); String bankName = sc.nextLine();
        System.out.print("Bank Acc: "); long acc = sc.nextLong(); sc.nextLine();
        System.out.print("IFSC: "); String ifsc = sc.nextLine();
        BankAccount newAccount = new BankAccount(bankName, acc, ifsc); // Bikin objek
        
        System.out.print("Department: "); String dep = sc.nextLine();
        System.out.print("Facility: "); String facility = sc.nextLine();
        System.out.print("Management Level: "); int level = sc.nextInt(); sc.nextLine();
        System.out.print("Entity: "); String entity = sc.nextLine();

        // Pass object newAccount ke constructor
        employees.add(new NewEmployee(id, name, mobile, salary, newAccount, dep, facility, level, entity));
        System.out.println("✅ Employee added!");
	}

	static void updateEmployee() {
		System.out.print("Enter Employee ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Employee found = null;
		for (Employee e : employees)
			if (e.empId == id)
				found = e;

		if (found == null) {
			System.out.println("Employee not found!");
			return;
		}

		System.out.print("New Name (" + found.name + "): ");
		String name = sc.nextLine();
		if (!name.isEmpty())
			found.name = name;
		System.out.print("New Department (" + found.dep + "): ");
		String dep = sc.nextLine();
		if (!dep.isEmpty())
			found.dep = dep;
		
		System.out.print("New Bank (" + found.account.getBankName() + "): ");
		String bank = sc.nextLine();
		if (!bank.isEmpty())
			found.account.setBankName(bank);
		
		System.out.print("New Facility (" + found.facility + "): ");
		String facility = sc.nextLine();
		if (!facility.isEmpty())
			found.facility = facility;
		System.out.print("New Mobile (" + found.mobileNo + "): ");
		String mobile = sc.nextLine();
		if (!mobile.isEmpty())
			found.mobileNo = Long.parseLong(mobile);
		System.out.println("✅ Employee updated!");
	}

	static void deleteEmployee() {
		System.out.print("Enter Employee ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		employees.removeIf(e -> e.empId == id);
		System.out.println("✅ Employee deleted (if existed)!");
	}

	static void searchEmployee() {
		System.out.print("Enter Name or Department to search: ");
		String query = sc.nextLine().toLowerCase();
		for (Employee e : employees) {
			if (e.name.toLowerCase().contains(query) || e.dep.toLowerCase().contains(query)) {
				e.display();
			}
		}
	}

	static void generatePayslip() {
		System.out.print("Enter Employee ID for payslip: ");
		int id = sc.nextInt();
		sc.nextLine();
		NewEmployee emp = null;
		for (Employee e : employees)
			if (e.empId == id && e instanceof NewEmployee)
				emp = (NewEmployee) e;

		if (emp == null) {
			System.out.println("Employee not found!");
			return;
		}

		System.out.println("+---------------------------------------------+");
		System.out.println("|                   PAY SLIP                  |");
		System.out.println("+---------------------------------------------+");
		System.out.printf("| Employee ID   : %-30d |\n", emp.empId);
		System.out.printf("| Name          : %-30s |\n", emp.name);
		System.out.printf("| Department    : %-30s |\n", emp.dep);
		System.out.printf("| Bank          : %-30s |\n", emp.account.getBankName());
		System.out.println("+---------------------------------------------+");
		System.out.printf("| Basic Salary  : %-30.2f |\n", emp.salary);
		System.out.printf("| HRA (20%%)     : %-30.2f |\n", emp.hra);
		System.out.printf("| DA  (10%%)     : %-30.2f |\n", emp.da);
		System.out.printf("| ProvidentFund : %-30.2f |\n", NewEmployee.PROVIDENT_FUND);
		System.out.printf("| ProfessionTax : %-30.2f |\n", NewEmployee.PROFESSIONAL_TAX);
		System.out.printf("| IncomeTax     : %-30.2f |\n", NewEmployee.INCOME_TAX);
		System.out.println("+---------------------------------------------+");
		System.out.printf("| NET SALARY    : %-30.2f |\n", emp.totalSalary());
		System.out.println("+---------------------------------------------+");
	}
}
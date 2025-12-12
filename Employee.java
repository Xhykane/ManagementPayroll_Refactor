public class Employee {
	int empId;
	String name;
	String dep;

	// Refactored: Introduce parameter object
	BankAccount account;

	long mobileNo;
	double salary;
	int managementlevel;
	String Entity;
	String facility;

	Employee(int empId, String name, long mobileNo, double salary, BankAccount account, String dep, String facility,
			 int managementlevel, String Entity) {
		this.empId = empId;
		this.name = name;
		this.dep = dep;
		this.account = account;
		this.salary = salary;
		this.mobileNo = mobileNo;
		this.managementlevel = managementlevel;
		this.Entity = Entity;
		this.facility = facility;
	}

	void display() {
		System.out.println("----------------------------------");
		System.out.println("Employee ID   : " + empId);
		System.out.println("Name          : " + name);
		System.out.println("Department    : " + dep);
		System.out.println("Bank          : " + account.getBankName());
		System.out.println("Mobile No     : " + mobileNo);
		System.out.println("Facility      : " + facility);
		System.out.println("Bank Acc No   : " + account.getAccountNumber());
		System.out.println("IFSC Code     : " + account.getIfscCode());
		System.out.println("Management Lv : " + managementlevel);
		System.out.println("Entity        : " + Entity);
	}
}
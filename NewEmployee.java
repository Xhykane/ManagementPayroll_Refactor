public class NewEmployee extends Employee {
    // REFACTORED: Replace Magic Number with Symbolic Constant
    public static final double HRA_PERCENTAGE = 0.20; // 20%
    public static final double DA_PERCENTAGE = 0.10;  // 10%
    public static final double PROVIDENT_FUND = 2500.00;
    public static final double PROFESSIONAL_TAX = 200.00;
    public static final double INCOME_TAX = 1200.00;

    double hra, da;

    public NewEmployee(int empId, String name, long mobileNo, double salary, BankAccount account, String dep, String facility,
                int managementlevel, String Entity) {
        super(empId, name, mobileNo, salary, account, dep, facility, managementlevel, Entity);
        recomputeSalary();
    }

    void recomputeSalary() {
        // REFACTORED: Pake Constant
        hra = HRA_PERCENTAGE * salary;
        da = DA_PERCENTAGE * salary;
    }

    double totalSalary() {
        // REFACTORED: Pake Constant
        return salary + hra + da + PROVIDENT_FUND - PROFESSIONAL_TAX - INCOME_TAX;
    }
}
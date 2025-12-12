public class BankAccount {
	private String bankName;
	private long accountNumber;
	private String ifscCode;

	public BankAccount(String bankName, long accountNumber, String ifscCode) {
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	@Override
	public String toString() {
		return bankName + " (" + accountNumber + ")";
	}
}
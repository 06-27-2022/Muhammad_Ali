package Utility;

import Main.ERS;
import Models.Employee;

public class AccountUtil {
	public static Employee login() {
		System.out.println();
		System.out.println("---------Log in---------");

		String username = InputValidation.enterString("Enter username: ");
		String password = InputValidation.enterString("Enter password: ");

		if (ERS.employeesList.isEmpty()) {
			System.out.println("No existing account.");
		} else {
			for (Employee account : ERS.employeesList) {
				if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
					return account;
				}
			}
			System.out.println("Wrong username or password");
		}
		return null;
	}

	public static void register() {
		System.out.println();
		System.out.println("---------Register an account---------");
		String username = "";
		String password = "";

		boolean validUsername = false;
		while (!validUsername) {
			username = InputValidation.enterString("Enter username: ").toLowerCase();

			if (ERS.employeesList.isEmpty()) {
				validUsername = true;
			} else {
				for (Employee account : ERS.employeesList) {
					if (username.equals(account.getUsername())) {
						System.out.println("Username already taken.");
						validUsername = false;
						break;
					} else {
						validUsername = true;
					}
				}
			}
		}

		password = InputValidation.enterString("Enter password: ");

		Employee newAccount = new Employee(0, username, password, "doesn't matter", 0);
		DAO dao = new DAO();
		// dao.addNewEmployee(newAccount);
	}

	public static void showAllEmployees() {
		System.out.println();
		System.out.println("---------Employees list---------");

		for (Employee employee : ERS.employeesList)
			System.out.println(employee);

		System.out.println("--------------------------------");

	}

	public static int getAccountBalanceByID(int id) {
		for (Employee employee: ERS.employeesList) {
			if(employee.getId() == id)
				return employee.getAccountBalance();
		}
		return 0;
	}
	
	public static String getUsernameByID(int id) {
		for (Employee employee: ERS.employeesList) {
			if(employee.getId() == id)
				return employee.getUsername();
		}
		return "";
	}
}

package mng;

import data.Account;
import data.DealerList;
import tools.MyTool;

public class DealerApp {

	public static void main(String[] args) {
		LogIn login = new LogIn();
		Account acc = null;// account will login to system
		boolean isAllowAcces = false;
		boolean cont = false;
		do {
			login = login.RequireLogin();
			acc = login.getAcc();
			if (acc != null) {
				System.out.println("Login Successfully !");
			}
			isAllowAcces = acc.getRole().equalsIgnoreCase(LogIn.permissonRole);
			if (isAllowAcces)
				break;

			if (!isAllowAcces) {
				System.out.println("Access Denied, this program for role " + LogIn.permissonRole + " only !");
				cont = MyTool.readBool("Do you want to login again or quit ! ");
				if (!cont) {
					System.out.println("Goodbye !");
					System.exit(0);
				}
			}
		} while (cont);

		// Set up menu
		String[] options = { "Add new dealer", "Search a dealer", "Changes dealer's status Continuing",
				"Remove a dealer", "Update a dealer", "Print all dealers", "Print continuing dealers",
				"Print UN-continuing dealers", "Write to file" };
		Menu menu = new Menu(options);
		DealerList dList = new DealerList(login);// create a login obj for valide acc
		dList.initWithFile();
		int choice = 0;
		System.out.println("\n===============================");
		System.out.println("   Welcome to manage dealers");
		System.out.println("===============================");

		do {
			choice = menu.getChoice("Managing dealers");
			System.out.println();
			switch (choice) {
			case 1:
				dList.addDealer();
				break;
			case 2:
				dList.searchDealer();
				break;
			case 3:
				dList.removeDealer();
				break;
			case 4:
				dList.removeDealerreal();
				break;
			case 5:
				dList.updateDealer();
				break;
			case 6:
				dList.printAllDealers("List Of Dealers");
				break;
			case 7:
				dList.printContinuingDealers();
				break;
			case 8:
				dList.printUnContinuingDealers();
				break;
			case 9:
				dList.writeDealerToFile();
				break;
			default:
				if (dList.isChanged()) {
					boolean response = MyTool.readBool("Data changed. Write to file ? ");
					if (response == true) {
						dList.writeDealerToFile();
					}
				}
				System.out.println("((See you next time))");
			}
		} while (choice > 0 && choice <= menu.size());
	}
}

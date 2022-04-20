package Login;
import java.util.*;
public class Arraylist extends information{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		information info = new information();
		while(true) {
			try {
			System.out.println("\nWELCOME ......\nPress 1 for Sign up\npress 2 for Sign In\nPress 3 to display all users\nPress 4 for Updation\nPress 5 to quit");
			System.out.println("Enter choice: ");
			int choice = Integer.parseInt(sc.next());
			switch(choice) {
					case 1 : 	System.out.println("\nEnter the Credentials : \n Enter the Candidate Name : ");
								String name  = sc.next();
								System.out.println("Enter the email_id : ");
								String email = sc.next();
								info.add_candidate(name, email);
								break;
						
					case 2 : 	System.out.println("\nEnter the identity number :");
				           		int id = Integer.parseInt(sc.next());
				           		System.out.println("\nEnter the Name : ");
				           		String Name= sc.next();
				           		info.check(id,Name);
								break;
					
					case 3 :    System.out.println("\nEnter Your Name : ");
								info.display(sc.next());
								break;
					
					case 4 :    System.out.println("\nEnter the identity number :");
                                int identitynumber = Integer.parseInt(sc.next());
                                info.update_candidate_information(identitynumber);
                                break;
								
					case 5 : System.exit(0);
								break;
		}
		
		}
		catch(InputMismatchException | NumberFormatException e) {
			System.out.println("Use the displayed options.");
		}
		finally {
			System.out.println("\n\nThanks for visiting the page");
		}
		}
	}
}

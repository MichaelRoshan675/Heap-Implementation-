package Login;
import java.util.*;

enum validation {
	SUCCESS,FAILURE;
}
public class information {
	static int identity_number=000;
	Scanner sc = new Scanner(System.in);
	HashMap<Integer,String> candidate = new HashMap<>();
	HashMap<Integer,String> candidate_email = new HashMap<>();
	HashMap<String,String> candidate_validation = new HashMap<>();
 	void change() {
		identity_number+=1;
	}
	public void add_candidate(String name, String email_id){
		change();
		candidate.put(identity_number, name);
		candidate_email.put(identity_number, email_id);
		display_candidate(name);
	}
	public void display_candidate(String Candidate_name)
	{
		Iterator<Integer> iterator = candidate.keySet().iterator();
		while(iterator.hasNext()) {
			int key = (int)iterator.next();
			if(Candidate_name.equals(candidate.get(key))) {
				System.out.println("\nIdentity Number : "+key);
				System.out.println();
			}
		}
	}
	public void display(String Name) {
		if(candidate_validation.get(Name) == validation.SUCCESS.name()) {
		if(candidate.isEmpty()) {
			System.out.println("\nNo Records");
		}
		Iterator<Integer> iterator = candidate.keySet().iterator();
		while(iterator.hasNext()) {
			int key = (int)iterator.next();
			System.out.println("\nId : "+key+"\nName: "+candidate.get(key)+"\nEmail id : "+candidate_email.get(key));
		}	
		}
		else {
			System.out.println("\nSign in for details");
		}
	}
	public void check(int identity_number, String candidate_name) {
		Iterator<Integer> iterator = candidate.keySet().iterator();
		int c=1;
		while(iterator.hasNext()) {
			int key = (int)iterator.next();
			if(candidate_name.equals(candidate.get(key)) &&  identity_number == key){
				System.out.println("LOGIN "+validation.SUCCESS);
				c=0;
				candidate_validation.put(candidate_name, validation.SUCCESS.name());
				break;
			}
			else {
				candidate_validation.put(candidate_name, validation.FAILURE.name());
			}
		}
		if(c==1) {
		System.out.println("LOGIN "+validation.FAILURE);
		}
	}
	public void update_candidate_information(int identity_number) {
		String validate_name = candidate.get(identity_number);
		if(candidate_validation.get(validate_name) == validation.SUCCESS.name()) {
			System.out.println("\nEnter the field to be updated : ");
			String to_update_field = sc.next();
			if(to_update_field.equals("name")) {
				System.out.println("\nEnter the name : ");
				candidate.replace(identity_number, sc.next());
			}
			else if(to_update_field.equals("email")) {
				System.out.println("\nEnter the new email : ");
				candidate_email.replace(identity_number, sc.next());
			}
		}
		System.out.println("Field Updated...");
	}
//	information(){
//		
//	}
}

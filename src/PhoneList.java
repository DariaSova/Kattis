import java.util.*;

public class PhoneList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for(int j=0; j<tests; j++){
			
		int n = sc.nextInt();
		sc.nextLine();
		
		boolean incons = false;
		
		ArrayList<String> numbers = new ArrayList<String>();
		
		for(int i=0; i<n; i++){
			numbers.add(sc.nextLine());
		}
		
		Collections.sort(numbers);
		
		for(int i=0; i<n-1; i++){
			String pref = numbers.get(i);
			String hasPref = numbers.get(i+1);
			
			if(hasPref.length()>= pref.length()){
				if(hasPref.startsWith(pref)) {
					System.out.println("NO");
					incons = true;
					break;
				}
			}
		}
		
		if(!incons) System.out.println("YES");
		
		}
	}

}

import java.util.*;


///remove sorting

public class LimitedCorrespondence {
	public static class StringLengthListSort implements Comparator<String>{

	    @Override
	    public int compare(String s1, String s2) {
	    	if(s1.length()!=s2.length()) return s1.length() - s2.length();
	    	else return s1.compareTo(s2);
	    }
	}
	
	
	static ArrayList<String> options;
	static String resA="";
	static String resB="";
	static long SMALLEST;
	
	public static void getoptions(ArrayList<String> strings){
		for(int i=0; i<strings.size(); i++){
			String curr = strings.get(i);
			String[] in = curr.split(" ");
			String a = in[0];
			String b = in[1];
			
//			String t1, t2;
//			if(a.startsWith(b)||b.startsWith(a)) {
				String t1 = resA+a;
				String t2 = resB+b;
//			}
			
			if(t1.equals(t2)) {

				if(t2.length()<=SMALLEST) {
					SMALLEST = t2.length();
					options.add(t2);
				}
				
			}
			
			else if(t1.startsWith(t2)||t2.startsWith(t1)){
//				if(SMALLEST<Integer.MAX_VALUE && t1.length()<SMALLEST){
				
					//i=-1;
					if(t1.length()<SMALLEST){
						strings.remove(i);
						resA = t1;
						resB = t2;
						getoptions(strings);
						strings.add(curr);
						//Collections.sort(strings);
					}
					
					
				}
//			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int k=0; k<5; k++){
			if(!sc.hasNextLine()) break;
		options = new ArrayList<>();
		resA="";
		resB="";
		SMALLEST = Integer.MAX_VALUE;
		
		
		int n = sc.nextInt();
		sc.nextLine();
		ArrayList<String> strings = new ArrayList<String>();
		
		for(int i=0; i<n; i++){
			strings.add(sc.nextLine());
//			StringsLexSort c = new StringsLexSort();
			//Collections.sort(strings);
		}
		
		
		getoptions(strings);
		
		
		if(options.isEmpty()) System.out.println("Case " + (k+1)+": "+"IMPOSSIBLE");
		else {
			StringLengthListSort ss = new StringLengthListSort();
			java.util.Collections.sort(options, ss);
			System.out.println("Case " + (k+1)+": "+options.get(0));
		}
		
		}
	}

}

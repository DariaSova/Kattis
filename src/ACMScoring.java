import java.util.*;


public class ACMScoring {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long total_time=0;
		int total_solved=0;
		
		HashMap<String, Integer> penalties = new HashMap<>();
		
		
		int t = sc.nextInt();
		while(t!=-1){
			String problem = sc.next();
			String res  = sc.next();
			
			if(res.equals("right")){
				total_solved++;
				total_time+=t;
				if(penalties.containsKey(problem)) total_time+=penalties.get(problem);
				
			}else{ //wrong
				if(penalties.containsKey(problem)) penalties.put(problem, penalties.get(problem)+20);
				else penalties.put(problem, 20);
			}
			
			
			
			//next str
			t = sc.nextInt();
		}
		
		
		System.out.println(total_solved+" "+total_time);
	}
}

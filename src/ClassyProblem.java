import java.util.*;
import java.math.*;

public class ClassyProblem {
	
	public static class Pair implements Comparable<Pair> {
			String name;
			int value;
			
			public Pair(String n, int val){
				this.name = n;
				this.value = val;
			}
			
			@Override
		    public int compareTo(Pair o) {
		        if(this.value == o.value){
		        	int x = this.name.compareTo(o.name);
			        return x == 0 ? x: this.name.compareTo(o.name); // : x;
		        }
		        return this.value > o.value ? -1 : 1;
				
		    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcases = sc.nextInt();
		
		for(int i=0; i<testcases; i++){
			int n = sc.nextInt();
			sc.nextLine();
			
			Pair[] people = new Pair[n];
			
			for(int j=0; j<n; j++){
				String[] in = sc.nextLine().split(" ");
				String person = in[0].replace(":", "");;
//				System.out.println(person);
				String[] classes = in[1].split("-");
				int res=0;
				int curr =0;
				for(int k=10; k>=1; k--){
					if(curr<classes.length){
						if(classes[curr].equals("upper")) res += 3*k;
						if(classes[curr].equals("middle")) res += 2*k;
						if(classes[curr].equals("lower")) res += k;
						curr++;
					}else{
						res+=k;
					}
				}
				

//				System.out.println(person + " " + res);
				people[j] = new Pair(person, res);

				
				
			}

			

			Arrays.sort(people);
			for (Pair p : people) System.out.println(p.name);
	        System.out.println("==============================");
			
		}
	}
}



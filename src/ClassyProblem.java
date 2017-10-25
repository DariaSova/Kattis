import java.util.*;

public class ClassyProblem {
	
	public static class Pair implements Comparable<Pair> {
			String name;
			String value;
			
			public Pair(String n, String val){
				this.name = n;
				this.value = val;
			}
			
			@Override
		    public int compareTo(Pair o) {
//		        if(this.value == o.value){
//		        if(this.value.compareTo(o.value)!=0){
		        	int x = this.value.compareTo(o.value);
			        return x == 0 ? this.name.compareTo(o.name) : x;
//		        }
//		        return this.name.compareTo(o.name);// ? -1 : 1;
//		        return this.value > o.value ? -1 : 1;
				
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
				String person = in[0].replace(":", "");
//				System.out.println(person);
				String[] classes = in[1].split("-");
//				int res=0;
				int curr =0;
				char[] t = new char[10];
				for(int k=0; k<10; k++){
					if(curr<classes.length){
						if(classes[classes.length - k - 1].equals("upper")) t[k]='0';
						if(classes[classes.length - k - 1].equals("middle")) t[k]='1';
						if(classes[classes.length - k - 1].equals("lower")) t[k]='2';
						curr++;
					}else{
						t[k] ='1';
					}
					
//					if(curr<classes.length){
//						if(classes[curr].equals("upper")) res += 3*k;
//						if(classes[curr].equals("middle")) res += 2*k;
//						if(classes[curr].equals("lower")) res += k;
//						curr++;
//					}else{
//						res+=k;
//					}
				}
				

				System.out.println(person + " "+ new String(t));
				people[j] = new Pair(person, new String(t));

				
				
			}

			

			Arrays.sort(people);
			for (Pair p : people) System.out.println(p.name);
	        System.out.println("==============================");
			
		}
	}
}


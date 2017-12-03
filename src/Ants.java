import java.util.Scanner;
import java.util.TreeSet;

public class Ants {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++){
		
			int l = sc.nextInt();
			int ants = sc.nextInt();
			int min = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int j=0; j<ants; j++){
				int pos = sc.nextInt();
			
				min = Math.max(min, Math.min(pos, l-pos));
				max = Math.max(max, Math.max(pos, l-pos));
			}
			
			System.out.println(min+" "+ max);
		}
	}

}

import java.util.*;

public class OddGnome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for(int i=0; i<tests; i++){
			int n = sc.nextInt();
			int[] gnomes = new int[n];
			for(int j=0; j<n; j++){
				gnomes[j] = sc.nextInt();
			}
			
			int prev = gnomes[0];
			for(int j=1; j<n; j++){
				int next = gnomes[j];
				if(next!=prev+1){
					System.out.println(j+1);
					break;
				}else{
					prev = next;
				}
			}
		}
	}
}

import java.util.*;

public class ProgressiveScramble {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<tests; i++){
			String input = sc.nextLine();
			String[] in = input.split(" ", 2);
			String cmd = in[0];
			String str = in[1];
			
			
			if(cmd.equals("e")){
				encrypt(str);
				System.out.println();
			}else if(cmd.equals("d")){
				decrypt(str);
				System.out.println();
			}
		}
	}
	
	public static void decrypt(String s){
		int n = s.length();
		if(n==0) return;
		int[] values = new int[n];
		for(int i=0; i<n; i++){
			if(s.charAt(i)==' '){
				values[i] = 0;
			}else{
				int val = (int)s.charAt(i)-96;
				values[i] = val;
			}
		}
		
		int prev = values[0];
		for(int i=1; i<n; i++){
			while(values[i]<prev) values[i] += 27;
			prev = values[i];
		}
		
		int temp=values[0];
		for(int i=1; i<n; i++){
			int temp2 = values[i];
			values[i] -= temp;
			temp = temp2;
		}
		
		for(int i=0; i<n; i++){
			if(values[i]==0) System.out.print(' ');
			else System.out.print((char)(values[i]+96));
		}
	}
	
	public static void encrypt(String s){
		int n = s.length();
		if(n==0) return;
		int[] values = new int[n];
		for(int i=0; i<n; i++){
			if(s.charAt(i)==' '){
				values[i] = 0;
			}else{
				int val = (int)s.charAt(i)-96;
				values[i] = val;
			}
		}

		for(int i=1; i<n; i++){
			values[i] += values[i-1];
		}
		
		for(int i=1; i<n; i++){
			values[i] = values[i] % 27;
		}
		
		for(int i=0; i<n; i++){
			if(values[i]==0) System.out.print(' ');
			else System.out.print((char)(values[i]+96));
		}
	}
}

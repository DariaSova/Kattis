import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Candies {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		InputStreamReader sc = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sc);
		try{
		int tests = Integer.valueOf(br.readLine());
		
		
		for(int i=0; i<tests; i++){
			br.readLine();
//			sc.next();
			//BigInteger total = new BigInteger("0");
			long total = 0;
			int N = Integer.valueOf(br.readLine());
			
			//sc.next();
			//br.readLine(); 
			
			for(int j=0; j<N; j++){
				//total.add(new BigInteger(br.readLine()));
				total+= Long.valueOf(br.readLine())%N;
			
			}
			
			
			if(total==0||total%N==0) System.out.println("YES");
			else System.out.println("NO");

		}
		
		 } catch (IOException ioe) {}
	
	}
}

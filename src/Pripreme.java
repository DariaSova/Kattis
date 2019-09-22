import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pripreme {
	public static void main ( String[] args ) {

		  Scanner sc = new Scanner( System.in );
//		  InputStreamReader sc = new InputStreamReader(System.in);
//		  BufferedReader br = new BufferedReader(sc);
		  
		  //try{
			  
			  int tests = sc.nextInt(); //Integer.valueOf(br.readLine());
			  long sum = 0;
			  long max = Long.MIN_VALUE;
			  
			  for(int i=0; i<tests; i++){
				  long num = sc.nextLong(); 
				  sum+=num; 
				  if(num>max) max = num;
				  
			  }

//			  System.out.println("sum "+ sum);
			  
			  if(max>sum-max) System.out.println(max*2);
			  else System.out.println(sum);
			  
			  
		//  } catch (IOException ioe) {}
	}

}

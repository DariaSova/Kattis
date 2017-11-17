
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OwlAndTheFox {
	public static void main ( String[] args ) {

//		  Scanner sc = new Scanner( System.in );
		  InputStreamReader sc = new InputStreamReader(System.in);
		  BufferedReader br = new BufferedReader(sc);
		  try{
		  
		  int tests = Integer.valueOf(br.readLine());
		  
		  
		  for(int i=0; i<tests; i++){
			
			  String str = br.readLine();
			  //original
//			  int length = in.length();
//			  in.replace("0", "");
			  char[] in = str.toCharArray(); 
			  
			  
			  for(int j=in.length-1; j>=0; j--){
				  
				  
				  if(in[j]!='0'){
						  int digit = Integer.valueOf(in[j]);
						  digit--;
						  in[j] = (char)digit;
		
						  break;
				  }
			  }
			  
			  if(in[0]=='0'){
				 System.out.println("0");
			  }else{
				  System.out.println(in);
			  }
			 
		  }
		  } catch (IOException ioe) {}
	}

}

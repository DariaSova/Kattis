import java.util.*;
import java.math.BigInteger;

public class MA {
	
	public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	
	 BigInteger n = new BigInteger(s.next());
	 int tests = Integer.valueOf(s.next());
	 
	 while(tests!=0&&!n.equals(BigInteger.ZERO)){
	  
		 for(int i=0; i<tests; i++){
			 BigInteger res = new BigInteger("-1");
			 BigInteger a = new BigInteger(s.next());
			 String oper = s.next();
			 BigInteger b = new BigInteger(s.next());
			 
			 try{
				 if(oper.equals("+")){
					res = a.add(b).mod(n);
				 }else if (oper.equals("-")){
					res = a.subtract(b).mod(n);
				 }else if (oper.equals("*")){
					res = a.multiply(b).mod(n);
				 }else { 
					res = a.multiply((b.modInverse(n))).mod(n);
				 }
			 } 
			 catch (ArithmeticException e1){/*do nothing*/}
	
			 System.out.println(res);
		 }
			 n = new BigInteger(s.next());
			 tests = Integer.valueOf(s.next());
		
		 }
	 s.close();
	}
}


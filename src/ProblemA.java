import java.util.*;
import java.math.BigInteger;

public class ProblemA {
	 Scanner sc = new Scanner(System.in);
	
	 BigInteger n = new BigInteger(sc.next());
	 System.out.println("hola");
	 int tests = sc.nextInt();
	 System.out.println(tests);
	 BigInteger res = new BigInteger("0");
	 
	 for(int i=0; i<tests; i++){
		 BigInteger a = new BigInteger(sc.next());
		 System.out.println(a);
		 String oper = sc.next();
		 BigInteger b = new BigInteger(sc.next());
		 System.out.println(b);
		 
		 if(oper.equals("+")){
			 res = a.add(b);
		 }else if (oper.equals("-")){
			 res = a.subtract(b);
		 }else if (oper.equals("*")){
			 res = a.multiply(b);
		 }else { //division
			 res = a.modInverse(b); //????
		 }
		 System.out.println(res.mod(n));
	 }

}

import java.util.*;
import java.math.*;

public class HCookie {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
		double r = sc.nextDouble();
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		double dist = x*x+y*y;
		if(dist>=r*r) System.out.println("miss");
		else{
			double h = r - Math.sqrt(dist);
			double circle = Math.PI * r *r;
			double segment = r*r* Math.acos((r-h)/r) - (r-h) * Math.sqrt(2*r*h-h*h);
			double rem = circle - segment;
			
			if(rem < segment) { 
				System.out.printf("%.6f %.6f", segment, rem);
				System.out.println();
			}
			
			else { System.out.printf("%.6f %.6f", rem, segment); System.out.println(); }
			
		
	        
		}
		}
	}

}

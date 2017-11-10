import java.util.*;
import java.math.*;

public class probA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int v = sc.nextInt();
		
		double res = h/Math.sin(Math.toRadians(v));
		int r = (int) Math.ceil(res);
		
		System.out.println(r);
	}

}

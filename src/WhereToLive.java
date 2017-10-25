import java.util.*;

public class WhereToLive {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double n = (double)sc.nextInt();
		double Xav=0, Yav = 0;
		
		while(n!=0){
			for(int i=0; i<n; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				//read points
				Xav+=x;
				Yav+=y;
			}
			
			Xav/=n;
			Yav/=n;
			System.out.print((int)roundPoint(Xav));
			System.out.print(" "+(int)roundPoint(Yav));
			System.out.println();
			
			n = sc.nextInt();
			Xav =0;
			Yav =0;
		}
		
	}
	
	public static double roundPoint(double x){
		double t = x%1;
		if(t>0.5) return Math.round(x);
		else return Math.floor(x);
	}
}

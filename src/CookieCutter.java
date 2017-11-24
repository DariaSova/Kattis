import java.util.*;

public class CookieCutter {
	
	public static double getArea(double[] X, double[] Y){
		double res = 0.0;
		for(int i=0; i<X.length-1; i++){
			double x1 = X[i];
			double x2 = X[i+1];
			double y1 = Y[i];
			double y2 = Y[i+1];
			res+=x1*y2-x2*y1;
		}
		res+=X[X.length-1]*Y[0]-X[0]*Y[Y.length-1];	
		
		return Math.abs(res)/2.0;
	}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			
			double[] X = new double[n];
			double[] Y = new double[n];
			
			for(int i=0; i<n; i++){
				X[i] = sc.nextDouble();
				Y[i] = sc.nextDouble();
			}
			
			int newsize = sc.nextInt();
			
			double area = getArea(X,Y);
			double a_diff = newsize/area;
			
			double factor = Math.sqrt(a_diff);
			
			double xmin = Double.MAX_VALUE;
			double ymin = Double.MAX_VALUE;
			//scale all points
			for(int i=0; i<n; i++){
				X[i] = X[i]*factor;
				Y[i] *=factor;
				
				if(X[i]<xmin) xmin=X[i];
				if(Y[i]<ymin) ymin = Y[i];
			}
			
			//normalize
			for(int i=0; i<n; i++){
				X[i] -=xmin ;
				Y[i] -=ymin;

				System.out.printf("%.11f %.11f", X[i], Y[i]);
				System.out.println();

			}
		
			
		}
}

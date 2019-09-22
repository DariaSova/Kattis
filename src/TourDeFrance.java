import java.util.*;
import java.math.*;

public class TourDeFrance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nf = sc.nextInt();
		
		while(true){
	
		int nr = sc.nextInt();
		double[] rare = new double[nr];
		double[] front = new double[nf];
		
		for(int i=0; i<nf; i++){
			front[i] = sc.nextInt();
		}
		
		for(int i=0; i<nr; i++){
			rare[i] = sc.nextInt();
		}
	
		double [] ratios = new double[nr*nf];
		
		int k=0;
		for(int i=0; i<nr; i++){
			for(int j=0; j<nf; j++){
				ratios[k++] = rare[i]/front[j];
			}
		}
		Arrays.sort(ratios);
		
		double res = 0.0;
		for(int i=1; i<ratios.length;i++){
			double n = ratios[i]/ratios[i-1];
			res = Math.max(res, n);
		}
		res = Math.round(res*100);
//		System.out.println();
//		System.out.printf("%.2fn%",res/100);
		System.out.println(res/100);
		int next = sc.nextInt();
		if(next==0) break;
		nf = next;
		}
		sc.close();
	}
}



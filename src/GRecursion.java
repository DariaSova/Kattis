import java.util.*;

public class GRecursion {
	static int[] As;
	static int[] Bs;
	static int al =0;
	static int bl=0;
	static int C;
	static int D;
	
	
	public static long recur(int x, int y, int i){
//		if(i>al) return 0;
		if(i==al||i==bl){
			return C; //recur(x-As[i], y-Bs[i], i++) + C;
		}else if(x>0 && y>0){
			return recur(x-As[i], y-Bs[i], 0)+recur(x, y, i++) ;
		}else{
			return D;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tests = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<tests; i++){
			String[] ab = sc.nextLine().split(" ");
			int len = (ab.length-2)/2;
			al = bl = len;
			//AB vals
			As = new int[len];
			Bs = new int[len];
			
			int k=0;
			int j=0;
			for(j=0; j<ab.length-2; j++){
				As[k] = Integer.valueOf(ab[j]);
				j++;
				Bs[k] = Integer.valueOf(ab[j]);
				k++;
				
			}
			//CD vals
			C = Integer.valueOf(ab[j]);
			D = Integer.valueOf(ab[++j]);
			
			String[] xy = sc.nextLine().split(" ");
			
			//XY values
			int[] XYvals = new int[xy.length];
			for(j=0; j<xy.length; j++){
				XYvals[j] = Integer.valueOf(xy[j]);
			}
			
			//call on xy
			for(int m=0; m<xy.length; m++){
				long res = recur(XYvals[m], XYvals[m+1], 0);
				m++;
				System.out.println(res);
				
			}
			
		}
	}
}

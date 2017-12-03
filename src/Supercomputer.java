import java.util.*;

class FenwickTree {
	  private Vector<Integer> ft;

	  private int LSOne(int S) { return (S & (-S)); }

	  public FenwickTree() {}

	  // initialization: n + 1 zeroes, ignore index 0
	  public FenwickTree(int n) { 
	    ft = new Vector<Integer>();
	    for (int i = 0; i <= n; i++) ft.add(0);
	  }

	  public int rsq(int b) {                              // returns RSQ(1, b)
	    int sum = 0; for (; b > 0; b -= LSOne(b)) sum += ft.get(b);
	    return sum; }

	  public int rsq(int a, int b) {                       // returns RSQ(a, b)
	    return rsq(b) - (a == 1 ? 0 : rsq(a - 1)); }

	  // adjusts value of the k-th element by v (v can be +ve/inc or -ve/dec)
	  void adjust(int k, int v) {                    // note: n = ft.size() - 1
	    for (; k < (int)ft.size(); k += LSOne(k)) ft.set(k, ft.get(k) + v); }
	};


public class Supercomputer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int bits = sc.nextInt();
		int t = sc.nextInt();
		
	    FenwickTree ft = new FenwickTree(bits);
	    
	    for(int i=0; i<t; i++){
	    	String cmd = sc.next();
	    	
	    	if(cmd.equals("F")){
	    		int pos = sc.nextInt();
	    		//int curr = ft.rsq(pos)-ft.rsq(pos-1);
	    		if(pos-1>=0) ft.adjust(pos, ((ft.rsq(pos)-ft.rsq(pos-1))==0 ? 1 : -1));
	    		else ft.adjust(pos, (ft.rsq(pos)==0 ? 1 : -1 ));
	    	}else if(cmd.equals("C")){
	    		int a = sc.nextInt();
	    		int b = sc.nextInt();
	    		
	    		System.out.println(ft.rsq(a, b));
	    	}
	    }
	    
	    
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Dvaput {
	static char T[];                        // the input string, up to 100K characters
	static int n; 
	static int[] RA, tempRA; 
	static Integer[] SA, tempSA;
	static  int[] c;   

	
	//for LCP 
	static  int[] P;    // for computing longest common prefix
	static  int[] PLCP;
	static  int[] LCP; 
	
	/*from competitive programming*/
	static void countingSort(int k) {
	    int i, sum, maxi = Math.max(300, n);   
	    Arrays.fill(c, 0);
//	    (c, 0);
//	    for (i = 0; i < c.length; i++) c[i] = 0;                // cler up freq t
	    for (i = 0; i < n; i++)                    
	      c[i + k < n ? RA[i + k] : 0]++;
	    for (i = sum = 0; i < maxi; i++) {
	      int t = c[i]; c[i] = sum; sum += t;
	    }
	    for (i = 0; i < n; i++)               // shuffle the suffix array if necessary
	      tempSA[c[SA[i] + k < n ? RA[SA[i] + k] : 0]++] = SA[i];
	    for (i = 0; i < n; i++)                          // update the suffix array SA
	      SA[i] = tempSA[i];
	  }

	
	 static void constructSA() {  
		 int i, k, r;
		    for (i = 0; i < n; i++) RA[i] = T[i];                      // initial rankings
		    for (i = 0; i < n; i++) SA[i] = i;          // initial SA: {0, 1, 2, ..., n-1}
		    for (k = 1; k < n; k <<= 1) {            // repeat sorting process log n times
		      countingSort(k);       // actually radix sort: sort based on the second item
		      countingSort(0);               // then (stable) sort based on the first item
		      tempRA[SA[0]] = r = 0;                  // re-ranking; start from rank r = 0
		      for (i = 1; i < n; i++)                         // compare adjacent suffices
		        tempRA[SA[i]] =      // if same pair => same rank r; otherwise, increase r
		          (RA[SA[i]] == RA[SA[i-1]] && RA[SA[i]+k] == RA[SA[i-1]+k]) ? r : ++r;
		      for (i = 0; i < n; i++)                          // update the rank array RA
		        RA[i] = tempRA[i];
		    }
		 

	 }
	 
	 static void findLCP() {
		    int i, L;
		    P[SA[0]] = -1;                                              // default value
		    for (i = 1; i < n; i++)                                 // compute P in O(n)
		      P[SA[i]] = SA[i-1];         // remember which suffix is behind this suffix
		    for (i = L = 0; i < n; i++) {                  // compute Permuted LCP in O(n)
		      if (P[i] == -1) { PLCP[i] = 0; continue; }                 // special case
		      while (i + L < T.length && P[i] + L < T.length && T[i + L] == T[P[i] + L]) L++; // L will be increased max n times
		      PLCP[i] = L;
		      L = Math.max(L-1, 0);                          // L will be decreased max n times
		    }
		    for (i = 1; i < n; i++)                                 // compute LCP in O(n)
		      LCP[i] = PLCP[SA[i]];   // put the permuted LCP back to the correct position
	}
	 
	 
	static int findMax(){
		int max =0;
		for(int i=0; i<LCP.length;i++){
			if(LCP[i]>max) max=LCP[i];
		}
		
		return max;
	}
	public static void main(String[] args) {
		//intialize
		int MAX_N = 200020;
	    c = new int[MAX_N];
	    RA = new int[MAX_N];
	    tempRA = new int[MAX_N];
	    SA = new Integer[MAX_N];
	    tempSA = new Integer[MAX_N];
	    P = new int[MAX_N];
	    PLCP = new int[MAX_N];
	    LCP = new int[MAX_N];
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		n = input.length()+1;
//	    
//	    n = 200001;
//	    String input =  "";
//	    for(int i=0; i<n-1; i++){
//	    	input+="a";
//	    }
	    input+="$";
		T = input.toCharArray();
		
		constructSA();
		findLCP();
		
		for (int i = 0; i < n; i++)
		     System.out.printf("%2d%2d\t%2d\t%s\n", i, SA[i], PLCP[i], new String(T, SA[i], T.length - SA[i]));

//		int result = findMax();
//		System.out.println(result);
//		sc.close();
		
	}

}

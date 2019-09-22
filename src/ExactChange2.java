import java.util.*;

class ExactChange2 {

static final int INF = Integer.MAX_VALUE;
static int P; // target amount, price
static int N; // number of coins
static int[] c = new int[101];     // the coins
static int[] D = new int[1100001]; // the (big) DP table

public static void main( String[] args ) {
   Scanner in = new Scanner( System.in );
   int T = in.nextInt();
   for (int t=0; t<T; ++t) {
      Arrays.fill( D, INF );  D[0] = 0;  // Initialize D.
      P = in.nextInt();
      N = in.nextInt();
      for (int n=0; n<N; ++n) c[n] = in.nextInt();
      
      for (int k=0; k<N; ++k) 
          for (int p=P-1; p>=0; --p) 
             if (D[p] < INF && D[p+c[k]] > 1+D[p]) 
                               D[p+c[k]] = 1+D[p];
      
      int p = P;
      while (D[p]==INF) ++p;
      System.out.println( p+" "+D[p] );
   }
}      
      
}

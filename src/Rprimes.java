import java.util.*;

public class Rprimes {
	static int _sieve_size;
	static boolean[] bs;   // 10^7 should be enough for most cases
	static List<Integer> primes = new ArrayList<Integer>();   
	
	public static void sieve(int upperbound) {          // create list of primes in [0..upperbound]
	    _sieve_size = upperbound + 1;                   // add 1 to include upperbound
	    bs = new boolean[_sieve_size];
	    Arrays.fill(bs,true);                                    // set all bits to 1
	    bs[0] = bs[1] = false;                                     // except index 0 and 1
	    for (long i = 2; i < _sieve_size; i++) if (bs[(int)i]) {
	      // cross out multiples of i starting from i * i!
	      for (long j = i * i; j < _sieve_size; j += i) bs[(int)j] = false;
	      primes.add((int)i);  // also add this vector containing list of primes
	  } }            
	
	
	public static long EulerPhi(long N) {
	    int PF_idx = 0;
	    long PF = primes.get(PF_idx), ans = N;             // start from ans = N
	    while (N != 1 && (PF * PF <= N)) {
	      if (N % PF == 0) ans -= ans / PF;                // only count unique factor
	      while (N % PF == 0) N /= PF;
	      PF = primes.get(++PF_idx);
	    }
	    if (N != 1) ans -= ans / N;                                     // last factor
	    return ans;
	  }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		sieve(10000000);
		
		while(N!=0){
//		long N = sc.nextLong();
		
		
		System.out.println(EulerPhi(N));
		N = sc.nextLong();
		}
	}
}

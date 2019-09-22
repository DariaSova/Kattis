import java.util.*;
import java.math.*;

public class ExactChange {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();
        for(int t=0; t<tests; t++){
        int amount = sc.nextInt();
        int ncoins = sc.nextInt();

        int []  sums = new int[amount+1];
//        int []  sums = new int[1100001];
        int[] diff = new int[amount+1];
        int [] coins = new int[ncoins];
        

        for(int i=0; i<ncoins; i++){
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);
        Arrays.fill(sums, Integer.MAX_VALUE);
        Arrays.fill(diff, Integer.MAX_VALUE);
        sums[0] = 0;
        diff[0] = 0; //amount;
        int sum =0;

        for(int coin: coins){
//        	for(int p = amount-1; p>=0; p--){
//        		if(sums[p] < Integer.MAX_VALUE && sums[p+coin] > 1+sums[p]) sums[p+coin] = sums[p]+1; 
//        	}
        	sum+=coin;
            for(int j = 1; j<= amount; j++){
            	if(j>sum) continue;
            	if(j-coin >= 0){
                	if(1+sums[j-coin] < sums[j]) {
                		sums[j] = 1+sums[j-coin];
//                		if(j==1200){
//                			System.out.println(diff[j-coin] + " plus "+coin);
//                		}
//                		if(j==500){
//                			System.out.println(diff[j-coin] + " plus "+coin);
//                		}
                		diff[j] = diff[j-coin] + coin;
                	}
                }else {
                	//coin is bigger than the number
                	if(coin <= diff[j]) {
                		sums[j] = 1; //Math.min(sums[j], 1);
                		diff[j] = coin;
                	}
                }
            }
        }
    
        if(diff[amount] == Integer.MAX_VALUE) System.out.println(0 + " " + 0);
        else System.out.println(diff[amount] + " " + sums[amount]);
//        int p =amount;
//        while (sums[p]==Integer.MAX_VALUE) p++;
//        System.out.println( p+" "+sums[p] );
    }
    }
}
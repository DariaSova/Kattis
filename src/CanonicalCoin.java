import java.util.*;

public class CanonicalCoin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coinsn = sc.nextInt();
		
		int[] coins = new int[coinsn];
		for(int i=0; i<coinsn; i++){
			coins[i] = sc.nextInt();
		}
		
		
		int biggestC = coins[coins.length-1];
		int secBiggest = coins[coins.length-2];
		
		int g=0;
		for(g=0; g<coins.length-1;g++){
            if(coins[g+1]<2*coins[g]){
               break;
            }
        }
		if(g==coins.length) {
			 System.out.println("canonical");
             System.exit(0);
		}
		
		//GREEDY
		int[] greedySum = new int[biggestC+secBiggest+1];
		greedySum[0] = 0;
//		greedySum[1] = 1;
		
//		int[] greedyT = new int[biggestC+secBiggest+1];
		//for each sum
		for(int i=1; i<greedySum.length; i++){
			//for each coin
			int amount = i;
			int cnt=0;
//			for(int j=coins.length-1; j>=0&&amount>0;j--){
			int j=coins.length-1;
			while(coins[j]>amount){j--;}
			if(j>=0){
				int coin = coins[j];
				if(amount>0&&amount-coin>=0){
					greedySum[i] = greedySum[amount-coin]+1;
				}
			}
//				while(coin<= amount && amount > 0){
//					amount-=coin;
//					cnt++;
//				}
//			}
//			greedySum[i] = cnt;
//			System.out.println(i+" with "+ greedySum[i]);
		}
		
		
		//DP DP
		int[] sums = new int[biggestC+secBiggest+1];
		int amount = biggestC+secBiggest;
		Arrays.fill(sums, Integer.MAX_VALUE);
		sums[0] =0;
		sums[1] = 1;
			
		   //for each coin
	       for(int coin: coins){
	        	for(int p = 2; p<=amount; p++){
	        		if(p-coin>=0) sums[p] = Math.min(sums[p], 1+sums[p-coin]);
	        	}
	       }
	      
//	      System.out.println(Arrays.toString(greedySum));
//         System.out.println(Arrays.toString(sums));
	    for(int k=amount; k>0; k--){
	    	if(sums[k]!=greedySum[k]){
	    		 System.out.println("non-canonical");
	             System.exit(0);
	    	}
	    }
		
		System.out.println("canonical");
		
	}

}

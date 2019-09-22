import java.util.*;

public class Pivot {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int[] nums = new int[n];
		    int[] mins = new int[n];
		    int[] maxs = new int[n];
		    int res = 0;
		
		    int max = Integer.MIN_VALUE;
		    int min = Integer.MAX_VALUE;
		    
		    //get maxs
		    for(int i = 0; i < n; i++) {
		    	nums[i] = sc.nextInt();
		    	maxs[i] = max;
		        if(nums[i] > max) max = nums[i];
		   
		    }
		
		    //get mins
		    for(int i = n - 1; i >= 0; i--) {
		    	mins[i] = min;
		        if(nums[i] < min) min = nums[i];
		       
		    }
		
		    for(int i = 0; i < n; i++) {
		        if(nums[i] >= maxs[i] && nums[i] <= mins[i]) res++;
		    }
		
		    System.out.println(res);
	}

}

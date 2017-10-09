import java.util.*;

public class Spaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long width = sc.nextInt();
		int n = sc.nextInt();
		long[] nums = new long[n+2];
		Set<Long> set = new HashSet<Long>();
		
		nums[0] = 0;
		nums[n+1] = width;
		
		for(int i=1; i<n+1; i++){
			nums[i] = sc.nextInt();
			set.add(nums[i]);
		}
		
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length; i++){
			for(int j=nums.length-1; j>i;j--){
				long r =nums[j]-nums[i];
				if(r<width&&r>0) set.add(r);
			}
		}
		set.add(width);
		TreeSet<Long> myTreeSet = new TreeSet<Long>();
		myTreeSet.addAll(set);
		System.out.println(myTreeSet.toString().replace("[", "").replace("]", "").replace(",", " "));
	}
}

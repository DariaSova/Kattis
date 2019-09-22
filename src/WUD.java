import java.util.*;



// return Integer.valueOf(map.get(k1).size()).compareTo(map.get(k2).size());
public class WUD {
	
	static int min(int[] toys){
		int min = 0;
		for(int i=0; i<toys.length;i++){
			if(toys[i]<toys[min]) min=i;
		}
		if (toys[min]==1000010) return -1;
		return min;
		
	}
	
	public static void main(String[] args) {

		
		
		Scanner sc = new Scanner(System.in);
		long result =0;
		
		int childnum = sc.nextInt();
		int toysnum = sc.nextInt();
		int catnum = sc.nextInt();
		
		HashMap<Integer, Set<Integer>> child_toys = new HashMap<Integer, Set<Integer>>();
		
		int[] cat_max = new int[catnum];
		int[] child_has = new int[childnum+1];
		child_has[0] = 1000010;
		
		//initialize hash of free toys
		Set<Integer> free_toys = new HashSet<>();
		for(int a=1; a<=toysnum; a++){
			free_toys.add(a);
		}
		
		for(int i=0; i<childnum; i++){
			int k = sc.nextInt();
			child_toys.put(i+1, new HashSet<>());
			for(int j=0; j<k; j++){
				child_toys.get(i+1).add(sc.nextInt());
				child_has[i+1]+=1;
			}
		}
		
		HashMap<Integer, Set<Integer>> cat_toys = new HashMap<Integer, Set<Integer>>();
		HashMap<Integer, Integer> toys_cat = new HashMap<>();
		
		for(int i=0; i<catnum; i++){
			int l = sc.nextInt();
			cat_toys.put(i+1, new HashSet<>());
			
			//int j=0;
			for(int j=0; j<l; j++){
				int curr_toy = sc.nextInt();
				cat_toys.get(i+1).add(curr_toy);
				toys_cat.put(curr_toy, i+1);
				free_toys.remove(curr_toy);
			}
			//read R
			cat_max[0] = sc.nextInt();
			
		}
		


		int min_ch = min(child_has);
		child_has[min_ch] = 1000010;
		
		while(min_ch!=-1){
		int key = min_ch;
//		for(Integer key : child_toys.keySet()){
//		for(Integer key : tset.ke){
			Set<Integer> possible = child_toys.get(key);
			if(!possible.isEmpty()){
			for(Integer t : possible){
				if(toys_cat.containsKey(t)){
					int cat = toys_cat.get(t);
					if(cat_max[cat-1]>0){
						//remove from categories
						cat_toys.get(cat).remove(t);
						cat_max[cat-1]-=1;
						result++;
					}
				}else if(free_toys.contains(t)){
					free_toys.remove(t);
					result++;
				}
			}
		}
			min_ch = min(child_has);
			if(min_ch!=-1)child_has[min_ch] = 1000010;
		}
//	}
		
		System.out.println(result);
	}
	
}

/*
4 3 2
2 1 2
1 1
1 3
1 3
1 1 1
1 2 1
 */

/*
4 4 1
2 1 2
2 1 4
1 3
1 3
2 1 2 1


*/
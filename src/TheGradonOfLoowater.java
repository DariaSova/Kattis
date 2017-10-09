import java.util.*;

public class TheGradonOfLoowater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		while(true){
			int headsn = sc.nextInt();
			int knightsn = sc.nextInt();
			
			if(headsn==0&&knightsn==0) break;
			
			String fail = "Loowater is doomed!";
			
				
			int[] heads = new int[headsn];
			int[] knights = new int[knightsn];
			
			for(int i=0; i<headsn; i++)
				heads[i] = sc.nextInt();
			
			for(int i=0; i<knightsn; i++)
				knights[i] = sc.nextInt();
			
			if(headsn>knightsn){
				System.out.println(fail);

			}else {
			
			long gold=0;
			Arrays.sort(heads);
			Arrays.sort(knights);
			
			int h,n;
			for(h=0,n=0; n<knightsn; n++){
					if(knights[n] >= heads[h]) {
						gold+=knights[n];
						if(++h==headsn) break;
					}
			}
				if(h==headsn) System.out.println(gold);
				else System.out.println(fail);
			}
		}
		sc.close();
	}
}

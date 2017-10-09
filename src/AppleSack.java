import java.util.*;

public class AppleSack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int apples = sc.nextInt();
		int size = sc.nextInt();
		long step = 1;
		
		while(apples>=size){
			step++;
			int runs = apples/size;
			int left = apples%size;
			apples-= runs;
			if(left>0) apples--;
		}
		
		System.out.println(step+apples);

	}
}

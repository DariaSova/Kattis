import java.util.*;

public class Socks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int socksn = sc.nextInt();
		int laundryCap = sc.nextInt();
		int colordiff = sc.nextInt();
		
		int[] socks = new int[socksn];
		
		for(int i=0; i< socksn; i++){
			socks[i] = sc.nextInt();
		}
		
		Arrays.sort(socks);
		
		int res=0;
		int capacity = laundryCap;
		
		if(socksn==0||laundryCap==0){
			System.out.println(res);
			System.exit(1);
		}
		
		for(int i=0; i<socksn; i++){
			res++;
			capacity--;

			while(i+1<socksn&&capacity>0&&socks[i+1]-socks[i]<=colordiff){
				i++;
				capacity--;
			}

			capacity = laundryCap;
		}
		System.out.println(res);
	}
}

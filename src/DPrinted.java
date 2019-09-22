import java.util.Scanner;

public class DPrinted {
	
	public static int bin_count(int n)
	{
	    int counter = 0;
	    while(n>=0)
	    {
	        counter++;
	        n >>= 1;
	        n--;
	    }
	    return counter;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
				
		int res;
		if(n < 4) res = n;
		else if((n & (n - 1))>0){
			res = bin_count(n<<1 + 1);
		}else {
			res = bin_count(n) + 1;
		}

		
		System.out.println(res);
	}


}

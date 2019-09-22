import java.util.*;

public class Tajna {
	
	public static int getSize(int len){
		 for (int i = (int) Math.sqrt(len); i > 0; i--) {
	            if (len % i == 0)
	                return i;
	        }
	        return len;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] in = sc.nextLine().toCharArray();
		
		int len = in.length;
		int rows = getSize(len);
		
		int col = len / rows;
		
		//write matric
		char[][]  m1 = new char[rows][col];
		
		int k=0;
		for(int i=0; i<col; i++){
			for(int j=0; j<rows; j++)
				m1[j][i] = in[k++];
		}
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<rows; i++){
			builder.append(m1[i]);
//			for(int j=0; j<col; j++)
//				m1[i][j] = in[k];
		}
		
		System.out.println(builder.toString());
		
	}
}

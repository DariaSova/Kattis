import java.util.*;

public class PathTracing {
//	public static class Point{
//		int x;
//		int y;
//		
//		public Point(int a, int b){
//			this.x =a;
//			this.y = b;
//		}
//	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		ArrayList<Point> points = new ArrayList<>();
		int x=0;
		int y=0;
		int xmax =0;
		int xmin = Integer.MAX_VALUE;
		int ymax =0;
		int ymin = Integer.MAX_VALUE;
		
		ArrayList<Integer> points = new ArrayList<>();
		//start
		//if(sc.hasNextLine()){
			points.add(0);
			points.add(0);
		//}

		
		while(sc.hasNextLine()){
//		for(int m=0; m<9; m++){
			String cmd = sc.nextLine();
			
			if(cmd.equals("up")){
				x--;
				points.add(x);
				points.add(y);
				if(xmin>x) xmin=x;
			}else if(cmd.equals("down")){
				x++;
				points.add(x);
				points.add(y);
				if(xmax<x) xmax=x;
			}else if(cmd.equals("right")){
				y++;
				points.add(x);
				points.add(y);
				if(ymax<y) ymax=y;
			}else if(cmd.equals("left")){
				y--;
				points.add(x);
				points.add(y);
				if(ymin>y) ymin=y;
			}
		}
		
		if(ymin==Integer.MAX_VALUE) ymin=0;
		if(xmin==Integer.MAX_VALUE) xmin=0;
		
		int xlen = xmax + Math.abs(xmin) +1;
		int ylen = ymax+Math.abs(ymin) +1;
		
		char[][] res = new char[xlen+2][ylen+2];
		
		for(char[] row : res){
			Arrays.fill(row, ' ');
		}
		Arrays.fill(res[0],'#');
		Arrays.fill(res[res.length-1],'#');
		for(int k=1; k<res.length;k++){
			res[k][0]='#';
			res[k][res[0].length-1] ='#';
		}
		if(!points.isEmpty()){
		
		//+1 for borders
		int xoff = Math.abs(xmin)+1;
		int yoff = Math.abs(ymin)+1;
		
		int r,c;
		int l;
		for(l=0; l<points.size()-2; l++){
			r = points.get(l);
			c = points.get(++l);
			
			res[r+xoff][c+yoff] = '*';
		}
		r = points.get(0);
		c = points.get(1);
		res[r+xoff][c+yoff] = 'S';
		r = points.get(l);
		c = points.get(++l);
		res[r+xoff][c+yoff] = 'E';
		
		for(int i=0; i<res.length; i++){
			for(int j=0; j<res[0].length; j++)
				System.out.print(res[i][j]);
			System.out.println();
		}
		}
	}
}

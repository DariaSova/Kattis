import java.util.*;

public class Dependancies {
	
	public static class Vertex implements Comparable<Vertex>{
		int in;
		ArrayList<Vertex> out;
		ArrayList<Vertex> ins;
//		HashSet<String> out;
		String name;
		boolean dep = false;
		
		
		public Vertex(String n){
			this.name = n;
			this.out = new ArrayList<>();
			this.ins = new ArrayList<>();
//			this.out = new HashSet<>();
			this.in = 0;
		}
		

		@Override
		public int compareTo(Vertex o) {
			
			if(this.in <= o.in)
				return -1;
			
			return 1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.valueOf(sc.nextLine());

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		HashMap<String, Vertex> hm = new HashMap<>();
		
		//get all records
		for(int i=0; i<t; i++){
			String[] s = sc.nextLine().replace(":", "").split(" ");
			
			Vertex v;
			if(hm.containsKey(s[0])) v = hm.get(s[0]);
			else {
				v = new Vertex(s[0]);
				hm.put(s[0], v);
			}
			
			for(int j=1; j<s.length; j++){
				String n = s[j];
				Vertex vn;
				if(hm.containsKey(n)) vn = hm.get(n);
				else {
					vn = new Vertex(n);
					hm.put(n, vn);
				}
				
				vn.out.add(v);
				v.in++;
				v.ins.add(vn);
			}
			
//			pq.add(v);
			
		}
		
		String changed = sc.nextLine();
		Vertex start=hm.get(changed);
//		Vertex start;
//		if(hm.containsKey(changed)) start = hm.get(changed);
//		else start = new Vertex(changed);
		start.in = 0;
		start.dep = true;
//		hm.put(changed, start);
//		pq.add(start);
		
		
//		PriorityQueue<Vertex> pq2 = new PriorityQueue<>();
		for(String key: hm.keySet()){
			Vertex k = hm.get(key);
//			if(k.in>0) {
			pq.add(k);
//			} else{
//				pq2.add(k);
//			}
		}
//		
//		while(!pq.isEmpty()){
//			Vertex curr = pq.remove();
//			System.out.println(curr.name);
//			
//			for(Vertex n: curr.out){
//				n.in--;
//			}
//		}
//		
//		HashSet<String> res = new HashSet<>();
		
		while(!pq.isEmpty()){
			Vertex curr = pq.remove();
			//if(curr.out.contains(changed)) curr.dep = true;
//			if(curr.dep) res.add(curr.name);
			if(curr.dep)	{
				
//				if(!res.contains(curr.name)) 
					System.out.println(curr.name);
//				res.add(curr.name);
			}
			
			for(Vertex n: curr.out){
				n.in--;
				if(curr.dep) n.dep = true;
				
			}
			
			if(curr.dep) {
				for(Vertex n: curr.ins){
					n.dep = true;
					
				}
			}
		}
		
//		for(String r: res){
//			System.out.println(r.toString());
//		}
	}

}

/*
 * c,d,f -> a
 * d-> z
 * 
 * 
 * 
 */



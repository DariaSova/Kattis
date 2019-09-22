import java.util.*;
public class Bumped {

    public static class Pair<T, M>{
        T X;
        M W; 

        public Pair(T x, M y){
            this.X = x;
            this.W = y;
        }
    }
    public static void main(String[] args){

        //adj list
        Vector < Vector< Pair <Integer, Integer>> > adjList = new Vector<>();

        Scanner input = new Scanner(System.in);
        int numCities = input.nextInt();
        int numRoads = input.nextInt();
        int numFlights = input.nextInt();
        int start = input.nextInt();
        int fin = input.nextInt();

        for (int i = 0; i<numCities; i++){
            for (int j = 0; j<numCities;j++){
                Vector<Pair<Integer, Integer>> v = new Vector<>();
                //initialize all vertices
                adjList.add(v);

            }
        }
        for (int i = 0; i<numRoads;i++){
            int first = input.nextInt();
            int second = input.nextInt();
            int weight = input.nextInt();
           
            Pair<Integer, Integer> p1  = new Pair<>(second, weight);
            Pair<Integer, Integer> p2  = new Pair<>(first, weight);
            adjList.get(first).add(p1);
            adjList.get(second).add(p2);
  
        }


        int resultSmall = Integer.MAX_VALUE;
        for (int i = 0; i<numFlights; i++){
            int first = input.nextInt();
            int second = input.nextInt();

            adjList.get(first).add(new Pair<Integer,Integer>(second, 0));
            int small = Dikstra(adjList,start,fin);
            if (small<resultSmall){
                resultSmall = small;
            }
            
        }
        
        System.out.println(resultSmall);
    }
    public static int Dikstra(Vector < Vector< Pair <Integer, Integer>> >  graph,int start,int fin){
        int[] dist = new int[graph.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        boolean[] visited = new boolean[graph.size()];
        ///USE PRIORITY QUEUE HERE instead of visited
        PriorityQueue<Vector<Pair<Integer, Integer>>> pq = new PriorityQueue<>();
        
//        pq.add(new Pair<>(0,fin));
        pq.add(graph.get(0));
        int index=0;
        
        while(!pq.isEmpty()){
        	Vector<Pair<Integer, Integer>> curr = pq.poll();
        	
        	for(Pair<Integer, Integer> neighbour: curr){
        		int newdist = dist[index] + neighbour.W;
        		
        		if(dist[neighbour.X] > newdist){
        			dist[neighbour.X] = newdist;
        			
        			pq.add(graph.get(neighbour.X));
        			index = neighbour.X;
        		}
        	}
        }
 /*       
        for (int i=0; i<graph.size(); i++){
            
        
            int u = smallDist(dist,visited);
            visited[u] = true;

            for(Pair<Integer, Integer> p : graph.get(u)){
                if(!visited[p.X]&&dist[u]!=Integer.MAX_VALUE&&dist[u]+p.W<dist[p.X])
                    dist[p.X] = dist[u]+p.W;
            }
            // for (int j=0; j<visited.length;j++){
                
                
            //     if (!visited[j]&&graph.get(u).co graph[u][j]!=-1&&dist[u]!=Integer.MAX_VALUE&&dist[u]+graph[u][j]<dist[j]){
            
            //         dist[j] = dist[u]+graph[u][j];
            //     }
            // }
        }
    */    
        return dist[fin];
    }
    
    public static int smallDist(int[] dist, boolean[] visited){
        int small = 0;
        for (int i = 0; i<dist.length;i++){
            if (!visited[i]){
                 small = i;
                break;
            }
        }
// if indexoutofbound error is here!!!!
        for (int i = 0; i<dist.length;i++){
            if (dist[i] < dist[small]&&!visited[i]){
                small = i;
            }
        }
        return small;
    }
}
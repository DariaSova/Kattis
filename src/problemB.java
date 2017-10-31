import java.util.*;
public class problemB{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numCities = input.nextInt();
        int numRoads = input.nextInt();
        int numFlights = input.nextInt();
        int start = input.nextInt();
        int fin = input.nextInt();
        int[][] graph = new int[numCities][numCities];
        for (int i = 0; i<numCities; i++){
            for (int j = 0; j<numCities;j++){
                graph[i][j] = -1;
            }
        }
        for (int i = 0; i<numRoads;i++){
            int first = input.nextInt();
            int second = input.nextInt();
            int weight = input.nextInt();
            graph[first][second] = weight;
            graph[second][first] = weight;
        }
        //int[] flightsX = new int[numFlights];
        //int[] flightsY = new int[num]i
        int resultSmall = Integer.MAX_VALUE;
        for (int i = 0;i<numFlights;i++){
            int first = input.nextInt();
            int second = input.nextInt();
            graph[first][second] = 0;
            int small = Dikstra(graph,start,fin);
            if (small<resultSmall){
                resultSmall = small;
            }
            graph[first][second] = -1;
        }
        
        System.out.println(resultSmall);
    }
    public static int Dikstra(int[][] graph,int start,int fin){
        int[] dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visited = new boolean[graph.length];
        
        for (int i=0; i<graph.length; i++){
            
        
            int u = smallDist(dist,visited);
            visited[u] = true;
            for (int j=0; j<visited.length;j++){
                
                
                if (!visited[j]&&graph[u][j]!=-1&&dist[u]!=Integer.MAX_VALUE&&dist[u]+graph[u][j]<dist[j]){
            
                    dist[j] = dist[u]+graph[u][j];
                }
            }
        }
        
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
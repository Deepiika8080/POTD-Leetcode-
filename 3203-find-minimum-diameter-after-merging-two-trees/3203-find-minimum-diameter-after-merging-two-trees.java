class Solution {
    public Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] edge:edges) {
            adjList.computeIfAbsent(edge[0] , k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1] , k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }
    
    public int findDiameter(Map<Integer, List<Integer>> adj) {
        List<Integer> farthestNode = BFS(adj, 0);
        
        farthestNode = BFS(adj, farthestNode.get(0));
        return farthestNode.get(1);
    }
    
     List<Integer> BFS(Map<Integer, List<Integer>> adj , int sourceNode) {
         Queue<Integer> q = new LinkedList<>();
         Map<Integer, Boolean> visited = new HashMap<>();
         q.add(sourceNode);
         visited.put(sourceNode , true);
         
         int maxDistance = 0 , farthestNode = sourceNode;
         
         while(!q.isEmpty()) {
             int n = q.size();
             for(int i=0;i<n;i++) {
                 int currNode = q.poll();
                 farthestNode = currNode;
                 
                 for(int neigh: adj.getOrDefault(currNode , new ArrayList<>())) {
                     if(!visited.getOrDefault(neigh , false)) {
                            q.add(neigh);
                            visited.put(neigh , true);
                     }
                 }
             }
             if(!q.isEmpty()) {
                 maxDistance++;
             }
         }
         return Arrays.asList(farthestNode , maxDistance);
     }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdjList(edges2);
        
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);
        
        int commonDiameter = (d1+1)/2 + (d2+1)/2 + 1;
        
        return Math.max(d1,Math.max(d2,commonDiameter));
    }
}
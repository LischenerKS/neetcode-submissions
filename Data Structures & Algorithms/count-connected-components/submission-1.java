class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }   


        int componentsCnt = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, adj, i);
                componentsCnt++;
            }
        }

        return componentsCnt;


    }

    private void dfs(boolean[] isVisited, List<List<Integer>> adj, Integer node) {
        isVisited[node] = true;
        for (Integer neighbour : adj.get(node)) {
            if (!isVisited[neighbour]) {
                dfs(isVisited, adj, neighbour);
            }
        }
    }



    // берем вершину и делаем dfs сохраняя путь в Pathset
    // countComponents++;
    // если set.size == n, то есть все обошли, то return 
    // если еще не все обошли, то запускаем обход для вершины которой нет в Pathset
}

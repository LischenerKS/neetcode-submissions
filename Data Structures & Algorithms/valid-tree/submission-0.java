class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> nodeToNeighboursList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeToNeighboursList.add(new ArrayList<>());
        }
        Set<Integer> pathSet = new HashSet<>();


        for (int[] edge: edges) {
            nodeToNeighboursList.get(edge[0]).add(edge[1]);

            nodeToNeighboursList.get(edge[1]).add(edge[0]);
        }

        return dfs(nodeToNeighboursList, pathSet, 0, -1) && (pathSet.size() == n);
        
    }

    private boolean dfs(List<List<Integer>> nodeToNeighboursList, Set<Integer> pathSet, Integer node, Integer parent) {
        if (pathSet.contains(node)) {
            return false;
        }

        pathSet.add(node);

        boolean isCycleNotExists = true;
        for (Integer neighbour : nodeToNeighboursList.get(node)) {
            if (neighbour != parent) {
                isCycleNotExists = isCycleNotExists && dfs(nodeToNeighboursList, pathSet, neighbour, node);
            }
        }

        return isCycleNotExists;
    }
}

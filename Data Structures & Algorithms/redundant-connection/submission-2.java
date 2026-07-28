class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> nodeToNeighbours = new HashMap<>();
        

        int n = 0;
        for (int[] edge : edges) {
            if (!nodeToNeighbours.containsKey(edge[0])) {
                nodeToNeighbours.put(edge[0], new HashSet<>());
            }
            nodeToNeighbours.get(edge[0]).add(edge[1]);

            if (!nodeToNeighbours.containsKey(edge[1])) {
                nodeToNeighbours.put(edge[1], new HashSet<>());
            }
            nodeToNeighbours.get(edge[1]).add(edge[0]);

            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        

        int[] ans = new int[0];

        for (int[] edge : edges) {
            nodeToNeighbours.get(edge[0]).remove(edge[1]);
            nodeToNeighbours.get(edge[1]).remove(edge[0]);

            Set<Integer> pathSet = new HashSet<>();

            if (isCycleNotExists(pathSet, nodeToNeighbours, -1, 1) && pathSet.size() == n) {
                ans = edge;
            }


            nodeToNeighbours.get(edge[0]).add(edge[1]);
            nodeToNeighbours.get(edge[1]).add(edge[0]);

        }
        return ans;
    }

    private boolean isCycleNotExists(Set<Integer> pathSet, Map<Integer, Set<Integer>> nodeToNeighbours, Integer parent, Integer node) {
        pathSet.add(node);

        boolean isNotCycle = true;
        for (Integer neighbour : nodeToNeighbours.get(node)) {
            if (neighbour != parent) {
                if (pathSet.contains(neighbour)) return false;
                isNotCycle = isNotCycle && isCycleNotExists(pathSet, nodeToNeighbours, node, neighbour);
            }
        }
        return isNotCycle;
    }

    

    // O(V + E)
    // dfs, pathSet
    // если  pathSet.size == n: граф связный
    // если во время пути встретили такую же вершину в pathSet
}

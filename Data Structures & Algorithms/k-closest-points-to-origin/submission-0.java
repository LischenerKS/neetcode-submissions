class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> heap = new PriorityQueue<>();

        for (int[] i : points) {
            heap.add(new Point(i[0], i[1]));
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point point = heap.poll();
            ans[i][0] = point.x();
            ans[i][1] = point.y(); 
        }

        return ans;

    }

    private record Point(int x, int y) implements Comparable<Point> {
        @Override
        public int compareTo(Point other) {
            double thisPointDist = Math.sqrt(this.x() * this.x() + this.y() * this.y());
            double otherPointDist = Math.sqrt(other.x() * other.x() + other.y() * other.y());

            return Double.compare(thisPointDist, otherPointDist);
        }
    }
}

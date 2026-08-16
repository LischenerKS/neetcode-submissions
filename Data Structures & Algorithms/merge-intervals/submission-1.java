class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            int[] curInterval = intervals[i];

            int maxHead = Math.max(lastInterval[0], curInterval[0]);
            int minTail = Math.min(lastInterval[1], curInterval[1]);


            if (maxHead <= minTail) { //пересекаются
                int minHead = Math.min(lastInterval[0], curInterval[0]);
                int maxTail = Math.max(lastInterval[1], curInterval[1]);

                int[] mergedInterval = new int[]{minHead, maxTail};

                mergedIntervals.set(mergedIntervals.size() - 1, mergedInterval);
            }
            else {
                mergedIntervals.add(curInterval);
            }
        }

        return mergedIntervals.toArray(int[][]::new);
        
    }
}

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> events = new ArrayList<>();

        for (Interval i : intervals) {
            events.add(new int[]{i.start, 1});
            events.add(new int[]{i.end, -1});
        }

        events.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int max = 0;
        int cur = 0;
        for (int[] event : events) {
            cur += event[1];
            max = Math.max(max, cur);
        }


        return max;
    }
}

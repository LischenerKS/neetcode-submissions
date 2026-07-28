class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // [after, before]
        Map<Integer, Set<Integer>> coursesAfterThisCourse = new HashMap<>();
        int[] neededCoursesForThisCourseCounters = new int[numCourses];

        Deque<Integer> courseDeq = new ArrayDeque<>();
        int[] validOrdering = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] couple = prerequisites[i];
            int after = couple[0];
            int before = couple[1];

            if (!coursesAfterThisCourse.containsKey(before)) {
                coursesAfterThisCourse.put(before, new HashSet<>());
            }
            coursesAfterThisCourse.get(before).add(after);
            neededCoursesForThisCourseCounters[after]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (neededCoursesForThisCourseCounters[i] == 0) {
                courseDeq.add(i);
            } 
        }

        int takenCourseCnt = 0;

        while (!courseDeq.isEmpty()) {
            int course = courseDeq.poll();

            validOrdering[takenCourseCnt] = course;
            takenCourseCnt++;

            if (!coursesAfterThisCourse.containsKey(course)) {
                coursesAfterThisCourse.put(course, new HashSet<>());
            }
            
            for (int i : coursesAfterThisCourse.get(course)) {
                neededCoursesForThisCourseCounters[i]--;
                if (neededCoursesForThisCourseCounters[i] == 0) {
                    courseDeq.add(i);
                }
            }
        }

        return (takenCourseCnt == numCourses) ? validOrdering : new int[0];

    }
}

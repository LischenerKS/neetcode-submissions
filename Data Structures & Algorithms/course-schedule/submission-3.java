class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Course> courseById = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int before = prerequisite[1];
            int after = prerequisite[0];

            if (!courseById.containsKey(before)) {
                courseById.put(before, new Course(before));
            }
            if (!courseById.containsKey(after)) {
                courseById.put(after, new Course(after));
            }

            Course beforeC = courseById.get(before);
            Course afterC = courseById.get(after);

            afterC.dependencies.add(beforeC);
            beforeC.dependent.add(afterC);
        }

        Deque<Course> courseDeq = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (!courseById.containsKey(i)) {
                courseById.put(i, new Course(i));
            }

            Course courseI = courseById.get(i);

            if (courseI.dependencies.isEmpty()) {
                courseDeq.add(courseI);
            }
        }

        int takedCourseCnt = 0;

        while (!courseDeq.isEmpty()) {
            int deqSize = courseDeq.size();

            for (int i = 0; i < deqSize; i++) {
                Course courseI = courseDeq.poll();
                courseI.isTaked = true;
                takedCourseCnt++;

                for (Course after : courseI.dependent) {
                    after.dependencies.remove(courseI);

                    if (after.dependencies.isEmpty()) {
                        courseDeq.add(after);
                    }
                }

            }
        }

        return (takedCourseCnt == numCourses) ? true : false;
        
    }

    private class Course {
        int id;
        Set<Course> dependencies;
        Set<Course> dependent; //кто от него зависит    
        boolean isTaked; 

        public Course(int id) {
            this.id = id;
            dependencies = new HashSet<>();
            dependent = new HashSet<>();
            isTaked = false;
        }  

        // создал граф
        // прохожу нахожу независимые
        // я их выполняю и добавляю в очередь на проверку доступности их соседей
    }
}

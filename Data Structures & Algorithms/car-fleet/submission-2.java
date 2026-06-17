class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        Map<Integer, Integer> speedByPos = new TreeMap<>(Collections.reverseOrder());
        Deque<Integer> nextParkHeadStartPos = new ArrayDeque<>();

        for (int i = 0; i < position.length; i++) {
            speedByPos.put(position[i], speed[i]);
        }

        int headStartPos;
        for (Integer pos : speedByPos.keySet()) {
            if (nextParkHeadStartPos.size() == 0) {
                nextParkHeadStartPos.addLast(pos);
                continue;
            } 

            headStartPos = nextParkHeadStartPos.peekLast();
            if (isCatchUp(pos, headStartPos, target, speedByPos)) {
                //успеет догнать и станет частью парка
            }
            else {
                //сам является автопарком
                nextParkHeadStartPos.addLast(pos);
            }
        }

        return nextParkHeadStartPos.size();
    }

    private boolean isCatchUp(int leftPos, int rightPos, int target, Map<Integer, Integer> speedByPos) {
        int leftSpeed = speedByPos.get(leftPos);
        int rightSpeed = speedByPos.get(rightPos);
        if (leftSpeed <= rightSpeed) {
            return false;
        }

        double timeRightToTarget = (target - rightPos) * 1.0 / rightSpeed;
        double timeLeftToCatchUpRight = (rightPos - leftPos) * 1.0 / (leftSpeed - rightSpeed);
        return timeRightToTarget >= timeLeftToCatchUpRight;


    }
}


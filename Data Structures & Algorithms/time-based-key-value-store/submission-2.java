class TimeMap {
    HashMap<KeyWithTimestamp, String> keyWithTimestampToValue;
    HashMap<String, List<Integer>> keyToTimeStampsArr;

    public TimeMap() {
        keyWithTimestampToValue = new HashMap<>();
        keyToTimeStampsArr = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyWithTimestampToValue.put(
            new KeyWithTimestamp(key, timestamp),
            value    
        );

        if (keyToTimeStampsArr.containsKey(key)) {
            keyToTimeStampsArr.get(key).add(timestamp);
        }
        else {
            keyToTimeStampsArr.put(key, new ArrayList<>());
            keyToTimeStampsArr.get(key).add(timestamp);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!keyToTimeStampsArr.containsKey(key)) return "";
        
        List<Integer> timestampsArr = keyToTimeStampsArr.get(key);

        int index = getLessOrEqualsThanNum(timestampsArr, timestamp);

        if (index == -1) return "";
        else {
            return keyWithTimestampToValue.get(
                new KeyWithTimestamp(key, index)
            );
        }
    }
}


//get num less or equals than timestamp, or return -1
public int getLessOrEqualsThanNum(List<Integer> nums, int target) {
    if (nums.size() == 1) {
        if (nums.get(0) <= target) return nums.get(0);
        else return -1;
    }
    else if (nums.size() == 2) {
        if (nums.get(1) <= target) return nums.get(1);
        else if (nums.get(0) <= target) return nums.get(0);
        else return -1;
    }

    int left = 0;
    int right = nums.size();
    int mid;
    
    int ans = Integer.MIN_VALUE;
    while (right - 1 > left) {
        mid  = left + (right - left) / 2;

        if (nums.get(mid) > target) right = mid;
        else if (nums.get(mid) < target) {
            ans = nums.get(mid);
            left = mid;
        }
        else {
            return target;
        }
    }
    if (nums.get(left) <= target) ans = nums.get(left);
    else if (ans == Integer.MIN_VALUE) ans = -1;

    
    return ans;
}

public record KeyWithTimestamp(String key, Integer timeStamp) {}

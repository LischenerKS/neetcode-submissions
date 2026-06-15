class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append("п");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        String buffer = "";
        for (char c : str.toCharArray()) {
            if (c == 'п') {
                ans.add(buffer);
                buffer = "";
            }
            else {
                buffer += c;
            }
        }
        
        return ans;
    }
}

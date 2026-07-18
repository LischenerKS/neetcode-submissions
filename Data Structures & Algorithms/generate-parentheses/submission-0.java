class Solution {
    private int openCnt;
    private int closeCnt;
    private StringBuilder sb;
    private List<String> ans;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.openCnt = 1;
        this.closeCnt = 0;

        this.ans = new ArrayList<>();

        this.sb = new StringBuilder();
        sb.append("(");

        this.n = n;

        f();
        return ans;
    }

    private void f() {
        if (openCnt == n && closeCnt == n) {
            ans.add(sb.toString());
            return;
        }

        if (openCnt > closeCnt && closeCnt < n) {
            int closeBracketIndex = sb.length();
            sb.append(")");
            closeCnt++;

            f();

            sb.deleteCharAt(closeBracketIndex);
            closeCnt--;
        }

        if (openCnt < n) {
            int openBracketIndex = sb.length();
            sb.append("(");
            openCnt++;

            f();

            sb.deleteCharAt(openBracketIndex);
            openCnt--;
        }


    }
}

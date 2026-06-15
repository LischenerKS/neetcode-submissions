class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //rows [0-8], columns [9-17], boxes[18-26]
        List<Map<Character, Integer>> groupByRow = new ArrayList<>();
        List<Map<Character, Integer>> groupByColumn = new ArrayList<>();
        List<Map<Character, Integer>> groupByBox = new ArrayList<>();


        //rows
        for (int i = 0; i <= 8; i++) {
            groupByRow.add(new HashMap<>());
            for (char c : board[i]) {
                if (c == '.') {
                    continue;
                }

                Integer counter = groupByRow.get(i).merge(c, 1, (t, g) -> t+1);

                if (counter > 1) {
                    return false;
                }
            }
        }

        //columns
        for (int i = 0; i <= 8; i++) {
            groupByColumn.add(new HashMap<>());
            for (int j = 0; j <= 8; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }

                Integer counter = groupByColumn.get(i).merge(c, 1, (t, g) -> t+1);
                if (counter > 1) {
                    return false;
                }
            }
        }

        //boxes
        int leftTopCornerFirstIndex = 0;
        int leftTopCornerSecondIndex = 0;
        for (int i = 0; i < 9; i++) {
            groupByBox.add(new HashMap<>());
            leftTopCornerSecondIndex = (i*3) % 9;
            leftTopCornerFirstIndex = i/3 * 3;

            char[] box = new char[] {
                board[leftTopCornerFirstIndex][leftTopCornerSecondIndex],
                board[leftTopCornerFirstIndex][leftTopCornerSecondIndex+1],
                board[leftTopCornerFirstIndex][leftTopCornerSecondIndex+2],
                board[leftTopCornerFirstIndex+1][leftTopCornerSecondIndex],
                board[leftTopCornerFirstIndex+1][leftTopCornerSecondIndex+1],
                board[leftTopCornerFirstIndex+1][leftTopCornerSecondIndex+2],
                board[leftTopCornerFirstIndex+2][leftTopCornerSecondIndex],
                board[leftTopCornerFirstIndex+2][leftTopCornerSecondIndex+1],
                board[leftTopCornerFirstIndex+2][leftTopCornerSecondIndex+2]
            };

            for (char c : box) {
                if (c == '.') {
                    continue;
                }

                Integer counter = groupByBox.get(i).merge(c, 1, (t, g) -> t+1);
                if (counter > 1) {
                    return false;
                }   
            }
            
        }

        return true;
    }
}

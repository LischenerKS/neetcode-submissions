class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }

        for (int i = 0; i < n; i++) {
            cur.add(sb.toString());
        }
        
        backtrack(ans, cur, new boolean[n], new boolean[2*n-1], new boolean[2*n-1], n, 0);


        return ans;
        
        // ищем первую не занятую
        // если не нашли, то
        //     если все верзи расставлены, то сохраняем решение и ret
        //     если не расставлены, ret

        // если нашли, то
        //     ставим ферзя
        //     отмечаем занятыми вертикаль, горизонталь и обе диагонали
        //     вызываем бэк трэк
        //     удаляем ферзя
            
    }

    private void backtrack(
        List<List<String>> ans, List<String> cur, boolean[] isColumnBuzy, 
        boolean[] isLeftDiagBuzy, boolean[] isRightDiagBuzy, int n, int cnt
    ) {
        if (cnt == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        int i = cnt;

        for (int j = 0; j < n; j++) {
            if (isColumnBuzy[j]) {
                continue;
            }

            if (!isLeftDiagBuzy[i + j] && !isRightDiagBuzy[n - j + i - 1]) {
                String row = cur.get(i);

                row = row.substring(0, j) + "Q" + row.substring(j+1, row.length());
                cur.set(i, row);

                isColumnBuzy[j] = true;
                isLeftDiagBuzy[i + j] = true;
                isRightDiagBuzy[n - j + i - 1] = true;

                backtrack(ans, cur, isColumnBuzy, isLeftDiagBuzy, isRightDiagBuzy, n, cnt + 1);

                row = row.substring(0, j) + "." + row.substring(j+1, row.length());
                cur.set(i, row);

                isColumnBuzy[j] = false;
                isLeftDiagBuzy[i + j] = false;
                isRightDiagBuzy[n - j + i - 1] = false;
            }
        }
        



    }
}

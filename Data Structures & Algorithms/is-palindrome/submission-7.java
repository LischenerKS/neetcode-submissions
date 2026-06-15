class Solution {
    public boolean isPalindrome(String s) {
        char[] symbols = s.toLowerCase().toCharArray();
        int i = 0;
        int j = symbols.length - 1;
        
        while (j >= i) {
            while ((j >= i) && (symbols[i] < 'a' || symbols[i] > 'z') && (symbols[i] < '0' || symbols[i] > '9')) i++;
            while ((j >= i) && (symbols[j] < 'a' || symbols[j] > 'z') && (symbols[i] < '0' || symbols[i] > '9')) j--;
            if ((j >= i) && (symbols[i] != symbols[j])) return false;
            i++; j--;
        }
        return true;
    }
}

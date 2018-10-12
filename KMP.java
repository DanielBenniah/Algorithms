public class KMP {
    
    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private static int[] computeTemporaryArray(char[] pattern){
        int [] lps = new int[pattern.length];
        int index = 0;
        for(int i = 1; i < pattern.length;) {
            if(pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                while (pattern[i] != pattern[index] && index != 0)
                    index = lps[index - 1];
                
                if (pattern[i] == pattern[index])
                    lps[i] = index + 1;
                else {
                    lps[i] = 0;
                    index = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    /**
     * KMP algorithm of pattern matching.
     */
    public static int KMPMatch (char[] text, char[] pattern) {
        
        int lps[] = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j!=0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length){
            return i - pattern.length;
        }
        return -1;
    }
        
    public static void main (String args[]){
        
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        int result = KMPMatch(str.toCharArray(), subString.toCharArray());
        System.out.print(result == -1 ? "No pattern" : result);
        
    }
}
class Solution {
    public int[] solution(String s) {
        int cnt = 0, removed = 0;
        int length = s.length();

        while (length > 1) {
            cnt++;
            removed += length;
            
            s = s.replace("0", "");
            length = s.length();
            removed -= length;

            s = Integer.toBinaryString(length);
            length = s.length();
        }
        
        return new int [] {cnt, removed};
    }
}

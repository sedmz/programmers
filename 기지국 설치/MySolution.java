class Solution {
    public int solution(int n, int[] stations, int w) {
        int i = 0, cnt = 0;
        for (int start = 1; start <= n;) {
            while(i < stations.length && stations[i] - w <= start) {
                start = stations[i++] + w + 1;
            }
            if (start <= n) {
                cnt++;
                start += w * 2 + 1;
            }
        }
        return cnt;
    }
}

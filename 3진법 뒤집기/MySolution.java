import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0, digit = (int) Math.pow(3, (int) (Math.log(n) / Math.log(3)));
        
        while (n > 0) {
            answer += n % 3 * digit;
            n /= 3;
            digit /= 3;
        }
        return answer;
    }
}

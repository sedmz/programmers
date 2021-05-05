import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : win_nums) {
            set.add(num);
        }
        
        int unknown = 0;
        for (int lotto : lottos) {
            if (lotto > 0) {
                set.remove(lotto);
            } else {
                unknown++;
            }
        }
        
        int size = set.size();
        return new int [] {Math.max(1, Math.min(size + 1 - unknown, 6)), Math.min(size + 1, 6)};
    }
}

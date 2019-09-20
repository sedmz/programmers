import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Vector<Integer> v = new Vector<>();
        int size = progresses.length;
        int[] days = new int[size];

        for (int i = 0; i < size; i++) {
            days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if (i > 0) {
                if (days[i - 1] > days[i]) {
                    days[i] = days[i - 1];
                }
            }
        }

        int cnt = 0;
        int max = days[0];
        for (int i = 0; i < size; i++) {
            if (days[i] > max) {
                v.add(cnt);
                max = days[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        v.add(cnt);

        int answer[] = new int[v.size()];
        for (int i = 0; i < v.size(); i++)
            answer[i] = v.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
    }
}

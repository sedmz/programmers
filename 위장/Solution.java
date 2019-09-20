import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++)
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);

        int answer = 1;

        Set<String> key = map.keySet();
        Iterator<String> it = key.iterator();
        while (it.hasNext())
            answer *= ((map.get(it.next())) + 1);


        return answer - 1;
    }
}

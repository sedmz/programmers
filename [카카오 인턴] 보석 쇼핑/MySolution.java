import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();

        int[] answer = {1, gems.length};
        int N = set.size();        
        int start = 0, end = 0, min = gems.length;
        
        for(end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                    
            while(map.size() == N) {
                if(min > end - start + 1) {
                    min = Math.min(min, end - start + 1);
                    answer[0] = start + 1;
                    answer[1] = end + 1;                  
                }
  
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                } 
                start++;
            }
        }
        return answer;
    }
}

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            
            if (deque.size() == m) {
                int removed = deque.removeFirst();
                int count = map.get(removed);
                if (count == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, count - 1);
                }
            }
            
            deque.addLast(num);
            
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            
            if (deque.size() == m) {
                max = Math.max(max, map.size());
            }
            
            if (max == m) {
                break;
            }
        }
        
        System.out.println(max);
        scanner.close();
    }
}
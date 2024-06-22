import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size == 1) {
                continue;
            }

            long[] ps = new long[size];
            ps[0] = list.get(0);
            for (int i = 1; i < ps.length; i++) {
                ps[i] = ps[i - 1] + list.get(i);
            }

            for (int i = 0; i < size; i++) {
                int ind = list.get(i);
                if (i == 0) {
                    res[ind] = ps[size - 1] - (long) ind * size;
                } else if (i == size - 1) {
                    res[ind] = (long) ind * size - ps[size - 1];
                } else {
                    res[ind] = (long) (i + 1) * ind - ps[i - 1] + ps[size - 1] - ps[i] - (long) ind * (size - i);
                }


            }

        }

        return res;
    }
}

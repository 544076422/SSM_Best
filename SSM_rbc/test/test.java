import org.junit.Test;

import java.util.HashMap;

public class test {
    @Test
    public void main() {
        int[] ints = {0, 1, 2, 5, 4, 8, 41, 3, 5, 4, 5, 5, 156, 12, 5, 98, 126, 45, 6, 465, 126, 49, 498, 4165, 165,};
        //冒泡
        int[] bubbling = Bubbling(ints);
        //选择
        //change(ints);
        //二分查找
        int x = find(bubbling, 98);
        System.out.println(x);
        System.out.println(bubbling[x]);
    }

    private static int find(int[] ints, int i) {
        int min = 0;
        int max = ints.length;
        int mid = (max + min) / 2;
        while (ints[mid] != i) {
            if (ints[mid] > i) {
                max = mid;
            } else {
                min = mid;
            }
            mid = (max + min) / 2;
        }
        return mid;
    }

    private static void change(int[] ints) {
        for (int x = 0; x < ints.length - 1; x++) {
            for (int y = x + 1; y < ints.length; y++) {
                if (ints[x] > ints[y]) {
                    int temp = ints[x];
                    ints[x] = ints[y];
                    ints[y] = temp;
                }
            }
        }
        for (int x : ints) {
            System.out.print(x + ",");
        }
    }

    private int[] Bubbling(int[] ints) {
        for (int x = 0; x < ints.length - 1; x++) {
            for (int y = 0; y < ints.length - x - 1; y++) {
                if (ints[y] > ints[y + 1]) {
                    int temp = ints[y];
                    ints[y] = ints[y + 1];
                    ints[y + 1] = temp;
                }
            }
        }
        for (int i : ints) {
            System.out.print(i + ",");
        }
        System.out.println();
        return ints;
    }

    @Test
    public void test3() {
        for (int i = 0 ; i < 500 ; i++){
            if (i=='a') System.out.println(i);
            if (i=='A') System.out.println(i);
        }
        int[] ints = twoSum(new int[]{5, 6, 8, 1, 2, 3, 5, 4, 8, 6, 2, 41, 5, 5}, 8);
        System.out.println(ints[0]+"---"+ints[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> integerIntegerHashMap = new HashMap<>();
        for(int x = 0 ; x < nums.length ; x++){
            int temp = target - nums[x];
            if(integerIntegerHashMap.containsKey(temp)){
                int[] ints = {x, (int) integerIntegerHashMap.get(temp)};
                return ints;
            }
            integerIntegerHashMap.put(nums[x] , x);
        }
        return null;
    }
}

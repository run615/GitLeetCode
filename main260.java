package Leetcode;

/**
 * 260. 只出现一次的数字 III
 */
public class main260 {
    /**
     *「异或」
     * 相同的数异或为0，不同为1。在运算过程中支持交换律和结合律。
     * 针对本题：因为数组里除了两个数个数为1，其他都为2。所以循环异或数组完之后的结果就是两个个数为1的数的异或结果。
     * 针对本题的测试用例[1,2,1,3,2,5]，数组整体异或的结果可以简化成3和5的异或，为6，换算成二进制就是'110'。这个二进制得从右往左观察（很关键），第一个不为0的数在第二位，这说明，3<=>'011'和5<=>'101',二进制从右往左的第二位才开始不同的。
     * 所以可以根据数组里所有数字转换为二进制后对第二位的判断，划分两组。（理由：因为两个目标值肯定不在同一个组，其次所有相同的树必定都落在同一个数组中）。
     * 将划分后的两个数组各自进行异或操作，得到的答案就是结果。
     * 
     * 「移位」脑补二进制‘32、16、8、4、2、1’
     * num << 1 : 表示num值的二进制向左移一位，比如 1 << 1 为 2； 2 << 1: 为4
     * num >> 1 : 向右移一位，比如 32 >> 1 为16
     *
     */
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum ^= nums[i]; // 最后sum得到的是两个只出现一次的数的异或值（异或：不同为1）
        }
        int first = 1;
        while((sum & first) == 0){ // 与运算（相同为1）
            first = first << 1;
        }
        int result[] = new int[2];
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & first) == 0){
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        main260 p = new main260();
        int[] res = p.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}

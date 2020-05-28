package Leetcode;

/**
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class mainmianshi11 {
    /**
     * 二分法
     * 让数组的每一轮中间值和最右边的值作比较
     */
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1; //如果中间值比最右边的值还要大，说明左边是递增的
            } else if (numbers[mid] < numbers[right]) { // 中间值小于最右边值，说明中间值到最右边是处于递增的状态
                right = mid;
            } else if(numbers[mid] == numbers[right]) { // 如果中间值等于最右边的值，需要慢慢缩小范围
                right = right - 1;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        mainmianshi11 p = new mainmianshi11();
        int[] numbers = {2, 2, 2, 0, 1};
        int res = p.minArray(numbers);
        System.out.println(res);
    }
}

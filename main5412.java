package Leetcode;

/**
 * 5412. 在既定时间做作业的学生人数
 */
public class main5412 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int len = startTime.length;
        for (int i = 0; i < len; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        main5412 p = new main5412();
        int[] startT = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] endT = new int[]{10,10,10,10,10,10,10,10,10};
        int queryTime = 5;
        int res = p.busyStudent(startT, endT, queryTime);
        System.out.println(res);
    }
}

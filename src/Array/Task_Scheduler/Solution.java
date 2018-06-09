package Array.Task_Scheduler;

import java.util.*;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] schedule = new int[26];

        // 以数组角标代表每个字符
        for (char c : tasks) {
            // 求出每个字符比'A'的ASCII码大多少，并以差值代表该字符
            schedule[c - 'A']++;
        }

        // 将上面获得的数组（代表每个任务出现的次数）排序
        // 这一步将忽略每个任务的名字
        Arrays.sort(schedule);

        // pointer
        int i = 25;

        // 这一步是为了找出数量并列第一的任务有几个
        while (i >= 0 && schedule[i] == schedule[25])
            i--;

        // ①将数量第一的任务视为一个frame 每个frame（除了最后一个frame）的长度为 （n + 1）
        // 除了最后一个frame 前面所有任务的总长度为(schedule[25] - 1) * （n + 1）
        // 最后一个frame的长度为（25 - i）
        // ②然而 当interval == 0 时 interval的长度将对frame无影响 总长度为task.length
        // 所以取两者中较大者 即为答案
        return Math.max(tasks.length, (schedule[25] - 1) * (n + 1) + 25 - i);
    }
}

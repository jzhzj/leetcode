package Array.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;


import static java.lang.Math.max;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
 * <p>
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * <p>
 * Return the maximum profit you can make.
 * <p>
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;//the maxPro you have if you don't have a stock that day
        int hold = -prices[0];//the maxPro you have if you have a stock that day, if you have a stock the first day,hold=-prices[0]
        int i;

        // Dynamic Programming
        for (i = 1; i < prices.length; i++) {
            cash = max(cash, hold + prices[i] - fee);//cash in day i is the maxvalue of cash in day i-1 or you sell your stock
            hold = max(hold, cash - prices[i]);
        }
        return cash;
    }
}

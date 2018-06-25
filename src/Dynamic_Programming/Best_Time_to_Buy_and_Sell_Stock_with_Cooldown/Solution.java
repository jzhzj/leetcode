package Dynamic_Programming.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p>
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int hold = -prices[0];
        int cash = 0;
        int cool = 0;
        for (int i : prices) {
            int tempHold = hold;
            int tempCash = cash;
            hold = Math.max(hold, cool - i);
            cash = Math.max(tempCash, tempHold + i);
            cool = Math.max(cool, tempCash);
        }
        return cash;
    }
}

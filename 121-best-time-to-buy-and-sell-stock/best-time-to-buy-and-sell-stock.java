// class Solution {
//     public int maxProfit(int[] prices) {
//         int min=Integer.MAX_VALUE;
//         int max=0;
//         for(int p: prices){
//             if(p<min) min=p;
//             else if(p-min> max) max=p-min;

//         }
//         return max;
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize to the largest possible value
        int maxProfit = 0; // Initialize profit to 0

        for (int price : prices) {
            if (price < minPrice) {
                // Update the minimum price
                minPrice = price;
            } else {
                // Calculate the profit and update maxProfit if it's greater
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit; // Return the maximum profit
    }
}

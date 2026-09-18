class Solution {
    public int maxProfit(int[] prices) {
        //prices - [7,1,5,3,6,4]

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int price : prices)
        {
            if(price < minPrice){
                minPrice = price;
            }
            else{
                int profit = price - minPrice;
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
        
    }
}

public class MaxProfit {
    public static void main(String[] args) {
        int k = 2;
        int[] price = {5, 11, 3, 50, 60, 90, 80, 3, 45};
        System.out.println("Maximum profit ="+getMaxProfit(price, k));
    }

    public static int getMaxProfit(int[] prices, int numberOfTransactions) {
        int days = prices.length;//n
        int[][] gains = new int[numberOfTransactions + 1][days + 1];

        for (int i = 0; i <= numberOfTransactions; i++) {
            for (int j = 0; j <= days; j++) {
                gains[i][j] = 0;
            }
        }
        for (int i = 1; i <= numberOfTransactions; i++) {
            for (int j = 1; j < days; j++) {
                int maximum_difference = 0;
                for (int m = 0; m < j; m++) {
                    maximum_difference = Math.max(maximum_difference, prices[j] - prices[m] + gains[i - 1][m]);
                }
                gains[i][j] = Math.max(gains[i][j - 1], maximum_difference);
            }
        }
        return gains[numberOfTransactions][days - 1];
    }
}

public class ShopPricing {

    public static int totalPrice(int[] prices) {
        int sum = 0;
        int i = 0;
        while (i < prices.length) {
            sum = sum + prices[i];
            i = i + 1;
        }
        return sum;
    }

    // Increase each price by 5%, but never let it exceed 1000
    public static void increasePrices(int[] prices) {
        int i = 0;
        while (i < prices.length) {
            int increased = prices[i] + (prices[i] * 5) / 100;
            if (increased > 1000) {
                increased = 1000;
            }
            prices[i] = increased;
            i = i + 1;
        }
    }

    // Find the second highest price (assumes all prices are non-negative)
    public static int secondHighest(int[] prices) {
        int highest = -1;
        int second = -1;
        int i = 0;
        while (i < prices.length) {
            int p = prices[i];
            if (p > highest) {
                second = highest;
                highest = p;
            } else if (p > second && p != highest) {
                second = p;
            }
            i = i + 1;
        }
        return second;
    }

    public static void main(String[] args) {

        int[] prices = {200, 950, 480, 999, 300};

        int total = totalPrice(prices);
        System.out.println("Total price before increase: " + total);

        increasePrices(prices);

        int second = secondHighest(prices);
        System.out.println("Second highest price after increase: " + second);

        System.out.println("Updated prices:");
        int i = 0;
        while (i < prices.length) {
            System.out.println(prices[i]);
            i = i + 1;
        }
    }
}

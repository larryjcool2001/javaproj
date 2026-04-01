import java.util.ArrayList;
import java.util.Arrays;  

public class StockPriceAnalysis {

    // Method to calculate average price
    public static double calculateAveragePrice(float[] prices) {
        double sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    // Method to find maximum price
    public static float findMaximumPrice(float[] prices) {
        float max = prices[0];
        for (float price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    // Method to count occurrences
    public static int countOccurrences(float[] prices, float target) {
        int count = 0;
        for (float price : prices) {
            if (price == target) {
                count++;
            }
        }
        return count;
    }

    // Method to compute cumulative sum
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulative = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price;
            cumulative.add(sum);
        }
        return cumulative;
    }

    public static void main(String[] args) {

        float[] stockArray = {120.5f, 121.0f, 119.8f, 122.2f, 120.5f, 123.0f, 124.5f, 122.2f, 121.8f, 120.5f};

        ArrayList<Float> stockList = new ArrayList<>(Arrays.asList(
                120.5f, 121.0f, 119.8f, 122.2f, 120.5f, 123.0f, 124.5f, 122.2f, 121.8f, 120.5f));

        double average = calculateAveragePrice(stockArray);
        float maximum = findMaximumPrice(stockArray);
        int occurrences = countOccurrences(stockArray, 120.5f);
        ArrayList<Float> cumulative = computeCumulativeSum(stockList);

        System.out.println("Average Price: " + average);
        System.out.println("Maximum Price: " + maximum);
        System.out.println("Occurrences of 120.5: " + occurrences);
        System.out.println("Cumulative Sum: " + cumulative);
    }
}


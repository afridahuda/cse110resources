public class WeatherStats {

    public static int findMax(int[] temps) {
        int max = temps[0];
        int i = 1;
        while (i < temps.length) {
            if (temps[i] > max) {
                max = temps[i];
            }
            i = i + 1;
        }
        return max;
    }

    public static int findMin(int[] temps) {
        int min = temps[0];
        int i = 1;
        while (i < temps.length) {
            if (temps[i] < min) {
                min = temps[i];
            }
            i = i + 1;
        }
        return min;
    }

    public static double findAverage(int[] temps) {
        int sum = 0;
        int i = 0;
        while (i < temps.length) {
            sum = sum + temps[i];
            i = i + 1;
        }
        return (double) sum / temps.length;
    }

    // Convert a string to uppercase manually (no built-in toUpperCase())
    public static String toUpperManual(String s) {
        String result = "";
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result = result + ch;
            i = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] temps = {30, 32, 29, 35, 33, 31, 28}; // 7 days, degrees Celsius

        int max = findMax(temps);
        int min = findMin(temps);
        double avg = findAverage(temps);

        System.out.println("Highest temperature: " + max);
        System.out.println("Lowest temperature: " + min);
        System.out.println("Average temperature: " + avg);

        System.out.println("Days above average:");
        int i = 0;
        while (i < temps.length) {
            if (temps[i] > avg) {
                System.out.println("Day " + (i + 1) + ": " + temps[i]);
            }
            i = i + 1;
        }

        String summary = "weather summary complete";
        System.out.println(toUpperManual(summary));
    }
}

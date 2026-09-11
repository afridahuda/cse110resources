public class UniversityAverage {

    // Recursive method to calculate the total sum of marks
    public static int sumMarksRecursive(int[] marks, int index) {
        if (index == marks.length) {
            return 0;
        }
        return marks[index] + sumMarksRecursive(marks, index + 1);
    }

    // Method to calculate the average mark
    public static double calculateAverage(int[] marks) {
        int sum = sumMarksRecursive(marks, 0);
        return (double) sum / marks.length;
    }

    // Method to count vowels in a student's name
    public static int countVowels(String name) {
        int count = 0;
        int i = 0;
        while (i < name.length()) {
            char ch = name.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count = count + 1;
            }
            i = i + 1;
        }
        return count;
    }

    public static void main(String[] args) {

        String[] names = {"Ayesha", "Rakib", "Farhana", "Tanvir", "Meherun"};
        int[] marks    = {78,       55,      92,         60,      85};

        double average = calculateAverage(marks);
        System.out.println("Average mark: " + average);

        System.out.println("Students who scored above average:");
        int i = 0;
        while (i < names.length) {
            if (marks[i] > average) {
                int vowels = countVowels(names[i]);
                System.out.println(names[i] + " - Vowels in name: " + vowels);
            }
            i = i + 1;
        }
    }
}

public class LibraryStats {

    public static double averageBorrows(int[] borrowCounts) {
        int sum = 0;
        int i = 0;
        while (i < borrowCounts.length) {
            sum = sum + borrowCounts[i];
            i = i + 1;
        }
        return (double) sum / borrowCounts.length;
    }

    public static String mostBorrowedTitle(String[] titles, int[] borrowCounts) {
        int maxIndex = 0;
        int i = 1;
        while (i < borrowCounts.length) {
            if (borrowCounts[i] > borrowCounts[maxIndex]) {
                maxIndex = i;
            }
            i = i + 1;
        }
        return titles[maxIndex];
    }

    public static void main(String[] args) {

        String[] titles    = {"Java Basics", "Data Structures", "Algorithms", "Clean Code", "Design Patterns"};
        int[] borrowCounts = {12,             25,                8,            30,           15};

        double avg = averageBorrows(borrowCounts);
        System.out.println("Average borrows: " + avg);

        String topTitle = mostBorrowedTitle(titles, borrowCounts);
        System.out.println("Most borrowed title: " + topTitle);

        System.out.println("Books borrowed more than average:");
        int i = 0;
        while (i < titles.length) {
            if (borrowCounts[i] > avg) {
                System.out.println(titles[i] + " - " + borrowCounts[i] + " borrows");
            }
            i = i + 1;
        }
    }
}

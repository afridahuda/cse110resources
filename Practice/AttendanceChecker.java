public class AttendanceChecker {

    public static double classAverage(int[] attendance) {
        int sum = 0;
        int i = 0;
        while (i < attendance.length) {
            sum = sum + attendance[i];
            i = i + 1;
        }
        return (double) sum / attendance.length;
    }

    // Eligible if present days are at least 75% of total classes
    public static boolean isEligible(int presentDays, int totalClasses) {
        return presentDays * 100 >= 75 * totalClasses;
    }

    public static void main(String[] args) {

        String[] names   = {"Ayesha", "Rakib", "Farhana", "Tanvir", "Meherun"};
        int[] attendance = {24,       18,      27,         20,      28};
        int totalClasses = 30;

        double avg = classAverage(attendance);
        System.out.println("Class average attendance: " + avg);

        System.out.println("Eligible students (attendance >= 75%):");
        int i = 0;
        while (i < names.length) {
            if (isEligible(attendance[i], totalClasses)) {
                System.out.println(names[i] + " - Present: " + attendance[i] + "/" + totalClasses);
            }
            i = i + 1;
        }
    }
}

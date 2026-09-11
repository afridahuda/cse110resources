public class FeedbackAnalyzer {

    // Count words assuming single-space separation
    public static int countWords(String comment) {
        int count = 1;
        int i = 0;
        while (i < comment.length()) {
            if (comment.charAt(i) == ' ') {
                count = count + 1;
            }
            i = i + 1;
        }
        return count;
    }

    // Uses the allowed indexOf() method to search for the keyword
    public static boolean containsKeyword(String comment, String keyword) {
        return comment.indexOf(keyword) != -1;
    }

    public static void main(String[] args) {

        String[] comments = {
            "the app is great and fast",
            "customer service was slow today",
            "great value for the price",
            "the delivery was late"
        };

        String keyword = "great";

        System.out.println("Comments containing \"" + keyword + "\":");
        int i = 0;
        while (i < comments.length) {
            if (containsKeyword(comments[i], keyword)) {
                int wc = countWords(comments[i]);
                System.out.println(comments[i] + " - Word count: " + wc);
            }
            i = i + 1;
        }
    }
}

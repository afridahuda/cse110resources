public class SentenceAnalyzer {

    // Count words, assuming words are separated by single spaces
    // with no leading/trailing spaces.
    public static int countWords(String sentence) {
        int count = 1;
        int i = 0;
        while (i < sentence.length()) {
            if (sentence.charAt(i) == ' ') {
                count = count + 1;
            }
            i = i + 1;
        }
        return count;
    }

    // Split the sentence into a pre-sized array of words, without String.split()
    public static String[] splitWords(String sentence, int wordCount) {
        String[] words = new String[wordCount];
        int wordIndex = 0;
        String current = "";
        int i = 0;
        while (i < sentence.length()) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                words[wordIndex] = current;
                wordIndex = wordIndex + 1;
                current = "";
            } else {
                current = current + ch;
            }
            i = i + 1;
        }
        words[wordIndex] = current; // last word has no trailing space
        return words;
    }

    public static String findLongestWord(String[] words) {
        String longest = words[0];
        int i = 1;
        while (i < words.length) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
            i = i + 1;
        }
        return longest;
    }

    public static void main(String[] args) {

        String sentence = "the quick brown fox jumps over the lazy dog";
        // assumed: single-spaced words, no punctuation

        int wordCount = countWords(sentence);
        String[] words = splitWords(sentence, wordCount);
        String longest = findLongestWord(words);

        System.out.println("Longest word: " + longest);
        System.out.println("Total word count: " + wordCount);
    }
}

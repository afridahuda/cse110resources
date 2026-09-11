public class UsernameValidator {

    // Determine length WITHOUT String's length() method.
    // Standard workaround: convert to a char array and read its length FIELD
    // (a field access, not a method call).
    public static int customLength(String username) {
        char[] chars = username.toCharArray();
        return chars.length;
    }

    // Check that a username contains only letters and digits
    public static boolean isValidChars(String username) {
        int len = customLength(username);
        int i = 0;
        while (i < len) {
            char ch = username.charAt(i);
            boolean isLetter = (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
            boolean isDigit = (ch >= '0' && ch <= '9');
            if (!isLetter && !isDigit) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }

    // Recursive method to count digits in a username
    public static int countDigitsRecursive(String username, int index) {
        int len = customLength(username);
        if (index == len) {
            return 0;
        }
        char ch = username.charAt(index);
        int add = 0;
        if (ch >= '0' && ch <= '9') {
            add = 1;
        }
        return add + countDigitsRecursive(username, index + 1);
    }

    public static void main(String[] args) {

        String[] usernames = {"rakib123", "ab", "user_1", "meherun22", "x1y2z3"};

        System.out.println("Valid usernames:");
        int i = 0;
        while (i < usernames.length) {
            String u = usernames[i];
            int len = customLength(u);
            if (len >= 6 && isValidChars(u)) {
                int digitCount = countDigitsRecursive(u, 0);
                System.out.println(u + " (length=" + len + ", digits=" + digitCount + ")");
            }
            i = i + 1;
        }
    }
}

public class NumberBaseConverter {
    public static void main(String[] args) {

        String input = "22"; // assumed non-negative integer string

        // ---- manually turn the string into an int (no Integer.parseInt) ----
        int num = 0;
        int i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            num = num * 10 + (ch - '0');
            i = i + 1;
        }
        // ----------------------------------------------------------------------

        // ---- binary (base 2) ----
        String binary = "";
        int temp = num;
        if (temp == 0) {
            binary = "0";
        }
        while (temp > 0) {
            int rem = temp % 2;
            binary = rem + binary; // prepend the new digit
            temp = temp / 2;
        }

        // ---- octal (base 8) ----
        String octal = "";
        temp = num;
        if (temp == 0) {
            octal = "0";
        }
        while (temp > 0) {
            int rem = temp % 8;
            octal = rem + octal;
            temp = temp / 8;
        }

        // ---- hexadecimal (base 16) ----
        String hex = "";
        temp = num;
        if (temp == 0) {
            hex = "0";
        }
        while (temp > 0) {
            int rem = temp % 16;
            char digitChar;
            if (rem < 10) {
                digitChar = (char) ('0' + rem);
            } else {
                digitChar = (char) ('A' + (rem - 10));
            }
            hex = digitChar + hex; // prepend the new digit character
            temp = temp / 16;
        }

        System.out.println("Decimal:     " + num);
        System.out.println("Binary:      " + binary);
        System.out.println("Octal:       " + octal);
        System.out.println("Hexadecimal: " + hex);
    }
}

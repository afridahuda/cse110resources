public class QuadraticSolver {
    public static void main(String[] args) {

        // Assumed input format: "<a>x^2<+/-><b>x<+/-><c>"
        // e.g. "x^2+5x+6" means a=1, b=5, c=6
        // Coefficient of 1 may be omitted (just "x" means coefficient 1).
        // Terms can appear in any order but only one of each type is assumed.
        String expr = "x^2+5x+6";

        int len = expr.length();
        int i = 0;
        int sign = 1;
        int num = 0;
        boolean hasNum = false;

        int a = 0, b = 0, c = 0;

        while (i < len) {
            char ch = expr.charAt(i);

            if (ch == '+') {
                sign = 1;
                i = i + 1;
            } else if (ch == '-') {
                sign = -1;
                i = i + 1;
            } else if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
                hasNum = true;
                i = i + 1;
            } else if (ch == 'x') {
                int coeff = hasNum ? num : 1;
                coeff = coeff * sign;

                if (i + 1 < len && expr.charAt(i + 1) == '^') {
                    // this is the x^2 term - skip 'x', '^', '2'
                    a = coeff;
                    i = i + 3;
                } else {
                    // this is the plain x term
                    b = coeff;
                    i = i + 1;
                }

                num = 0;
                hasNum = false;
            } else {
                // unexpected character, skip it
                i = i + 1;
            }
        }

        // whatever number is left un-consumed at the end is the constant term
        if (hasNum) {
            c = num * sign;
        }

        System.out.println("Parsed: a=" + a + ", b=" + b + ", c=" + c);

        if (a == 0) {
            System.out.println("Not a quadratic equation (a = 0).");
        } else {

            long D = (long) b * b - 4L * a * c; // discriminant, may be negative

            // ---- manual square root of |D| using Newton's method (no Math.sqrt) ----
            long absD = D < 0 ? -D : D;
            double guess;
            if (absD == 0) {
                guess = 0;
            } else {
                guess = absD / 2.0;
                int iter = 0;
                while (iter < 60) {
                    if (guess != 0) {
                        guess = (guess + absD / guess) / 2.0;
                    }
                    iter = iter + 1;
                }
            }
            double sq = guess;
            // --------------------------------------------------------------------

            if (D >= 0) {
                double x1 = (-b + sq) / (2.0 * a);
                double x2 = (-b - sq) / (2.0 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else {
                double realPart = -b / (2.0 * a);
                double imagPart = sq / (2.0 * a);
                System.out.println("x1 = " + realPart + " + " + imagPart + "i");
                System.out.println("x2 = " + realPart + " - " + imagPart + "i");
            }
        }
    }
}

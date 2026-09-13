public class LikeTermsCombiner {
    public static void main(String[] args) {

        // Assumed input format: terms with variables 'x' and/or 'y' only,
        // each term optionally preceded by a sign and a coefficient.
        // e.g. "x+x+7x+6y"
        String expr = "x+x+7x+6y";

        int len = expr.length();
        int i = 0;
        int sign = 1;
        int num = 0;
        boolean hasNum = false;

        int coeffX = 0;
        int coeffY = 0;

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
                coeffX = coeffX + coeff * sign;
                num = 0;
                hasNum = false;
                i = i + 1;
            } else if (ch == 'y') {
                int coeff = hasNum ? num : 1;
                coeffY = coeffY + coeff * sign;
                num = 0;
                hasNum = false;
                i = i + 1;
            } else {
                i = i + 1; // skip unexpected character
            }
        }

        // ---- build the simplified output string ----
        String result = "";
        boolean firstTerm = true;

        if (coeffX != 0) {
            int absX = coeffX < 0 ? -coeffX : coeffX;
            String signX = coeffX < 0 ? "-" : (firstTerm ? "" : "+");
            String numPartX = (absX == 1) ? "" : ("" + absX);
            result = result + signX + numPartX + "x";
            firstTerm = false;
        }

        if (coeffY != 0) {
            int absY = coeffY < 0 ? -coeffY : coeffY;
            String signY = coeffY < 0 ? "-" : (firstTerm ? "" : "+");
            String numPartY = (absY == 1) ? "" : ("" + absY);
            result = result + signY + numPartY + "y";
            firstTerm = false;
        }

        if (result.equals("")) {
            result = "0";
        }

        System.out.println(result);
    }
}

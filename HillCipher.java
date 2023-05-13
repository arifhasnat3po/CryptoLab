import java.util.Arrays;

class HillCipher {
    private static final double[][] KEY_MATRIX = new double[][] { { 19, 10, 34 }, { 34, 10, 19 }, { 340, 1, 91 } };
    private static final double[][] INV_KEY_MATRIX = new double[][] { { -3 / 215, 292 / 21285, 10 / 4257
    }, { -34 / 645, 3277 / 21285, -53 / 4257 }, { 34 / 645, -1127 / 21285, 10 / 4257 } };
    private static final String KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String encode(char a, char b, char c) {
        int posA = a - 65;
        int posB = b - 65;
        int posC = c - 65;
        double x = posA * KEY_MATRIX[0][0] + posB * KEY_MATRIX[1][0] + posC * KEY_MATRIX[2][0];
        double y = posA * KEY_MATRIX[0][1] + posB * KEY_MATRIX[1][1] + posC * KEY_MATRIX[2][1];
        double z = posA * KEY_MATRIX[0][2] + posB * KEY_MATRIX[1][2] + posC * KEY_MATRIX[2][2];
        a = KEY.charAt((int) (x % 26));
        b = KEY.charAt((int) (y % 26));
        c = KEY.charAt((int) (z % 26));
        return "" + a + b + c;
    }

    private static String decode(char a, char b, char c) {
        int posA = a - 65;
        int posB = b - 65;
        int posC = c - 65;
        double x = posA * INV_KEY_MATRIX[0][0] + posB * INV_KEY_MATRIX[1][0] + posC * INV_KEY_MATRIX[2][0];
        double y = posA * INV_KEY_MATRIX[0][1] + posB * INV_KEY_MATRIX[1][1] + posC * INV_KEY_MATRIX[2][1];
        double z = posA * INV_KEY_MATRIX[0][2] + posB * INV_KEY_MATRIX[1][2] + posC * INV_KEY_MATRIX[2][2];
        a = KEY.charAt((int) ((x % 26 + 26) % 26));
        b = KEY.charAt((int) ((y % 26 + 26) % 26));
        c = KEY.charAt((int) ((z % 26 + 26) % 26));
        return "" + a + b + c;
    }

  public static void main(String[] args) {
    String msg = "Arif Hasnat";
    System.out.println("Simulation of Hill Cipher\n-------------------------");
    System.out.println("Input message: " + msg);
    msg = msg.toUpperCase().replaceAll("\\s", "");
    int n = msg.length();
int padding = (n % 3 == 0) ? 0 : 3 - (n % 3);
for (int i = 0; i < padding; i++) {
msg = msg + "X";
}
n = msg.length();
StringBuilder encoded = new StringBuilder();
for (int i = 0; i < n; i += 3) {
char a = msg.charAt(i);
char b = msg.charAt(i + 1);
char c = msg.charAt(i + 2);
encoded.append(encode(a, b, c));
}
System.out.println("Encoded message: " + encoded);
StringBuilder decoded = new StringBuilder();
for (int i = 0; i < n; i += 3) {
char a = encoded.charAt(i);
char b = encoded.charAt(i + 1);
char c = encoded.charAt(i + 2);
decoded.append(decode(a, b, c));
}
System.out.println("Decoded message: " + decoded.toString().substring(0, n - padding));
}

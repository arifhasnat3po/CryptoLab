class lab2pract{
  /* 3x3 key matrix for 3 characters at once */
  public static double[][] keymat = new double[][] { { 1, 9, 1 }, { 0, 3, 3 }, { 4, 0, 0 } }; /* key inverse matrix */
  public static double[][] invkeymat = new double[][] { {0, 0, 0.25} {0.125, -1/24, -1/32} {1/8, 3/8, 1/32} };
  public static String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private static String encode(char a, char b, char c) {
    String ret = "";
    double x, y, z;
    int posa = (int) a - 65;
    int posb = (int) b - 65;
    int posc = (int) c - 65;
    x = posa * keymat[0][0] + posb * keymat[1][0] + posc * keymat[2][0];
    y = posa * keymat[0][1] + posb * keymat[1][1] + posc * keymat[2][1];
    z = posa * keymat[0][2] + posb * keymat[1][2] + posc * keymat[2][2];
    a = key.charAt((int) (x % 26));
    b = key.charAt((int) (y % 26));
    c = key.charAt((int) (z % 26));
    ret = "" + a + b + c;
    return ret;
  }

  private static String decode(char a, char b, char c) {
    String ret = "";
    double x, y, z;
    int posa = (int) a - 65;
    int posb = (int) b - 65;
    int posc = (int) c - 65;
    x = posa * invkeymat[0][0] + posb * invkeymat[1][0] + posc * invkeymat[2][0];
    y = posa * invkeymat[0][1] + posb * invkeymat[1][1] + posc * invkeymat[2][1];
    z = posa * invkeymat[0][2] + posb * invkeymat[1][2] + posc * invkeymat[2][2];
    a = key.charAt((int) ((x % 26 + 26) % 26));
    b = key.charAt((int) ((y % 26 + 26) % 26));
    c = key.charAt((int) ((z % 26 + 26) % 26));
    ret = "" + a + b + c;
    return ret;
  }

  /**
 * @param args
 */
public static void main(String[] args) {
    String msg;
    String enc = "";
    String dec = "";
    int n;
    msg = "Arif Hasnat";
    System.out.println("Simulation of Hill Cipher\n-------------------------");
    System.out.println("Input message : " + msg);
msg = msg.toUpperCase();
msg = msg.replaceAll("\\s", "");
/* remove spaces */ n = msg.length() % 3;
/* append padding text X */ if (n != 0) {
for (int i = 1; i <= (3 - n); i++) {
msg += 'X';
}
}
System.out.println("padded message : " + msg);
char[] pdchars = msg.toCharArray();
for (int i = 0; i < msg.length(); i += 3) {
enc += encode(pdchars[i], pdchars[i + 1], pdchars[i + 2]);
}
System.out.println("encoded message : " + enc);
char[] dechars = enc.toCharArray();
for (int i = 0; i < enc.length(); i += 3) {
dec += decode(dechars[i], dechars[i + 1], dechars[i + 2]);
}
System.out.println("decoded message : " + dec);
}
}
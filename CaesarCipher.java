class CaesarCipher{
  /**
   * @param enc
   * @param offset
   * @return
   */
  public static String encode(String enc, int offset){
   offset = (offset % 26 + 26) % 26;
    StringBuilder encoded = new StringBuilder();
for (char i: enc.toCharArray()){
if (Character.isLetter(i)){
if (Character.isUpperCase(i)){
encoded.append((char)('A'+(i - 'A' + offset)%26));
}else{
encoded.append((char)('a'+(i - 'a' + offset)%26));
}
}else{
encoded.append(i);
}
}
return encoded.toString();
}
public static String decoded(String enc, int offset){
  return encode(enc, 26 - offset);
}

public static void main(String[]args)throws java.lang.Exception{
String msg = "Arif Hasnat";
System.out.print("Simulation caesar cipher\n---------");
System.out.println("Input:"+ msg);
System.out.printf("Encrypted Message:");
System.out.println(CaesarCipher.encode(msg,34));
System.out.printf("Decrypted Message:");
System.out.print(CaesarCipher.decoded(CaesarCipher.encode(msg,34),34));
}
}
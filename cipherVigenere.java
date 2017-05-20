public class cipherVigenere {
  
  public static int[] decryptShift(int[] code, int[] key) {
    // Given an alphanumeric code and key, decodes the message following a Vigenere cipher.
    // Passes over punctuation.
    
    int[] decodedMessage = new int[code.length];
    int difference;
    int n = 0;
    int len = code.length;
    int limit = key.length;
    
    for (int i = 0; i < len; i++) {
      if (code[i] <= 25) {
        difference = (code[i] - key[n]);
        if (difference < 0) {
          decodedMessage[i] = 26 + difference;
        } else {
          decodedMessage[i] = difference % 26;
        }
        n++;
        n = n % limit;
      } else {
        decodedMessage[i] = code[i];
      }
    }
    return decodedMessage;
  }
  
  public static int[] encryptShift(int[] message, int[] key) {
    // Given a message and key, encrypts the message using the key in a Vigenere cipher.
    // Passes over punctuation.
    
    int[] codedMessage = new int[message.length];
    int len = message.length;
    int n = 0;
    int limit = key.length;
    
    for (int i = 0; i < len; i++) {
      if (message[i] <= 25) {
        codedMessage[i] = (message[i] + key[n]) % 26;
        n++;
        n = n % limit;
      } else {
        codedMessage[i] = message[i];
      }
    }
    return codedMessage;
  }
  
  public static String encrypt(String message, String key) {
    
    // Returns the message, coded by the key.
    
    int[] messageArray = cipherLeaves.string_to_alphanum(message);
    int[] keyArray = cipherLeaves.string_to_alphanumKEY(key);
    
    int[] rawMessage = encryptShift(messageArray, keyArray);
    String codedMessage = cipherLeaves.alphanum_to_string(rawMessage);
    
    return codedMessage;
  }
  
  public static String decrypt(String code, String key) {
    
    // returns the message, decoded by the key.
    
    int[] codeArray = cipherLeaves.string_to_alphanum(code);
    int[] keyArray = cipherLeaves.string_to_alphanumKEY(key);
    
    int[] rawDecode = decryptShift(codeArray, keyArray);
    String decodedMessage = cipherLeaves.alphanum_to_string(rawDecode);
    
    return decodedMessage;
  }
  
}
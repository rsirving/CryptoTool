public class cipherCaesar {
  
  public static char[] encryptShift(int[] message, int shift) {
    // Given a message and a shift amount, encrypts the message with the corresponding Caesar cipher.
    // Passes over punctuation.
    
    char[] codedMessage = new char[message.length];
    int len = message.length;
    
    for (int i = 0; i < len; i++) {
      if (message[i] <= 25) {
        codedMessage[i] = (char) (((message[i] + shift) % 26) + 65);
      } else {
        codedMessage[i] = (char) message[i];
      }
    }
    return codedMessage;
  }
  
  public static String encrypt(String message, char shift) {
    String answer = null;
    if (Character.isLetter(shift) == true) {
      shift = Character.toUpperCase(shift);
      int shiftAmount = shift - 65;
      int[] rawMessage = new int[message.length()];
      char[] codedMessage = new char[rawMessage.length];
      
      rawMessage = cipherLeaves.string_to_alphanum(message);
      codedMessage = encryptShift(rawMessage, shiftAmount);
      
      answer = new String(codedMessage);
    } else {
      ;
    }
    return answer;
  } 
  
  public static char[] decryptShift(int[] code, int shift) {
    char[] decodedMessage = new char[code.length];
    int len = code.length;
    int difference, shifted;
    
    for (int i = 0; i < len; i++) {
      if (code[i] <= 25) {
        difference = code[i] - shift;
        if (difference < 0) {
          shifted = 26 + difference;
        } else {
          shifted = difference;
        }
        decodedMessage[i] = (char) (shifted + 65);
      } else {
        decodedMessage[i] = (char) code[i];
      }
    }
    return decodedMessage;
  }
  
  public static String decrypt(String code, char shift) {
    String answer = null;
    if (Character.isLetter(shift) == true) {
      shift = Character.toUpperCase(shift);
      int shiftAmount = shift - 65;
      
      int[] rawCode = new int[code.length()];
      char[] decodedMessage = new char[rawCode.length];
      
      rawCode = cipherLeaves.string_to_alphanum(code);
      decodedMessage = decryptShift(rawCode, shiftAmount);
      
      answer = new String(decodedMessage);
    } else {
      ;
    }
    return answer;
  }
  
}
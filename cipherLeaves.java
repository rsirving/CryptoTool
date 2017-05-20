public class cipherLeaves {
  
  public static int[] letter_to_alphanum(char[] input) {
    // ['A','B','C',' ','.'] -> [0,1,2,32,46]
    // Converts an array of characters to an array of ASCII values.
    // Letters are converted to values closer to their actual alphanumeric values for ease of use.
    
    int len = input.length;
    int[] output = new int[len];
      for (int i = 0; i < len ; i++) {
      if (Character.isLetter(input[i]) == true) {
        output[i] = (((int) input[i]) - 65);
      } else {
        output[i] = (int) input[i];
      }
    }
    return output;
  }
  
  public static char[] alphanum_to_letter(int[] input) {
    // [0,1,2,32,46] -> ['A','B','C',' ','.']
    // Converts an array of alphanumeric/ASCII values to an array of characters.
    
    int len = input.length;
    char[] output = new char[len];
    
    for (int i = 0; i < len; i++) {
      if (input[i] <= 25) {
        output[i] = ((char) (input[i] + 65));
      } else {
        output[i] = (char) input[i];
      }
    }
    return output;
  }
  
  public static int[] string_to_alphanum(String input) {
    // "ABC ." -> ['A','B','C',' ','.'] -> [0,1,2,32,46]
    // Used for the conversion of code strings to character arrays.
    // Converts to uppercase, leaves all punctuation.
    
    input = input.toUpperCase();
    char[] rawCode = input.toCharArray();
    int[] code = letter_to_alphanum(rawCode);
    return code;
  }
  
  public static int[] string_to_alphanumKEY(String input) {
    // 'ABC .' -> ['A','B','C',' '] -> [0,1,2,32]
    // Used for the conversion of key strings to arrays of characters.
    // Converts to uppercase, removes all punctuation but spaces.
    
    input = input.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ").toUpperCase();
    char[] rawCode = input.toCharArray();
    int[] code = letter_to_alphanum(rawCode);
    return code;
  }
  
  public static String alphanum_to_string(int[] input) {
    // [0,1,2,32,46] -> ['A','B','C',' ','.'] -> "ABC ."
    // Converts from alphanumeric/ASCII values to characters to a string.
    
    int len = input.length;
    char[] output = new char[len];
    for (int i = 0; i < len; i++) {
      if (input[i] <= 25) {
        output[i] = (char) (input[i] + 65);
      } else {
        output[i] = (char) input[i];
      }
    }
    String answer = new String(output);
    return answer;
  }
  
}
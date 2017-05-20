import java.util.Arrays;

public class cipherFrequency {
  
  public static int[] letterCount(String message) {
    int[] freqArray = new int[26];
    Arrays.fill(freqArray, 0);
    int[] messageArray = cipherLeaves.string_to_alphanumKEY(message);
    int len = messageArray.length;
    int x;
    
    for (int i = 0; i < len; i++) {
      x = messageArray[i];
      if (x <= 25) {
        freqArray[x] = freqArray[x] + 1;
      } else {
        ;
      }
    }
    return freqArray;
  }
  
}
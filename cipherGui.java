import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Run this one!//

public class cipherGui {
  
  public static void main(String[] args) {
    
    JFrame frame = new JFrame("Decryption/Encryption");
    frame.setSize(520,420);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponentsChoice(panel);
    frame.setVisible(true);
  }
  
  private static void placeComponentsChoice(JPanel panel) {
    
    panel.setLayout(null);
    
    final JLabel keyRequest = new JLabel("Cipher (A-Z):");
    keyRequest.setBounds(80,130,100,25);
    panel.add(keyRequest);
    
    String[] cipherOptions = { "Caesar", "Vigenere" };    
    final JComboBox<String> cipherSelect = new JComboBox<>(cipherOptions);
    cipherSelect.setBounds(20,20,160,25);
    panel.add(cipherSelect);
    cipherSelect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (cipherSelect.getSelectedItem() == "Caesar") {
          keyRequest.setText("Enter cipher (A-Z):");
        } else if (cipherSelect.getSelectedItem() == "Vigenere") {
          keyRequest.setText("Enter key:");
        }
      }
    });
    
    final JTextField keyInput = new JTextField(20);
    keyInput.setBounds(190,130,160,25);
    panel.add(keyInput);
    
    final JTextArea textField = new JTextArea(5,20);
    textField.setBounds(190,20,310,100);
    textField.setLineWrap(true);
    textField.setWrapStyleWord(true);
    panel.add(textField);
    
    final JTextArea frequencyOutput = new JTextArea(5,20);
    frequencyOutput.setBounds(20,170,480,200);
    frequencyOutput.setEditable(false);
    frequencyOutput.setLineWrap(true);
    frequencyOutput.setWrapStyleWord(true);
    panel.add(frequencyOutput);
    
    JButton encryptButton = new JButton("Encrypt");
    encryptButton.setBounds(20,50,160,25);
    panel.add(encryptButton);
    encryptButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        if (cipherSelect.getSelectedItem() == "Caesar") {
          char key = keyInput.getText().charAt(0);
          String answer = cipherCaesar.encrypt(input, key);
          textField.setText(answer);
        } else if (cipherSelect.getSelectedItem() == "Vigenere") {
          String key = keyInput.getText();
          String answer = cipherVigenere.encrypt(input, key);
          textField.setText(answer);
        }
      }
    });
    
    JButton decryptButton = new JButton("Decrypt");
    decryptButton.setBounds(20,80,160,25);
    panel.add(decryptButton);
    decryptButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        if (cipherSelect.getSelectedItem() == "Caesar") {
          char key = keyInput.getText().charAt(0);
          String answer = cipherCaesar.decrypt(input, key);
          textField.setText(answer);
        } else if (cipherSelect.getSelectedItem() == "Vigenere") {
          String key = keyInput.getText();
          String answer = cipherVigenere.decrypt(input, key);
          textField.setText(answer);
        }
      }
    });
    
    JButton frequencyButton = new JButton("Frequency");
    frequencyButton.setBounds(350,130,160,25);
    panel.add(frequencyButton);
    frequencyButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frequencyOutput.setText("");
        String input = textField.getText();
        int[] frequency = cipherFrequency.letterCount(input);
        int n = 'A';
        char nextLetter;
        for (int i = 0; i < 26; i++) {
          nextLetter = (char) (n + i);
          String nextLine = "" + nextLetter + ": " + frequency[i] + "; ";
          frequencyOutput.append(nextLine);
        }
      }
    });
  }
  
}
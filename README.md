# CryptoTool
My final project for Computer Architecture, taught by Michael Siff: I learned basic Java, and created a small program that could encrypt and decrypt messages using a Caesar or Vigenere cipher. It can also count letter frequency for cryptological purposes. Compile the documents, and then run cipherGUI.java.

# Caesar Cipher
A simple substitution cipher that shifts each letter a fixed number of places down the alphabet. A cipher of 'B' - which would be shifting each letter one place down the alphabet - would turn "HELLO, WORLD!" into "IFMMP, XPSME!"
An easy way to think about it is that the letter you put into the key box is the letter that 'A' will be shifted to. Thus, entering 'A' as the key wouldn't change the message at all.

# Vigenere Cipher
The Vigenere cipher has its roots in the Caesar cipher, but it's much, much more complicated and harder to brute force. Instead of using a single letter as the key, the Vigenere cipher uses a whole word. It's easier to demonstrate than to explain, so here's a message ("HELLO, WORLD!") with a key ("DAVE").
H E L L O ,  W O R L D !
D A V E D    A V E D A
The key determines what Caesar cipher shift value each letter in the message will be changed by. H is shifted by 4 letters, E isn't shifted, the first L is shifted by 21, and so on. This message would be encrypted as "KEGPR, WJVOD!".

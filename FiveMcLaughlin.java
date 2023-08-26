import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FiveMcLaughlin {
    public static void main(String[] args) {
        int m = (int) Math.pow(2, 7);
        char[] cipher = new char[m];
        for (int i = 0; i < m; i++)
            cipher[i] = (char) mod(7 * i + 3, m);

        String cipherText = read("cipher.txt");
        int aInverse = 55; 

        for (int i = 0; i < cipherText.length(); i++) {
            char encryptedChar = cipherText.charAt(i);
            char decryptedChar = (char) mod(aInverse * (encryptedChar - 3), m);
            System.out.print(decryptedChar);
        }
    }
    public static String read(String path) {
        String ret = null;
        try {
            ret = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
    public static int mod(int x, int n) {
        return ((x % n) + n) % n;
    }
}

    


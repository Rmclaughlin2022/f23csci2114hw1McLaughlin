import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FourMcLaughlin {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ryan M\\Downloads\\half_gaps(1).bin";
        byte[] bytes = getFileBytes(filePath);

        if (bytes != null) {
            long[] gaps = new long[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                gaps[i] = Byte.toUnsignedLong(bytes[i]);
            }

    
            long[] cumSum = new long[gaps.length];    
            long sum = 0;
            for (int i = 0; i < gaps.length; i++) {
                sum += gaps[i];
                cumSum[i] = sum;
            }

          
            for (int i = 0; i < cumSum.length; i++) {            //computes the array of numbers and also * by 2 and +3 like told to
                cumSum[i] = cumSum[i] * 2 + 3;
            }

System.out.println("First fifteen Numbers:");
for (int i = 0; i < Math.min(15, cumSum.length); i++) {   //first 15 numbers loop
    System.out.println(cumSum[i]);
}

System.out.println("Last five Numbers:");
int startIndex = Math.max(0, cumSum.length - 5);  // Minus 5 from the length so that it gets the last 5 numbers in the loop
for (int i = startIndex; i < cumSum.length; i++) {
    System.out.println(cumSum[i]);
}

Long Starttime= System.nanoTime();
Double Timetook = System.nanoTime() - (Starttime) / 1e9;  //1e9 is 10x^9 to convert from nano seconds to actual seconds

System.out.println("Time Taken: " + Timetook + " Seconds");


        } else {
            System.out.println("Failed to read file.");  //Just in case code does not work as a check case
        }
    }

    public static byte[] getFileBytes(String path) {   //code that was given
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}


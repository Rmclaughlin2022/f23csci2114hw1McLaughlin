public class TwoMcLaughlin {

  public static int fibNumbers(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibNumbers(n - 2) + fibNumbers(n - 1);
    }
  }

  public static void main(String[] args) {
    if (args.length != 1) { 
      System.out.println("Please provide a single value for n.");
      return;
    }

    int n = Integer.parseInt(args[0]);
    int[] fibonacciArray = new int[n];
    int maxNumberWidth = 0;

    for (int i = 0; i < n; i++) {
      fibonacciArray[i] = fibNumbers(i);
      int currentWidth = String.valueOf(fibonacciArray[i]).length();
      if (currentWidth > maxNumberWidth) {
        maxNumberWidth = currentWidth;
      }
    }

    int NumbersInRow = 7;
    for (int i = 0; i < n; i++) {
      String formattedNumber = String.format("%" + maxNumberWidth + "d", fibonacciArray[i]);
      System.out.print(formattedNumber + " ");
      if ((i + 1) % NumbersInRow == 0) {
        System.out.println();
      }
    }
  }
}
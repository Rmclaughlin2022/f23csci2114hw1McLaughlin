public class ThreeMcLaughlin {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java SieveOfEratosthenes <limit>");
            return;
        }
        
        int n = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        System.out.print("Prime numbers less than 100: ");
        for (int i = 2; i < 100; i++) {
            if (isPrime[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
        

        int count = 0;
        int largest = 0;
        for (int i = n - 1; i >= 2; i--) {
            if (isPrime[i]) {
                System.out.println("Largest prime: " + i);
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        
        double startTime = System.nanoTime();
        eratosthenes(isPrime);
        double duration = (System.nanoTime() - startTime) / (60 * Math.pow(10, 9));
        System.out.println("Time taken: " + duration + " minutes");
    }
    
    public static void eratosthenes(boolean[] isPrime) {
    }
}










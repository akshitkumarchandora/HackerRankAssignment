import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        // Complete this function
        int p = (int)nthroot(N,X);
        int sum = rec(X,p,N);
        return sum;
    }
    static int rec(int X,int p,int power){
        if(X==0){
            return 1;
        }
        if(X<0){
            return 0;
        }
        if(p<0){
            return 0;
        }
        
        return rec(X,p-1,power)+rec(X-(int)Math.pow(p,power),p-1,power);
    }
    
  public static double nthroot(int n, double x, double p) 
    {
        if(x < 0) 
        {
            System.err.println("Negative!");
            return -1;
        }
        if(x == 0) 
            return 0;
        double x1 = x;
        double x2 = x / n;  
        while (Math.abs(x1 - x2) > p) 
        {
            x1 = x2;
            x2 = ((n - 1.0) * x2 + x / Math.pow(x2, n - 1.0)) / n;
        }
        return x2;
    }
    
     public static double nthroot(int n, double x) 
    {
        return nthroot(n, x, .0001);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

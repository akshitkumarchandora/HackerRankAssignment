import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        Arrays.sort(arr);
        //int []check=new int[k];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int op_minimised=Integer.MAX_VALUE;
        int sub=0;
        
        for(int i=k-1;i<arr.length;i++)
        {
            max=arr[i];
            min=arr[i-k+1];
            sub=max-min;
            if(sub==0)
            return 0;
            if(max-min < op_minimised)
                op_minimised=sub;
        }
       return op_minimised; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

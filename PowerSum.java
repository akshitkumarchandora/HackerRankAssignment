import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {

        return solve(X,N);
    }

    static int solve(int total,int N )
    {
        int num=(int)Math.pow(total,(double)1/N);
        int []numbers=new int[num];//3
        for(int i=0;i<num;i++)
            numbers[i]=i+1;//0-1 1-2 2-3
            //numbers=new int[]{3,1,2};
        int [][]dpTable=new int[num+1][total+1];
        for(int i=0;i<num+1;i++)
        {
            dpTable[i][0]=1;
        }
        for(int i=1;i<num+1;i++){
            for(int j=1;j<total+1;j++){
                
                if((int)Math.pow(numbers[i-1],N)<=j)
                dpTable[i][j]=dpTable[i-1][j]+dpTable[i-1][j-(int)Math.pow(numbers[i-1],N)];
                else
                dpTable[i][j]=dpTable[i-1][j];
            }
        }
        for(int i=0;i<=num;i++)
        {for(int j=0;j<=total;j++)
        {
            System.out.print(dpTable[i][j]+ "   ");
        }
        System.out.println();
        }

        System.out.println(Arrays.toString(numbers));
        return dpTable[num][total];

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

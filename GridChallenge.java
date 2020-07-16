import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        char [][]mat=new char[grid.length][grid[0].length()];
        int i=0;
        for(String str:grid){
                char []c=str.toCharArray();
                Arrays.sort(c);
                mat[i++]=c;
        }
        boolean check=true;
        for(i=0;i<mat[0].length;i++){
            {
                for(int j=0;j<mat.length-1;j++)
                {
                    if(mat[j][i]>mat[j+1][i])
                    {
                        check=false;
                        break;
                    }
                }
            }
        }
        if(check)
        return "YES";
        else
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());


        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int result = 0;

            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum == m) {
                    result++;
                    start++;
                    end--;
                }else if(sum < m){
                    start++;
                }else{
                    end--;
                }

            }

       System.out.println(result);
    }
}



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++){
        String str = br.readLine();
        if(isVPS(str)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    br.close();

    }
    public static boolean isVPS(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else if(stack.empty()){
                return false;
            }
            else {
                stack.pop();
            }
        }
        return stack.empty();
    }
}


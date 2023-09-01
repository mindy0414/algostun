import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A+1];
        int[] dp = new int[A+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= A; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = 1;
        int ans = 1;
        for (int i = 2; i <= A; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }

        int value = ans;
        Stack<Integer> stack = new Stack<>();

        for (int i = A; i >= 1; i--) {
            if (value == dp[i]) {
                stack.push(arr[i]);
                value--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(ans);
        System.out.println(sb);


    }
}


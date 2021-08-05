package baekjoon;

import java.util.Scanner;

public class Main_2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        
        for (int i = 1; i < n; i++) {
			String m = i+"";
			int sum = i;
			for (int j = 0; j < m.length(); j++) {
				sum += Integer.parseInt(m.charAt(j)+"");
			}
			if (sum == n) {
                answer = i;
                break;
            }
		}
        System.out.println(answer);
        
        scanner.close();
        
    }
}

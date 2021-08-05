package baekjoon;

import java.util.Scanner;

public class Main_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] sum = new int[12];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        sum[3] = 4;
        
        for (int i = 4; i < sum.length; i++) {
			sum[i] = sum[i-1] + sum[i-2] + sum[i-3];
		}
        
        int n = sc.nextInt();
        int[] tc = new int[n];
        for (int i = 0; i < n; i++) {
        	tc[i] = sc.nextInt();
		}
        for (int i = 0; i < n; i++) {
        	System.out.println(sum[tc[i]]);
        }
        
        sc.close();
        
    }
}

package baekjoon;

import java.util.Scanner;

public class Main_2503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] num = new int[504]; //9 * 8 * 7 = 504
        int tc = sc.nextInt();
        int size = 0;
        
        for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if (i == j || j == k || k == i) continue;
					num[size++] = i*100 + j*10 + k;
				}
			}
		}
        
        for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			int strike = sc.nextInt();
			int ball = sc.nextInt();
			
			if (strike == 3) {
				size = 1;
				break;
			}
			
			for (int j = 0; j < size; j++) {
				if (cntStrike(num[j]+"", n+"") != strike || cntBall(num[j]+"", n+"") != ball) {
					num[j] = num[--size];
					j--;
				}
			}
			
		}
        
        System.out.println(size);
        
        sc.close();
    }
    
    public static int cntStrike(String n1, String n2) {
    	int cnt = 0;

    	for (int i = 0; i < 3; i++) {
			if (n1.charAt(i) == n2.charAt(i)) cnt++;
		}
    	
    	return cnt;
    }

    public static int cntBall(String n1, String n2) {
    	int cnt = 0;
    	
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != j) {
					if (n1.charAt(i) == n2.charAt(j)) cnt++;
				}
			}
		}
    	
    	return cnt;
    }
    
}

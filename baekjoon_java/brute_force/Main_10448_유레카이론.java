package baekjoon;

import java.util.Scanner;

public class Main_10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] t = new int[43];
        t[0] = 1;
        for (int i = 1; i < t.length; i++) {
			t[i] += t[i-1] + i+1;
		}
        
        int tc = sc.nextInt();
        int[] num = new int[tc];
        
        for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
        
        for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				for (int k = 0; k < t.length; k++) {
					for (int l = 0; l < num.length; l++) {
						if (num[l] < 3) continue;
						if (t[i]+t[j]+t[k] == num[l]) num[l] = 1;
					}
				}
			}
		}
        
        for (int i = 0; i < num.length; i++) {
			if (num[i] != 1) System.out.println("0");
			else System.out.println(num[i]);
		}
        
        sc.close();
        
    }
}

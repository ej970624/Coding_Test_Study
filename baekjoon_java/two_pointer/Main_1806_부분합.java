package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		int answer = N+1;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			long sum = 0;
			for (int j = i; j < N; j++) {
				sum += num[j];
				if (sum >= S) {
					answer = Math.min(answer, j-i+1);
					break;
				}
			}
		}
		
		if (answer == N+1) System.out.println(0);
		else System.out.println(answer);
	}

}

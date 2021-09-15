package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main_14889_스타트와링크 {
	
	static int N, K, team[], power[][], answer;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = N/2;
		power = new int[N][N];
		team = new int[K];
		answer = Integer.MAX_VALUE;
		flag = false;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				power[i][j]	= Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(answer);
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if (flag) return; //flag = true면 answer가 0이라는 뜻이므로, 더이상 탐색 X
		if (cnt == K) {
			int sum1 = 0;
			int sum2 = 0;
			boolean[] check = new boolean[N];
			for (int i = 0; i < K; i++) {
				check[team[i]] = true;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (check[i] == check[j]) {
						if (check[i]) sum1 += power[i][j] + power[j][i];
						else sum2 += power[i][j] + power[j][i];
					}
				}
			}
			answer = Math.min(answer, Math.abs(sum1-sum2));
			if (answer == 0) flag = true; //차이가 0이면 더이상 탐색할 필요 없으므로 flag = true
			return;
		}
		for (int i = start; i < N; i++) {
			team[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

}

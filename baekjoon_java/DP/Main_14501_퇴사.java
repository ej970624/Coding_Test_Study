package baekjoon.DP;

import java.io.*;
import java.util.*;

public class Main_14501_퇴사 {
	
	static class Consulting {
		int start, end, pay;

		public Consulting(int start, int end, int pay) {
			this.start = start;
			this.end = end;
			this.pay = pay;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Consulting[] consultings = new Consulting[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			consultings[i] = new Consulting(i, i+Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] profit = new int[N+1];
		profit[0] = 0;
		for (int i = 0; i < N; i++) {
			if (consultings[i].end > N) continue;
			profit[consultings[i].end] = Math.max(profit[consultings[i].end], profit[consultings[i].start]+consultings[i].pay);
			for (int j = consultings[i].end+1; j < N+1; j++) {
				profit[j] = Math.max(profit[consultings[i].end], profit[j]);
			}
		}
		
		System.out.println(profit[N]);
	}

}

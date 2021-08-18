package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_14719_빗물 {
	
	static int H, W, answer = 0;
	static int[][] block;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		block = new int[H][W];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++) {
			int h = Integer.parseInt(st.nextToken());
			for (int j = H-1; j > H-1-h; j--) {
				block[j][i] = 1;
			}
		}
		
		for (int i = 0; i < H; i++) {
			dfs(i, 0, false, 0);
		}
		System.out.println(answer);
	}

	static void dfs(int x, int y, boolean flag, int cnt) {
		if (y >= W) return;
		if (flag) {
			if (block[x][y] == 1) {
				answer += cnt;
				dfs(x, y+1, true, 0);
			} else {
				dfs(x, y+1, true, cnt+1);
			}
		} else {
			if (block[x][y] == 1) {
				dfs(x, y+1, true, cnt);
			} else {
				dfs(x, y+1, false, cnt);
			}
		}
	}
}

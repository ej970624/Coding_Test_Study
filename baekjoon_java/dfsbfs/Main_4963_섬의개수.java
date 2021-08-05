package baekjoon.dfsbfs;

import java.util.*;
import java.io.*;

public class Main_4963_섬의개수 {
	
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //우, 우하, 하, 좌하, 좌, 좌상, 상, 우상
	static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	static int w, h, island[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			island = new int[h][w];
			int cnt = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (island[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
		island[x][y] = 0;
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0<=nx && nx<h && 0<= ny && ny<w && island[nx][ny] == 1) {
				dfs(nx, ny);
			} 
		}
	}

}

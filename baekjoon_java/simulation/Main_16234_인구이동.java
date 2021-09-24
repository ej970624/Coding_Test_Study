package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_16234_인구이동 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int N, L, R, countries[][];
	static List<List<Point>> union;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		countries = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				countries[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while (true) {
			visited = new boolean[N][N];
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j])	if (bfs(i, j)) flag = true;
				}
			}
			
			if (!flag) break;
			
			day++;
		}
		
		System.out.println(day);
		br.close();
	}
	
	static boolean bfs(int x, int y) {
		ArrayDeque<Point> connected = new ArrayDeque<>();
		ArrayDeque<Point> que = new ArrayDeque<>();
		visited[x][y] = true;
		que.offer(new Point(x, y));
		connected.offer(new Point(x, y));
		int sum = countries[x][y];
		
		while (!que.isEmpty()) {
			Point p = que.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny] && L <= Math.abs(countries[p.x][p.y]-countries[nx][ny]) && Math.abs(countries[p.x][p.y]-countries[nx][ny]) <= R) {
					visited[nx][ny] = true;
					que.offer(new Point(nx, ny));
					connected.offer(new Point(nx, ny));
					sum += countries[nx][ny];
				}
			}
		}
		
		if (connected.size() == 1) return false;
		
		int avg = sum/connected.size();
		while (!connected.isEmpty()) {
			Point p = connected.poll();
			countries[p.x][p.y] = avg;
		}
		
		return true;
	}

}

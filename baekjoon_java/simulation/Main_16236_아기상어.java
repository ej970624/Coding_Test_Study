package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어 {

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 }; // 상, 좌, 우, 하
	static int size, cnt, time, N, space[][];

	static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		int x = 0, y = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}

		size = 2;
		cnt = 0;
		time = 0;
		bfs(x, y);

		System.out.println(time);
		br.close();
	}

	static void bfs(int x, int y) {
		boolean[][] visited = new boolean[N][N];
		ArrayDeque<Point> que = new ArrayDeque<>();
		PriorityQueue<Point> available = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.d, o2.d)==0?(Integer.compare(o1.x, o2.x)==0?Integer.compare(o1.y, o2.y):Integer.compare(o1.x, o2.x)):Integer.compare(o1.d, o2.d));
		que.offer(new Point(x, y, 0));
		visited[x][y] = true;
		
		while (!que.isEmpty()) {
			if (!available.isEmpty() && available.peek().d < que.peek().d+1) {
				Point next = available.poll();
				
				if (++cnt == size) {
					size++;
					cnt = 0;
				}
				
				space[x][y] = 0;
				space[next.x][next.y] = 9;
				x = next.x;
				y = next.y;
				time += next.d;
				que.clear();
				que.offer(new Point(x, y, 0));
				visited = new boolean[N][N];
				visited[x][y] = true;
				available.clear();
				continue;
			} 
			
			Point p = que.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					if (space[nx][ny] == 0 || space[nx][ny] == size) {
						que.offer(new Point(nx, ny, p.d+1));
						visited[nx][ny] = true;
					} else {
						if (space[nx][ny] < size) {
							que.offer(new Point(nx, ny, p.d+1));
							available.offer(new Point(nx, ny, p.d+1));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
	}

}

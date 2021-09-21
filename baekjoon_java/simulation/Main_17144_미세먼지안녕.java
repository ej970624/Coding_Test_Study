package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_17144_미세먼지안녕 {
	
	static int[] dx0 = {-1, 0, 1, 0};
	static int[] dy0 = {0, 1, 0, -1};
	static int[] dx1 = {1, 0, -1, 0};
	static int[] dy1 = {0, 1, 0, -1};
	static int R, C, T, room[][];
	static Point[] aircleaner;
	static List<Point> dust;
	
	static class Point {
		int x, y, plus;

		public Point(int x, int y, int plus) {
			this.x = x;
			this.y = y;
			this.plus = plus;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		aircleaner = new Point[2];
		dust = new ArrayList<Point>();
		int idx = 0;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) aircleaner[idx++] = new Point(i, j, 0);
				if (room[i][j] > 0) dust.add(new Point(i, j, 0));
			}
		}
		
		for (int i = 0; i < T; i++) {
			spreadDust();
			airCleanerOn();
		}
		
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0) answer += room[i][j];
			}
		}
		
		System.out.println(answer);
		br.close();
		
	}
	
	static void spreadDust() {
		List<Point> change = new ArrayList<>();
		for (int i = 0; i < dust.size(); i++) {
			int amount = room[dust.get(i).x][dust.get(i).y]/5;
			if (amount < 1) continue;
			int cnt = 0;
			for (int j = 0; j < dx0.length; j++) {
				int nx = dust.get(i).x + dx0[j];
				int ny = dust.get(i).y + dy0[j];
				if (0<=nx && nx<R && 0<=ny && ny<C && room[nx][ny] != -1) {
					change.add(new Point(nx, ny, amount));
					cnt++;
				}
			}
			if (cnt > 0) change.add(new Point(dust.get(i).x, dust.get(i).y, -1*cnt*amount));
		}
		
		for (int i = 0; i < change.size(); i++) {
			Point p = change.get(i);
			if (room[p.x][p.y] == 0) dust.add(new Point(p.x, p.y, 0));
			room[p.x][p.y] += p.plus;
		}
	}
	
	static void airCleanerOn() {
		int cx = aircleaner[0].x;
		int cy = aircleaner[0].y;
		int d = 0;
		int nx = cx + dx0[d];
		int ny = cy + dy0[d];
		
		while (nx != aircleaner[0].x || ny != aircleaner[0].y) {
			if (room[cx][cy] != -1)	room[cx][cy] = room[nx][ny];
			cx = nx;
			cy = ny;
			if (nx == 0 && ny == 0 || nx == 0 && ny == C-1 || nx == aircleaner[0].x && ny == C-1) d++;
			nx = cx + dx0[d];
			ny = cy + dy0[d];
		}
		room[cx][cy] = 0;
			
		cx = aircleaner[1].x;
		cy = aircleaner[1].y;
		d = 0;
		nx = cx + dx1[d];
		ny = cy + dy1[d];
		while (nx != aircleaner[1].x || ny != aircleaner[1].y) {
			if (room[cx][cy] != -1)	room[cx][cy] = room[nx][ny];
			cx = nx;
			cy = ny;
			if (nx == R-1 && ny == 0 || nx == R-1 && ny == C-1 || nx == aircleaner[1].x && ny == C-1) d++;
			nx = cx + dx1[d];
			ny = cy + dy1[d];
		}
		room[cx][cy] = 0;
		
		for (int i = 0; i < dust.size(); i++) {
			int x = dust.get(i).x;
			int y = dust.get(i).y;
			if (x <= aircleaner[0].x) {
				if (x == aircleaner[0].x && y < C-1) {
					dust.get(i).y += 1;
				} else if (x != 0 && y == C-1) {
					dust.get(i).x -= 1;
				} else if (x == 0 && y != 0) {
					dust.get(i).y -= 1;
				} else if (x != aircleaner[0].x && y == 0) {
					dust.get(i).x += 1;
				}
				if (dust.get(i).x == aircleaner[0].x && dust.get(i).y == aircleaner[0].y) {
					dust.remove(i);
					i--;
				}
			} else {
				if (x == aircleaner[1].x && y < C-1) {
					dust.get(i).y += 1;
				} else if (x != R-1 && y == C-1) {
					dust.get(i).x += 1;
				} else if (x == R-1 && y != 0) {
					dust.get(i).y -= 1;
				} else if (x != aircleaner[1].x && y == 0) {
					dust.get(i).x -= 1;
				}
				if (dust.get(i).x == aircleaner[1].x && dust.get(i).y == aircleaner[1].y) {
					dust.remove(i);
					i--;
				}
			}
		}
	}

}

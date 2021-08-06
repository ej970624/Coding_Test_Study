package baekjoon.dfsbfs;

import java.util.*;
import java.io.*;

public class Main_20058_마법사상어와파이어스톰 {

	static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dc = { 1, 0, -1, 0 };
	static int size, max = 0, ice[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		ice = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < size; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int twoL = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
			if (twoL > 1) {
				// 회전
				for (int iR = 0; iR < size; iR += twoL) {
					for (int iC = 0; iC < size; iC += twoL) {
						int[][] temp = new int[twoL][twoL];
//						for (int r = 0; r < twoL; r++) {
//							for (int c = 0; c < twoL; c++) {
//								temp[r][c] = ice[iR + twoL - 1 - c][iC + r];
//							}
//						}
						//밑의 for문을 위의 주석처럼 해도 됨.
						for (int rotation = 0; rotation < twoL/2; rotation++) {
							int x = iR+rotation;
							int y = iC+rotation;
							int nx = rotation;
							int ny = twoL-1-rotation;
							
							for (int m = 0; m < (twoL-2*rotation)*4-4; m++) {
								temp[nx][ny] = ice[x][y];
								
								if (rotation<=nx && nx<twoL-1-rotation && ny == twoL-1-rotation) {
									nx++;
									y++;
								} else if (nx == twoL-1-rotation && rotation<ny && ny<= twoL-1-rotation) {
									ny--;
									x++;
								} else if (rotation<nx && nx<=twoL-1-rotation && ny == rotation) {
									nx--;
									y--;
								} else if (nx == rotation && rotation<=ny && ny<twoL-1-rotation) {
									ny++;
									x--;
								}
							}
							
						}
						for (int l = 0; l < twoL; l++) {
							for (int m = 0; m < twoL; m++) {
								ice[iR + l][iC + m] = temp[l][m];
							}
						}
					}
				}
			}

			// 인접 칸 얼음 확인 후 감소
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					int cnt = 0;
					if (ice[j][k] == 0)
						continue;
					for (int d = 0; d < dr.length; d++) {
						int nr = j + dr[d];
						int nc = k + dc[d];
						if (nr < 0 || size <= nr || nc < 0 || size <= nc || ice[nr][nc] == 0)
							cnt++;
					}
					if (cnt > 1)
						if (--ice[j][k] == 0)
							ice[j][k] = -1;
				}

			}
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (ice[j][k] == -1)
						ice[j][k] = 0;
				}
			}
		}

		int total = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				total += ice[i][j];
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (ice[i][j] != 0)
					max = Math.max(max, bfs(i, j));
			}
		}

		System.out.println(total);
		System.out.println(max);
	}

	static int bfs(int x, int y) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { x, y });
		ice[x][y] = 0;
		int cnt = 1;

		while (!que.isEmpty()) {
			int[] xy = que.poll();
			for (int i = 0; i < dr.length; i++) {
				int nx = xy[0] + dr[i];
				int ny = xy[1] + dc[i];
				if (0 <= nx && nx < size && 0 <= ny && ny < size && ice[nx][ny] != 0) {
					ice[nx][ny] = 0;
					que.offer(new int[] { nx, ny });
					cnt++;
				}
			}
		}
		return cnt;
	}

}

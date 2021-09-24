package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_17143_낚시왕 {
	
	static int[] dx = {-1, 1, 0, 0}; //위, 아래, 오른쪽, 왼쪽 순
	static int[] dy = {0, 0, 1, -1};
	
	static class Shark {
		int s, d, z;

		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Shark[][] board = new Shark[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(board[i], null);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1; //행
			int c = Integer.parseInt(st.nextToken())-1; //열
			int s = Integer.parseInt(st.nextToken()); //속력
			int d = Integer.parseInt(st.nextToken())-1; //이동방향
			int z = Integer.parseInt(st.nextToken()); //크기
			board[r][c] = new Shark(s, d, z);
		}
		
		
		int answer = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (board[j][i] != null) { //상어발견!
					answer += board[j][i].z;
					board[j][i] = null; //상어 잡음
					break;
				}
			}
			
			//상어 이동
			Shark[][] temp = new Shark[R][C]; //이동 전 모습을 저장할 temp배열에 복사
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					temp[j][k] = board[j][k];
				}
			}
			//이동 후의 모습을 저장해야 하므로 null로 초기화
			for (int j = 0; j < R; j++) {
				Arrays.fill(board[j], null);
			} 
			
			for (int x = 0; x < R; x++) {
				for (int y = 0; y < C; y++) {
					if (temp[x][y] != null) {
						Shark shark = temp[x][y];
						int nx = x;
						int ny = y;
						
						for (int j = 0; j < shark.s; j++) {
							if (nx == 0 && shark.d == 0) shark.d = 1;
							if (nx == R-1 && shark.d == 1) shark.d = 0;
							if (ny == 0 && shark.d == 3) shark.d = 2;
							if (ny == C-1 && shark.d == 2) shark.d = 3;
							
							nx += dx[shark.d];
							ny += dy[shark.d];
						}
						
						if (board[nx][ny] != null) { //이동한 곳에 상어가 있다면 크기비교
							if (board[nx][ny].z > shark.z) { //방금 온 상어가 더 작다면 넘어감
								continue;
							}
						}
						board[nx][ny] = shark;
					}
				}
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}

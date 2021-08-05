package baekjoon.brute_force;

import java.io.*;
import java.util.*;

public class Main_3190_뱀 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //우, 하, 좌, 상
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n+2][n+2];
		board[1][1] = 1;
		
		int cntApple = Integer.parseInt(br.readLine());
		for (int i = 0; i < cntApple; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 4;
		}
		int[] dirInfo = new int[10001];
		int cntDir = Integer.parseInt(br.readLine());
		for (int i = 0; i < cntDir; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dirInfo[Integer.parseInt(st.nextToken())] = (st.nextToken().equals("D"))?1:-1;
		}

		Deque<String> snake = new ArrayDeque<>();
		snake.add("1 1");
		int dirIdx = 0;
		int time = 0;
		while (true) {
			time++;
			String head = snake.getFirst();
			StringTokenizer st = new StringTokenizer(head);
			int i = Integer.parseInt(st.nextToken())+dir[dirIdx][0];
			int j = Integer.parseInt(st.nextToken())+dir[dirIdx][1];
			if (i == 0 || i == n+1 || j == 0 || j == n+1 || board[i][j] == 1) break;
			if (board[i][j] != 4) {
				String tail = snake.getLast();
				st = new StringTokenizer(tail);
				board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 0;
				snake.removeLast();
			}
			board[i][j] = 1;
			snake.addFirst(i + " " + j);
			if (dirInfo[time] != 0) {
				dirIdx += dirInfo[time];
				if (dirIdx == -1) dirIdx = dir.length-1;
				else if (dirIdx == dir.length) dirIdx = 0;
			}
		}
		System.out.println(time);
	}

}

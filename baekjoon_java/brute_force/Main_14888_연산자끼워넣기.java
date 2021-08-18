package baekjoon.brute_force;

import java.io.*;
import java.util.*;

public class Main_14888_연산자끼워넣기 {
	
	static int N, order[], num[], operator[], min, max;
	static boolean selected[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		num = new int[N];
		order = new int[N-1];
		operator = new int[N-1];
		selected = new boolean[N-1];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				operator[idx++] = i;
			}
		}
		
		min = Integer.MAX_VALUE/2;
		max = Integer.MIN_VALUE/2;
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void perm(int cnt) {
		if (cnt == N-1) {
			int key = num[0];
			int idx = 1;
			for (int i = 0; i < N-1; i++) {
				if (operator[order[i]] == 0) { //덧셈
					key += num[idx++];
				} else if (operator[order[i]] == 1) { //뺄셈
					key -= num[idx++];
				} else if (operator[order[i]] == 2) { //곱셈
					key *= num[idx++];
				} else { //나눗셈
					if (key < 0) key = -(Math.abs(key) / num[idx++]);
					else key /= num[idx++];
				}
			}
			min = Math.min(min, key);
			max = Math.max(max, key);
		}
		
		for (int i = 0; i < N-1; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			order[cnt] = i;
			perm(cnt+1);
			selected[i] = false;
		}
	}

}

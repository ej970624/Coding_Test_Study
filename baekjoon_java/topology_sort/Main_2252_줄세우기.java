package baekjoon.topology_sort;

import java.io.*;
import java.util.*;

public class Main_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer>[] que = new ArrayDeque[N+1];
		boolean[] selected = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			que[i] = new ArrayDeque<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			que[after].offer(before);
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		while (!stack.isEmpty()) {
			int n = stack.pop();
			if (selected[n]) {
				if (stack.isEmpty() && n < N) {
					stack.push(n+1);
				}
				continue;
			}
			if (que[n].isEmpty()) {
				sb.append(n).append(" ");
				selected[n] = true;
				if (stack.isEmpty() && n < N) {
					stack.push(n+1);
				}
			} else {
				stack.push(n);
				while(!que[n].isEmpty()) {
					stack.push(que[n].poll());
				}
			}
		}
		System.out.println(sb);
		br.close();
	}

}

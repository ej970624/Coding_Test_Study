package baekjoon.dfsbfs;

import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS {
	
	static StringBuilder sb;
	static int N, M, V;
	static PriorityQueue<Integer>[] edges1, edges2;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		edges1 = new PriorityQueue[N+1];
		edges2 = new PriorityQueue[N+1];
		
		for (int i = 0; i <= N; i++) {
			edges1[i] = new PriorityQueue<>();
			edges2[i] = new PriorityQueue<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			edges1[n1].add(n2);
			edges1[n2].add(n1);
			edges2[n1].add(n2);
			edges2[n2].add(n1);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs();
		System.out.println(sb);
		br.close();
		
	}
	
	static void dfs(int n) {
		sb.append(n).append(" ");
		visited[n] = true;
		
		while (!edges1[n].isEmpty()) {
			int i = edges1[n].poll();
			if (visited[i]) continue;
			dfs(i);
		}
	}
	
	static void bfs() {
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.offer(V);
		visited[V] = true;
		
		while(!que.isEmpty()) {
			int n = que.poll();
			sb.append(n).append(" ");
			
			while (!edges2[n].isEmpty()) {
				int i = edges2[n].poll();
				if (visited[i]) continue;
				
				que.offer(i);
				visited[i] = true;
			}
		}
	}

}

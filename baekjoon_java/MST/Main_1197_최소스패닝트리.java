package baejoon.MST;

import java.io.*;
import java.util.*;

public class Main_1197_최소스패닝트리 {
	
	static Vertex[] vertexes;
	
	static class Vertex {
		int n, parent;

		public Vertex(int n, int parent) {
			this.n = n;
			this.parent = parent;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		vertexes = new Vertex[V+1];
		for (int i = 1; i <= V; i++) {
			vertexes[i] = new Vertex(i, i);
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		int cnt = 0;
		long answer = 0;
		while (!pq.isEmpty()) {
			int[] v = pq.poll();
			if (findSet(v[0]) != findSet(v[1])) {
				union(vertexes[v[0]], vertexes[v[1]]);
				answer += v[2];
				if (++cnt == V-1) break;
			}
		}
		System.out.println(answer);
		br.close();
	}
	
	static int findSet(int n) {
		Vertex v = vertexes[n];
		while (v.n != v.parent) {
			v = vertexes[v.parent];
		}
		return v.parent;
	}
	
	static void union(Vertex v1, Vertex v2) {
		vertexes[findSet(v1.n)].parent = vertexes[findSet(v2.n)].n; 
	}

}

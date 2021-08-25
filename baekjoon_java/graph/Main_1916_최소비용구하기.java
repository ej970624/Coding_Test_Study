package baekjoon.graph;

import java.io.*;
import java.util.*;

public class Main_1916_최소비용구하기 {
	
	static class Node {
		int head;
		List<int[]> linked;
		public Node(int head, List<int[]> linked) {
			this.head = head;
			this.linked = linked;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N+1];
		for (int i = 0; i < N+1; i++) {
			nodes[i] = new Node(i, new ArrayList<>());
		}
		
		boolean[] visited = new boolean[N+1];
		int[] minValue = new int[N+1];
		Arrays.fill(minValue, Integer.MAX_VALUE);
		int start, end;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			nodes[n1].linked.add(new int[] {n2, value});
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		minValue[start] = 0;
		int current = start;
		while(current != end) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int[] arr : nodes[current].linked) {
				if (!visited[arr[0]] && minValue[arr[0]] > minValue[current] + arr[1]) {
					minValue[arr[0]] = minValue[current] + arr[1];
				}
			}
			for (int i = 1; i < N+1; i++) {
				if (!visited[i] && min > minValue[i]) {
					min = minValue[i];
					minIdx = i;
				}
			}
			visited[current] = true;
			current = minIdx;
		}
		System.out.println(minValue[end]);
	}

}

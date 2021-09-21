package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_16235_나무재테크 {
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N, M, K, space[][], A[][];
	static PriorityQueue<Tree> trees;
	static ArrayDeque<Tree> deadtree, five;
	
	static class Tree {
		int x, y, age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		trees = new PriorityQueue<>((o1, o2)->Integer.compare(o1.age, o2.age));
		deadtree = new ArrayDeque<>();
		five = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.offer(new Tree(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		space = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(space[i], 5);
		}
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();
		}
		
		System.out.println(trees.size());
		br.close();
	}
	
	static void spring() {
		ArrayDeque<Tree> temp = new ArrayDeque<>();
		while (!trees.isEmpty()) {
			Tree t = trees.poll();
			if (space[t.x][t.y] < t.age) {
				deadtree.offer(t);
			} else {
				space[t.x][t.y] -= t.age;
				t.age += 1;
				temp.offer(t);
				if (t.age % 5 == 0) five.offer(t);
			}
		}
		
		while (!temp.isEmpty()) trees.offer(temp.poll());
	}
	
	static void summer() {
		while (!deadtree.isEmpty()) {
			Tree t = deadtree.poll();
			space[t.x][t.y] += t.age/2;
		}
	}
	
	static void autumn() {
		while (!five.isEmpty()) {
			Tree t = five.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					trees.offer(new Tree(nx, ny, 1));
				}
			}
		}
	}
	
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				space[i][j] += A[i][j];
			}
		}
	}

}

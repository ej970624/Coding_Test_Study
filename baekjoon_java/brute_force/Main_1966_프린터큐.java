package baekjoon.brute_force;

import java.io.*;
import java.util.*;

public class Main_1966_프린터큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n]; // 몇번째로 인쇄되는지
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int[] priority = new int[size];
			Integer[] sortedPriority = new Integer[size];
			int keyIdx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < size; j++) {
				priority[j] = Integer.parseInt(st.nextToken());
				sortedPriority[j] = priority[j];
			}
			
			Arrays.sort(sortedPriority, Collections.reverseOrder());
			int si = 0; // sortedPriority index
			int pi = 0; // priority index
			while (true) {
				if (sortedPriority[si] == priority[pi]) {
					answer[i]++;
					if (pi == keyIdx) break;
					else si++;
				} 
				if (pi == size-1) {
					pi = 0;
				} else {
					pi++;
				}
				
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}

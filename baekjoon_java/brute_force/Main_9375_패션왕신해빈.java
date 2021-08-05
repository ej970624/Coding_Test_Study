package baekjoon.brute_force;

import java.io.*;
import java.util.*;

public class Main_9375_패션왕신해빈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int[] answer = new int[tc]; 

		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> fashion = new HashMap<>();
			for (int j = 0; j < n; j++) {
				String item = br.readLine().split(" ")[1];
				if (fashion.get(item) == null) {
					fashion.put(item, 1);
				} else {
					fashion.put(item, fashion.get(item)+1);
				}
			}
			int cnt = 1;
			for (int f : fashion.values()) {
				cnt *= (f+1);
			}
			answer[i] = cnt-1;
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}

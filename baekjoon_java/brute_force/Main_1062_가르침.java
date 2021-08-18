package baekjoon.brute_force;

import java.io.*;
import java.util.*;

public class Main_1062_가르침 {
	
	static int N, K, answer;
	static boolean[] alpha;
	static String[] word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine().trim();
		}
		
		alpha = new boolean[26];
		alpha['a'-'a'] = true;
		alpha['n'-'a'] = true;
		alpha['t'-'a'] = true;
		alpha['i'-'a'] = true;
		alpha['c'-'a'] = true;
		
		answer = 0;
		if (K >= 5) {
			comb(0, 0);
		} 
		System.out.println(answer);
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == K-5) {
			int sum = 0;
			label : for (int i = 0; i < N; i++) {
				String s = word[i].substring(4, word[i].length()-4);
				for (int j = 0; j < s.length(); j++) {
					if (!alpha[s.charAt(j)-'a']) continue label;
				}
				sum++;
			}
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i = start; i < 26; i++) {
			if (alpha[i]) continue;
			alpha[i] = true;
			comb(cnt+1, i+1);
			alpha[i] = false;
		}
	}

}

package programmers;

import java.util.Arrays;
import java.util.Collections;

public class Solution_프린터 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
	}

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Integer[] sorted = new Integer[priorities.length];
        for (int i = 0; i < sorted.length; i++) {
			sorted[i] = priorities[i];
		}
        Arrays.sort(sorted, Collections.reverseOrder());
        int si = 0; // sortedPriority index
		int pi = 0; // priority index
		while (true) {
			if (sorted[si] == priorities[pi]) {
				answer++;
				if (pi == location) break;
				else si++;
			} 
			if (pi == priorities.length-1) {
				pi = 0;
			} else {
				pi++;
			}
			
		}
        return answer;
    }
}

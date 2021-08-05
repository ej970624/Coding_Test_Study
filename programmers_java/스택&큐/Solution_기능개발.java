package programmers;

import java.util.*;

public class Solution_기능개발 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 })));
		// 출력결과 : [1, 3, 2]
	}

	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int size = 0;
        int idx = 0;
        
        while (idx < progresses.length) {
	        for (int i = 0; i < progresses.length; i++) {
	        	progresses[i] += speeds[i];
			}
	        int cnt = 0;
	        for (int i = idx; i < progresses.length; i++) {
				if (progresses[i] < 100) break;
				else {
					answer[size] += 1;
					idx++;
					cnt++;
				}
			}
	        if (cnt > 0) size++;
        }
        
        return Arrays.copyOf(answer, size);
    }

}

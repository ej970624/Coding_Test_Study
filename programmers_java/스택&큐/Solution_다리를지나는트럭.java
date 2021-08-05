package programmers;

import java.util.*;

public class Solution_다리를지나는트럭 {

	public static void main(String[] args) {
		System.out.println(solution(100, 100, new int[]{10}));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(truck_weights[0], 1));
        int w = truck_weights[0];
        int idx = 1;
        
        while(!que.isEmpty()) {
        	answer++;
        	for(Info info : que) {
        		info.location++;
        	}
        	if (que.peek().location > bridge_length) {
        		w -= que.peek().weight;
        		que.poll();
        	}
        	if (idx < truck_weights.length && w + truck_weights[idx] <= weight) {
        		w += truck_weights[idx];
        		que.add(new Info(truck_weights[idx++], 1));
        	}
		}
        
        return answer;
    }
	

}

class Info {
	int weight;
	int location;
	
	Info(int weight, int location) {
		this.weight = weight;
		this.location = location;
	}
}

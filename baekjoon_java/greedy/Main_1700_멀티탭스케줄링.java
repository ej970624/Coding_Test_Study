package baekjoon.greedy;

import java.io.*;
import java.util.*;

//하나의 멀티탭으로 여러제품 사용
//생활패턴 분석하여 제품 사용순서 알아냄
//플러그를 빼는 횟수를 최소화하는 방법 찾기 -> 플러그 빼는 횟수의 최솟값 출력
public class Main_1700_멀티탭스케줄링 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //멀티탭 구멍 수
		int K = Integer.parseInt(st.nextToken()); //사용할 제품의 총 순서
		ArrayDeque<Integer>[] product = new ArrayDeque[K+1]; //인덱스에 해당하는 제품이 사용할 순서리스트 저장
		for (int i = 0; i < K+1; i++) {
			product[i] = new ArrayDeque<>();
		}
		int[] order = new int[K]; //사용할 제품의 순서대로 제품번호 저장
		int[] multi = new int[N]; //멀티탭 사용중인 제품번호 저장
		boolean[] used = new boolean[K+1]; //사용중인 제품 구분
		int answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			product[order[i]].offer(i); //해당 제품번호가 몇번째에 사용되는지 que로 저장
		}
		
		int idx = 0;
		for (int i = 0; i < N; i++, idx++) { //처음 멀티탭 구멍 수 만큼 채워줌
			if (used[order[idx]]) {
				i--;
				product[order[idx]].poll();
				continue;
			}
			multi[i] = order[idx];
			used[multi[i]] = true;
			product[order[idx]].poll();
		}
		
		//멀티탭에서 사용중인 제품 중에 그 다음에 사용할 순서가 가장 늦은 제품빼고 다음 제품 넣어주기
		for (int i = idx; i < K; i++) { 
			if (used[order[i]]) {
				product[order[i]].poll();
				continue;
			}
			int nextMax = 0;
			int maxIdx = -1;
			for (int j = 0; j < N; j++) {
				if (product[multi[j]].peek() == null) {
					maxIdx = j;
					break;
				}
				if (nextMax < product[multi[j]].peek()) {
					nextMax = product[multi[j]].peek();
					maxIdx = j;
				}
			}
			used[multi[maxIdx]] = false;
			multi[maxIdx] = order[i];
			used[order[i]] = true;
			product[order[i]].poll();
			answer++;
		}
		
		System.out.println(answer);
		br.close();
	}

}

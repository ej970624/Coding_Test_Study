package baekjoon.stackqueue;

import java.io.*;
import java.util.*;

public class Main_2504_괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Stack<Object[]> stack = new Stack<>();
		int answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(' || arr[i] == '[') {
				stack.push(new Object[] {arr[i], 0});
			} else {
				if (stack.isEmpty()) {
					answer = 0;
					break;
				}
				Object[] value = stack.pop();
				int sub = 0;
				if ((int)value[1] == 0) value[1] = 1;
				if (arr[i] == ')' && (char)value[0] == '(') {
					sub = (int)value[1]*2;
				} else if (arr[i] == ']' && (char)value[0] == '[') {
					sub = (int)value[1]*3;
				} else {
					answer = 0;
					break;
				}
				if (stack.isEmpty()) answer += sub;
				else stack.peek()[1] = (int)stack.peek()[1] + sub;
			}
		}
		
		System.out.println(stack.isEmpty()?answer:"0");
		br.close();
	}

}

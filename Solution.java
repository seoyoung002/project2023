package Main;

import java.util.*;

class Solution {
	public char[] solution(int n, int[][] ladder) { 
		char[] answer = new char[n];
		for (int i = 0; i < n; i++) { // 학생 수 만큼 루프
			answer[i] = (char) (65 + i); // 학생 이름 (A,B,C...) 입력
		}

		for (int i = 0; i < ladder.length; i++) { // 사다리의 가로 줄 만큼 루프
			for (int j = 0; j < ladder[i].length; j++) { // 사다리의 한 가로 줄의 개수 만큼 루프
				char temp = answer[ladder[i][j]]; // 현재 위치의 값을 temp에 저장
				answer[ladder[i][j]] = answer[ladder[i][j] - 1]; // 현재 위치에 이전 위치의 값 저장
				answer[ladder[i][j] - 1] = temp; // 이전 위치에 저장된 값을 temp에 저장
			}
		}
		return answer;  
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[][] { { 1, 3 }, { 2, 4 }, { 1, 4 } })));
		System.out.println(Arrays.toString(T.solution(7, new int[][] { { 1, 3, 5 }, { 1, 3, 6 }, { 2, 4 } })));
		System.out.println(
				Arrays.toString(T.solution(8, new int[][] { { 1, 5 }, { 2, 4, 7 }, { 1, 5, 7 }, { 2, 5, 7 } })));
		System.out.println(Arrays.toString(T.solution(12,
				new int[][] { { 1, 5, 8, 10 }, { 2, 4, 7 }, { 1, 5, 7, 9, 11 }, { 2, 5, 7, 10 }, { 3, 6, 8, 11 } })));
	}

}

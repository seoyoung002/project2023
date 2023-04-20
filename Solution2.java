package Main;

import java.util.*;

class Solution2 {
	public int[] solution(int[][] board, int k) {
		int[] answer = new int[2];

		// 시작위치 초기화 
		answer[0] = 0;
		answer[1] = 0;

		// 방향키 index 설정
		int d = 1;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; 

		// k초 만큼 루프
		for (int i = 0; i < k; i++) {

			// 다음 칸으로 이동할 x,y 새로운 변수 생성
			int x = answer[0] + dx[d];
			int y = answer[1] + dy[d];

			// 보드의 길이를 벗어나거나, 보드가 1인 경우 위치 변경
			if (x == board.length || y == board.length || x < 0 || y < 0 || board[x][y] == 1) {
				d = d + 1;
				d %= 4;
				continue; 
			}

			answer[0] += dx[d];
			answer[1] += dy[d];
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		int[][] arr1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = { { 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr3, 25)));

	}
}

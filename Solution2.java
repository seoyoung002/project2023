package Main;

import java.util.*;

class Solution2 {
	public int[] solution(int[][] board, int k) {
		int[] answer = new int[2];

		// ������ġ �ʱ�ȭ 
		answer[0] = 0;
		answer[1] = 0;

		// ����Ű index ����
		int d = 1;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; 

		// k�� ��ŭ ����
		for (int i = 0; i < k; i++) {

			// ���� ĭ���� �̵��� x,y ���ο� ���� ����
			int x = answer[0] + dx[d];
			int y = answer[1] + dy[d];

			// ������ ���̸� ����ų�, ���尡 1�� ��� ��ġ ����
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

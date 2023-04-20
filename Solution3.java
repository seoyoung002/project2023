package Main;

import java.util.*;

class Solution3 {
	public int solution(int[][] board) {
		int answer = 0;

		// 현수와 강아지 위치를 찾기 위한 변수 선언 및 초기화
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		// 현수와 강아지 현재 위치 찾기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == 2) {
					x1 = i;
					y1 = j;
				}
				if (board[i][j] == 3) {
					x2 = i;
					y2 = j;
				}
			}
		}

		// 방향키 index 설정
		int d1 = 0;
		int d2 = 0;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int count = 0;

		// 1000분 만큼 루프
		while (count < 1000) {

			// 이동할 때마다 count 증가
			count++;

			// 다음 칸으로 이동할 x,y 새로운 변수 생성
			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];

			// 위치가 변했는지 안변했는지 확인하는 flag
			boolean flag1 = true;
			boolean flag2 = true;

			// 보드의 길이를 벗어나거나, 보드가 1인 경우 위치 변경
			if (nx1 == 10 || ny1 == 10 || nx1 < 0 || ny1 < 0 || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4;
				flag1 = false; // 위치가 변했음 표시
			}
			if (nx2 == 10 || ny2 == 10 || nx2 < 0 || ny2 < 0 || board[nx2][ny2] == 1) {
				d2 = (d2 + 1) % 4;
				flag2 = false; // 위치가 변했음 표시
			}
			if (flag1 == true) { // 위치가 안변했으면
				// 다음 자리로 변경
				x1 = nx1;
				y1 = ny1;
			}
			if (flag2 == true) { // 위치가 안변했으면
				// 다음 자리로 변경
				x2 = nx2;
				y2 = ny2;
			}

			// 현수와 강아지가 만나는 경우
			if (x1 == x2 && y1 == y2) {
				break;
			}
		}
		if (count >= 1000) {
			return 0;
		}
		return count;
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		int[][] arr1 = { { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 } };
		System.out.println(T.solution(arr1));
		int[][] arr2 = { { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 2, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 3 } };
		System.out.println(T.solution(arr2));
	}
}

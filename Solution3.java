package Main;

import java.util.*;

class Solution3 {
	public int solution(int[][] board) {
		int answer = 0;

		// ������ ������ ��ġ�� ã�� ���� ���� ���� �� �ʱ�ȭ
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		// ������ ������ ���� ��ġ ã��
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

		// ����Ű index ����
		int d1 = 0;
		int d2 = 0;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int count = 0;

		// 1000�� ��ŭ ����
		while (count < 1000) {

			// �̵��� ������ count ����
			count++;

			// ���� ĭ���� �̵��� x,y ���ο� ���� ����
			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];

			// ��ġ�� ���ߴ��� �Ⱥ��ߴ��� Ȯ���ϴ� flag
			boolean flag1 = true;
			boolean flag2 = true;

			// ������ ���̸� ����ų�, ���尡 1�� ��� ��ġ ����
			if (nx1 == 10 || ny1 == 10 || nx1 < 0 || ny1 < 0 || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4;
				flag1 = false; // ��ġ�� ������ ǥ��
			}
			if (nx2 == 10 || ny2 == 10 || nx2 < 0 || ny2 < 0 || board[nx2][ny2] == 1) {
				d2 = (d2 + 1) % 4;
				flag2 = false; // ��ġ�� ������ ǥ��
			}
			if (flag1 == true) { // ��ġ�� �Ⱥ�������
				// ���� �ڸ��� ����
				x1 = nx1;
				y1 = ny1;
			}
			if (flag2 == true) { // ��ġ�� �Ⱥ�������
				// ���� �ڸ��� ����
				x2 = nx2;
				y2 = ny2;
			}

			// ������ �������� ������ ���
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

package Main;

import java.util.*;

class Solution4 {
	public int[] solution(int c, int r, int k) {
		int[] answer = new int[2];

		// �¼��� �迭 ����
		int[][] arr = new int[c][r];

		// k ��° ��� �ڸ� ������ {0,0} ����
		if (k > c * r) {
			answer = new int[] { 0, 0 };
			return answer;
		}

		// ���� index ���� 
		int d = 1; // �ʱ� ���� ���� 
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// ó�� �ڸ� ����
		int x = 0;
		int y = 0;
		// ������ �ڸ� �� ���� 
		int count = 1;

		// count = k �� �������� ���� ����
		while (count < k) {
			
			// �������� �̵��� �ڸ�
			int nx = x + dx[d];
			int ny = y + dy[d];

			// �������� �̵��� �ڸ��� �¼� ������ ����ų� �̹� ������ �ڸ��� ���
			if (nx < 0 || ny < 0 || nx >= c || ny >= r || arr[nx][ny] > 0) {
				d = (d + 1) % 4; // ���� ��ȯ
				continue; // ���� ����
			}
			
			arr[x][y] = count; // ���� �ڸ��� ������ �ڸ� �� count ����
			count++; // ������ �ڸ� �� ����

			x = nx; // ���� �¼� ���� �̵�
			y = ny; // ���� �¼����� �̵�
		}
		
		// �¼��� (1,1)���� �����ϱ� ������ +1 
		answer[0] = x + 1;
		answer[1] = y + 1;
		return answer;
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
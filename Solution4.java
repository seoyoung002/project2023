package Main;

import java.util.*;

class Solution4 {
	public int[] solution(int c, int r, int k) {
		int[] answer = new int[2];

		// 좌석도 배열 정의
		int[][] arr = new int[c][r];

		// k 번째 사람 자리 없으면 {0,0} 리턴
		if (k > c * r) {
			answer = new int[] { 0, 0 };
			return answer;
		}

		// 방향 index 설정 
		int d = 1; // 초기 방향 설정 
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// 처음 자리 설정
		int x = 0;
		int y = 0;
		// 배정된 자리 수 정의 
		int count = 1;

		// count = k 와 같아지면 루프 종료
		while (count < k) {
			
			// 다음으로 이동할 자리
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 다음으로 이동할 자리가 좌석 범위를 벗어나거나 이미 배정된 자리인 경우
			if (nx < 0 || ny < 0 || nx >= c || ny >= r || arr[nx][ny] > 0) {
				d = (d + 1) % 4; // 방향 전환
				continue; // 다음 루프
			}
			
			arr[x][y] = count; // 현재 자리에 배정된 자리 수 count 대입
			count++; // 배정된 자리 수 증가

			x = nx; // 다음 좌석 으로 이동
			y = ny; // 다음 좌석으로 이동
		}
		
		// 좌석이 (1,1)부터 시작하기 때문에 +1 
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
package Main;

import java.util.*;

class Solution5 {
	public int solution(int[] nums) {
		int answer = 0;
		
		// peak 구해서 arraylist에 넣기
		ArrayList<Integer> peak = new ArrayList<Integer>();

		// peak 숫자 구하기
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1] && nums[i - 1] < nums[i]) {
				peak.add(i);
			}
		}
		//System.out.println(peak);

		// peak 리스트 크기 만큼 루프
		for (int i = 0; i < peak.size(); i++) {
			// peak 의 배열 index 넣기
			int left = peak.get(i);
			int right = peak.get(i);
			int count = 1; 

			// peak index를 기준으로 왼쪽을 탐색하면서 연속된 수 셈
			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
				left--;
				count++;
			}
			// peak index를 기준으로 오른쪽 탐색하면서 연속된 수 셈
			while (right + 1 < nums.length && nums[right] > nums[right + 1]) {
				right++;
				count++;
			}
			// 현재 peak 기준 count 중 제일 큰 count 선택
			answer = Math.max(answer, count);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
	}
}
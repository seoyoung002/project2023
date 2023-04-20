package Main;

import java.util.*;

class Solution5 {
	public int solution(int[] nums) {
		int answer = 0;
		
		// peak ���ؼ� arraylist�� �ֱ�
		ArrayList<Integer> peak = new ArrayList<Integer>();

		// peak ���� ���ϱ�
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1] && nums[i - 1] < nums[i]) {
				peak.add(i);
			}
		}
		//System.out.println(peak);

		// peak ����Ʈ ũ�� ��ŭ ����
		for (int i = 0; i < peak.size(); i++) {
			// peak �� �迭 index �ֱ�
			int left = peak.get(i);
			int right = peak.get(i);
			int count = 1; 

			// peak index�� �������� ������ Ž���ϸ鼭 ���ӵ� �� ��
			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
				left--;
				count++;
			}
			// peak index�� �������� ������ Ž���ϸ鼭 ���ӵ� �� ��
			while (right + 1 < nums.length && nums[right] > nums[right + 1]) {
				right++;
				count++;
			}
			// ���� peak ���� count �� ���� ū count ����
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
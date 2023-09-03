package onboarding;

import java.util.List;

public class Problem1 {

    public static int find_max_between_plus_and_multi(int num) {
        int units = 0;
        int plus_sum = 0;
        int multi_sum = 1;
        while (num != 0) {
            units = num % 10;
            plus_sum += units;
            multi_sum *= units;
            num = num / 10;
        }
        return Math.max(plus_sum, multi_sum);
    }

    public static int find_max_between_left_and_right(int[] pages) {
        int left_sum = find_max_between_plus_and_multi(pages[0]);
        int right_sum = find_max_between_plus_and_multi(pages[1]);
        return Math.max(left_sum, right_sum);
    }

    public static boolean is_invalid_page(int[] pages) {
        int left_page = pages[0];
        int right_page = pages[1];
        if (pages.length != 2) {
            return true;
        }
        if (left_page % 2 != 1) {
            return true;
        }
        if (right_page > 400) {
            return true;
        }
        return false;
    }


    public static int find_who_win(int pobi_num, int crong_num) {
        if (pobi_num < crong_num) {
            return 1;
        }
        if (pobi_num > crong_num) {
            return 2;
        }
        return 0;
    }

    public static int solution(int[] pobi, int[] crong) {
        int result = 0;
        if (is_invalid_page(pobi) || is_invalid_page(crong)) {
            return -1;
        }
        try {
            int pobi_max = find_max_between_left_and_right(pobi);
            int crong_max = find_max_between_left_and_right(crong);
            result = find_who_win(pobi_max, crong_max);
        } catch (Exception e) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11, 12}, new int[]{13, 14}));
    }
}
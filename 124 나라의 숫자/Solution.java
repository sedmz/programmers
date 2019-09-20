// 너무 더티코드라 마음이 아프다

class Solution {
    public String solution(int n) {
        String number = "";

        int idx = 0;
        while (n > 0) {
            number = n % 3 + number;
            n /= 3;
        }

        StringBuilder str = new StringBuilder(number);
        boolean b = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0' && b == false && i != 0) {
                str.setCharAt(i, '4');
                b = true;
            } else if (str.charAt(i) == '0' && b == true) {
                str.setCharAt(i, '2');
            } else if (str.charAt(i) != '0' && b == true) {
                switch (str.charAt(i)) {
                case '1':
                    str.setCharAt(i, '0');
                    i++;
                    break;
                case '2':
                    str.setCharAt(i, '1');
                    break;
                case '4':
                    str.setCharAt(i, '2');
                    break;
                }
                b = false;
            }

        }

        return str.toString().replaceAll("0", "");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 1; i <= 100; i++) {
            System.out.println(sol.solution(i));
        }
    }
}

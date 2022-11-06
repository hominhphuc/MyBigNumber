package add2num;

import java.util.Scanner;

public class MyBigNumber {
	public static void main(String[] args) {

		System.out.println("Nhập chuỗi số thứ  nhất: ");
		String s1 = new Scanner(System.in).nextLine();

		System.out.println("Nhập chuỗi số thứ  hai: ");
		String s2 = new Scanner(System.in).nextLine();

		sum(s1, s2);
	}

	public static String sum(String s1, String s2) {
		String temp = "";
		if (s1.length() < s2.length()) {
			temp = s1;
			s1 = s2;
			s2 = temp;
		}
		String sum = "";
		int asyncStep = s1.length() - s2.length();
		String pow = "";
		int soNho = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.length() - 1 - i - asyncStep < 0) {
				System.out.println(" Bước " + (i + 1) + " Ta cộng 2 số: " + s1.charAt(s1.length() - 1 - i) + " và " + "0"
						+ " ra kết quả: " + Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i))) % 10 + " nhớ: "
						+ soNho);

				String subSum = String
						.valueOf(((Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i)))) % 10 + soNho) == 10
								? 0
								: ((Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i)))) % 10 + soNho))
						.concat(pow);
				sum = subSum.substring(0, subSum.length() - i).concat(sum);
				soNho = ((Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i))) + soNho) >= 10) ? 1 : 0;
				System.out.println("Tổng tạm thời là: " + sum);
			} else {
				System.out.println(" Bước " + (i + 1) + " Ta cộng 2 số: " + s1.charAt(s1.length() - 1 - i) + " và "
						+ s2.charAt(s1.length() - 1 - i - asyncStep) + " ra kết quả: "
						+ (Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i)))
								+ Integer.valueOf(String.valueOf(s2.charAt(s1.length() - 1 - i - asyncStep)))) % 10
						+ " nhớ: " + soNho);

				String subSum = String.valueOf(((Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i)))
						+ Integer.valueOf(String.valueOf(s2.charAt(s1.length() - 1 - i - asyncStep)))) % 10
						+ soNho) == 10
								? 0
								: ((Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i)))
										+ Integer.valueOf(String.valueOf(s2.charAt(s1.length() - 1 - i - asyncStep))))
										% 10 + soNho))
						.concat(pow);
				sum = subSum.substring(0, subSum.length() - i).concat(sum);
				soNho = ((Integer.valueOf(String.valueOf(s1.charAt(s1.length() - 1 - i)))
						+ Integer.valueOf(String.valueOf(s2.charAt(s1.length() - 1 - i - asyncStep))) + soNho) >= 10)
								? 1
								: 0;
				System.out.println("Tổng tạm thời là: " + sum);
			}

			pow = pow.concat("0");
			if (i == (s1.length() - 1)) {
				if (soNho == 1) {
					sum = "1".concat(sum);
				}
				System.out.println("Tổng cuối cùng của 2 số là " + sum);
			}

		}

		return sum;
	}

}

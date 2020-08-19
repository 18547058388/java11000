package git;

import java.util.Scanner;

import org.junit.Test;

public class MyNot {
	// 14输入三个整数x,y,z，请把这三个数由小到大输出。
		@Test
		public void work14() {
			System.out.println("请输入三个数");
			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (x > y && y > z && y < x) {
				System.out.println(z);
				System.out.println(y);
				System.out.println(x);

			} else if (y > x && y > z && y > x) {
				System.out.println(z);
				System.out.println(x);
				System.out.println(y);
			} else if (x < y && x < z && y < z) {
				System.out.println(x);
				System.out.println(y);
				System.out.println(z);

			} else if (x > z && x > y && y > z) {
				System.out.println(x);
				System.out.println(z);
				System.out.println(y);

			} else if (y > z && y > x && x > z) {
				System.out.println(y);
				System.out.println(z);
				System.out.println(x);

			} else if (y > z && y > x && z > x) {
				System.out.println(y);
				System.out.println(x);
				System.out.println(z);

			}

		}
}

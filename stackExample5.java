/*
 * stackExample5.java
 * using stack to validate input parentheses, whether matching
 */

import java.util.*;

public class stackExample9 {
	public static boolean analyze(String s) {
		Deque<Character> ourStack = new ArrayDeque<>();

		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if(c == '(') {
				ourStack.addFirst(c);
			}
			else {
				if(ourStack.size() == 0)
					return false;
				else
					if(c == ')') {
						ourStack.removeFirst();
					}

				else continue;

}
		}

		if(ourStack.size() == 0)
			return true;
		else
			return false;
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a line of parentheses: ");

		String s = input.nextLine();
		boolean ret = analyze(s);

		if(ret)
			System.out.println("matching");
		else
			System.out.println("not matching");
	}
}

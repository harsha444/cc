package google.hashmap;

import java.util.*;

public class JewelsAndStones {
	public static int numJewelsInStones(String jewels, String stones) {
		Set<Character> s = new HashSet<>();
		for(char ch: stones.toCharArray()) {
			s.add(ch);
		}
		int response = 0;
		for(char ch: jewels.toCharArray()) {
			if (s.contains(ch)) {
				response += 1;
			}
		}
		return response;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String jewels = sc.nextLine();
		String stones = sc.nextLine();
		System.out.println(numJewelsInStones(jewels, stones));
	}
}
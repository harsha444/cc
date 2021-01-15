package google.hashmap;

import java.util.*;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> response = new ArrayList<>();
		Map<String, List<String>> m = new HashMap<>();
		for(String str: strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sorted = String.valueOf(chars);
			if(!m.containsKey(sorted)) {
				m.put(sorted, new ArrayList<>());
			}
			m.get(sorted).add(str);
		}
		for(Map.Entry<String, List<String>> i: m.entrySet()) {
			response.add(i.getValue());
		}
		return response;
	}

	public static List<List<String>> groupAnagramsUsingDelimiter(String[] strs) {
		List<List<String>> response = new ArrayList<>();
		Map<String, List<String>> m = new HashMap<>();
		int[] arr = new int[26];
		for(String str: strs) {
			StringBuilder key = new StringBuilder();
			Arrays.fill(arr, 0);
			char[] charArr = str.toCharArray();
			for(char ch: charArr) {
				arr[ch-'a'] += 1;
			}

			for(int i=0; i<26; i++) {
				key.append("#");
				key.append(arr[i]);
			}
			m.putIfAbsent(key.toString(), new ArrayList<>());
			m.get(key.toString()).add(str);
		}
		for(Map.Entry<String, List<String>> i: m.entrySet()) {
			response.add(i.getValue());
		}
		return response;
	}

	public static void main(String[] args) {
		List<List<String>> response = groupAnagramsUsingDelimiter(new String[]{"eat","tea","tan","ate","nat","bat"});
		for(List<String> ls: response) {
			for(String s: ls) {
				System.out.print(s);
			}
			System.out.println();
		}
	}
}
package google.graphs;

import java.util.*;

class UF {
	int[] parent;
	int[] w;
	public UF(int n) {
		parent = new int[n];
		w = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i;
			w[i] =1;
		}
	}

	public int root(int i) {
		while(i!=parent[i]) {
			i = parent[parent[i]];
		}
		return i;
	}

	public void union(int a, int b) {
		int rootA = root(a);
		int rootB = root(b);
		if(w[rootA]>w[rootB]) {
			parent[rootB] = parent[rootA];
			w[rootA] += w[rootB];
		} else {
			parent[rootA] = parent[rootB];
			w[rootB] += w[rootA];
		}
	}

	public boolean find(int a, int b) {
		return root(a) == root(b);
	}
}

public class SentenceSimilarity {
	
	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
		if(words1.length != words2.length) {
			return false;
		}

		HashMap<String, Integer> m = new HashMap<>();
		int index = 0;
		UF uf = new UF(pairs.size() * 2);
		for(List<String> ls: pairs) {
			m.putIfAbsent(ls.get(0), index++);
			m.putIfAbsent(ls.get(1), index++);
			uf.union(m.get(ls.get(0)), m.get(ls.get(1)));
		}

		for(int i=0; i<words1.length; i++) {
			if(words1[i].equals(words2[i])) {
				continue;
			}
			int numberMapped1 = m.getOrDefault(words1[i], -1);
			int numberMapped2 = m.getOrDefault(words2[i], -1);
			if(numberMapped1==-1 || numberMapped2==-1 || !uf.find(numberMapped1, numberMapped2)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		List<List<String>> pairs = Arrays.asList(Arrays.asList("great", "good"), Arrays.asList("fine", "good"),
			Arrays.asList("acting","drama"), Arrays.asList("skills","talent"));
		System.out.println(areSentencesSimilarTwo(words1, words2, pairs));
	}
}
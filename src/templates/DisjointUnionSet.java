package templates;

public class DisjointUnionSet {
    int[] set;

    int[] rank;

    int size;

    public DisjointUnionSet(int n) {
        size = n;
        set = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int num) {
        // finds the parent of the component
        while (num != set[num]) {
            num = set[set[num]];
        }
        return num;
    }

    public void union(int num1, int num2) {
        // sets the parent of num1 to num2's parent or viceversa based on rank
        int parentNum1 = find(num1);
        int parentNum2 = find(num2);
        if (parentNum1 != parentNum2) {
            if (rank[parentNum1] > rank[parentNum2]) {
                set[parentNum2] = parentNum1;
            } else if (rank[parentNum1] < rank[parentNum2]) {
                set[parentNum1] = parentNum2;
            } else {
                set[parentNum1] = parentNum2;
                rank[parentNum2] += 1;
            }
        }
    }

    public boolean connected(int num1, int num2) {
        return find(num1) == find(num2);
    }
}

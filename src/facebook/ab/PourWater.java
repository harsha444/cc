package facebook.ab;

public class PourWater {
    public int[] pourWater(int[] heights, int volume, int k) {
        for (int i = 0; i < volume; i++) {
            int curr = k;
            while (curr > 0 && heights[curr] >= heights[curr - 1]) {
                curr--;
            }
            while (curr < heights.length - 1 && heights[curr] >= heights[curr + 1]) {
                curr++;
            }
            while (curr > k && heights[curr] == heights[curr - 1]) {
                curr -= 1;
            }
            heights[curr]+=1;
        }
        return heights;
    }

    public static void main(String[] args) {

    }
}

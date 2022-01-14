//package facebook.ab.two;
//
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Set;
//
//public class SlidingPuzzle {
//    public int slidingPuzzle(int[][] board) {
//        String target = "123450";
//        String start = "";
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                start += board[i][j];
//            }
//        }
//        // keep visited set of strings
//        Set<String> seen = new HashSet<>();
//        //possible directions
//        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
//        // queue for pushing and going in a bfs way
//        Queue<String> queue = new LinkedList<>();
//        queue.add(start);
//        int res = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String curr = queue.poll();
//                if (curr.equals(target)) {
//                    return res;
//                }
//                int zero = curr.indexOf('0');
//                for (int dir : dirs[zero]) {
//                    String next = swap(curr, zero, dir);
//                    if(seen.contains(next)) {
//                        continue;
//                    }
//                    seen.add(next);
//                    queue.offer(next);
//                }
//            }
//            res++;
//        }
//    }
//}

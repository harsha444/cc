// package cses.searchingnsorting;
//
//import java.io.*;
//import java.util.*;
//
//public class ConcertTickets {
//	static class InputReader {
//        BufferedReader reader;
//        StringTokenizer tokenizer;
//        public InputReader(InputStream stream) {
//            reader = new BufferedReader(new InputStreamReader(stream), 32768);
//            tokenizer = null;
//        }
//        String next() { // reads in the next string
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return tokenizer.nextToken();
//        }
//        public int nextInt() { return Integer.parseInt(next()); } // reads in the next int
//        public long nextLong() { return Long.parseLong(next()); } // reads in the next long
//        public double nextDouble() { return Double.parseDouble(next()); } // reads in the next double
//    }
//
//    static InputReader f= new InputReader(System.in);
//    static PrintWriter out= new PrintWriter(System.out);
//	public static void main(String[] args) {
//		int n,m;
//		int[] h = new int[(int)2e5];
//		int[] t = new int[(long)10e9];
//		for(int i=0; i<n; i++) {
//			h[i] = f.nextInt();
//		}
//		for(int i=0; i<n; i++) {
//			t[i] = f.nextInt();
//		}
//		Arrays.sort(h, 0, n);
//		for(int i=0,j=0; i<n,j<m; i++) {
//			if(h[i]>0 && )
//		}
//	}
//}
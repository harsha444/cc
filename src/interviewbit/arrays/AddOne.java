package interviewbit.arrays;

import java.util.ArrayList;

public class AddOne {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        Integer step = 1;
        int sz = A.size();
        for (int i = sz - 1; i >= 0; i--) {
            A.set(i, A.get(i) + step);
            step = 0;
            if (A.get(i) > 9) {
                A.set(i, 0);
                step = 1;
            }
        }
        if (step == 1) {
            A.add(0, 1);
        }
        int nFirstZeroes = 0;
        for(int i=0; i<sz+1; i++) {
            if(A.get(i) == 0) {
                nFirstZeroes+=1;
            } else {
                break;
            }
        }
        return new ArrayList<Integer>(A.subList(nFirstZeroes, sz));
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(9);
        input.add(9);
        input.add(9);
        input.add(9);
        input.add(9);
        ArrayList<Integer> response = plusOne(input);
        System.out.println(response);
    }
}

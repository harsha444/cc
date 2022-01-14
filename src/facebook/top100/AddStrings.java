package facebook.top100;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder response = new StringBuilder();
        int carry = 0;
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        while (num1Len >= 0 || num2Len >= 0) {
            int num1CurrChar = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
            int num2CurrChar = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;
            int sum = num1CurrChar + num2CurrChar + carry;
            carry = sum / 10;
            sum = sum % 10;
            response.append(sum);
            num1Len -= 1;
            num2Len -= 1;
        }
        if (carry != 0) {
            response.append(carry);
        }
        return response.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "45"));
    }
}

/*
* FB questions from posts - clone graph, subarray sum=k, running avg, LCA, pointer 3 - merge sorted arrays
* All FB questions - frequent
* LRU cache, Alien Dict, Island formed, trapping rain water, wordBreakII, backtracking ques
* Top FB questions
* */
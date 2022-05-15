package google2022;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal(1.2);
        BigDecimal y = new BigDecimal(1.20);
        BigDecimal z = null;
        System.out.println(Objects.equals(z, x));
    }
}

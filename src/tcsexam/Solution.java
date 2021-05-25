package tcsexam;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

class Auditorium {
    private int audiId;

    private String audiName;

    private int audiCapacity;

    private int audiRating;

    private String audiType;

    public Auditorium() {
    }

    public Auditorium(int audiId, String audiName, int audiCapacity, int audiRating, String audiType) {
        this.audiId = audiId;
        this.audiName = audiName;
        this.audiCapacity = audiCapacity;
        this.audiRating = audiRating;
        this.audiType = audiType;
    }

    public int getAudiId() {
        return audiId;
    }

    public void setAudiId(int audiId) {
        this.audiId = audiId;
    }

    public String getAudiName() {
        return audiName;
    }

    public void setAudiName(String audiName) {
        this.audiName = audiName;
    }

    public int getAudiCapacity() {
        return audiCapacity;
    }

    public void setAudiCapacity(int audiCapacity) {
        this.audiCapacity = audiCapacity;
    }

    public int getAudiRating() {
        return audiRating;
    }

    public void setAudiRating(int audiRating) {
        this.audiRating = audiRating;
    }

    public String getAudiType() {
        return audiType;
    }

    public void setAudiType(String audiType) {
        this.audiType = audiType;
    }
}

public class Solution {
    private static Auditorium[] auditoriums = new Auditorium[4];

    private static void getAudiCapacity(Auditorium[] auditoriums, int x) {
        Auditorium auditorium = Arrays.stream(auditoriums).sequential().filter(a -> a.getAudiId() == x).findFirst().orElse(null);
        if (Objects.isNull(auditorium) || auditorium.getAudiCapacity() <= 0) {
            System.out.println("Incorrect Auditorium id");
        } else {
            System.out.println(auditorium.getAudiCapacity());
        }
    }

    private static void getSecondHighestAudiRating(Auditorium[] auditoriums, String s) {
        List<Auditorium> filteredAuditoriums = Arrays.stream(auditoriums).filter(a -> a.getAudiType().equalsIgnoreCase(s)).sorted()
                                                     .collect(Collectors.toList());
        if (filteredAuditoriums.size() < 2) {
            System.out.println("Incorrect Auditorium Type");
        } else {
            System.out.println(filteredAuditoriums.get(1).getAudiId());
            System.out.println(filteredAuditoriums.get(1).getAudiRating());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            int audiId = sc.nextInt();
            String audiName = sc.nextLine();
            int audiCapacity = sc.nextInt();
            int audiRating = sc.nextInt();
            String audiType = sc.nextLine();
            Auditorium auditorium = new Auditorium(audiId, audiName, audiCapacity, audiRating, audiType);
            auditoriums[i] = auditorium;
        }
        int queryId = sc.nextInt();
        String queryType = sc.nextLine();
        getAudiCapacity(auditoriums, queryId);
        getSecondHighestAudiRating(auditoriums, queryType);

    }
}

package facebook.ab.two;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestCommonRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parentalMap = new HashMap<>();
        for (List<String> regionList : regions) {
            for (int i = 1; i < regionList.size(); i++) {
                parentalMap.put(regionList.get(i), regionList.get(0));
            }
        }
        String tempRegion1 = region1;
        String tempRegion2 = region2;
        while (!tempRegion1.equals(tempRegion2)) {
            tempRegion1 = parentalMap.getOrDefault(region1, region2);
            tempRegion2 = parentalMap.getOrDefault(region2, region1);
        }
        return tempRegion1;
    }
}

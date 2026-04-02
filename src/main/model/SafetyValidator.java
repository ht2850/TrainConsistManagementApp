package model;

import java.util.List;

public class SafetyValidator {

    // UC12: Safety validation
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        for (GoodsBogie b : bogies) {
            if ("Cylindrical".equals(b.getType()) && !"Petroleum".equals(b.getCargo())) {
                return false;
            }
        }
        return true;
    }
}
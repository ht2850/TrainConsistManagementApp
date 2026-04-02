package java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainValidationTest {

    @Test
    void testValidTrainID() {
        assertTrue("TRN-1234".matches("TRN-\\d{4}"));
    }

    @Test
    void testInvalidTrainID() {
        assertFalse("TRAIN12".matches("TRN-\\d{4}"));
    }

    @Test
    void testValidCargoCode() {
        assertTrue("PET-AB".matches("PET-[A-Z]{2}"));
    }

    @Test
    void testInvalidCargoCode() {
        assertFalse("PET-ab".matches("PET-[A-Z]{2}"));
    }
}
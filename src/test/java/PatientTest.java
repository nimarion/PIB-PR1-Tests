import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PatientTest {

    public static class PatientConstructorTest {

        @Test
        public void testPatient() {
            Patient patient = new Patient(3333, "Niklas, Marion");
            assertEquals(3333, patient.getNumber());
            assertEquals("Niklas, Marion", patient.getName());
        }

        @Test
        public void testPatientWrongNumber() {
            Assertions.assertThrows(Throwable.class, () -> {
                new Patient(10001, "Niklas, Marion");
            });
            Assertions.assertDoesNotThrow(() -> {
                new Patient(9999, "Niklas, Marion");
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Patient(999, "Niklas, Marion");
            });
        }

        @Test
        public void testPatientWrongName() {
            Patient patient = new Patient(3333, "Niklas, Marion");
            Assertions.assertThrows(Throwable.class, () -> {
                new Patient(3333, "Niklas");
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Patient(3333, null);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Patient(3333, "");
            });
            Assertions.assertThrows(Throwable.class, () -> {
               patient.setName("");
            }); 
            Assertions.assertThrows(Throwable.class, () -> {
                patient.setName(null);
             });     
             Assertions.assertThrows(Throwable.class, () -> {
                patient.setName("Niklas");
             });   
        }

    }
}

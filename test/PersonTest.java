import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p1;

    @BeforeEach
    void setUp() {
        p1 = new Person("Roger", "Uncle", "000005", "Mr.", 1999);
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Vinay");
        assertEquals("Vinay", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Thamara");
        assertEquals("Thamara", p1.getLastName());
    }

    @Test
    void setID() {
        p1.setID("000006");
        assertEquals("000006", p1.getID());
    }

    @Test
    void setTitle() {
        p1.setTitle("Sir.");
        assertEquals("Sir.", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(1234);
        assertEquals(1234, p1.getYOB());
    }
}
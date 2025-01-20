package groupId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoworkingSpaceTest {

    @Test
    void givenExistingSpace_whenRemoveSpaceIsCalled_thenReturnFalse() {
        CoworkingSpace testSpace = new CoworkingSpace("Test Space", 200, true);
        int coworkingspace_id = CoworkingSpaceDAO.findIdByType("Test Space");
        assertFalse(testSpace.existById(coworkingspace_id));
    }
}

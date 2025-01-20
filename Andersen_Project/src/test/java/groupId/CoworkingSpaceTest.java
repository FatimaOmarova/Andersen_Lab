package groupId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoworkingSpaceTest {

    @Test
    void givenExistingSpace_whenRemoveSpaceIsCalled_thenReturnFalse() {
        CoworkingSpace testSpace = new CoworkingSpace("8,Test Space,200,true");
        CoworkingSpace.removeSpace(8);
        assertFalse(Main.spaces.stream().anyMatch(space -> space.getId() == 8));
    }


}

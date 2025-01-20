package groupId;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationTest {
    @Test
    public void getReservationTest() {
        Reservation mockReservation = mock(Reservation.class);

        when(mockReservation.getReservationId()).thenReturn(12);
        when(mockReservation.getSpaceId()).thenReturn(3);

        assertEquals(12, mockReservation.getReservationId());
        assertEquals(3, mockReservation.getSpaceId());

        verify(mockReservation).getReservationId();
        verify(mockReservation).getSpaceId();
    }
    @Test
    public void testReservation() {
        Main.reservations.clear();
        CoworkingSpace testSpace = new CoworkingSpace("8,Test Space,200,true");
        Main.customerList.put(101, new Customer(101, "Test Customer", "password"));

        assertTrue(Reservation.isValidRequest(8, 101));

        assertTrue(Reservation.makeReservation(1, 8, 101, 20221215, 5, 12));
        assertEquals(1, Main.reservations.size());
    }

}

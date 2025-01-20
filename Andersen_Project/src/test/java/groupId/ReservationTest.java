package groupId;

import org.junit.jupiter.api.Test;

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
    public void givenValidInput_whenMakeReservationIsCalled_thenReturnTrue() {
        CoworkingSpaceDAO.addCoworkingSpace("Test Space", 200, true);
        CustomerDAO.addCustomer("Test Customer", "password");

        int coworkingspace_id = CoworkingSpaceDAO.findIdByType("Test Space");
        int customer_id = CustomerDAO.findIdByUsername("Test Customer");

        int value_before = ReservationDAO.getAllReservation().size();

        Reservation.makeReservation(customer_id, coworkingspace_id, "2022-12-15", "5", "12");

        int value_after = ReservationDAO.getAllReservation().size();
        assertEquals(value_before + 1, value_after);
    }

}

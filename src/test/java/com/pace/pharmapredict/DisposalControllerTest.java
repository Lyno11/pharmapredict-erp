package com.pace.pharmapredict;

import com.pace.pharmapredict.controller.DisposalController;
import com.pace.pharmapredict.model.Disposal;
import com.pace.pharmapredict.model.Medication;
import com.pace.pharmapredict.repository.DisposalRepository;
import com.pace.pharmapredict.repository.MedicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DisposalControllerTest {

    @Mock
    private MedicationRepository medicationRepository;

    @Mock
    private DisposalRepository disposalRepository;

    @InjectMocks
    private DisposalController disposalController;

    @Test
    public void testSuccessfulDisposal() {
        // 1. SETUP: Create a fake medication with 100 pills
        Medication fakeMed = new Medication();
        fakeMed.setNdcCode(12345L);
        fakeMed.setQuantityAvailable(100);

        // Tell the mock database: "When someone asks for ID 12345, return this fake object"
        when(medicationRepository.findById(12345L)).thenReturn(Optional.of(fakeMed));

        // 2. ACTION: Try to dispose 20 pills
        Disposal request = new Disposal();
        request.setMedicationId(12345L);
        request.setQuantity(20);

        ResponseEntity<String> response = disposalController.recordDisposal(request);

        // 3. ASSERT: Check the results
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Did we get a 200 OK?
        assertEquals(80, fakeMed.getQuantityAvailable()); // Did 100 - 20 become 80?
    }

    @Test
    public void testInsufficientStock() {
        // 1. SETUP: Create a fake medication with only 10 pills
        Medication fakeMed = new Medication();
        fakeMed.setNdcCode(12345L);
        fakeMed.setQuantityAvailable(10);

        when(medicationRepository.findById(12345L)).thenReturn(Optional.of(fakeMed));

        // 2. ACTION: Try to dispose 50 pills (Too many!)
        Disposal request = new Disposal();
        request.setMedicationId(12345L);
        request.setQuantity(50);

        ResponseEntity<String> response = disposalController.recordDisposal(request);

        // 3. ASSERT: Should be a generic BAD REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        // Ensure the stock is STILL 10 (Math shouldn't happen on error)
        assertEquals(10, fakeMed.getQuantityAvailable());
    }
}
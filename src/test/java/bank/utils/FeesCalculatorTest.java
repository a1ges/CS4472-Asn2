package bank.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Use of Parameterized helps in this case, since multiple runs of same test are required

class DepositTest {
    FeesCalculator calculator = new FeesCalculator();

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    // Deposit White-Box Tests
    // Each of test cases represent the pre-joined outtermost leaves in a DU path
	// Outlined in document``
    @Test
    void testDeposit() {
			//student block
            assertEquals(0.255, calculator.calculateDepositInterest(51, 501, true));
            assertEquals(0.1275, calculator.calculateDepositInterest(51, 500, true));
            assertEquals(0.255, calculator.calculateDepositInterest(50, 5001, true));
            // No interest in this case.
			assertEquals(0, calculator.calculateDepositInterest(50, 4999, true));
			// not student block
            assertEquals(2.008, calculator.calculateDepositInterest(251, 2501, false));
            assertEquals(1.004, calculator.calculateDepositInterest(251, 2500, false));
            assertEquals(0, calculator.calculateDepositInterest(250, 10001, false));
            assertEquals(.25, calculator.calculateDepositInterest(250, 10000, false));

        }   
    
    
}

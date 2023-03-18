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
			// 51*0.005
            assertEquals(0.255, calculator.calculateDepositInterest(51, 501, true));
			//  51 * .0025 (0.25%)
			assertEquals(0.1275, calculator.calculateDepositInterest(51, 499, true));
            // 49 * 0.005
			assertEquals(0.245, calculator.calculateDepositInterest(49, 5001, true));
            // No interest in this case.
			assertEquals(0, calculator.calculateDepositInterest(49, 4999, true));
			// not student block
			// 0.008 * 251
            assertEquals(2.008, calculator.calculateDepositInterest(251, 2501, false));
           // 0.004 * 251
			assertEquals(1.004, calculator.calculateDepositInterest(251, 2499, false));
            // 0
			assertEquals(0, calculator.calculateDepositInterest(249, 10001, false));
            
			// 0.005* 249
			assertEquals(1.245, calculator.calculateDepositInterest(249, 10000, false));

        }   
    
    
}

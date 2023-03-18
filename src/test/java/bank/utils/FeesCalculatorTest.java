package bank.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

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
			// bound check
			assertEquals(.25, calculator.calculateDepositInterest(50, 5001, true));

			assertEquals(0, calculator.calculateDepositInterest(49, 4999, true));
			// not student block
			// 0.008 * 251			

            assertEquals(2.008, calculator.calculateDepositInterest(251, 2501, false));
           // 0.004 * 251
			assertEquals(1.004, calculator.calculateDepositInterest(251, 2499, false));
            // 0
			assertEquals(1.25, calculator.calculateDepositInterest(250, 10001, false));
            
			// 0.005* 249
			assertEquals(0, calculator.calculateDepositInterest(249, 10000, false));
			assertEquals(0, calculator.calculateDepositInterest(249, 9999, false));


        }   
    
    
}

class WithdrawalTest {
    FeesCalculator calculator;

    @BeforeEach
    void setUp() throws Exception {
    	calculator = new FeesCalculator();
    }

    @AfterEach
    void tearDown() throws Exception {
    	System.out.println("End of Withdrawal Test");
    }

    @Test
    void test() {
    	assertEquals(0.001, calculator.calculateWithdrawalFee(500, 1000, true, Calendar.SATURDAY)); // 1
    	assertEquals(0.001, calculator.calculateWithdrawalFee(500, 1000, true, Calendar.SUNDAY)); // 2
    	assertEquals(0.0, calculator.calculateWithdrawalFee(100, 500, true, Calendar.MONDAY)); // 3
    	assertEquals(0.003, calculator.calculateWithdrawalFee(120, 850, false, Calendar.SUNDAY)); // 4
    	assertEquals(0.003, calculator.calculateWithdrawalFee(500, 900, false, Calendar.WEDNESDAY)); // 5
    	assertEquals(0.001, calculator.calculateWithdrawalFee(1000, 4000, false, Calendar.SATURDAY)); // 6
    	assertEquals(0.001, calculator.calculateWithdrawalFee(1200, 4000, false, Calendar.THURSDAY)); // 7
    	assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 6000, false, Calendar.SUNDAY)); // 8
    	assertEquals(0.0, calculator.calculateWithdrawalFee(2000, 12000, false, Calendar.TUESDAY)); // 9
    }   
    
}

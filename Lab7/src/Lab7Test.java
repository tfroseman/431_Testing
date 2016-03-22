import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import sweng431.MyComputation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Lab7.PACKAGE_NAME
 * thomasroseman on 3/1/16
 */
@RunWith(Parameterized.class)
public class Lab7Test {
    private MyComputation test_instance;
    private int value1, value2, expected_sum, expected_product;

    @Parameterized.Parameters
    public static ArrayList<TestingInput> data() {
        return new ArrayList<TestingInput>() {{
            add(new TestingInput(9,21));
            add(new TestingInput(5,6));
            add(new TestingInput(4,14));
            add(new TestingInput(3,12));
            add(new TestingInput(8,19));
            add(new TestingInput(6,14));
        }};
    }



    @Test
    public void testSum() throws Exception {
        assertEquals(expected_sum, test_instance.sum(value1, value2));
    }

    @Test
    public void testProduct() throws Exception {
        assertEquals(expected_product, test_instance.product(value1, value2));
    }

    @Before
    public void setUp() throws Exception {
        test_instance = new MyComputation();

    }

    @After
    public void tearDown() throws Exception {

    }

    public Lab7Test(TestingInput testingInput) {
        this.value1 = testingInput.getValue1();
        this.value2 = testingInput.getValue2();
        this.expected_sum = testingInput.getSum();
        this.expected_product = testingInput.getProduct();
    }
}
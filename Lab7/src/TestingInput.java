import junit.framework.Test;

/**
 * Lab7.PACKAGE_NAME
 * thomasroseman on 3/9/16
 */
public class TestingInput {
    private int value1;
    private int value2;
    private int sum;
    private int product;

    public TestingInput(int value1, int value2){
        this.value1 = value1;
        this.value2 = value2;
        this.sum = value1 + value2;
        this.product = value1*value2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getSum() {
        return sum;
    }

    public int getProduct() {
        return product;
    }
}

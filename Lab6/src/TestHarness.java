/**
 * Lab5.PACKAGE_NAME
 * thomasroseman on 2/9/16
 */
public abstract class TestHarness {

    /**
     *
     * @param actual int
     * @param expected int
     * @return Boolean if actual is equal to expected
     */
    public boolean checkEqual(int actual, int expected){
        return actual == expected;
    }

    /**
     *
     * @param actual int
     * @param expected int
     * @return Boolean if actual is greater than to expected
     */
    public boolean checkGreater(int actual, int expected){
        return actual > expected;
    }

    /**
     *
     * @param actual int
     * @param expected int
     * @return Boolean if actual is less than to expected
     */
    public boolean checkSmaller(int actual, int expected){
        return actual < expected;
    }

    /**
     *
     * @param actual double
     * @param expected double
     * @return Boolean if actual is equal to expected
     */
    public boolean checkEqual(double actual, double expected){
        return actual == expected;
    }

    /**
     *
     * @param actual double
     * @param expected double
     * @return Boolean if actual is greater than to expected
     */
    public boolean checkGreater(double actual, double expected){
        return actual > expected;
    }

    /**
     *
     * @param actual double
     * @param expected double
     * @return Boolean if actual is less than to expected
     */
    public boolean checkSmaller(double actual, double expected){
        return actual < expected;
    }

    /**
     *
     * @param actual Mycomparable
     * @param expected Mycomparable
     * @return boolean True of actual is equal to expected
     */
    public abstract boolean checkEqual(MyComparable actual, MyComparable expected);

    /**
     *
     * @param actual Mycomparable
     * @param expected Mycomparable
     * @return boolean True of actual is greater than expected
     */
    public abstract boolean checkGreater(MyComparable actual, MyComparable expected);

    /**
     *
     * @param actual Mycomparable
     * @param expected Mycomparable
     * @return boolean True of actual is less than expected
     */
    public abstract boolean checkSmaller (MyComparable actual, MyComparable expected);
}

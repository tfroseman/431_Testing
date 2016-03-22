/**
 * Lab5.PACKAGE_NAME
 * thomasroseman on 2/9/16
 */
public class BoxTestLet extends MyTestHarness {
    /**
     * @param actual   Mycomparable
     * @param expected Mycomparable
     * @return boolean True of actual is equal to expected
     */
    @Override
    public boolean checkEqual(MyComparable actual, MyComparable expected) {
        return actual.compareTo(expected) == 0;
    }

    /**
     * @param actual   Mycomparable
     * @param expected Mycomparable
     * @return boolean True of actual is greater than expected
     */
    @Override
    public boolean checkGreater(MyComparable actual, MyComparable expected) {
        return actual.compareTo(expected) == 1;
    }

    /**
     * @param actual   Mycomparable
     * @param expected Mycomparable
     * @return boolean True of actual is less than expected
     */
    @Override
    public boolean checkSmaller(MyComparable actual, MyComparable expected) {
        return actual.compareTo(expected) == -1;
    }
}

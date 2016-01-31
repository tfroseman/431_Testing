package lab2;

/**
 * Lab2.lab2
 * thomasroseman on 1/19/16
 */
public class TestingValues {
    private int pos1, pos2, actualsum;

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public void setPos2(int pos2) {
        this.pos2 = pos2;
    }

    public int getActualsum() {
        return actualsum;
    }

    public void setActualsum(int actualsum) {
        this.actualsum = actualsum;
    }

    public TestingValues(int pos1, int pos2, int actualsum) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.actualsum = actualsum;
    }

    public TestingValues(String[] values){
        this.pos1 = Integer.parseInt(values[0]);
        this.pos2 = Integer.parseInt((values[1]));
        this.actualsum = Integer.parseInt(values[2]);
    }

    @Override
    public String toString() {
        return "TestingValues{" +
                "pos1=" + pos1 +
                ", pos2=" + pos2 +
                ", actualsum=" + actualsum +
                '}';
    }
}

/**
 * Lab4.PACKAGE_NAME
 * thomasroseman on 2/8/16
 */
public class Lab4 {
    public static void main(String[] args) {
        //z = 3x^2 + y^2 + 3xy – 7x – 8y + 10
        //partial 6x+3y-7
        // x = +- 200, y = +-200
        //Max 1793.00000
        //Min -1807.00000

        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        int z;

        for (int i = -200; i <= 200; i++){
            for (int j = -200; j <= 200; j++){
                z = 6*i + 3*j - 7;
                if (z > max){
                    max = z;
                }
                if (z < min){
                    min = z;
                }
            }
        }

        System.out.printf("Max %.5f\n", max);
        System.out.printf("Min %.5f\n", min);
    }
}

/**
 * Lab5.PACKAGE_NAME
 * thomasroseman on 2/9/16
 */
public class Lab5 {
    public static void main(String[] args) {
        Box box1 = new Box(1,2,3);
        Box box2 = new Box(1,2,3);

        Product product1 = new Product(2.1);
        Product product2 = new Product(3.5);

        BoxTestLet boxTestLet = new BoxTestLet();
        ProductTestLet productTestLet = new ProductTestLet();

        System.out.println(boxTestLet.checkGreater(product1, product2));
        System.out.println(productTestLet.difference(product1, product2));
        System.out.println(productTestLet.checkEqual(box1, box2));

    }
}

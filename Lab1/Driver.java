public class Driver {
    public static void main(String Args[])
    {
        Calculator additionF = new Calculator();
        Calculator multiplicationF = new Calculator();
        System.out.printf("%.1f + %.1f = %.1f \n", 5.0, 6.0, additionF.add(5.0, 6.0));
        System.out.printf("%.1f * %.1f = %.1f", 5.0, 6.0, multiplicationF.multiply(5.0, 6.0));
    }
}
 
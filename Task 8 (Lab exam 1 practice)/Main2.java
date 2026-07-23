import java.util.Scanner;

class ShoppingCart {
    String[] itemName;
    double[] price;
    int[] qty;
    int count;
    double discount;

    ShoppingCart(int n) {
        itemName = new String[n];
        price = new double[n];
        qty = new int[n];
        count = 0;
    }

    public void addItem(String name, double p, int q) {
        itemName[count] = name;
        price[count] = p;
        qty[count] = q;
        count++;
    }

    public void applyDiscount(double percentage) {
        discount = percentage;
    }

    public double calculateTotalWithTax(double taxRate) {
        double subtotal = getSubtotal();
        double afterDiscount = subtotal - (subtotal * discount / 100);
        return afterDiscount + (afterDiscount * taxRate / 100);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < count; i++) {
            subtotal += price[i] * qty[i];
        }
        return subtotal;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of product: ");
        int n = sc.nextInt(); 

        ShoppingCart cart = new ShoppingCart(n);

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double price = sc.nextDouble();
            int qty = sc.nextInt();
            cart.addItem(name, price, qty);
        }

        System.out.print("Enter the discount amount: ");
        double discount = sc.nextDouble();
        System.out.print("Enter the taxt amount: ");
        double tax = sc.nextDouble();

        cart.applyDiscount(discount);

        System.out.println("Subtotal: " + (int) cart.getSubtotal());
        System.out.println("Total after " + (int) discount + "% discount and " + (int) tax + "% tax: " + cart.calculateTotalWithTax(tax));

        sc.close();
    }
}

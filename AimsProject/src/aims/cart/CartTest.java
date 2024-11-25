package aims.cart;

import aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Create sample DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        // Add DVDs to cart
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // Print cart
        cart.printCart();

        // Search by ID
        System.out.println("Searching for DVD with ID 2:");
        cart.searchById(2);

        System.out.println("Searching for DVD with ID 5:");
        cart.searchById(5);

        // Search by title
        System.out.println("Searching for DVDs with title 'Star':");
        cart.searchByTitle("Star");

        System.out.println("Searching for DVDs with title 'Harry Potter':");
        cart.searchByTitle("Harry Potter");
    }
}

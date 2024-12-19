
package aims;

import java.util.Scanner;

import javax.swing.JOptionPane;

import aims.cart.Cart;
import aims.exception.DuplicatedItemException;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Track;
import aims.screen.CartScreen;
import aims.screen.StoreScreen;
import aims.store.Store;
public class Aims {

    private static Scanner sc;
    private static Store store;
    private static Cart cart;
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        Media[] sampleMedia = new Media[] {
                new DigitalVideoDisc("Journey to Mars", "Sci-fi", "Liam Johnson", 140, 40.25f),
                new DigitalVideoDisc("Love in Paris", "Romance", "Anna Smith", 105, 80.50f),
                new DigitalVideoDisc("Haunted House", "Horror", "Michael Brown", 110, 55.75f),
                new CompactDisc("Echoes", "Rock", "Nina Jones", "Tom Harris", 65.40f) {{
                    addTrack(new Track("Silent Whispers", 4));
                    addTrack(new Track("Endless Road", 6));
                    addTrack(new Track("Lost in Time", 5));
                }},
                new CompactDisc("Sunrise", "Jazz", "Alice Green", "Chris White", 85.30f) {{
                    addTrack(new Track("Morning Light", 4));
                    addTrack(new Track("Midnight Blues", 5));
                }},
                new Book("Secrets of the Ocean", "Adventure", 30.99f) {{
                    addAuthor("David Walker");
                }},
                new Book("Passion Flames", "Romance", 45.20f) {{
                    addAuthor("Sophie Adams");
                    addAuthor("Claire Martin");
                }},
                new CompactDisc("Reflections", "Classical", "Orion", "Eclipse", 27.75f) {{
                    addTrack(new Track("Dawn", 2));
                    addTrack(new Track("Twilight", 3));
                    addTrack(new Track("Starlight", 4));
                }},
                new Book("L.U.C.Y", "Drama", 72.50f) {{
                    addAuthor("Aiden Lee");
                }}
        };


        for (Media m : sampleMedia) {
            try {
                store.addMedia(m);
            } catch (DuplicatedItemException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        openStoreScreen();
    }

    public static Store getStore() {
        return store;
    }

    public static Cart getCart() {
        return cart;
    }

    public static StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public static CartScreen getCartScreen() {
        return cartScreen;
    }

    public static void openStoreScreen() {
        storeScreen = new StoreScreen(store);
    }

    public static void closeStoreScreen() {
        storeScreen.setVisible(false);
        storeScreen = null;
    }

    public static void openCartScreen() {
        cartScreen = new CartScreen(cart);
    }

    public static void closeCartScreen() {
        cartScreen.setVisible(false);
        cartScreen = null;
    }

}

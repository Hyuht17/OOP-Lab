package aims;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    viewCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore(Scanner scanner) {
        System.out.println("Store contents:");
        store.printStore();

        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    viewCart(scanner);
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void seeMediaDetails(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            System.out.println(media.toString());

            if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống

                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if (media instanceof DigitalVideoDisc) {
                            DigitalVideoDisc dvd = (DigitalVideoDisc) media; // Ép kiểu
                            dvd.play();
                        } else if (media instanceof CompactDisc) {
                            CompactDisc cd = (CompactDisc) media; // Ép kiểu
                            cd.play();
                        }
                        break;
                    case 0:
                        System.out.println("Returning to store menu.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please choose again.");
                }
            }
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void addMediaToCart(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
            if (media instanceof DigitalVideoDisc) {
                System.out.println("Number of DVDs in cart: " + countDVDsInCart());
            }
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    public static void playMedia(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media; // Ép kiểu
            dvd.play();
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media; // Ép kiểu
            cd.play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }


    public static int countDVDsInCart() {
        return (int) cart.getItemsOrdered().stream()
                .filter(media -> media instanceof DigitalVideoDisc)
                .count();
    }

    public static void updateStore(Scanner scanner) {
        System.out.println("Update store:");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1:
                System.out.print("Enter media details (id, title, category, cost): ");
                int id = scanner.nextInt();
                scanner.nextLine();
                String title = scanner.nextLine();
                String category = scanner.nextLine();
                float cost = scanner.nextFloat();
                scanner.nextLine();

                Media newMedia = new Book(id, title, category, cost);
                store.addMedia(newMedia);
                System.out.println("Media added to store.");
                break;
            case 2:
                System.out.print("Enter the title of the media to remove: ");
                String removeTitle = scanner.nextLine();
                Media mediaToRemove = store.searchByTitle(removeTitle);

                if (mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                    System.out.println("Media removed from store.");
                } else {
                    System.out.println("Media not found in store.");
                }
                break;
            default:
                System.out.println("Invalid choice! Returning to main menu.");
        }
    }

    public static void viewCart(Scanner scanner) {
        cart.printCart();

        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1:
                    filterCart(scanner);
                    break;
                case 2:
                    sortCart(scanner);
                    break;
                case 3:
                    removeMediaFromCart(scanner);
                    break;
                case 4:
                    playMedia(scanner);
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void filterCart(Scanner scanner) {
        System.out.println("Filter options:");
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            cart.searchById(id);
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void sortCart(Scanner scanner) {
        System.out.println("Sort options:");
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        if (choice == 1) {
            cart.sortCartByTitle();
        } else if (choice == 2) {
            cart.sortCartByCost();
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void removeMediaFromCart(Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.getItemsOrdered().stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully!");
        cart.clearCart();
    }
}

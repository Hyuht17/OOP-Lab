package aims.cart;

import aims.media.DigitalVideoDisc;
import aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if ( itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(media);
            System.out.println("The disc has been added");
        }
        else{
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        int findItem = -1;
        if (itemsOrdered.size() > 0){
            if (itemsOrdered.contains(media)){
                findItem = itemsOrdered.indexOf(media);
            }
            if (findItem != -1){
                itemsOrdered.remove(findItem);
                System.out.println("The disc has been removed");
            }
            else {
                System.out.println("The disc is not in the cart");
            }
        }
    }

    public float totalCost(){
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++){
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        for (int i = 0; i < dvdList.length; i++){
//            if (qtyOrdered < MAX_NUMBERS_ORDERED){
//                itemsOrdered[qtyOrdered] = dvdList[i];
//                qtyOrdered++;
//            }
//            else{
//                System.out.println("The cart is almost full");
//            }
//        }
//    }

    public void addMedia(Media...mediaList){
        for (Media media : mediaList){
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED){
                itemsOrdered.add(media);
            }
            else{
                System.out.println("The cart is almost full");
            }
        }
    }

//    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
//        if (qtyOrdered < MAX_NUMBERS_ORDERED){
//            itemsOrdered[qtyOrdered] = dvd1;
//            qtyOrdered++;
//            itemsOrdered[qtyOrdered] = dvd2;
//            qtyOrdered++;
//        }
//        else{
//            System.out.println("The cart is almost full");
//        }
//    }

    public void printCart(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++){
            System.out.println((i + 1) + "." + itemsOrdered.get(i).toString());
            totalCost += itemsOrdered.get(i).getCost();
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("*************************************************");
    }


    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found: " + itemsOrdered.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).isMatch(title)) {
                System.out.println("Found: " + itemsOrdered.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }

    public ArrayList<Media> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered);
    }

    public void sortCartByTitle() {
        itemsOrdered.sort((media1, media2) -> {
            media1.getTitle().compareTo(media2.getTitle());
            return 0;
        });
        System.out.println("The cart has been sorted by Title" + ".");
    }

    public void sortCartByCost() {
        itemsOrdered.sort((media1, media2) -> {
            return Float.compare(media1.getCost(), media2.getCost());
            });
        System.out.println("The cart has been sorted by Title" + ".");
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }
}


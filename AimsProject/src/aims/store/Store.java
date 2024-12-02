package aims.store;

import aims.media.DigitalVideoDisc;
import aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia (Media media){
        if (itemsInStore.size() < MAX_ITEMS_IN_STORE){
            itemsInStore.add(media);
            System.out.println("The media has been added");
        }
        else{
            System.out.println("The store is full");
        }
    }

    public void removeMedia(Media media) {
        int findIndex = -1;
        String title = media.getTitle();
        findIndex = itemsInStore.indexOf(itemsInStore.equals(title));

        if (findIndex != -1) {
            itemsInStore.remove(findIndex);
            System.out.println("The Media has been removed from the store.");
        } else {
            System.out.println("No Meida with the title \"" + title + "\" was found in the store.");
        }
    }

    public void listDVDs(){
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public void printStore(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < itemsInStore.size(); i++){
            System.out.println((i + 1) + "." + itemsInStore.get(i).toString());
            totalCost += itemsInStore.get(i).getCost();
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("*************************************************");
    }

    public Media searchByTitle(String title){
        Media findMedia = null;
        for (Media media : itemsInStore){
            if (media.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                findMedia = media;
                break;
            }
        }
        return findMedia;
    }
}

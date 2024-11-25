package aims.store;

import aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD (DigitalVideoDisc disc){
        if (qtyInStore < MAX_ITEMS_IN_STORE){
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The disc has been added");
        }
        else{
            System.out.println("The store is full");
        }
    }

    public void removeDVD(String title){
        int findIndex = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getTitle().equalsIgnoreCase(title)) {
                findIndex = i;
                break;
            }
        }

        if (findIndex != -1) {
            for (int i = findIndex; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[qtyInStore - 1] = null;
            qtyInStore--;
            System.out.println("The DVD has been removed from the store.");
        } else {
            System.out.println("No DVD with the title \"" + title + "\" was found in the store.");
        }
    }

    public void listDVDs(){
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println(itemsInStore[i].toString());
        }
    }
}

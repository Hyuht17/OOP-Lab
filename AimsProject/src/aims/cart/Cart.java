package aims.cart;

import aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if ( qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else{
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int findItem = -1;
        if (qtyOrdered > 0){
            for (int i = 0; i < qtyOrdered; i++){
                if (itemsOrdered[i].getTitle().equals((disc.getTitle()))){
                    findItem = i;
                }
            }
            if (findItem != -1){
                for (int i = findItem; i < qtyOrdered - 1; i++) {
                    itemsOrdered[i] = itemsOrdered[i + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
            }
            else {
                System.out.println("The disc is not in the cart");
            }
        }
    }

    public float totalCost(){
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}

package test;

import aims.disc.DigitalVideoDisc;
import aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Rager Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addDVD(dvd1);
        store.addDVD(dvd2);

        System.out.println("Number of DVDs in store: ");
        store.listDVDs();

        store.removeDVD("The Lion King");
        System.out.println("Number of DVDs in store: ");
        store.listDVDs();
    }
}

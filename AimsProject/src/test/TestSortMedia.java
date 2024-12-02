package test;

import aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSortMedia {
    public static void main(String[] args) {
        List<Media> cart = new ArrayList<>();
        cart.add(new Book(1, "Java Programming", "Education", 49.99f, new ArrayList<>()));
        cart.add(new DigitalVideoDisc("Java Programming", "Education", "Director A", 120, 59.99f));
        cart.add(new Book(3, "Data Science", "Education", 29.99f, new ArrayList<>()));

        System.out.println("Sorting by Title then Cost:");
        Collections.sort(cart, Media.COMPARE_BY_TITLE_COST);
        cart.forEach(System.out::println);

        System.out.println("\nSorting by Cost then Title:");
        Collections.sort(cart, Media.COMPARE_BY_COST_TITLE);
        cart.forEach(System.out::println);
    }
}

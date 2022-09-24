package Java_Problem_Statement;


import java.util.ArrayList;
import java.util.List;

public class ItemList {
    static List<Item> list = new ArrayList<>();

    //This method is used to create dummy object of time item
    void addItems() {
        list.add(new Item("Copy", 90, 25));
        list.add(new Item("Pencil", 10, 500));
        list.add(new Item("Spiral Copy", 20, 25));
        list.add(new Item("Exam Board", 80, 30));
        list.add(new Item("Eraser", 10, 25));
        list.add(new Item("Sharpener", 10, 25));
        list.add(new Item("Pencil Box", 30, 25));
        list.add(new Item("Instrumentation Box", 40, 25));
        list.add(new Item("Color Pencil Packet", 70, 25));
        list.add(new Item("Pen", 10, 500));
    }

    //This function will return the list of dummy Items
    public List<Item> getListOfItem(){
        return list;
    }
}

package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.addLast(book);
    }

    public Book pop() {
        if(!this.isEmpty()) {
            return stack.removeLast();
        }
        return null;
    }

    public Book peek() {
        if(!this.isEmpty()) {
            return stack.getLast();
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (Book book: stack) {
            System.out.println(" - " + book);
        }
    }
}


package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        //Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        //Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        //Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------
    /* In this test, the time taken by ArrayList is less than that of LinkedList,because direct index access in
    ArrayList is fast, while LinkedList must traverse nodes to reach random positions
     */
    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        // random insertions
        for(int i= 0; i<OPERATIONS;i++){
            int index = random.nextInt(list.size()+1);
            list.add(index,i);
        }
        //random deletions
        for(int i= 0; i<OPERATIONS;i++){
            int index = random.nextInt(list.size());
            list.remove(index);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------
    /* In this test the time taken by ArrayList is longer than that of LinkedList , because adding or removing
    at the head or tail only updates pointers, but ArrayList shifts elements
     */
    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        // Insertions at beginning and end
        for (int i = 0;i<OPERATIONS;i++) {
            list.add(0, -1);
            list.add(list.size(), -1);
        }
        // Deletions at beginning and end
        for (int i =0;i<OPERATIONS;i++) {
            if (!list.isEmpty()) list.remove(0);
            if (!list.isEmpty()) list.remove(list.size() - 1);
        }
        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------
    /* In this test, the time taken by the ArrayList is less than that of LinkedList , because ArrayList supports
    constant-time index access , while LinkedList requires linear traversal for each access
     */
    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        // sum of the all elements in the list
        for (int i = 0; i <OPERATIONS;i++) {
            int index = random.nextInt(list.size());
            sum += list.get(index);
        }
        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}


//Exercise 13.3 --> works with arrays of Comparable elements

import java.util.Arrays;

public class Heapifier {
   private Heapifier() {};

   // converts array a into a heap
   public static void heapify(Comparable[] a) {
      int n = a.length;
      for (int k = n/2; k >= 1; k--){
         sink(a, k, n);
      }
   }

   // restores the heap invariant for the subtree rooted at index k
   private static void sink(Comparable[] a, int k, int n) {
      while (2*k <= n){
         int j = 2*k;
         if (j < n && less(a, j, j+1)) j++;
         if (!less(a, k, j)) break;
         exch(a, k, j); //exchange parent w child
         k = j;
      }
   }

   // Helper methods for comparisons and swaps.
   // Indices are "off-by-one" to support 1-based indexing.
   private static boolean less(Comparable[] a, int i, int j) {
      return a[i-1].compareTo(a[j-1]) < 0;
   }

   private static void exch(Object[] a, int i, int j) {
      Object temp = a[i-1];
      a[i-1] = a[j-1];
      a[j-1] = temp;
   }
   public static void main(String[] args) {
      //TEST Exercise 13.1
      System.out.println("***********************************************");
      System.out.println("Testing EXERCISE 13.1");
      
      Character[] letters1 = {'P','L','A','Y','G','R','O','U','N','D'};
      System.out.println("Original array: " + Arrays.toString(letters1));

      Heapifier.heapify(letters1);
      System.out.println("Heapified array: " + Arrays.toString(letters1));

      //TEST Exercise 13.2
      System.out.println("***********************************************");
      System.out.println("Testing EXERCISE 13.2");

      Character[] letters2 = {'M','I','S','C','O','U','N','T','E','D'};
      System.out.println("Original array: " + Arrays.toString(letters2));

      Heapifier.heapify(letters2);
      System.out.println("Heapified array: " + Arrays.toString(letters2));
      System.out.println("***********************************************");
   }
}

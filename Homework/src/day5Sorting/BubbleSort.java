package day5Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        System.out.println("Before Sorting:");
        for (int n : arr) {
            System.out.print(n + " ");
        }

    
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("\nAfter Sorting:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
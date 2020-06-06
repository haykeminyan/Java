import java.util.Arrays;
import java.util.Random;

public class SimpleMethods {
    public static void main(String[] args) {
        int[] mass_range = range(1, 162);
        System.out.println("List range is: " + Arrays.toString(mass_range));
        int[] mass_shuffle = shuffle_array(mass_range);
        System.out.println("Shuffle array is: " + Arrays.toString(mass_shuffle));
        int[] result = bubble_sort(mass_shuffle);
        System.out.println("Bubble sort: " + Arrays.toString(result));
        int low_elem_linear_search = 0;
        int high_elem_linear_search = result.length - 1;
        System.out.println("The low element of array is: " + low_elem_linear_search);
        System.out.println("The highest element of array is: " + high_elem_linear_search);
        System.out.println(
                "Linear search answer: " + linear_search(result, 10, low_elem_linear_search, high_elem_linear_search));
    }

    static int[] range(int low, int high) {
        int[] a = new int[high - low];
        for (int i = 0, j = low; i < high - low; i++, j++) {
            a[i] = j;
        }
        return a;

    }

    static int[] shuffle_array(int[] a) {
        Random rgen = new Random();
        for (int i = 0; i < a.length; i++) {
            int randomPosition = rgen.nextInt(a.length);
            int temp = a[i];
            a[i] = a[randomPosition];
            a[randomPosition] = temp;
        }
        return a;
    }

    static int[] bubble_sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    static int linear_search(int[] a, int key, int low_elem_linear_search, int high_elem_linear_search) {
        int index = -1;
        while (low_elem_linear_search <= high_elem_linear_search) {
            int mid = (low_elem_linear_search + high_elem_linear_search) / 2;
            System.out.println("Current elem searching: " + a[mid]);
            if (a[mid] == key) {
                index = mid;
                break;
            } else if (a[mid] > key) {
                high_elem_linear_search = mid - 1;
            } else if (a[mid] < key) {
                low_elem_linear_search = mid + 1;
            }
        }
        return index;
    }

}
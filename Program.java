import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        int[] mass_range = nums(0, 122);
        System.out.println("List range is: " + Arrays.toString(mass_range));
        int[] mass_shuffle = shuffle_array(mass_range);
        System.out.println("Shuffle array is: " + Arrays.toString(mass_shuffle));
        int[] result = bubble_sort(mass_shuffle);
        System.out.println("Bubble sort: " + Arrays.toString(result));
        int low_elem_linear_search = result[0];
        int high_elem_linear_search = result[result.length - 1];
        System.out.println(
                "Linear search answer: " + linear_search(result, 12, low_elem_linear_search, high_elem_linear_search));
    }

    static int[] nums(int low, int high) {
        int[] res = new int[high - low];
        for (int i = 0; i < high - low; i++) {
            res[i] = i;
        }
        return res;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<Integer>();
        while (input.hasNext()) {
            try {
                list.add(input.nextInt());
            } catch (NumberFormatException e) {
                System.err.println("Input list contains a non-number.");
                return;
            }
        }
        int[]arr= new int[list.size()];
        for (int i=0; i<list.size(); i++){
            arr[i]=list.get(i);
        }
        int max = getMax(arr);
        int min = getMin(arr);
        System.out.println("Die min ist " + min);
        System.out.println("Die max ist " + max);

        int[] count = count(arr, min, max);
        System.out.println("Frequencies "+ Arrays.toString(count));
        int[] sort = countingSort(arr);
        System.out.println("sortiert " + Arrays.toString(arr));

    }

    public static int getMin(int[] data){
        int min = data[0];
        for(int i = 1; i < data.length; i++){
            if(data[i] < min){
                min = data[i];
            }
        }
        return min;
    }
    public static int getMax(int[] data){
        int max = data[0];
        for(int i = 1; i < data.length; i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        return max;
    }

    public static int[] count (int[] input, int min, int max){
        int [] output = new int[max - min + 1];
        for (int i = 0; i < output.length; i++) {
            output[i] = 0;
        }
        for(int i = 0; i< input.length; i++){
            if(input[i] >= min && input[i] <= max){
                output[input[i] - min] += 1;
            }

        }
        return output;
    }

    public static int[] countingSort(int[] input){
        int min = getMin(input);
        int[] helper = count(input, min, getMax((input)));

        int inputIndex = 0;
        for (int i = 0; i < helper.length; i++){
            while(helper[i] > 0){
                input[inputIndex] = i + min;
                helper[i]--;
                inputIndex++;
            }
        }




        return helper;
    }

}

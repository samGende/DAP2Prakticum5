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
        int[] count = count(arr, min, max);
        System.out.println(Arrays.toString(count));
        int[] sort = countingSort(arr);
        System.out.println(Arrays.toString(arr));

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
        for (int i = helper.length-2; i >= 0; i--){
            helper[i] += helper[i+1];
        }
        int[] output = new int[input.length];
        for(int i = 0; i < input.length; i++){
            output[helper[input[i] - min] -1] = input[i];
            helper[input[i] - min] -= 1;

        }

        for(int i = 0; i < input.length; i++){
            input[i] = output[i];
        }


        return helper;
    }

}

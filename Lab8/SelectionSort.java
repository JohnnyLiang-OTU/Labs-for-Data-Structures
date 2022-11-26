import java.util.Arrays;
public class SelectionSort {
    public static void selectionSort(int[] numbers)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            int smallest = i;
            for(int j = i+1; j < numbers.length; j++)
            {
                if(numbers[smallest] > numbers[j])
                {
                    smallest = j;
                }
            }
            int temp = numbers[smallest];
            numbers[smallest] = numbers[i];
            numbers[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[] {2,6,4,78,3,2,1,4,2,4,3,4,4,4655,12};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}


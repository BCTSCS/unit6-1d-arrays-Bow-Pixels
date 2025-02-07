import java.io.File;
import java.util.Scanner;
public class DataAnalyzer{


    public static void main(String[] args){
        int[] list = {10,20,30,40,50};
        System.out.println(searchList(list, 40));
        System.out.println(searchList(20, list));
        int[] numbers = new int[100];
        try {
            File f = new File("numbers.txt");
            
            Scanner input = new Scanner(f);
            for(int i = 0; i < 100; i++){
                numbers[i] = input.nextInt();
            }
           
            input.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }

        System.out.println(searchList(numbers, 17));
        int[] newNumbers = reverseList(numbers);

        printArray(newNumbers);



        
       

    }
    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length-1; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.print("]");
    }
     // Linear Search  
    public static int searchList(int[] numbers, int target){
        int index = 0;
        while(index <= numbers.length - 1){
            if(numbers[index] == target){
                return index;
            }
            index++;
        }

        return -1;
    }
    // Binary Search - List must be sorted first
    public static int searchList(int target, int[] numbers){
        int minIndex = 0;
        int maxIndex = numbers.length -1;
        while (minIndex <= maxIndex){
            int middleIndex = (maxIndex+minIndex)/2;
            if(numbers[middleIndex] == target){
                return middleIndex;
            }
            else{
                if(target > numbers[middleIndex]){
                    minIndex = middleIndex + 1;
                }else{
                    maxIndex = middleIndex - 1;
                }
            }
        }
        return -1;
    }
    public static int[] reverseList(int[] array){
        int[] newArray = new int[array.length];

        for(int i = 0; i < array.length-1; i++){
            newArray[i] = array[array.length-1-i];
        }
        return newArray;
    }

}
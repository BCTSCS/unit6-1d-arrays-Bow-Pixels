public class DataAnalyzer{


    public static void main(String[] args){
        int[] list = {10,20,30,40,50};
        System.out.println(searchList(list, 40));
        System.out.println(searchList(20, list));

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
}
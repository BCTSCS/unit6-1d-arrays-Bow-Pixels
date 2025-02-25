import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class FileOperator {
    private Scanner fileReader;
    private File myFile; 

    public FileOperator(String filename){
        setFile(filename);
    }

    public void setFile(String filename){
        myFile = new File(filename);
        try{
            fileReader = new Scanner(myFile);
        }catch(FileNotFoundException error){
            System.out.println("File not found.");
        }
    }

    public int[] toIntArray(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = fileReader.nextInt();
        }
        return arr;
    }

    public double[] toDoubleArray(int size){
        double[] arr = new double[size];
        for(int i = 0; i< size; i++){
            arr[i] = fileReader.nextDouble();
        }
        return arr;
    }

    public String[] toStringArray(int size){
        String[] arr = new String[size];
        for(int i = 0; i < size; i++){
            arr[i] = fileReader.nextLine();
        }
        return arr;
    }

    public ArrayList<String> toStringArray(){
        ArrayList<String> arr = new ArrayList<String>();
        while(fileReader.hasNextLine()){
            arr.add(fileReader.nextLine());
        }
        return arr;
    }

    public ArrayList<Integer> toIntgArray(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(fileReader.hasNextInt()){
            arr.add(fileReader.nextInt());
        }
        return arr;
    }

    public ArrayList<Double> toDoubleArray(){
        ArrayList<Double> arr = new ArrayList<Double>();
        while(fileReader.hasNextDouble()){
            arr.add(fileReader.nextDouble());
        }
        return arr;
    }

    
}

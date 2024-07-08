package file;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class file{
    public static void main(String[] args) {
        //creating a new file
        try{
            File obj = new File("fruits.txt");
            if(obj.createNewFile()){
                System.out.println("file created : "+obj.getName());
            }else{
                System.out.println("File already exists ");
            }
        }catch(Exception e) {
            System.out.println("some error occured while creating the file");
            e.printStackTrace();
        }
        //adding data to a file
        try{
            FileWriter add = new FileWriter("fruits.txt");
            add.write("apple\nbanana\norange\ngrape\napple\nbanana\nkiwi\npineapple\norange\npear\npineapple\nstrawberry\nstrawberry\nstrawberry\nmango\nmango\nmango\nmango\napple\napple\napple");
            add.close();
            System.out.println("Contents added to the file succesfully");
        }catch(Exception a){
            System.out.println("some error occured while adding the contents to the file");
            a.printStackTrace();
        }
        // program to get distinct fruits and their count
        Map<String,Integer> fruitCount = new HashMap<>(); // stores only unique keys and different number of values
        try{
            FileReader read = new FileReader("fruits.txt");
            BufferedReader br = new BufferedReader(read);
            String line;
            while((line = br.readLine()) != null){
                if(fruitCount.containsKey(line)){
                    fruitCount.put(line,fruitCount.get(line)+1);
            }else{
                fruitCount.put(line,1);
            }
            }
            br.close();
            System.out.println("Contents read from the file succesfully");
            System.out.println("unique fruits and their count :");
            for(Map.Entry<String,Integer> entry : fruitCount.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }catch(Exception e){
            System.out.println("some error occured while reading the file");
            e.printStackTrace();
        }
    }
}
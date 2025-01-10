package groupId;

import java.io.*;

public class FileHandling {
    public static void loadSpacesfromFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            Main.spaces.clear();
            String line;
            while((line = br.readLine()) != null){
                new CoworkingSpace(line);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void saveSpacesToFile(String filename){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(CoworkingSpace space : Main.spaces){
                bw.write(space.getId() + "," + space.getType()+ "," + space.getPrice() + "," + space.isAvailability() + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

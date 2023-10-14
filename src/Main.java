
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
public class BrandList {

    private ArrayList<Brand> brandList = new ArrayList<Brand> ();
     java.io.File f = new java.io.File("C:\\Users\\admin\\Desktop\\JAVA\\MinhTrangBMW\\Brands.txt");

   
       public boolean loadFromFile(String path) {
        try (  BufferedReader br = Files.newBufferedReader(f.toPath(),StandardCharsets.UTF_8);) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");  // Assuming space is the delimiter
                Brand brand = new Brand(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                brandList.add(brand);
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(path);
                
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    }
    
}

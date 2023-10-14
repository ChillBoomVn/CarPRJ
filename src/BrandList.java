/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import util.MyUtil;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.File;
/**
 *
 * @author reality
 */
public class BrandList {

    public ArrayList<Brand> brandList = new ArrayList<Brand> ();
     java.io.File f = new java.io.File("C:\\Users\\admin\\Desktop\\JAVA\\MinhTrangBMW\\Brands.txt");

    public BrandList() {
    }
    
    
    
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

    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Brand brand : brandList) {
                pw.println(brand.toString());
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public int searchID(String ID) {

        if (brandList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getBrandID().equalsIgnoreCase(ID)) {
                return i;
            }

        }

        return -1;
    }

    public Brand getUserChoice() {

        return null;
    }

    public void addBrand() {
        String brandID;
        String brandName;
        String soundBrand;
        double price;
        int pos;
        do {

            brandID = MyUtil.getString("Input brand ID: ", "Brand ID is required !");
            pos = searchID(brandID);
            if (pos >= 0) {
                System.out.println(" Brand ID has been existed, please input another ID");
            }

        } while (pos != -1);

        brandName = MyUtil.getString("Input brandName: ", "Brand name is required !");
        soundBrand = MyUtil.getString("input sound brand: ", "Sound brand is required !");
        price = MyUtil.getADouble("Input price (greater than 0):", "Input price again !");
        brandList.add(new Brand(brandID, brandName, soundBrand, price));
        System.out.println("BRAND HAS BEED ADDED SUCCESSFULLY !");

    }

    public void updateBrand() {
        String brandID;
        String newBrandName;
        String newSoundBrand;
        double newPrice;
        int pos;
        brandID = MyUtil.getString("Input brand ID: ", "Brand ID is required !");
        pos = searchID(brandID);
        if (pos == -1) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println("THE BRAND IS FOUND, PLEASE UPDATE !!");
            newBrandName = MyUtil.getString("Input brandName: ", "Brand name is required !");
            newSoundBrand = MyUtil.getString("input sound brand: ", "Sound brand is required !");
            newPrice = MyUtil.getADouble("Input price (greater than 0): ", "Input price again !");
            System.out.println("BEFORE UPDATING");
            System.out.println(brandList.get(pos));
            
            //Update
            brandList.get(pos).setBrandName(newBrandName);
            brandList.get(pos).setSoundBrand(newSoundBrand);
            brandList.get(pos).setPrice(newPrice);
            System.out.println("AFTER UPDATING");
            System.out.println(brandList.get(pos));
            
            

        }
        
        
    }

    public void listBrand() {
        if (brandList.isEmpty()) {
            System.out.println("The brand list is empty");
        }
        for (int i = 0; i < brandList.size(); i++) {
            System.out.println(brandList.get(i));

        }

    }

}
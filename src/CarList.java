import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MyUtil;
import java.util.StringTokenizer;

public class CarList {
    private List<Car> carList = new ArrayList<Car>();
    private BrandList brandList;
    String path = "C:\\Users\\admin\\Desktop\\JAVA\\MinhTrangBMW\\Cars.txt";

    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }
    
     
    
    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("FILE IS NOT EXIST");
            return false;

        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.length() > 0) {
                    StringTokenizer stk = new StringTokenizer(line, ",:");
                    String CarId = stk.nextToken().trim();
                    String brandID = stk.nextToken().trim();
                    String color = stk.nextToken().trim();
                    String frameID = stk.nextToken().trim();
                    String engineID = stk.nextToken().trim();
                    int pos = brandList.searchID(brandID);
                    Brand b = brandList.;
                    carList.add(new Car(CarId, brandID, color, frameID, engineID) );

                }

            }
            br.close(); fr.close();

        } catch (IOException e) {
            System.out.println("FAILED");
            
        }
        return true;

    }
    
    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Car car : carList) {
                pw.println(car.toCSVString());
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public int searchID(String brandID) {
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getBrandID().equalsIgnoreCase(brandID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String frameID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine(String engineID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getEngineID().equals(engineID)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addCar(String carID) {
        // Create a menu for choosing a brand (assuming menu is a class to get user input)
        Brand brand = menu.getChoice(brandList);
        String color = MyUtil.getString("Input color: ", "Color is required!");
        String frameID = MyUtil.getValidFrameID("Input frameID: ");
        String engineID = MyUtil.getValidEngineID("Input engineID: ");
        
        Car car = new Car(carID, brand, color, frameID, engineID);
        carList.add(car);
    }
    
    public void printBasedBrandName(String aPartOfBrandName) {
        int count = 0;
        for (Car car : carList) {
            if (car.getBrand().getBrandName().contains(aPartOfBrandName)) {
                System.out.println(car.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car is detected!");
        }
    }
    
    public boolean removeCar(String removedID) {
        int pos = searchID(removedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            carList.remove(pos);
            return true;
        }
    }
    
    public boolean updateCar(String updatedID) {
        int pos = searchID(updatedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            Brand brand = menu.getChoice(brandList);
            String color = MyUtil.getString("Input color: ", "Color is required!");
            String frameID = MyUtil.getValidFrameID("Input frameID: ");
            String engineID = MyUtil.getValidEngineID("Input engineID: ");
            
            Car car = carList.get(pos);
            car.setBrand(brand);
            car.setColor(color);
            car.setFrameID(frameID);
            car.setEngineID(engineID);
            return true;
        }
    }
    
    public void listCars() {
        Collections.sort(carList);
        for (Car car : carList) {
            System.out.println(car.screenString());
        }
    }
}

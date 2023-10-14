/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class FileBrand {
 File f = new File (filename);
If (f doesn’t exist) return false;
7
Else {
 Open file in text format for reading line-by-line;
 While ( a line is read from file) {
 Split the read line into parts;
 Extract parts to carID, brandID, color, frameID, engineID
 int pos= brandList.searchID(brandID);
 Brand b = brandList.get(pos);
 Create new car with data above;
 Add new car to the list; 
 }
 Close the file;
 Return true;
}
   
}

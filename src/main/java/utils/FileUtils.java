package utils;

import products.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static File writeProductToTXTFile(List<Product> products) throws IOException {
        File file = new File("temp.txt");
        FileWriter fileWriter  = new FileWriter(file);
        file.setWritable(true);
        file.setReadable(true);
        System.out.println(file.getAbsolutePath());
        for(Product pro:products){
            System.out.println(pro);
            fileWriter.write(pro.toString()+"\n");
        }
        fileWriter.flush();
        return file;
    }
}

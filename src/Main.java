import java.io.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String FILE_NAME = "/Users/admin/Documents/CODEGYM/java-core/document/c0924g1_io_1.txt";

    public static void main(String[] args) {

        //String data = "Welcome to Ha Noi";

        //writeByteFile(FILE_NAME, data);

        //readByteFile(FILE_NAME);

        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Samsung", 200.0));
        products.add(new Product(2,"Iphone", 300.0));
        products.add(new Product(3,"OPPO", 400.0));

        //writeDataToFile(FILE_NAME, products);

        List<Product> productList = readDataFromFile(FILE_NAME);

    }

    public static void writeByteFile(String fileName, String data) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte b[] = data.getBytes();
            bos.write(b);
            bos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readByteFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int ch;
            while ((ch = bis.read()) != -1)
                System.out.print((char) ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }
}
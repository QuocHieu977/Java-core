package utils.file;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {


    public static Object readDataFormFile(String fileName) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writeDatToFile(Object newData, String fileName)  {
//        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            // read data old form file
//            File file = new File(fileName);
//            ArrayList<Object> dataList;
//            if (file.exists()){
//                objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
//                dataList = (ArrayList<Object>) objectInputStream.readObject();
//            } else {
//                dataList = new ArrayList<>();
//            }
//
//            //insert new data to dataList
//            dataList.add(newData);

            //  write all data to file(new and old)
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(newData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
//                objectInputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

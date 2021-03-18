package AwesomeToDoLyOnGradle;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class FileMaster {
    private String path = "src/main/java/";

    public void writeAsObject(ArrayList<YourList> madeList) {
        try {
            FileOutputStream fileStream = new FileOutputStream(path + "taskAfterAdd.txt");
            ObjectOutputStream objectWriter = new ObjectOutputStream(fileStream);

            objectWriter.writeObject(madeList);

            objectWriter.close();
            fileStream.close();

        }
        catch (IOException e)
        {
            System.out.println("File isn´t found. " + e);
        }
    }

    public ArrayList<YourList> readAsObject() {
        ArrayList<YourList> madeList = new ArrayList<>();

        try {
            FileInputStream fileInStream = new FileInputStream(path + "taskAfterAdd.txt");
            ObjectInputStream objectReader = new ObjectInputStream(fileInStream);

            madeList = (ArrayList<YourList>) objectReader.readObject();

            objectReader.close();
            fileInStream.close();

        } catch (IOException e) {
            System.out.println("File isn´t found. " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Problems found inside the file. " + e);
        }
        return madeList;
    }


}

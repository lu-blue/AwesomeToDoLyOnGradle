package AwesomeToDoLyOnGradle;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class FileMaster {
    private String path = "app/src/main/java/AwesomeToDoLyOnGradle/";
    //private String path = "/Users/lubov/Documents/AwesomeToDoLyOnGradle/app/src/main/java/AwesomeToDoLyOnGradle";

    public void writeAsObject(ArrayList<Task> madeList) {
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

    public ArrayList<Task> readAsObject() {
        ArrayList<Task> madeList = new ArrayList<>();

        try {
            FileInputStream fileInStream = new FileInputStream(path + "taskAfterAdd.txt");
            ObjectInputStream objectReader = new ObjectInputStream(fileInStream);

            madeList = (ArrayList<Task>) objectReader.readObject();

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

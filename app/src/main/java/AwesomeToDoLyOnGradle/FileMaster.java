package AwesomeToDoLyOnGradle;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains methods for writing an array list of tasks into a file,
 * obtained from the user, and re-writing it over if the user makes changes to it.
 * In addition, it provides functionality to then read this list again in the app
 * and make changes to it, even after restarting.
 *
 * "fileName" provides the path to the file to which the list can be written into.
 * */

public class FileMaster {
    private String fileName = "app/src/main/java/AwesomeToDoLyOnGradle/";

    public void writeAsObject(String fileName, ArrayList<Task> madeList) {
        try {
            FileOutputStream fileStream = new FileOutputStream(fileName);
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

    public static ArrayList<Task> readAsObject(String fileName) {
        ArrayList<Task> madeList = new ArrayList<Task>();

        try {
            FileInputStream fileInStream = new FileInputStream(fileName);
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

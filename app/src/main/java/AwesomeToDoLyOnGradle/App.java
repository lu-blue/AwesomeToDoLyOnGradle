/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package AwesomeToDoLyOnGradle;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static YourList list0 = new YourList();

    /**
     * When a user starts the app, the main method initializes a program,
     * starting an interactive user interface which will display all the options
     * a user can choose from to: add a new task; view a task list; edit an existing Task;
     * remove an existing task; mark tasks as done; view all available options,
     * or save a list of tasks and quit an app.
     * */
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {

        viewAllOptions();
        boolean quit = false;

        try {
            while (!quit) {

                    System.out.println("\nEnter an option number (or enter 5 to view options again):");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 1:
                            addNewTask();
                            break;

                        case 2:
                            list0.viewList();
                            break;

                        case 3:
                            editExistingTask();
                            break;

                        case 4:
                            removeExistingTask();
                            break;

                        case 5:
                            viewAllOptions();
                            break;

                        case 6:
                            markAsDone();
                            break;

                        case 7:
                            saveAndQuitApp();
                            break;

                        default:
                            System.out.println("Invalid entry, just try again!");
                    }
                }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nThe app quited. Please, restart the app.");
            e.printStackTrace();
        } finally {
            if (scanner.nextLine().equals("quit"))
                scanner.close();
        }
    }

    private static void viewAllOptions () {
        System.out.println("" + "WELCOME TO TODOLY!\n"
                + "Here is what you can do:");
        System.out.println("(1) Add New Task\n"
                + "(2) View Task List\n"
                + "(3) Edit Existing Task\n"
                + "(4) Remove Existing Task\n"
                + "(5) View Options\n"
                + "(6) Mark Task as Done\n"
                + "(7) Save and Quit");
    }

    private static void addNewTask () {
        System.out.println("Is it your first time you add a task in ToDoLy? Press 1." +
                "\nIf you´ve saved tasks before, press 2.");
        int choiceFork1 = scanner.nextInt();
        scanner.nextLine();

        switch (choiceFork1) {
                case 1:
                System.out.println("Please, give a name to a project to which your task will belong to: ");
            String project = scanner.nextLine();
            System.out.println("Please, enter a task title: ");
            String title = scanner.nextLine();
            System.out.println("Please, enter your task description (what you need to do):");
            String taskBody = scanner.nextLine();
            System.out.println("Please, enter when this task is due (in the format yyyy-MM-dd):");
            String dueDate = scanner.nextLine();

            Task newTask = new Task();
            newTask.Task(project, title, taskBody, dueDate);
            if (list0.addNewTask(newTask)) { //checking if a task is successfully added
                list0.saveTask();
            } else {
                System.out.println("Cannot add, " + title + "as it already exists for another task.");
            }
            break;

            case 2:
                list0.viewList();

                System.out.println("Please, give a name to a project to which your task will belong to: ");
                String project1 = scanner.nextLine();
                System.out.println("Please, enter a task title: ");
                String title1 = scanner.nextLine();
                System.out.println("Please, enter your task description (what you need to do):");
                String taskBody1 = scanner.nextLine();
                System.out.println("Please, enter when this task is due (in the format yyyy-MM-dd):");
                String dueDate1 = scanner.nextLine();

                Task newTask1 = new Task();
                newTask1.Task(project1, title1, taskBody1, dueDate1);
                if (list0.addNewTask(newTask1)) {
                    list0.saveTask();
                } else {
                    System.out.println("Cannot add, " + title1 + "as it already exists for another task.");
                }
                break;
        }
    }

    /**
     * To edit a task, a user is asked to give a valid task title first
     * which he/she can see from the displayed whole list of already entered tasks
     * */
    private static void editExistingTask () {
        list0.viewList();

        System.out.println("\nEnter an existing task title: ");
        String title = scanner.nextLine();
        Task existingTaskRecord = list0.queryTask(title);
        if (existingTaskRecord == null) {
            System.out.println("Ooops, a task was not found.");
            return;
        }
        /** If a valid title is provided, a user is asked to input new values
         * for all the task parameters, which then replace the ones stored in that task before
         * */

        System.out.println("Enter a new project name for your task to replace the old one: ");
        String newProject = scanner.nextLine();
        System.out.println("Enter a new title for your task to replace the old one: ");
        String newTitle = scanner.nextLine();
        System.out.println("Give a new description to your task to replace the old one: ");
        String newTaskBody = scanner.nextLine();
        System.out.println("Please, enter a new due date for this task (in the format yyyy-MM-dd):");
        String newDueDate = scanner.nextLine();

        Task newTask = new Task();
        newTask.Task(newProject, newTitle, newTaskBody, newDueDate);
        if (list0.updateExistingTask(existingTaskRecord, newTask)) {
            System.out.println("Your task was successfully updated!");
            list0.saveTask();
        } else {
            System.out.println("An error occurred while updating your task.");
        }
    }

    /**
     * If a valid title is provided by the user,
     * the whole task with that title is being removed
     * */
    private static void removeExistingTask() {

        list0.viewList();

        System.out.println("Enter an existing task title: ");
        String title = scanner.nextLine();
        Task existingTaskRecord = list0.queryTask(title);
        if (existingTaskRecord == null) {
            System.out.println("Ooops, a task was not found.");
            return;
        }

        if (list0.removeExistingTask(existingTaskRecord)) {
            System.out.println("Your task is successfully deleted.");
            list0.saveTask();
        } else {
            System.out.println("An error occurred while removing your task.");
        }
    }

    private static void markAsDone () {
        list0.viewList();

        System.out.println("Enter an existing task title: ");
        String title = scanner.nextLine();
        Task existingTaskRecord = list0.queryTask(title);
        if (existingTaskRecord == null) {
            System.out.println("Ooops, a task was not found.");
            return;
        }
        if(list0.markAsDoneStatus(existingTaskRecord)){
            System.out.println("Awesome, your task is marked as done now!");
            list0.saveTask();
        } else {
            System.out.println("An error occurred while removing your task.");
        }
    }

    private static void saveAndQuitApp () {
        System.out.println("Thank you, your tasks are saved now! \n" +
                "Do you want to save your list and quit ToDoLy? " +
                "If yes, type a word QUIT.\n If not, enter 5 to view your options again");
    }
}


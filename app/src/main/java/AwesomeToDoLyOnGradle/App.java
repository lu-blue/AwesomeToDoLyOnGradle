/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package AwesomeToDoLyOnGradle;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static YourList list0 = new YourList();

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
                            list0.viewTaskList(); // calls a method from class List0, applied on object list0 (made here, in Main class)
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
                            list0.saveAndQuitApp();
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

        private static void addNewTask () {
            System.out.println("Please, give a name to a project to which your task will belong to: ");
            String project = scanner.nextLine();
            System.out.println("Please, enter a task title: ");
            String title = scanner.nextLine();
            System.out.println("Please, enter your task description (what you need to do):");
            String taskBody = scanner.nextLine();
            System.out.println("Please, enter when this task is due (in the format yyyy-MM-dd):");
            String dueDate = scanner.nextLine();

            Task newTask = new Task(); // a new task object is created
            newTask.Task(project, title, taskBody, dueDate); // !!!
            if (list0.addNewTask(newTask)) { //checking if a task is successfully added
                System.out.println(
                        "Awesome, a new task is added!\nTask assigned to a project: " + project + "."
                        + "\nTask title: " + title + "."
                        + "\nWhat to do: " + taskBody + "."
                        + "\nDue date: " + dueDate + "."
                        + "\nStatus: Not done.");

            } else {
                System.out.println("Cannot add, " + title + "as it already exists for another task.");
            }
        }

        private static void editExistingTask () {
            System.out.println("Review your list before editing!");
            list0.viewTaskList();

            System.out.println("\nEnter an existing task title: ");
            String title = scanner.nextLine();
            Task existingTaskRecord = list0.queryTask(title);
            if (existingTaskRecord == null) {
                System.out.println("Ooops, a task was not found.");
                return;
            }

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
            } else {
                System.out.println("An error occurred while updating your task.");
            }
        }


        //Looking for a task by title works but is cumbersome (as titles can be hard to remember or reproduce)
        private static void removeExistingTask() {
            System.out.println("Enter an existing task title: ");
            String title = scanner.nextLine();
            Task existingTaskRecord = list0.queryTask(title);
            if (existingTaskRecord == null) {
                System.out.println("Ooops, a task was not found.");
                return;
            }

            if (list0.removeExistingTask(existingTaskRecord)) {
                System.out.println("Your task is successfully deleted.");
            } else {
                System.out.println("An error occurred while removing your task.");
            }
        }

        //private static void saveAndQuitApp () {
         //   System.out.println("Do you want to save your list and quit ToDoLy? " +
         //           "If yes, type a word QUIT. If not, press any option from 1 to 5");



            //System.out.println ("Your tasks are saving...");
            //ArrayList<YourList> myAwesomeTasks = new ArrayList<>();
            //myAwesomeTasks.add(list0);
            //System.out.println(myTasks.toString()); //gives a weird output

            //FileMaster fileMaster = new FileMaster(); // to write a file
            //fileMaster.writeAsObject(myAwesomeTasks);

            //ArrayList<YourList> checkObject = fileMaster.readAsObject(); // to read a file
            //System.out.println("Awesome! A new task is added: " + checkObject);

         //   }

        private static void viewAllOptions () {
            System.out.println("" + "WELCOME TO TODOLY."
                    + "You have X tasks to do and Y tasks are done!\n"
                    + "Here is a list of options:");
            System.out.println("(1) Add New Task\n" //2 add
                    + "(2) View Task List\n" //1 display. In IP specs: by project or by due date
                    + "(3) Edit Existing Task\n" // 3 update existing; 4 remove
                    + "(4) Remove Existing Task\n"
                    + "(5) View all available options\n" // 6 print available options
                    + "(6) Save and Quit"); //0 shutdown. In IP specs: not only quit, but save to file

        }


        //Additional method (not required in IP specs) for searching a task by its title
        public static void queryTask () {
            System.out.println("Enter an existing task title: ");
            String title = scanner.nextLine();
            Task existingTaskRecord = list0.queryTask(title);
            if (existingTaskRecord == null) {
                System.out.println("Ooops, a task was not found.");
            }
            //System.out.println("Task with a title " + existingTaskRecord.getTitle()
             //       + "belongs to a project " + existingTaskRecord.getProject() + "."
            //        + "\n Task description: " + existingTaskRecord.getTaskBody());

        }
    }


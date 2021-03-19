package AwesomeToDoLyOnGradle;

import java.io.Serializable;
import java.util.ArrayList;

public class YourList implements Serializable {


    private ArrayList<Task> myTasks;

    public YourList() {
        this.myTasks = new ArrayList<>();
    }


    public boolean addNewTask(Task task0) {
        if (findTask(task0.getTitle()) >=0) {
            System.out.println("This task title already exists.");
            return false;
        }
        myTasks.add(task0);
        return true;
    }

    /**
     * It updates the whole task - project, title, task body and a due date, one by one
     * */
    public boolean updateExistingTask(Task oldTask, Task newTask) {
        int foundPosition = findTask(oldTask);
        if (foundPosition < 0) {
            System.out.println ("Task with a title " + oldTask.getTitle().substring(0, 1).toUpperCase() + oldTask.getTitle().substring(1) + " was not found.");
            return false;
        }

        this.myTasks.set(foundPosition, newTask);
        System.out.println("Task with a title " + oldTask.getTitle().substring(0, 1).toUpperCase() + oldTask.getTitle().substring(1) + " was replaced with " + "a task with a title "
                + newTask.getTitle().substring(0, 1).toUpperCase() + newTask.getTitle().substring(1) + ".");
        return true;
    }

    /**
     * Removes all details about a task completely
     * after it finds a task by its title
     * */
    public boolean removeExistingTask(Task task0) {
        int foundPosition = findTask(task0);
        if (foundPosition < 0) {
            System.out.println ("Task with a title " + task0.getTitle().substring(0, 1).toUpperCase() + task0.getTitle().substring(1) + " was not found.");
            return false;
        }
        this.myTasks.remove(foundPosition);
        System.out.println("Task with a title " + task0.getTitle().substring(0, 1).toUpperCase() + task0.getTitle().substring(1) + " is almost deleted...");
        return true;
    }

    /**
     * Returns an index of a task you´re interested in,
     * so that we can use it in the next method findTask below
     * */
    private int findTask(Task task0) {
        return this.myTasks.indexOf(task0);
    }

    private int findTask(String titleContent) { //finds a task by its title, returning an index
        for (int i=0; i<this.myTasks.size(); i++) {
             Task task0 = this.myTasks.get(i);
             if (task0.getTitle().equals(titleContent)) {
                 return i;
             }
        }
        return -1;
    }

    public String queryTask(Task task0) {
        if (findTask (task0) >= 0) {
            return task0.getTitle();
        }
        return null;
    }

    public Task queryTask(String title) {
        int position = findTask(title);
        if(position >= 0) {
            return this.myTasks.get(position);
        }
        return null;
    }
    //Add for "sorting" so that 1) you show project first, then - title, task body and due date;
    // and also 2) so that to show a due date first, then - project, title and task body).
    // How? Like a switch? And then rearrange how I print out things
    // (in this method now I have only view in order of project, title, task body, due date

    // TODO Connect this method to Reading/Writing files (otherwise it shows only
    // the task made by the first time user
    /**
     * Enables viewing a complete list of tasks after they are entered by a first-time user.
     * */
    public void viewTaskList() {
        if(this.myTasks.size() <= 0) {
            System.out.println("Your list of tasks is empty.");
        } else {
            System.out.println("Here are all your existing tasks:\n");
            for (int i = 0; i < this.myTasks.size(); i++) {
                System.out.println((i + 1) + "." +
                        "Project: " + this.myTasks.get(i).getProject() + " -> " +
                        "Title: " + this.myTasks.get(i).getTitle() + " -> " +
                        "Description: " + this.myTasks.get(i).getTaskBody() + " -> " +
                        "Due date: " + this.myTasks.get(i).getDueDate() + " -> " +
                        "Status: " + this.myTasks.get(i).getIsDone()); // Need to be redone when Writer/Reader is ready
            }
        }
    }




    //public void defaultStatus() {
     //   int i = 0; i < this.myTasks.size(); i++;
     //   while (this.myTasks.get(i).getIsDone() == true) {
     //       System.out.println("not done");
     //   }

    }



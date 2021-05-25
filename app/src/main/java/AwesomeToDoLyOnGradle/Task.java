package AwesomeToDoLyOnGradle;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {

    //fields
    private String project;
    private String title;
    private String taskBody;
    private LocalDate dueDate;
    private boolean isDone;


    // constructor
    public void Task(String project, String title, String taskBody, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (project == null || title == null || taskBody == null || date == null) {
            return;
        }
        this.project = project;
        this.title = title;
        this.taskBody = taskBody;
        this.dueDate = LocalDate.parse(date, formatter);

    }

    public void Task(String project, String title, String taskBody, String date, boolean isDone) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (project == null || title == null || taskBody == null || date == null) {
            return;
        }
        this.project = project;
        this.title = title;
        this.taskBody = taskBody;
        this.dueDate = LocalDate.parse(date, formatter);
        this.isDone = false;

    }

    public String getProject() {
        return project;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskBody() {
        return taskBody;

    }

    public LocalDate getDueDate() {
        return dueDate;

    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) { //true
        this.isDone = isDone;
    }

    @Override
   public String toString() {
   return "\nTask project: " + project + ", Title: " + title +
           ", Description: " + taskBody + ", Due date: " + dueDate +
                ", Status: " + (isDone?"Done.\n":"Not done.\n");
    }

}






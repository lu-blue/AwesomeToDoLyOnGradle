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
    ///to add boolean isDone

    // constructor
    public void Task(String project, String title, String taskBody, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (project == null || title == null || taskBody == null || date == null) {
            return;
        }
        this.project = project;
        this.title = title;
        this.taskBody = taskBody;
        // this.dueDate = dueDate;
        this.dueDate = LocalDate.parse(date, formatter);

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

}

    /* @Override
    public String toString() {
        return "Task project = " + project + " , title = " + title + " , description = " + taskBody + ", due date = " + dueDate", Done = " + isDone;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
*/






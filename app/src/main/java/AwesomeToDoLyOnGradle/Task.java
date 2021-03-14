package AwesomeToDoLyOnGradle;

public class Task {

    //fields
    private String project;
    private String title;
    private String taskBody;
    //to add Date due date
    ///to add boolean isDone

    // constructor
    public void Task(String project, String title, String taskBody) {
        if (project == null || title == null || taskBody == null) {
            return;
        }
        this.title = title;
        this.taskBody = taskBody;
        this.project = project;
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

}

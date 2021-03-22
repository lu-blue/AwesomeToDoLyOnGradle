package AwesomeToDoLyOnGradle;

import java.util.Comparator;

public class ProjectSorter implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getProject().compareToIgnoreCase(o2.getProject());
    }
}

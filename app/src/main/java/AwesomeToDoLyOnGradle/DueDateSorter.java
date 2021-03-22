package AwesomeToDoLyOnGradle;

import java.util.Comparator;

class DueDateSorter implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getDueDate().compareTo(o2.getDueDate()); //why sorts by project alphabetically again?..
    }
}

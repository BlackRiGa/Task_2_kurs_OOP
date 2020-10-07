package vsu.cs.tasks;

import static vsu.cs.tasks.Bathroom.getInstance;
import static vsu.cs.tasks.TextInterface.userInteraction;

public class Main {
    public static void main(String[] args) {
        Bathroom test = getInstance();
        userInteraction(test);
    }
}

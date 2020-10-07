package vsu.cs.tasks;

public class WaterConsumer extends Plumb{     //водопользователь
    int length;
    int width;
    
    public WaterConsumer(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }
}

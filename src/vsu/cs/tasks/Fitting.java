package vsu.cs.tasks;

public class Fitting extends Plumb{
    Type type;

    public Fitting(String name, int inputs, int outputs, Type type){
        super(name);
        this.type = type;
    }
}

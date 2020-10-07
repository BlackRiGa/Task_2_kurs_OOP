package vsu.cs.tasks;

public class Tube extends Plumb{
    Type type;
    int length;
    int diameter;

    public Tube(String name, TubeBuilder builder) throws Exception{
        super(name);

        this.length = builder.length;
        this.diameter = builder.diameter;
        this.type = builder.type;
    }
}

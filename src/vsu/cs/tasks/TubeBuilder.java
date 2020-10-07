package vsu.cs.tasks;

public class TubeBuilder {
    Type type;
    int length;
    int diameter;
    
    public TubeBuilder(){
        this.length = 20;
        this.diameter = 5;
        this.type = Type.PLUMBING;
    }
    
    public TubeBuilder changeLength(int length) throws Exception{
        if(length<=0) throw new Exception("Such pipe doesn't exist. Length<=0");
        this.length = length;
        return this;
    }
    
    public TubeBuilder changeDiameter(int diameter) throws Exception{
        if(diameter<=0) throw new Exception("Such pipe doesn't exist. Diameter<=0");
        this.diameter = diameter;
        return this;
    }
    
    public TubeBuilder changeType(Type type){
        this.type = type;
        return this;
    }
    
}

package me.finnlr.factory.gravityHandler;

public class GravityResult {
    //Info from here https://stackoverflow.com/questions/2832472/how-to-return-2-values-from-a-java-method/2832496

    private final int x;
    private final int y;

    public GravityResult(int x, int y){
        //So two variables can be returned they need to be set here.
        this.x = x;
        this.y = y;
    }

    public int getCalX(){
        return this.x;
    }

    public int getCalY(){
        return this.y;
    }

    @Override
    public String toString() {
        return "GravityResult{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}

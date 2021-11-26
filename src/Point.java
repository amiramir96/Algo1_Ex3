import java.awt.geom.Point2D;

public class Point extends Point2D {
    double _x;
    double _y;

    public Point(double x, double y){
        this._x = x;
        this._y = y;
    }

    @Override
    public double getX() {
        return this._x;
    }

    @Override
    public double getY() {
        return this._y;
    }

    @Override
    public void setLocation(double x, double y) {
        this._x = x;
        this._y = y;
    }

    @Override
    public String toString(){
        return "x cor: "+this._x+" y cod: "+this._y;
    }
}

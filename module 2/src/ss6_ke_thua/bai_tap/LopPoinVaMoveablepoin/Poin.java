package ss6_ke_thua.bai_tap.LopPoinVaMoveablepoin;

public class Poin {
    private float x = 0.0f;
    private float y = 0.0f;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void Point(){

    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        float[] arr = {this.x, this.y};
        return arr;
    }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y +")";
    }
}

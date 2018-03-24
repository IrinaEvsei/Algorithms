package sample;

public class TSPPoint {

    protected int x;
    protected int y;
    protected String id;

    public TSPPoint(int x, int y, String id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s(%d,%d)", id, x, y);
    }

}


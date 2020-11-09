package wk4.model;
public abstract class AbstractVector 
{
    private int size;
    protected AbstractVector(int size)
    {
        this.size  = size;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public abstract String toString();
}
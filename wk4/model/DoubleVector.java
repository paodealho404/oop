package wk4.model;

public class DoubleVector extends AbstractVector{
    protected double vector[];
    public DoubleVector(int size)
    {
        super(size);
        this.vector = new double[getSize()];
    }
    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return super.getSize();
    }
    @Override
    public void setSize(int size) {
        // TODO Auto-generated method stub
        super.setSize(size);
    }
    public DoubleVector vectorAdition(DoubleVector vector){
        DoubleVector result = new DoubleVector(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            result.vector[i] = this.vector[i] + vector.vector[i];
        }
        return result;
    }
    public DoubleVector scalarMultiplication(String x){
        double scalar = Double.parseDouble(x);
        DoubleVector result = new DoubleVector(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            result.vector[i] = this.vector[i] * scalar;
        }
        return result;
    }
    public double scalarProduct(DoubleVector vector)
    {
        DoubleVector result = new DoubleVector(this.getSize());
        double x=0;
        for (int i = 0; i < this.getSize(); i++) {
            x+= result.vector[i] = this.vector[i] * vector.vector[i];
        }
        return x;
    }
    public DoubleVector opositeVector(){
        DoubleVector result = new DoubleVector(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            if(vector[i]==0)result.vector[i] = vector[i];
            else result.vector[i] = -1*vector[i] ;
        }
        return result;
    }
    public boolean areOrtogonal(DoubleVector vector){
        if(scalarProduct(vector) == 0) return true;
        return false;
    }
    public boolean areParallel(DoubleVector vector){
        double x = this.getModulus();
        double y = vector.getModulus();
        double t = scalarProduct(vector);
        if(Math.abs(t/(x*y))==1) return true;
        return false;
    }
    public double getModulus(){
        double x=0;
        for (int i = 0; i < this.getSize(); i++) {
            x+=Math.pow(vector[i], 2);
        }
        x = Math.sqrt(x);
        return x;
    }
    public String toString()
    {
        String result = "{ ";
        for (int i = 0; i < getSize(); i++) {
            result+= Double.toString(vector[i]);
            result+=" ";
        }
        result+="}";
        return result;
    }
    public void insert(double x, int i)
    {
        this.vector[i] = x;
    }


}

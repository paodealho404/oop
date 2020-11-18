package wk4.model;

import wk4.interfacevector.IvectorInt;

public class IntVector extends AbstractVector implements IvectorInt{
    int vector[];
    public IntVector(int size)
    {
        super(size);
        this.vector = new int[getSize()];
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
    public IntVector vectorAdition(IntVector vector){
        IntVector result = new IntVector(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            result.vector[i] = this.vector[i] + vector.vector[i];
        }
        return result;
    }
    public IntVector scalarMultiplication(String x){
        int scalar = Integer.parseInt(x);
        IntVector result = new IntVector(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            result.vector[i] = this.vector[i] * scalar;
        }
        return result;
    }
    public double scalarProduct(IntVector vector)
    {
        double result=0;
        for (int i = 0; i < this.getSize(); i++) {
            result+= this.vector[i] * vector.vector[i];
        }
        return result;
    }
    public IntVector opositeVector(){
        IntVector result = new IntVector(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            result.vector[i] =  -1 * vector[i];
        }
        return result;
    }
    public boolean areOrtogonal(IntVector vector){
        if(scalarProduct(vector) == 0) return true;
        return false;
    }
    public boolean areParallel(IntVector vector){
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
    public String toString(){
        String result = "{ ";
        for (int i = 0; i < getSize(); i++) {
            result+= Integer.toString(vector[i]);
            result+=" ";
        }
        result+="}";
        return result;
    }
    public void insert(int x, int i)
    {
        this.vector[i] = x;
    }


}

package wk4.interface_vector;
import wk4.model.DoubleVector;
public interface IvectorDouble{
    public DoubleVector scalarMultiplication(String x);
    public DoubleVector scalarProduct(DoubleVector vector);
    public DoubleVector vectorAdition(DoubleVector vector);
    public DoubleVector opositeVector();
    public boolean areOrtogonal(DoubleVector vector);
    public boolean areParallel(DoubleVector vector);
    public double getModulus(DoubleVector vector);
}

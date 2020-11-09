package wk4.interface_vector;
import wk4.model.IntVector;
public interface IvectorInt {
    public IntVector scalarMultiplication(String x);
    public IntVector scalarProduct(IntVector vector);
    public IntVector vectorAdition(IntVector vector);
    public IntVector opositeVector();
    public boolean areOrtogonal(IntVector vector);
    public boolean areParallel(IntVector vector);
    public double getModulus(IntVector vector);
}

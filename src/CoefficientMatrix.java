import java.util.*;

class CoefficientMatrix {
    private final double[][] matrix;
    private final double[] constants;
    private final List<String> variables;

    public CoefficientMatrix(List<LinearEquation> equations, Set<String> variableSet) {
        int numEquations = equations.size();
        int numVariables = variableSet.size();

        matrix = new double[numEquations][numVariables];
        constants = new double[numEquations];
        variables = new ArrayList<>(variableSet);

        for (int i = 0; i < numEquations; i++) {
            LinearEquation eq = equations.get(i);
            Map<String, Double> coeffs = eq.getCoefficients();

            for (int j = 0; j < numVariables; j++) {
                String var = variables.get(j);
                matrix[i][j] = coeffs.getOrDefault(var, 0.0); // Default to 0 if variable is missing
            }
            constants[i] = eq.getConstant();
        }
    }

    // Getter methods
    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getConstants() {
        return constants;
    }

    public List<String> getVariables() {
        return variables;
    }
    public void printMatrix() {
        System.out.println("Coefficient Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.printf(" | %8.2f\n", constants[i]);
        }
        System.out.println();
    }
}

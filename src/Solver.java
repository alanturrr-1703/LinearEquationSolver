class Solver {
    private double[][] matrix;  // Coefficient matrix
    private double[] constants; // Right-hand side values
    private int size;           // Number of equations/variables

    public Solver(CoefficientMatrix coefficientMatrix) {
        this.matrix = coefficientMatrix.getMatrix();
        this.constants = coefficientMatrix.getConstants();
        this.size = matrix.length;
    }

    public double[] solve() {
        forwardElimination();
        return backSubstitution();
    }

    private void forwardElimination() {
        for (int pivot = 0; pivot < size; pivot++) {
            // Find the maximum row to swap with (for numerical stability)
            int maxRow = pivot;
            for (int i = pivot + 1; i < size; i++) {
                if (Math.abs(matrix[i][pivot]) > Math.abs(matrix[maxRow][pivot])) {
                    maxRow = i;
                }
            }
            swapRows(pivot, maxRow);

            // Check for no solution (zero row with nonzero constant)
            if (isZeroRow(matrix[pivot]) && constants[pivot] != 0) {
                throw new ArithmeticException("No solution exists! (Inconsistent system)");
            }

            // Check for infinite solutions (zero row with zero constant)
            if (isZeroRow(matrix[pivot]) && constants[pivot] == 0) {
                throw new ArithmeticException("Infinite solutions exist! (Dependent equations)");
            }

            // Make pivot element 1
            double pivotValue = matrix[pivot][pivot];
            if (pivotValue == 0) continue; // Skip already zeroed rows
            for (int j = pivot; j < size; j++) {
                matrix[pivot][j] /= pivotValue;
            }
            constants[pivot] /= pivotValue;

            // Eliminate lower rows
            for (int i = pivot + 1; i < size; i++) {
                double factor = matrix[i][pivot];
                for (int j = pivot; j < size; j++) {
                    matrix[i][j] -= factor * matrix[pivot][j];
                }
                constants[i] -= factor * constants[pivot];
            }
        }
    }

    private double[] backSubstitution() {
        double[] solution = new double[size];

        for (int i = size - 1; i >= 0; i--) {
            solution[i] = constants[i];
            for (int j = i + 1; j < size; j++) {
                solution[i] -= matrix[i][j] * solution[j];
            }
        }
        return solution;
    }

    private void swapRows(int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;

        double tempConst = constants[row1];
        constants[row1] = constants[row2];
        constants[row2] = tempConst;
    }

    private boolean isZeroRow(double[] row) {
        for (double val : row) {
            if (val != 0) return false;
        }
        return true;
    }
}

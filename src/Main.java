import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the number of variables
        System.out.print("Enter the number of variables: ");
        int numVariables = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Set<String> variables = new LinkedHashSet<>();
        List<LinearEquation> equations = new ArrayList<>();

        // Step 2: Input equations
        System.out.println("Enter your equations (Example: 2x + 3y - z = 5):");
        for (int i = 0; i < numVariables; i++) {
            System.out.print("Equation " + (i + 1) + ": ");
            String equation = scanner.nextLine();
            equations.add(new LinearEquation(equation, variables));
        }

        // Step 3: Convert to coefficient matrix
        CoefficientMatrix matrix = new CoefficientMatrix(equations, variables);

        // Display coefficient matrix
        matrix.printMatrix();

        // Step 4: Solve the system
        try {
            Solver solver = new Solver(matrix);
            double[] solution = solver.solve();
            List<String> variableList = matrix.getVariables();

            System.out.println("\nSolution:");
            for (int i = 0; i < solution.length; i++) {
                System.out.println(variableList.get(i) + " = " + solution[i]);
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

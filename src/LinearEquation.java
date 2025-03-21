import java.util.*;
import java.util.regex.*;

class LinearEquation {
    private Map<String, Double> coefficients; // Variable -> Coefficient
    private double constant; // Right-hand side constant

    public LinearEquation(String equation, Set<String> variableSet) {
        coefficients = new HashMap<>();
        this.constant = 0.0;
        parseEquation(equation, variableSet);
    }

    private void parseEquation(String equation, Set<String> variableSet) {
        equation = equation.replaceAll("\\s+", ""); // Remove spaces

        // Split at '='
        String[] sides = equation.split("=");
        if (sides.length != 2) throw new IllegalArgumentException("Invalid equation format");

        String leftSide = sides[0];
        this.constant = Double.parseDouble(sides[1]); // Right-hand side is the constant

        // Regex pattern: Match coefficients with variables (e.g., "3x1", "-2y", "z")
        Pattern pattern = Pattern.compile("([-+]?[0-9]*\\.?[0-9]*)?([a-zA-Z][a-zA-Z0-9]*)");
        Matcher matcher = pattern.matcher(leftSide);

        while (matcher.find()) {
            String coeffStr = matcher.group(1); // Coefficient part
            String variable = matcher.group(2); // Variable name

            double coefficient = (coeffStr == null || coeffStr.equals("+")) ? 1 :
                    (coeffStr.equals("-")) ? -1 :
                            Double.parseDouble(coeffStr);

            coefficients.put(variable, coefficient);
            variableSet.add(variable); // Store all encountered variable names
        }
    }

    public Map<String, Double> getCoefficients() {
        return coefficients;
    }

    public double getConstant() {
        return constant;
    }
}

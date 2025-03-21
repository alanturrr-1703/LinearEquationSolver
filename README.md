# Linear Equation Solver in Java

## 🚀 Overview
This project is a **Linear Equation Solver** built in Java from scratch. It allows users to enter a system of linear equations and solves it using **Gaussian Elimination**. The solver supports:

✔️ **Parsing mathematical equations** (e.g., `2x + 3y - z = 5`)
✔️ **Dynamic variable detection** (supports `x, y, z` or `x1, x2, x3` for large systems)
✔️ **Error handling for infinite/no solutions**
✔️ **Matrix representation for better visualization**
✔️ **Object-Oriented Design** for clean, modular code

---

## 📌 Features
- **Interactive User Input**: Supports `n` equations with `n` variables.
- **Gaussian Elimination**: Converts the system into an upper-triangular matrix and applies **back-substitution**.
- **Smart Variable Handling**: Detects unique variable names (e.g., `x1, x2, y, z` instead of just `x, y, z`).
- **Error Detection**:
  - `No Solution` when equations are contradictory.
  - `Infinite Solutions` when equations are dependent.
- **Easy to Use**: Just run the program, enter the equations, and get the solution instantly!

---

## 🛠️ Installation & Setup
### Prerequisites
- Java 8 or higher

### Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/LinearEquationSolver.git
   cd LinearEquationSolver
   ```
2. Compile the program:
   ```sh
   javac Main.java
   ```
3. Run the solver:
   ```sh
   java Main
   ```

---

## 🔢 How It Works
### Example Input
```
Enter the number of variables: 3
Enter your equations (Example: 2x + 3y - z = 5):
Equation 1: 2x + 3y - z = 5
Equation 2: 4x - y + 2z = 6
Equation 3: -x + 2y + 3z = 2
```

### Matrix Representation
```
Coefficient Matrix:
|  2  3  -1 |  5  |
|  4 -1   2 |  6  |
| -1  2   3 |  2  |
```

### Output Solution
```
x = 1.0
y = 2.0
z = 3.0
```

### Error Handling Examples
#### ❌ No Solution (Contradictory Equations)
```
Equation 1: x + y = 5
Equation 2: x + y = 10

Error: No solution exists! (Inconsistent system)
```
#### ♾️ Infinite Solutions (Dependent Equations)
```
Equation 1: x + y = 5
Equation 2: 2x + 2y = 10

Error: Infinite solutions exist! (Dependent equations)
```

---

## 📂 Project Structure
```
📦 LinearEquationSolver
 ┣ 📜 Main.java            # Handles user input and displays results
 ┣ 📜 LinearEquation.java   # Parses equations into variables & coefficients
 ┣ 📜 CoefficientMatrix.java # Converts parsed data into a matrix
 ┣ 📜 Solver.java           # Implements Gaussian Elimination
 ┗ 📜 README.md            # Project documentation
```

---

## 📝 Future Improvements
- ✅ Support for fractional coefficients
- ✅ GUI version using JavaFX
- ✅ File input/output for batch processing

---

## 🏆 Credits
Developed by **Harshit Thakkar** 🚀

If you find this project helpful, feel free to ⭐ star the repo! 😊


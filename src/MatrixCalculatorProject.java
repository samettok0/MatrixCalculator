import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;

public class MatrixCalculatorProject {
    // Constants for matrix limits
    private static final int MAX_ROWS_AND_COLUMNS = 5;  // Maximum size for matrices
    private static final int MIN_ROWS_AND_COLUMNS = 1;  // Minimum size for matrices
    private static final double MAX_MATRIX_VALUE = 1e10;  // Maximum allowed value in matrix
    private static final double MIN_MATRIX_VALUE = -1e10;  // Minimum allowed value in matrix
    private static final double PRECISION_WARNING_THRESHOLD = 1e8;  // Threshold for large number warnings
    private static final double PRECISION_WARNING_THRESHOLD_SMALL = 1e-8;  // Threshold for small number warnings

    // This is a Java program that performs various matrix operations such as addition, subtraction, multiplication, scalar division, scalar multiplication, transpose, inverse, trace, adjoint, and orthogonality check.
    // The program allows the user to input matrices and choose the desired operation from a menu.

    // Main method to run the program
    // It contains a menu for the user to select the desired matrix operation.
  
  public static void main(String[] args) {  

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for user input
        int choice = 0;  // Initialize choice to 0
        double[][] matrix1;
        double[][] matrix2;
        double[][] result;
        double scalarValue;
        int rows, columns;  // Move declarations here

        displayName();


        do {  // Start a do-while loop to keep the program running
          
            displayMenu();  // Call the displayMenu method to show the menu options
            
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 12) {
                    System.out.println("\nError: Invalid choice. Please enter a number between 1 and 12.");
                    scanner.nextLine(); // Clear the invalid input
                    continue;
                }
            } catch (Exception e) {
                System.out.println("\nError: Invalid input. Please enter a number between 1 and 12.");
                System.out.println("Note: Alphabetic characters (a, b, c, etc.) are not allowed.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {  // Start a switch statement based on the user's choice
                case 1:
                    clearScreen();
                    System.out.print("\nMATRIX ADDITION\n\n");
                    System.out.println("Matrix Addition is the process of adding two or more matrices by summing their corresponding elements.\nWhen adding two matrices, you add the elements at the same positions to create a new matrix.\nBoth input matrices must have the same dimensions, meaning that the number of rows and columns in the first matrix should match the number of rows and columns in the second matrix.\n\n");
                    
                    // First get dimensions for both matrices
                    System.out.println("Enter dimensions for both matrices:");
                    System.out.print("Enter the number of rows (" + MIN_ROWS_AND_COLUMNS + "-" + MAX_ROWS_AND_COLUMNS + "): ");
                    rows = scanner.nextInt();
                    System.out.print("Enter the number of columns (" + MIN_ROWS_AND_COLUMNS + "-" + MAX_ROWS_AND_COLUMNS + "): ");
                    columns = scanner.nextInt();
                    
                    if (rows < MIN_ROWS_AND_COLUMNS || rows > MAX_ROWS_AND_COLUMNS || 
                        columns < MIN_ROWS_AND_COLUMNS || columns > MAX_ROWS_AND_COLUMNS) {
                        System.out.println("Error: Invalid dimensions. Please enter numbers between " + MIN_ROWS_AND_COLUMNS + " and " + MAX_ROWS_AND_COLUMNS);
                        break;
                    }
                    
                    System.out.println("\nEnter details for the first matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, rows, columns);
                    
                    System.out.println("\nEnter details for the second matrix: \n");
                    matrix2 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, rows, columns);
                    
                    System.out.println("\nMatrix-1:\n");
                    printMatrix(matrix1);
                    System.out.println("\n\nMatrix-2:\n");
                    printMatrix(matrix2);

                    result = addMatrices(matrix1, matrix2);
                    if (result != null) {
                      System.out.println("\nProceeding...\n\nThis is result:\n");
                      printMatrix(result);
                    }
                    break;
                    //Adding Matrices
                case 2:
                	System.out.print("\nMATRIX SUBTRACTION\n\n");
                	System.out.println("Matrix Subtraction is the process of subtracting one matrix from another by subtracting their corresponding elements.\nWhen subtracting one matrix from another, you subtract the elements at the same positions to create a new matrix.\nBoth input matrices must have the same dimensions, meaning that the number of rows and columns in the first matrix should match the number of rows and columns in the second matrix.");
                    System.out.println("\nEnter dimensions for both matrices:");
                    System.out.print("Enter the number of rows (1-" + MAX_ROWS_AND_COLUMNS + "): ");
                    rows = scanner.nextInt();
                    System.out.print("Enter the number of columns (1-" + MAX_ROWS_AND_COLUMNS + "): ");
                    columns = scanner.nextInt();
                    
                    if (rows <= 0 || rows > MAX_ROWS_AND_COLUMNS || columns <= 0 || columns > MAX_ROWS_AND_COLUMNS) {
                        System.out.println("Invalid dimensions. Please enter positive numbers between 1 and " + MAX_ROWS_AND_COLUMNS);
                        break;
                    }
                    
                    System.out.println("\nEnter details for the first matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, rows, columns);
                        
                    System.out.println("\nEnter details for the second matrix: \n");
                    matrix2 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, rows, columns);
                    
                    System.out.println("\nMatrix-1:\n");
                    printMatrix(matrix1);
                    System.out.println("\n\nMatrix-2:\n");
                    printMatrix(matrix2);

                    result = subtractMatrices(matrix1, matrix2);
                    if (result != null) {
                      System.out.println("\nProceeding...\n\nThis is result: ");
                      printMatrix(result);
                    }
                    break;
                    //Subtracting Matrices
                case 3:
                	System.out.println("\nMATRIX MULTIPLICATION\n\n");
                	System.out.println("Matrix Multiplication is the process of multiplying two matrices to obtain a new matrix.\nTo multiply two matrices, the number of columns in the first matrix must be equal to the number of rows in the second matrix.");
                    
                    System.out.println("\nEnter dimensions for the first matrix:");
                    System.out.print("Enter the number of rows (1-" + MAX_ROWS_AND_COLUMNS + "): ");
                    int rows1 = scanner.nextInt();
                    System.out.print("Enter the number of columns (1-" + MAX_ROWS_AND_COLUMNS + "): ");
                    int columns1 = scanner.nextInt();
                    
                    System.out.println("\nEnter dimensions for the second matrix:");
                    System.out.print("Enter the number of rows (1-" + MAX_ROWS_AND_COLUMNS + "): ");
                    int rows2 = scanner.nextInt();
                    System.out.print("Enter the number of columns (1-" + MAX_ROWS_AND_COLUMNS + "): ");
                    int columns2 = scanner.nextInt();
                    
                    if (rows1 <= 0 || rows1 > MAX_ROWS_AND_COLUMNS || columns1 <= 0 || columns1 > MAX_ROWS_AND_COLUMNS ||
                        rows2 <= 0 || rows2 > MAX_ROWS_AND_COLUMNS || columns2 <= 0 || columns2 > MAX_ROWS_AND_COLUMNS) {
                        System.out.println("Invalid dimensions. Please enter positive numbers between 1 and " + MAX_ROWS_AND_COLUMNS);
                        break;
                    }
                    
                    if (columns1 != rows2) {
                        System.out.println("Error: Number of columns in first matrix must equal number of rows in second matrix for multiplication.");
                        break;
                    }
                    
                    System.out.println("\nEnter details for the first matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, rows1, columns1);
                        
                    System.out.println("\nEnter details for the second matrix: \n");
                    matrix2 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, rows2, columns2);
                    
                    System.out.println("\nMatrix-1:\n");
                    printMatrix(matrix1);
                    System.out.println("\n\nMatrix-2:\n");
                    printMatrix(matrix2);

                    result = multiplyMatrices(matrix1, matrix2);
                    if (result != null) {
                      System.out.println("\nProceeding...\n\nThis is result: ");
                      printMatrix(result);
                    }
                    break;
                    //Multiplication of Matrices
                case 4:
                	System.out.println("\nSCALAR DIVISION OF THE MATRIX\n");
                	System.out.println("Matrix division by a scalar (scalar division) is the process of dividing every element in a matrix by a scalar (a single number). ");
                    System.out.println("\nEnter details for the matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, 0, 0);
                    
                    System.out.print("Enter the scalar value: ");
                    scalarValue = scanner.nextDouble();
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    System.out.println("\nScalar Value:\n");
                    System.out.printf("%f",scalarValue);
                    
                    if (scalarValue != 0) {
                      result = scalarDivision(matrix1, scalarValue);
                      System.out.println("\nProceeding...\n\nThis is result: ");
                      printMatrix(result);
                    }
                    else {
                      System.out.println("Error: Division by zero is not allowed.");
                    }
                    //Scalar Division of the Matrix
                    break;
                case 5:
                    System.out.println("\nSCALAR MULTIPLICATION OF THE MATRIX\n");
                    System.out.println("Scalar Multiplication is the process of multiplying a matrix by a scalar value.");
                	
                    System.out.println("\nEnter details for the matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, 0, 0);

                    System.out.print("Enter the scalar value: ");
                    scalarValue = scanner.nextDouble();
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    System.out.println("\nScalar Value:\n");
                    System.out.printf("%f",scalarValue);
                    
                    
                    result = scalarMultiply(matrix1, scalarValue);
                    System.out.println("\nProceeding...\n\nThis is result: ");
                    printMatrix(result);
                    
                    //Scalar Multiplication of the Matrix
                    break;
                case 6:
                	System.out.println("\nTRANSPOSE OF THE MATRIX\n");
                	System.out.println("The transpose of a matrix is a new matrix that is obtained by interchanging its rows and columns.");
                	
                    System.out.println("\nEnter details for the matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, 0, 0);
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    result = transposeMatrix(matrix1);
                    System.out.println("\nProceeding...\n\nThis is result: ");
                    printMatrix(result);
                    //Transpose of the Matrix
                    break;
                case 7:
                	System.out.println("\nINVERSE OF THE MATRIX\n");
                	System.out.println("The inverse of a square matrix, denoted as A^(-1), is a matrix that, when multiplied by the original matrix A, yields the identity matrix (I). It is used to \"undo\" the effects of the original matrix in various mathematical and computational applications.");
                    System.out.println("""
                            The matrix must be square (having the same number of rows and columns).\r
                            \r
                            The determinant of the matrix must be nonzero. If the determinant is zero, the matrix is said to be singular, and it does not have an inverse.""");
                	
                	System.out.println("\nEnter details for the matrix: \n");
                	
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, 0, 0);
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    result = findInverse(matrix1);
                    if (result != null) {
                        System.out.println("Inverse of the matrix:");
                        printMatrix(result);
                    }
                    //Inverse of the Matrix
                    break;
                case 8:
                	clearScreen();
                	System.out.println("\nTRACE OF THE MATRIX\n");
                	System.out.println("The trace of a matrix is the sum of the elements on its main diagonal, which are the elements that run from the top-left corner to the bottom-right corner of the matrix. \nThe given matrix must be square!");
                    
                	System.out.println("\nEnter details for the matrix:");
                    
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, 0, 0);
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    if (calculateTrace(matrix1) != null) {
                      System.out.println("\nProceeding...\n\nThis is result: ");
                      System.out.printf("%f", calculateTrace(matrix1));
                    }
                    //Trace of the Matrix
                    break;
                case 9:
                	System.out.println("\nADJOINT OF THE MATRIX\n");
                	System.out.println("The adjoint of a square matrix is a matrix formed by taking the transpose of its cofactor matrix. It's used to find the inverse of a matrix when it exists. If you have a square matrix A, the adjoint is denoted as adj(A).");
                    
                	System.out.println("\nEnter details for the matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, 0, 0);
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    result = calculateAdjoint(matrix1);
                    if (result != null) {
                        System.out.println("Adjoint of the matrix:");
                        printMatrix(result);
                    }
                    //Adjoint of the Matrix
                    break;
                case 10:
                	System.out.println("\nCHECK MATRIX FOR ORTHOGONALITY\n");
                	System.out.println("To check a matrix for orthogonality, ensure its column vectors are both linearly independent and mutually orthogonal. One way to understan if matrix is orthogonal is if the matrix's transpose and inverse are equal.");
                	System.out.println("Matrix given must be squate to have orthogonality!");
                    System.out.println("\nEnter details for the matrix: \n");
                    matrix1 = inputMatrix(scanner, MAX_ROWS_AND_COLUMNS, 0, 0);
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    boolean result1 = isOrthogonalMatrix(matrix1);
                  if (result1) {
                    System.out.println("The matrix given is orthogonal.");
                  }
                  else {
                    System.out.println("The matrix given is not orthogonal.");
                  }
                    //Check Matrix for Orthogonality
                    break;
                case 11:
                    OperationHistory.displayHistory();
                    break;
                case 12:
                    System.out.println("Terminating the program.");
                    // Display message indicating program termination
                    break;
                default:
                    // Remove the default case since we handle invalid input in the try-catch block
                    break;
            }

            if (choice != 12) {
                System.out.print("\nPress Enter to return to the menu...");
                scanner.nextLine(); // the newline character
                scanner.nextLine(); // Wait for the user to choose
            }
        } while (choice != 12);  // Continue the loop until the user selects Terminate

  }
  
    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            handleMatrixError("Matrix Addition", "One or both matrices are null", 
                "This can happen if matrix input was interrupted or failed.");
            return null;
        }
        
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            handleMatrixError("Matrix Addition", "Matrix dimensions are incompatible", 
                "For matrix addition, both matrices must have the same dimensions.\n" +
                "Matrix1: " + matrix1.length + "x" + matrix1[0].length + "\n" +
                "Matrix2: " + matrix2.length + "x" + matrix2[0].length);
            return null;
        }

        // Check for special matrix types
        if (isZeroMatrix(matrix1) || isZeroMatrix(matrix2)) {
            handleMatrixWarning("Matrix Addition", "One or both matrices are zero matrices", 
                "Adding with zero matrices may not be necessary.");
        }

        int rows = matrix1.length;
        int columns = matrix1[0].length;
        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
                if (Math.abs(result[i][j]) > MAX_MATRIX_VALUE) {
                    handleMatrixWarning("Matrix Addition", "Result exceeds maximum allowed value", 
                        "This may lead to precision issues in calculations.");
                }
            }
        }

        handleMatrixSuccess("Matrix Addition", 
            "Added " + rows + "x" + columns + " matrices");
        return result;
    }
    
    public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            System.out.println("Error: One or both matrices are null.");
            System.out.println("Note: This can happen if matrix input was interrupted or failed.");
            return null;
        }
        
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Error: Matrix dimensions are incompatible for subtraction.");
            System.out.println("Note: For matrix subtraction, both matrices must have the same dimensions.");
            System.out.println("      Matrix1: " + matrix1.length + "x" + matrix1[0].length);
            System.out.println("      Matrix2: " + matrix2.length + "x" + matrix2[0].length);
            return null;
        }

        int rows = matrix1.length;
        int columns = matrix1[0].length;
        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
                // Check for overflow in subtraction
                if (Math.abs(result[i][j]) > MAX_MATRIX_VALUE) {
                    System.out.println("Warning: Result exceeds maximum allowed value.");
                    System.out.println("Note: This may lead to precision issues in calculations.");
                }
            }
        }
        return result;
    }
    
    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            handleMatrixError("Matrix Multiplication", "One or both matrices are null", 
                "This can happen if matrix input was interrupted or failed.");
            return null;
        }
        
        if (matrix1[0].length != matrix2.length) {
            handleMatrixError("Matrix Multiplication", "Matrix dimensions are incompatible", 
                "For matrix multiplication, the number of columns in the first matrix\n" +
                "must equal the number of rows in the second matrix.\n" +
                "Matrix1: " + matrix1.length + "x" + matrix1[0].length + "\n" +
                "Matrix2: " + matrix2.length + "x" + matrix2[0].length);
            return null;
        }

        // Check for special matrix types
        if (isZeroMatrix(matrix1) || isZeroMatrix(matrix2)) {
            handleMatrixWarning("Matrix Multiplication", "One or both matrices are zero matrices", 
                "Multiplying with zero matrices will result in a zero matrix.");
        }
        if (isIdentityMatrix(matrix1)) {
            handleMatrixWarning("Matrix Multiplication", "First matrix is an identity matrix", 
                "Multiplying with identity matrix will return the second matrix unchanged.");
        }
        if (isIdentityMatrix(matrix2)) {
            handleMatrixWarning("Matrix Multiplication", "Second matrix is an identity matrix", 
                "Multiplying with identity matrix will return the first matrix unchanged.");
        }

        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;

        // Use Strassen's algorithm for large matrices
        if (rows1 > 2 && columns1 > 2 && columns2 > 2) {
            handleMatrixWarning("Matrix Multiplication", "Using Strassen's algorithm", 
                "This algorithm is more efficient for large matrices.");
            return strassenMultiply(matrix1, matrix2);
        }

        // Use standard multiplication for small matrices
        double[][] result = new double[rows1][columns2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    if (Math.abs(result[i][j]) > MAX_MATRIX_VALUE) {
                        handleMatrixWarning("Matrix Multiplication", "Result exceeds maximum allowed value", 
                            "This may lead to precision issues in calculations.");
                    }
                }
            }
        }

        handleMatrixSuccess("Matrix Multiplication", 
            "Multiplied " + rows1 + "x" + columns1 + " with " + columns1 + "x" + columns2 + " matrices");
        return result;
    }

    public static double[][] scalarDivision(double[][] matrix, double scalar) {
        if (matrix == null) {
            System.out.println("Error: Matrix is null.");
            System.out.println("Note: This can happen if matrix input was interrupted or failed.");
            return null;
        }
        
        if (Math.abs(scalar) < PRECISION_WARNING_THRESHOLD_SMALL) {
            System.out.println("Error: Division by zero or very small number is not allowed.");
            System.out.println("Note: Very small divisors can lead to numerical instability.");
            return null;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] / scalar;
                // Check for overflow in division
                if (Math.abs(result[i][j]) > MAX_MATRIX_VALUE) {
                    System.out.println("Warning: Result exceeds maximum allowed value.");
                    System.out.println("Note: This may lead to precision issues in calculations.");
                }
            }
        }
        return result;
    }

    // Helper method for common matrix validations
    private static boolean validateMatrix(double[][] matrix, String operation) {
        if (matrix == null) {
            System.out.println("Error: Matrix is null.");
            System.out.println("Note: This can happen if matrix input was interrupted or failed.");
            return false;
        }
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Error: Matrix dimensions are invalid.");
            return false;
        }
        return true;
    }

    public static double[][] scalarMultiply(double[][] matrix, double scalar) {
        if (!validateMatrix(matrix, "Scalar Multiplication")) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        return result;
    }

    public static double[][] findInverse(double[][] matrix) {
        if (matrix == null) {
            handleMatrixError("Matrix Inverse", "Matrix is null", 
                "This can happen if matrix input was interrupted or failed.");
            return null;
        }
        
        if (!isSquare(matrix)) {
            handleMatrixError("Matrix Inverse", "Matrix must be square", 
                "Square matrices have equal number of rows and columns.");
            return null;
        }

        // Check for special matrix types
        if (isIdentityMatrix(matrix)) {
            handleMatrixWarning("Matrix Inverse", "Matrix is an identity matrix", 
                "The inverse of an identity matrix is itself.");
        }
        if (isDiagonal(matrix)) {
            handleMatrixWarning("Matrix Inverse", "Matrix is diagonal", 
                "Using optimized inverse calculation for diagonal matrix.");
            return findInverseDiagonal(matrix);
        }
        if (isUpperTriangular(matrix) || isLowerTriangular(matrix)) {
            handleMatrixWarning("Matrix Inverse", "Matrix is triangular", 
                "Using optimized inverse calculation for triangular matrix.");
        }

        double determinant = calculateDeterminant(matrix);
        if (Math.abs(determinant) < PRECISION_WARNING_THRESHOLD_SMALL) {
            handleMatrixError("Matrix Inverse", "Matrix is singular", 
                "Singular matrices (determinant is zero or very close to zero) cannot be inverted.");
            return null;
        }

        double[][] adjoint = calculateAdjoint(matrix);
        if (adjoint == null) {
            return null;
        }

        int size = matrix.length;
        double[][] inverse = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inverse[i][j] = adjoint[i][j] / determinant;
                if (Math.abs(inverse[i][j]) > MAX_MATRIX_VALUE) {
                    handleMatrixWarning("Matrix Inverse", "Inverse matrix contains very large values", 
                        "This may indicate numerical instability.");
                }
            }
        }

        handleMatrixSuccess("Matrix Inverse", 
            "Calculated inverse of " + size + "x" + size + " matrix");
        return inverse;
    }

    // Optimized inverse calculation for diagonal matrices
    private static double[][] findInverseDiagonal(double[][] matrix) {
        int size = matrix.length;
        double[][] inverse = new double[size][size];
        
        for (int i = 0; i < size; i++) {
            if (Math.abs(matrix[i][i]) < PRECISION_WARNING_THRESHOLD_SMALL) {
                System.out.println("Error: Matrix has zero or very small diagonal elements.");
                System.out.println("Note: Diagonal matrices with zero elements cannot be inverted.");
                return null;
            }
            inverse[i][i] = 1.0 / matrix[i][i];
        }
        
        return inverse;
    }

    public static double calculateDeterminant(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Error: Matrix is null.");
            return 0;
        }
        
        if (!isSquare(matrix)) {
            System.out.println("Error: Matrix must be square to calculate determinant.");
            return 0;
        }

        int size = matrix.length;
        if (size == 1) {
            return matrix[0][0];
        }
        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // Use LU decomposition for large matrices
        if (size > 3) {
            System.out.println("Note: Using LU decomposition for large matrix determinant calculation.");
            return calculateDeterminantLU(matrix);
        }

        // Use cofactor expansion for small matrices
        double determinant = 0;
        for (int j = 0; j < size; j++) {
            double[][] subMatrix = getSubMatrix(matrix, 0, j);
            if (subMatrix != null) {
                determinant += matrix[0][j] * Math.pow(-1, j) * calculateDeterminant(subMatrix);
            }
        }
        return determinant;
    }

    public static double[][] getSubMatrix(double[][] matrix, int row, int col) {
        if (matrix == null) {
            return null;
        }
        
        int size = matrix.length;
        if (size <= 1) {
            return null;
        }

        double[][] subMatrix = new double[size - 1][size - 1];
        int subRow = 0;
        int subCol;

        for (int i = 0; i < size; i++) {
            if (i == row) continue;
            subCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == col) continue;
                subMatrix[subRow][subCol] = matrix[i][j];
                subCol++;
            }
            subRow++;
        }

        return subMatrix;
    }

    public static Double calculateTrace(double [][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
          System.out.println("Input is not a square matrix.");
          return null;
      }
  
      double trace = 0;
      for (int i = 0; i < matrix.length; i++) {
          trace += matrix[i][i]; // Sum the diagonal elements
      }
  
      return trace;
    }
    
    public static double[][] transposeMatrix(double[][] matrix) {
        if (!validateMatrix(matrix, "Matrix Transpose")) {
            return null;
        }
     
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        double[][] result = new double[numCols][numRows];

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static double[][] calculateAdjoint(double[][] matrix) {
        if (!isSquare(matrix)) {
            System.out.println("Error: Matrix must be square to calculate adjoint.");
            System.out.println("Note: Square matrices have equal number of rows and columns.");
            return null;
        }

        if (isDiagonal(matrix)) {
            System.out.println("Note: Matrix is diagonal. Using optimized adjoint calculation.");
            return calculateAdjointDiagonal(matrix);
        }

        int n = matrix.length;
        double[][] adjoint = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] subMatrix = getSubMatrix(matrix, i, j);
                double cofactor = Math.pow(-1, i + j) * calculateDeterminant(subMatrix);
                adjoint[i][j] = cofactor;
            }
        }

        return transposeMatrix(adjoint);
    }

    // Optimized adjoint calculation for diagonal matrices
    private static double[][] calculateAdjointDiagonal(double[][] matrix) {
        int size = matrix.length;
        double[][] adjoint = new double[size][size];
        
        for (int i = 0; i < size; i++) {
            double product = 1.0;
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    product *= matrix[j][j];
                }
            }
            adjoint[i][i] = product;
        }
        
        return adjoint;
    }

    public static boolean isOrthogonalMatrix(double[][] matrix) {
        if (!isSquare(matrix)) {
            System.out.println("Error: Matrix must be square to check for orthogonality.");
            System.out.println("Note: Square matrices have equal number of rows and columns.");
            return false;
        }

        if (isDiagonal(matrix)) {
            System.out.println("Note: Matrix is diagonal. Using optimized orthogonality check.");
            return isOrthogonalDiagonal(matrix);
        }

        double[][] transposedMatrix = transposeMatrix(matrix);
        double[][] inverseMatrix = findInverse(matrix);
        
        if (inverseMatrix == null) {
            return false;
        }

        // Check if the transpose and the inverse are equal
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                assert transposedMatrix != null;
                if (Math.abs(transposedMatrix[i][j] - inverseMatrix[i][j]) > PRECISION_WARNING_THRESHOLD_SMALL) {
                    return false;
                }
            }
        }

        return true;
    }

    // Optimized orthogonality check for diagonal matrices
    private static boolean isOrthogonalDiagonal(double[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            if (Math.abs(matrix[i][i] * matrix[i][i] - 1.0) > PRECISION_WARNING_THRESHOLD_SMALL) {
                return false;
            }
        }
        return true;
    }
    
    public static double[][] inputMatrix(Scanner scanner, int maxRowsAndColumns, int requiredRows, int requiredColumns) {
        int rows, columns;
        double[][] matrix;

        if (requiredRows > 0 && requiredColumns > 0) {
            // If dimensions are provided, use them
            rows = requiredRows;
            columns = requiredColumns;
        } else {
            // Otherwise, ask for dimensions
            do {
                System.out.print("Enter the number of rows (" + MIN_ROWS_AND_COLUMNS + "-" + maxRowsAndColumns + "): ");
                try {
                    String input = scanner.next();
                    
                    // Check if input contains alphabetic characters
                    if (input.matches(".*[a-zA-Z].*")) {
                        System.out.println("Error: Invalid input. Alphabetic characters are not allowed.");
                        System.out.println("Note: Please enter only numbers (e.g., 1, 2, 3)");
                        scanner.nextLine(); // Clear the invalid input
                        rows = -1; // Set to invalid value to continue the loop
                        continue;
                    }
                    
                    // Try to parse as double first to catch decimal numbers
                    double decimalValue = Double.parseDouble(input);
                    if (decimalValue != Math.floor(decimalValue)) {
                        System.out.println("Error: Decimal numbers are not allowed for matrix dimensions.");
                        System.out.println("Note: Please enter only whole numbers (e.g., 1, 2, 3)");
                        scanner.nextLine(); // Clear the invalid input
                        rows = -1; // Set to invalid value to continue the loop
                        continue;
                    }
                    
                    rows = (int) decimalValue;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                    System.out.println("Note: Please enter only whole numbers (e.g., 1, 2, 3)");
                    scanner.nextLine(); // Clear the invalid input
                    rows = -1; // Set to invalid value to continue the loop
                }
                if (rows < MIN_ROWS_AND_COLUMNS || rows > maxRowsAndColumns) {
                    System.out.println("Error: Invalid number of rows. Please enter a number between " + MIN_ROWS_AND_COLUMNS + " and " + maxRowsAndColumns);
                    System.out.println("Note: Larger matrices may cause memory issues and calculation errors.");
                }
            } while (rows < MIN_ROWS_AND_COLUMNS || rows > maxRowsAndColumns);

            do {
                System.out.print("Enter the number of columns (" + MIN_ROWS_AND_COLUMNS + "-" + maxRowsAndColumns + "): ");
                try {
                    String input = scanner.next();
                    
                    // Check if input contains alphabetic characters
                    if (input.matches(".*[a-zA-Z].*")) {
                        System.out.println("Error: Invalid input. Alphabetic characters are not allowed.");
                        System.out.println("Note: Please enter only numbers (e.g., 1, 2, 3)");
                        scanner.nextLine(); // Clear the invalid input
                        columns = -1; // Set to invalid value to continue the loop
                        continue;
                    }
                    
                    // Try to parse as double first to catch decimal numbers
                    double decimalValue = Double.parseDouble(input);
                    if (decimalValue != Math.floor(decimalValue)) {
                        System.out.println("Error: Decimal numbers are not allowed for matrix dimensions.");
                        System.out.println("Note: Please enter only whole numbers (e.g., 1, 2, 3)");
                        scanner.nextLine(); // Clear the invalid input
                        columns = -1; // Set to invalid value to continue the loop
                        continue;
                    }
                    
                    columns = (int) decimalValue;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                    System.out.println("Note: Please enter only whole numbers (e.g., 1, 2, 3)");
                    scanner.nextLine(); // Clear the invalid input
                    columns = -1; // Set to invalid value to continue the loop
                }
                if (columns < MIN_ROWS_AND_COLUMNS || columns > maxRowsAndColumns) {
                    System.out.println("Error: Invalid number of columns. Please enter a number between " + MIN_ROWS_AND_COLUMNS + " and " + maxRowsAndColumns);
                    System.out.println("Note: Larger matrices may cause memory issues and calculation errors.");
                }
            } while (columns < MIN_ROWS_AND_COLUMNS || columns > maxRowsAndColumns);
        }

        matrix = new double[rows][columns];

        System.out.println("Enter the matrix elements:");
        System.out.println("Note: Values should be between -1e10 and 1e10 for best results.");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean validInput = false;
                do {
                    try {
                        System.out.printf("Enter element [%d][%d]: ", i + 1, j + 1);
                        String input = scanner.next();
                        
                        // Check if input contains alphabetic characters
                        if (input.matches(".*[a-zA-Z].*")) {
                            System.out.println("Error: Invalid input. Alphabetic characters are not allowed.");
                            System.out.println("Note: Please enter only numbers (e.g., 1, -1, 1.5, -1.5)");
                            scanner.nextLine(); // Clear the invalid input
                            continue;
                        }
                        
                        double value = Double.parseDouble(input);
                        
                        // Check for NaN and infinite values
                        if (Double.isNaN(value)) {
                            System.out.println("Error: Not a Number (NaN) is not allowed. Please enter a valid number.");
                            System.out.println("Note: NaN can occur from invalid mathematical operations like 0/0 or square root of negative numbers.");
                            scanner.nextLine(); // Clear the invalid input
                            continue;
                        }
                        
                        if (Double.isInfinite(value)) {
                            System.out.println("Error: Infinite values are not allowed. Please enter a finite number.");
                            System.out.println("Note: Infinite values can occur from division by zero or very large numbers.");
                            scanner.nextLine(); // Clear the invalid input
                            continue;
                        }
                        
                        // Check for value limits
                        if (value > MAX_MATRIX_VALUE) {
                            System.out.println("Error: Value is too large. Maximum allowed value is " + MAX_MATRIX_VALUE);
                            System.out.println("Note: Very large numbers may cause precision issues in calculations.");
                            scanner.nextLine(); // Clear the invalid input
                            continue;
                        }
                        
                        if (value < MIN_MATRIX_VALUE) {
                            System.out.println("Error: Value is too small. Minimum allowed value is " + MIN_MATRIX_VALUE);
                            System.out.println("Note: Very small numbers may cause precision issues in calculations.");
                            scanner.nextLine(); // Clear the invalid input
                            continue;
                        }
                        
                        // Check for extremely large or small numbers
                        if (Math.abs(value) > PRECISION_WARNING_THRESHOLD) {
                            System.out.println("Warning: The number is very large. This might cause precision issues in calculations.");
                            System.out.println("Note: Consider using a smaller number for better accuracy.");
                        }
                        
                        if (Math.abs(value) < PRECISION_WARNING_THRESHOLD_SMALL && value != 0) {
                            System.out.println("Warning: The number is very close to zero. This might cause precision issues in calculations.");
                            System.out.println("Note: Consider using zero instead for better accuracy.");
                        }
                        
                        matrix[i][j] = value;
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid input. Please enter a valid number.");
                        System.out.println("Note: Valid inputs include integers and decimal numbers (e.g., 1, -1, 1.5, -1.5)");
                        scanner.nextLine(); // Clear the invalid input
                    }
                } while (!validInput);
            }
        }
        return matrix;
    }

    /**
     * Prints a matrix in a formatted way with proper alignment and spacing.
     * @param matrix The matrix to be printed
     */
    public static void printMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Error: Cannot print null or empty matrix");
            return;
        }

        // Calculate the maximum width needed for each column
        int[] columnWidths = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (double[] doubles : matrix) {
                columnWidths[j] = Math.max(columnWidths[j],
                        String.format("%.2f", doubles[j]).length());
            }
        }

        // Print the matrix with proper formatting
        System.out.println("\nMatrix:");
        for (double[] doubles : matrix) {
            System.out.print("│ ");
            for (int j = 0; j < doubles.length; j++) {
                System.out.printf("%" + columnWidths[j] + ".2f", doubles[j]);
                if (j < doubles.length - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println(" │");
        }
        System.out.println();
    }

    /**
     * Displays the program name and author information with an enhanced ASCII art banner.
     * The ASCII art is designed to be visually appealing and clearly readable.
     */
    public static void displayName() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                     Matrix Calculator - Version 1.1                        ║");
        System.out.println("║                     Author: Samet Tok                                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝\n");

        // Enhanced ASCII art for "SAMET TOK"
        System.out.println("███████╗ █████╗ ███╗   ███╗███████╗████████╗    ████████╗ ██████╗ ██╗  ██╗");
        System.out.println("██╔════╝██╔══██╗████╗ ████║██╔════╝╚══██╔══╝    ╚══██╔══╝██╔═══██╗██║ ██╔╝");
        System.out.println("███████╗███████║██╔████╔██║█████╗     ██║          ██║   ██║   ██║█████╔╝ ");
        System.out.println("╚════██║██╔══██║██║╚██╔╝██║██╔══╝     ██║          ██║   ██║   ██║██╔═██╗ ");
        System.out.println("███████║██║  ██║██║ ╚═╝ ██║███████╗   ██║          ██║   ╚██████╔╝██║  ██║");
        System.out.println("╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝");
        System.out.println("\nA comprehensive matrix calculator supporting various matrix operations\n");
    }

    /**
     * Displays the main menu of the program with clear formatting and descriptions.
     * Each option is numbered and includes a brief description of the operation.
     */
    public static void displayMenu() {
        clearScreen();
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                              Matrix Operations Menu                         ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║  1. Matrix Addition         - Add two matrices of the same dimensions     ║");
        System.out.println("║  2. Matrix Subtraction     - Subtract two matrices of the same dimensions ║");
        System.out.println("║  3. Matrix Multiplication  - Multiply two compatible matrices            ║");
        System.out.println("║  4. Scalar Division        - Divide a matrix by a scalar value           ║");
        System.out.println("║  5. Scalar Multiplication  - Multiply a matrix by a scalar value         ║");
        System.out.println("║  6. Matrix Transpose       - Transpose a matrix (swap rows and columns)  ║");
        System.out.println("║  7. Matrix Inverse        - Calculate the inverse of a square matrix     ║");
        System.out.println("║  8. Matrix Trace          - Calculate the trace of a square matrix       ║");
        System.out.println("║  9. Matrix Adjoint        - Calculate the adjoint of a square matrix     ║");
        System.out.println("║ 10. Orthogonality Check   - Check if a matrix is orthogonal             ║");
        System.out.println("║ 11. Operation History     - Display recent operation history             ║");
        System.out.println("║ 12. Terminate             - Exit the program                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        System.out.print("\nPlease enter the number of the operation you want to perform (1-12): ");
    }

    /**
     * Clears the console screen for better readability.
     * Supports both Windows and Unix-based systems.
     */
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error while clearing the screen: " + e.getMessage());
        }
    }

    // Matrix validation methods
    public static boolean isSquare(double[][] matrix) {
        return matrix != null && matrix.length > 0 && matrix.length == matrix[0].length;
    }

    public static boolean isDiagonal(double[][] matrix) {
        if (!isSquare(matrix)) {
            return false;
        }
        
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && Math.abs(matrix[i][j]) > PRECISION_WARNING_THRESHOLD_SMALL) {
                    return false;
                }
            }
        }
        return true;
    }

    // Strassen's algorithm for matrix multiplication
    private static double[][] strassenMultiply(double[][] A, double[][] B) {
        int n = A.length;
        if (n <= 2) {
            return standardMultiply(A, B);
        }

        // Split matrices into submatrices
        int half = n / 2;
        double[][] A11 = new double[half][half];
        double[][] A12 = new double[half][half];
        double[][] A21 = new double[half][half];
        double[][] A22 = new double[half][half];
        double[][] B11 = new double[half][half];
        double[][] B12 = new double[half][half];
        double[][] B21 = new double[half][half];
        double[][] B22 = new double[half][half];

        // Split A and B into submatrices
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + half];
                A21[i][j] = A[i + half][j];
                A22[i][j] = A[i + half][j + half];
                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + half];
                B21[i][j] = B[i + half][j];
                B22[i][j] = B[i + half][j + half];
            }
        }

        // Calculate Strassen's products
        double[][] P1 = strassenMultiply(A11, subtractMatrices(B12, B22));
        double[][] P2 = strassenMultiply(Objects.requireNonNull(addMatrices(A11, A12)), B22);
        double[][] P3 = strassenMultiply(Objects.requireNonNull(addMatrices(A21, A22)), B11);
        double[][] P4 = strassenMultiply(A22, subtractMatrices(B21, B11));
        double[][] P5 = strassenMultiply(Objects.requireNonNull(addMatrices(A11, A22)), addMatrices(B11, B22));
        double[][] P6 = strassenMultiply(Objects.requireNonNull(subtractMatrices(A12, A22)), addMatrices(B21, B22));
        double[][] P7 = strassenMultiply(Objects.requireNonNull(subtractMatrices(A11, A21)), addMatrices(B11, B12));

        // Calculate result submatrices
        double[][] C11 = addMatrices(subtractMatrices(addMatrices(P5, P4), P2), P6);
        double[][] C12 = addMatrices(P1, P2);
        double[][] C21 = addMatrices(P3, P4);
        double[][] C22 = subtractMatrices(subtractMatrices(addMatrices(P5, P1), P3), P7);

        // Combine result submatrices
        double[][] result = new double[n][n];
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                assert C11 != null;
                result[i][j] = C11[i][j];
                assert C12 != null;
                result[i][j + half] = C12[i][j];
                assert C21 != null;
                result[i + half][j] = C21[i][j];
                assert C22 != null;
                result[i + half][j + half] = C22[i][j];
            }
        }
        return result;
    }

    // Standard matrix multiplication for small matrices
    private static double[][] standardMultiply(double[][] A, double[][] B) {
        int n = A.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // LU decomposition for determinant calculation
    private static double calculateDeterminantLU(double[][] matrix) {
        int n = matrix.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];
        
        // Initialize L and U
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
            System.arraycopy(matrix[i], 0, U[i], 0, n);
        }

        // Perform LU decomposition
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(U[k][k]) < PRECISION_WARNING_THRESHOLD_SMALL) {
                    System.out.println("Warning: Matrix is close to singular.");
                    return 0;
                }
                L[i][k] = U[i][k] / U[k][k];
                for (int j = k + 1; j < n; j++) {
                    U[i][j] -= L[i][k] * U[k][j];
                }
            }
        }

        // Calculate determinant as product of diagonal elements of U
        double determinant = 1;
        for (int i = 0; i < n; i++) {
            determinant *= U[i][i];
        }
        return determinant;
    }

    // Additional matrix validation methods
    public static boolean isUpperTriangular(double[][] matrix) {
        if (!isSquare(matrix)) {
            return false;
        }
        
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(matrix[i][j]) > PRECISION_WARNING_THRESHOLD_SMALL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLowerTriangular(double[][] matrix) {
        if (!isSquare(matrix)) {
            return false;
        }
        
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(matrix[i][j]) > PRECISION_WARNING_THRESHOLD_SMALL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentityMatrix(double[][] matrix) {
        if (!isSquare(matrix)) {
            return false;
        }
        
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j && Math.abs(matrix[i][j] - 1.0) > PRECISION_WARNING_THRESHOLD_SMALL) {
                    return false;
                }
                if (i != j && Math.abs(matrix[i][j]) > PRECISION_WARNING_THRESHOLD_SMALL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isZeroMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (Math.abs(doubles[j]) > PRECISION_WARNING_THRESHOLD_SMALL) {
                    return false;
                }
            }
        }
        return true;
    }

    // Operation history tracking class to maintain a record of recent operations.
    // Stores up to 10 most recent operations with their success/failure status.
    private static class OperationHistory {
        private static final int MAX_HISTORY = 10;
        private static final String[] operations = new String[MAX_HISTORY];
        private static int currentIndex = 0;

        /**
         * Adds a new operation to the history.
         * @param operation Description of the operation performed
         */
        public static void addOperation(String operation) {
            operations[currentIndex] = operation;
            currentIndex = (currentIndex + 1) % MAX_HISTORY;
        }

        /**
         * Displays the operation history in a formatted way.
         */
        public static void displayHistory() {
            System.out.println("\n╔════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                              Operation History                            ║");
            System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
            int count = 0;
            for (int i = 0; i < MAX_HISTORY; i++) {
                int index = (currentIndex - 1 - i + MAX_HISTORY) % MAX_HISTORY;
                if (operations[index] != null) {
                    System.out.printf("║ %2d. %-70s ║%n", ++count, operations[index]);
                }
            }
            System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        }
    }

    // Enhanced error handling for matrix operations
    private static void handleMatrixError(String operation, String error, String note) {
        System.out.println("Error in " + operation + ": " + error);
        System.out.println("Note: " + note);
        OperationHistory.addOperation(operation + " - Failed: " + error);
    }

    private static void handleMatrixWarning(String operation, String warning, String note) {
        System.out.println("Warning in " + operation + ": " + warning);
        System.out.println("Note: " + note);
    }

    private static void handleMatrixSuccess(String operation, String details) {
        OperationHistory.addOperation(operation + " - Success: " + details);
    }

}

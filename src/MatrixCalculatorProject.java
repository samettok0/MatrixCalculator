import java.util.Scanner;
import java.lang.Math;

public class MatrixCalculatorProject {
    // This is a Java program that performs various matrix operations such as addition, subtraction, multiplication, scalar division, scalar multiplication, transpose, inverse, trace, adjoint, and orthogonality check.
    // The program allows the user to input matrices and choose the desired operation from a menu.

    // Main method to run the program
    // It contains a menu for the user to select the desired matrix operation.
  
  public static void main(String[] args) {  
;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for user input
        int choice;  // Declare an integer variable to store the choice the user is going to choose
        int maxRowsAndColumns = 5;
        double[][] matrix1 = null;
        double[][] matrix2 = null;
        double[][] result = null;
        double scalarValue;

        displayName();


        do {  // Start a do-while loop to keep the program running
          
            displayMenu();  // Call the displayMenu method to show the menu options
            
            choice = scanner.nextInt();  // Read the user's choice as an integer

            switch (choice) {  // Start a switch statement based on the user's choice
                case 1:
                    clearScreen();
                    System.out.print("\nMATRIX ADDITION\n\n");
                    System.out.println("Matrix Addition is the process of adding two or more matrices by summing their corresponding elements.\nWhen adding two matrices, you add the elements at the same positions to create a new matrix.\nBoth input matrices must have the same dimensions, meaning that the number of rows and columns in the first matrix should match the number of rows and columns in the second matrix.\n\n");
                    System.out.println("Enter details for the first matrix: \n");
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                    
                
                    System.out.println("\nEnter details for the second matrix: \n");
                    matrix2 = inputMatrix(scanner, maxRowsAndColumns);
                    
                    
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
                    System.out.println("\nEnter details for the first matrix: \n");
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                        
                    System.out.println("\nEnter details for the second matrix: \n");
                    matrix2 = inputMatrix(scanner, maxRowsAndColumns);
                    
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
                	System.out.println("\nMATRIX MULTIPLICATIN\n\n");
                	System.out.println("Matrix Multiplication is the process of multiplying two matrices to obtain a new matrix.\nTo multiply two matrices, the number of columns in the first matrix must be equal to the number of rows in the second matrix.");
                    
                	System.out.println("\nEnter details for the first matrix: \n");                    
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                        
                    System.out.println("\nEnter details for the second matrix: \n");
                    matrix2 = inputMatrix(scanner, maxRowsAndColumns);
                    
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
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                    
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
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);

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
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                    
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
                    System.out.println("The matrix must be square (having the same number of rows and columns).\r\n"
                    		+ "\r\n"
                    		+ "The determinant of the matrix must be nonzero. If the determinant is zero, the matrix is said to be singular, and it does not have an inverse.");
                	
                	System.out.println("\nEnter details for the matrix: \n");
                	
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                    
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
                    
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                    
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
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                    
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
                    matrix1 = inputMatrix(scanner, maxRowsAndColumns);
                    
                    System.out.println("\nMatrix:\n");
                    printMatrix(matrix1);
                    
                    boolean result1 = isOrthogonalMatrix(matrix1);
                  if (result1 == true) {
                    System.out.println("The matrix given is orthogonal.");
                  }
                  else {
                    System.out.println("The matrix given is not orthogonal.");
                  }
                    //Check Matrix for Orthogonality
                    break;
                case 11:
                    System.out.println("Terminating the program.");
                    // Display message indicating program termination
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between (1-11).");
                    // Display a message for an invalid choice
            }

            if (choice != 11) {
                System.out.print("\nPress Enter to return to the menu...");
                scanner.nextLine(); // the newline character
                scanner.nextLine(); // Wait for the user to choose
            }
        } while (choice != 11);  // Continue the loop until the user selects Terminate

  }
  
    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        int numRows = matrix1.length;
        int numCols = matrix1[0].length;
        double[][] result = new double[numRows][numCols];

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrix dimensions do not match for addition.");
            return null;
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }
    
    public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
        int numRows = matrix1.length;
        int numCols = matrix1[0].length;
        double[][] result = new double[numRows][numCols];

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrix dimensions do not match for subtraction.");
            return null;
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }
    
    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        int numRows1 = matrix1.length;
        int numCols1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numCols2 = matrix2[0].length;

        if (numCols1 != numRows2) {
            System.out.println("Matrix dimensions are not compatible for multiplication.");
            return null;
        }

        double[][] result = new double[numRows1][numCols2];


        for (int i = 0; i < numRows1; i++) {
            for (int j = 0; j < numCols2; j++) {
                double sum = 0;
                for (int k = 0; k < numCols1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static double[][] scalarDivision(double[][] matrix, double scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] / scalar;
            }
        }

        return result;
    }

    public static double[][] scalarMultiply(double[][] matrix, double scalar) {
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
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // Check if the matrix is square
        if (matrix[0].length != n) {
          System.out.println("Matrix's dimensions are not equal.");
          return null; // The matrix is not square
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1.0 : 0.0;
            }
        }

        for (int i = 0; i < n; i++) {
            double pivot = augmentedMatrix[i][i];

            if (pivot == 0) {
                System.out.print("The matrix is singular, and its inverse does not exist.\n");
                return null; // The matrix is singular
            }
           

            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        double[][] inverse = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverse;
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
    
    public static double[][] transposeMatrix(double[][] matrix1) {
     
          int numRows = matrix1.length;
          int numCols = matrix1[0].length;
          double[][] result = new double[numCols][numRows];

          for (int i = 0; i < numCols; i++) {
              for (int j = 0; j < numRows; j++) {
                result[i][j] = matrix1[j][i];
              }
          }
          return result;
      }

    public static double[][] calculateAdjoint(double[][] matrix) {
        int n = matrix.length;

        if (n != matrix[0].length) {
            System.out.println("The matrix is not square. The adjoint matrix can only be calculated for square matrices.");
            return null; // Return null to indicate an error.
        }

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

    public static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        double determinant = 0;
        for (int i = 0; i < n; i++) {
            determinant += matrix[0][i] * Math.pow(-1, i) * calculateDeterminant(getSubMatrix(matrix, 0, i));
        }

        return determinant;
    }
    
    public static double[][] getSubMatrix(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] subMatrix = new double[n - 1][n - 1];
        int r = 0, c = 0;

        for (int i = 0; i < n; i++) {
            if (i == row) continue; //O row'daki elemanları yeni matrise atamamak için countinue.

            for (int j = 0; j < n; j++) {
                if (j == col) continue; // O column'daki elemanları yeni matrise atamamak için countinue.

                subMatrix[r][c] = matrix[i][j];
                c++;
            }

            r++;
            c = 0;
        }

        return subMatrix;
    }
 
    public static boolean isOrthogonalMatrix(double[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        if (numRows != numCols) {
            System.out.println("Matrix is not square; it cannot be orthogonal.");
            return false;
        }

        double[][] transposedMatrix = transposeMatrix(matrix);

        double[][] inverseMatrix = findInverse(matrix);
        
        if (inverseMatrix == null) {
          return false;
        }

        // Check if the transpose and the inverse are equal
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (Math.abs(transposedMatrix[i][j] - inverseMatrix[i][j]) > 1e-9) {  //Rounding errorları gözardı etmek için yazılmış bir satır.
                    return false;
                }
            }
        }

        return true;
    }
    
    public static double[][] inputMatrix(Scanner scanner, int maxRowsAndColumns) {
        int rows, columns;
        boolean validInput;

        // Input the number of rows (between 1 and maxRowsAndColumns)
        do {
            System.out.print("Enter the number of rows (1-" + maxRowsAndColumns + "): ");
            try {
                rows = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                validInput = false;
                rows = 0;
            }
        } while (!validInput || rows < 1 || rows > maxRowsAndColumns);

        // Input the number of columns (between 1 and maxRowsAndColumns)
        do {
            System.out.print("Enter the number of columns (1-" + maxRowsAndColumns + "): ");
            try {
                columns = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                validInput = false;
                columns = 0;
            }
        } while (!validInput || columns < 1 || columns > maxRowsAndColumns);

        double[][] matrix = new double[rows][columns];

        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                do {
                    System.out.print("Matrix[" + i + "][" + j + "]: ");
                    try {
                        matrix[i][j] = scanner.nextDouble();
                        validInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine(); // Clear the invalid input
                        validInput = false;
                    }
                } while (!validInput);
            }
        }

        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.2f", matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]\n");
        }
    }


    public static void displayName() {
        System.out.println("Project: Matrix Calculator");
        System.out.println("Author: Samet Tok");

        // ASCII art representation for SAMET TO
        System.out.println("  █████  █████  ███    ███ ███████ ████████");
        System.out.println("  ██    ██   ██ ████  ████ ██         ██   ");
        System.out.println("  █████ ███████ ██ ████ ██ █████      ██   ");
        System.out.println("     ██ ██   ██ ██  ██  ██ ██         ██   ");
        System.out.println("  █████ ██   ██ ██      ██ ███████    ██   ");
        System.out.println();
    }


    public static void displayMenu() {;
      clearScreen();
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Matrix Addition");
        System.out.println("2. Matrix Subtraction");
        System.out.println("3. Matrix Multiplication");
        System.out.println("4. Scalar Division of the Matrix");
        System.out.println("5. Scalar Multiplication of the Matrix");
        System.out.println("6. Transpose of the Matrix");
        System.out.println("7. Inverse of the Matrix");
        System.out.println("8. Trace of the Matrix");
        System.out.println("9. Adjoint of the Matrix");
        System.out.println("10. Check Matrix for Orthogonality");
        System.out.println("11. Terminate");
        System.out.print("Please enter the number of the operation you want to perform (1-11): ");
        
    }
    
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

}

# Matrix Calculator

A comprehensive Java-based matrix calculator that supports various matrix operations with a user-friendly command-line interface.

## Features

- **Basic Matrix Operations**
  - Matrix Addition
  - Matrix Subtraction
  - Matrix Multiplication (with optimized Strassen's algorithm for large matrices)
  - Scalar Multiplication
  - Scalar Division

- **Advanced Matrix Operations**
  - Matrix Transpose
  - Matrix Inverse
  - Matrix Trace
  - Matrix Adjoint
  - Orthogonality Check

- **Special Features**
  - Input validation with detailed error messages
  - Support for various matrix types (diagonal, triangular, identity, zero)
  - Operation history tracking
  - Optimized algorithms for special matrix types
  - Precision control and numerical stability checks

## Requirements

- Java Development Kit (JDK) 8 or higher
- Command-line interface support

## Installation

1. Clone the repository:
```bash
git clone https://github.com/samettok0/MatrixCalculator.git
```

2. Navigate to the project directory:
```bash
cd MatrixCalculator
```

3. Compile the Java file:
```bash
javac src/MatrixCalculatorProject.java
```

4. Run the program:
```bash
java -cp src MatrixCalculatorProject
```

## Usage

1. Upon running the program, you'll be presented with a menu of available operations.
2. Choose an operation by entering the corresponding number (1-12).
3. Follow the prompts to input matrix dimensions and elements.
4. View the results of your operation.
5. Check operation history using option 11.

### Input Guidelines

- Matrix dimensions must be between 1 and 5
- Matrix elements must be between -1e10 and 1e10
- For operations involving two matrices, ensure compatible dimensions

## Features in Detail

### 1. Matrix Addition
- Adds corresponding elements of two matrices
- Requires matrices of the same dimensions

### 2. Matrix Subtraction
- Subtracts corresponding elements of two matrices
- Requires matrices of the same dimensions

### 3. Matrix Multiplication
- Implements both standard multiplication and Strassen's algorithm
- Automatically chooses the most efficient method based on matrix size
- Requires compatible matrix dimensions (first matrix columns = second matrix rows)

### 4. Scalar Operations
- Scalar Division: Divides each element by a scalar value
- Scalar Multiplication: Multiplies each element by a scalar value

### 5. Advanced Operations
- Transpose: Swaps rows and columns
- Inverse: Calculates matrix inverse using optimized methods for special cases
- Trace: Calculates sum of main diagonal elements
- Adjoint: Calculates classical adjoint of a matrix
- Orthogonality Check: Verifies if a matrix is orthogonal

## Error Handling

The calculator includes comprehensive error handling for:
- Invalid matrix dimensions
- Incompatible matrices for operations
- Singular matrices in inverse calculations
- Numerical overflow/underflow conditions
- Invalid input values

## Performance Optimizations

- Specialized algorithms for diagonal matrices
- Strassen's algorithm for large matrix multiplication
- LU decomposition for determinant calculation
- Efficient memory management for large matrices

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Author

Samet Tok && Furkan Zayif


## Version History

- 1.1: Current version with all matrix operations and optimizations
- 1.0: Initial release with basic matrix operations 
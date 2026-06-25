package interview.exam.problem;

import java.util.Objects;

public class GridProblemImpl implements IGridProblem {

    /**
     * Searches for a 2D pattern within a larger 2D grid of strings.
     * Time Complexity: O((N - M + 1) * (W - H + 1) * M * H) where N x W is the grid
     * size and M x H is the pattern size.
     * Space Complexity: O(1) auxiliary space.
     * 
     * @param grid    The larger grid to search within.
     * @param pattern The smaller pattern to locate.
     * @return true if the pattern exists within the grid; false otherwise.
     * @throws NullPointerException     if grid or pattern is null.
     * @throws IllegalArgumentException if grid or pattern rows contain null values
     *                                  or are jagged.
     */
    @Override
    public boolean solveGrid(String[] grid, String[] pattern) {
        // Fail-fast on null inputs or empty matrices
        Objects.requireNonNull(grid, "Grid input matrix cannot be null.");
        Objects.requireNonNull(pattern, "Pattern input matrix cannot be null.");

        if (grid.length == 0 || pattern.length == 0) {
            return false;
        }

        validateMatrixStructure(grid, "Grid");
        validateMatrixStructure(pattern, "Pattern");

        // Define the search boundaries for the sliding window
        int gridHeight = grid.length;
        int gridWidth = grid[0].length();
        int patternHeight = pattern.length;
        int patternWidth = pattern[0].length();

        if (patternHeight > gridHeight || patternWidth > gridWidth) {
            return false;
        }

        // Calculate the maximum starting boundaries to prevent out-of-bounds scanning
        int maxRow = gridHeight - patternHeight;
        int maxCol = gridWidth - patternWidth;

        // Slide the pattern window across the grid row-by-row, column-by-column
        for (int r = 0; r <= maxRow; r++) {
            for (int c = 0; c <= maxCol; c++) {
                if (checkMatch(grid, pattern, r, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if the pattern matches a specific window in the grid starting at
     * the specified grid coordinates.
     * 
     * @param grid     The target grid matrix.
     * @param pattern  The pattern matrix to match against.
     * @param startRow The starting row offset in the grid.
     * @param startCol The starting column offset in the grid.
     * @return true if the pattern perfectly matches the grid window; false
     *         otherwise.
     */
    private static boolean checkMatch(String[] grid, String[] pattern, int startRow, int startCol) {
        int patternHeight = pattern.length;
        int patternWidth = pattern[0].length();

        for (int i = 0; i < patternHeight; i++) {
            for (int j = 0; j < patternWidth; j++) {
                if (grid[startRow + i].charAt(startCol + j) != pattern[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validates that the matrix rows are non-null and uniform in length.
     * 
     * @param matrix     The matrix to validate.
     * @param matrixName Label used for diagnostic exception messages.
     * @throws IllegalArgumentException if any row is null or if lengths are
     *                                  non-uniform.
     */
    private static void validateMatrixStructure(String[] matrix, String matrixName) {
        if (matrix[0] == null) {
            throw new IllegalArgumentException(matrixName + " row cannot be null at index 0");
        }

        int expectedWidth = matrix[0].length();

        // Start at 1 since index 0 was used to establish the expected width
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i] == null) {
                throw new IllegalArgumentException(matrixName + " row cannot be null at index " + i);
            }
            if (matrix[i].length() != expectedWidth) {
                throw new IllegalArgumentException(matrixName + " is jagged at row " + i);
            }
        }
    }
}

package interview.exam.problem;

public class GridProblemImpl implements IGridProblem {

    /**
     * Searches for a 2D pattern within a larger 2D grid of strings.
     * 
     * @param grid    The larger grid to search within.
     * @param pattern The smaller pattern to locate.
     * @return true if the pattern exists seamlessly within the grid; false
     *         otherwise.
     */
    @Override
    public boolean solveGrid(String[] grid, String[] pattern) {
        // Fail-fast if either input is null or empty to prevent NullPointerExceptions
        if (grid == null || pattern == null || grid.length == 0 || pattern.length == 0) {
            return false;
        }

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
     * (startRow, startCol).
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

}

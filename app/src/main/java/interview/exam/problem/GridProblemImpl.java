package interview.exam.problem;

public class GridProblemImpl implements IGridProblem {

    /**
     * Provide the implementation to solve the problem statement
     */
    @Override
    public boolean solveGrid(String[] grid, String[] pattern) {
        // TODO Implement the solution
        if (pattern == null || pattern.length == 0) {
            return true; // An empty pattern is always found
        }

        if (grid == null || grid.length == 0 || pattern.length > grid.length) {
            return false; // If grid is empty or pattern is taller than grid, it cannot be found
        }

        if (!isValidPattern(pattern)) {
            return false; // If pattern is not valid, it cannot be found
        }

        int patternHeight = pattern.length;
        int patternWidth = pattern[0].length();

        if (patternWidth == 0) {
            return true; // An empty pattern is always found
        }

        String firstPatternRow = pattern[0];

        for (int gridRow = 0; gridRow <= grid.length - patternHeight; gridRow++) {
            String currentGridRow = grid[gridRow];
            
            if (currentGridRow == null || currentGridRow.length() < patternWidth) {
                continue; // Skip rows that are null or shorter than the pattern width
            }

            int searchStartIndex = 0;

            while (searchStartIndex <= currentGridRow.length() - patternWidth) {
                int gridCol = currentGridRow.indexOf(firstPatternRow, searchStartIndex);
                if (gridCol == -1) {
                    break; // No more occurrences of the first pattern row in this grid row
                }

                if (matchesPattern(grid, pattern, gridRow, gridCol, patternWidth)) {
                    return true; // Found a match for the entire pattern
                }
                searchStartIndex = gridCol + 1; // Move to the next character after the found pattern row
            }
        }
        return false;
    }

    private boolean isValidPattern(String[] pattern) {
        if (pattern[0] == null) {
            return false; // If the first row of the pattern is null, it's not valid
        }

        int patternWidth = pattern[0].length();

        for (String row : pattern) {
            if (row == null || row.length() != patternWidth) {
                return false; // All rows in the pattern must be non-null and of the same width
            }
        }
        return true;
    }

    private boolean matchesPattern(
        String[] grid,
        String[] pattern,
        int gridStartRow,
        int gridStartCol,
        int patternWidth
    ) {
        // First pattern row is already matched, so we start from the second row
        for (int patternRow = 1; patternRow < pattern.length; patternRow++) {
            String gridRow = grid[gridStartRow + patternRow];
            
            if (gridRow == null || gridStartCol + patternWidth > gridRow.length()){
                return false; // If the grid row is null or doesn't have enough characters, it's not a match
            }

            if (!gridRow.startsWith(pattern[patternRow], gridStartCol)) {
                return false; // If the current pattern row doesn't match the corresponding grid row, it's not a match
            }
            
        }
        return true; // All pattern rows matched
    }
    
}
 
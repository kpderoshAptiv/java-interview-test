package interview.exam.problem;

public class GridProblemImpl implements IGridProblem {

    /**
     * Provide the implementation to solve the problem statement
     */
    @Override
    public boolean solveGrid(String[] grid, String[] pattern) {
        if (grid == null || pattern == null || grid.length == 0 || pattern.length == 0) {
            return false;
        }

        if (pattern.length > grid.length) {
            return false;
        }

        int gridWidth = grid[0] != null ? grid[0].length() : 0;
        int patternWidth = pattern[0] != null ? pattern[0].length() : 0;

        if (gridWidth == 0 || patternWidth == 0 || patternWidth > gridWidth) {
            return false;
        }

        return false;
    }

}

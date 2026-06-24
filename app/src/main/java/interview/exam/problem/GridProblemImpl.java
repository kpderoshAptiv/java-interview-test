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

        int gridHeight = grid.length;
        int gridWidth = grid[0].length();
        int patternHeight = pattern.length;
        int patternWidth = pattern[0].length();

        if (patternHeight > gridHeight || patternWidth > gridWidth) {
            return false;
        }

        return true;
    }

}

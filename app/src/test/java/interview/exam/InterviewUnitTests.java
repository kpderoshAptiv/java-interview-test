package interview.exam;

import org.junit.Test;
import static org.junit.Assert.assertFalse;

import interview.exam.problem.IGridProblem;
import interview.exam.problem.GridProblemImpl;

public class InterviewUnitTests {

    private final IGridProblem solver = new GridProblemImpl();

    @Test
    public void shouldReturnFalse_WhenGridOrPatternIsNull() {
        assertFalse(solver.solveGrid(null, new String[]{"123"}));
        assertFalse(solver.solveGrid(new String[]{"123"}, null));
        assertFalse(solver.solveGrid(null, null));
    }

    @Test
    public void shouldReturnFalse_WhenGridOrPatternIsEmpty() {
        assertFalse(solver.solveGrid(new String[]{}, new String[]{"123"}));
        assertFalse(solver.solveGrid(new String[]{"123"}, new String[]{}));
    }

    @Test
    public void shouldReturnFalse_WhenPatternIsTallerThanGrid() {
        String[] grid = {"123", "456"};
        String[] pattern = {"12", "34", "56"};
        
        assertFalse(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnFalse_WhenPatternIsWiderThanGrid() {
        String[] grid = {"123", "456"};
        String[] pattern = {"1234"};
        
        assertFalse(solver.solveGrid(grid, pattern));
    }
}

package interview.exam;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import interview.exam.problem.IGridProblem;
import interview.exam.problem.GridProblemImpl;

public class InterviewUnitTests {

    private final IGridProblem solver = new GridProblemImpl();

    @Test
    public void shouldReturnFalse_WhenGridOrPatternIsNull() {
        assertFalse(solver.solveGrid(null, new String[] { "123" }));
        assertFalse(solver.solveGrid(new String[] { "123" }, null));
        assertFalse(solver.solveGrid(null, null));
    }

    @Test
    public void shouldReturnFalse_WhenGridOrPatternIsEmpty() {
        assertFalse(solver.solveGrid(new String[] {}, new String[] { "123" }));
        assertFalse(solver.solveGrid(new String[] { "123" }, new String[] {}));
    }

    @Test
    public void shouldReturnFalse_WhenPatternIsTallerThanGrid() {
        String[] grid = { "123", "456" };
        String[] pattern = { "12", "34", "56" };

        assertFalse(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnFalse_WhenPatternIsWiderThanGrid() {
        String[] grid = { "123", "456" };
        String[] pattern = { "1234" };

        assertFalse(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnTrue_WhenPatternExistsInCenter() {
        String[] grid = {
                "12345",
                "67890",
                "abcde"
        };
        String[] pattern = {
                "78",
                "bc"
        };

        assertTrue(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnTrue_WhenPatternIsAtTheVeryBottomRightCorner() {
        String[] grid = {
                "12345",
                "67890",
                "abcde"
        };
        String[] pattern = {
                "90",
                "de"
        };

        assertTrue(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnFalse_WhenCharactersDoNotMatch() {
        String[] grid = {
                "123",
                "456",
                "789"
        };
        String[] pattern = {
                "12",
                "49"
        };

        assertFalse(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnTrue_WhenPatternIsExactSameSizeAsGridAndMatches() {
        String[] grid = {
                "123",
                "456"
        };
        String[] pattern = {
                "123",
                "456"
        };

        assertTrue(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnFalse_WhenPatternIsExactSameSizeAsGridButDoesNotMatch() {
        String[] grid = {
                "123",
                "456"
        };
        String[] pattern = {
                "123",
                "45X"
        };

        assertFalse(solver.solveGrid(grid, pattern));
    }
}

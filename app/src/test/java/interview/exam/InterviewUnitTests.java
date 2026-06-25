package interview.exam;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import interview.exam.problem.IGridProblem;
import interview.exam.problem.GridProblemImpl;

public class InterviewUnitTests {

    private final IGridProblem solver = new GridProblemImpl();

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException_WhenGridIsNull() {
        solver.solveGrid(null, new String[] { "123" });
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException_WhenPatternIsNull() {
        solver.solveGrid(new String[] { "123" }, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_WhenGridIsJagged() {
        String[] jaggedGrid = {
                "1234",
                "12",
                "1234"
        };
        String[] pattern = { "12" };

        solver.solveGrid(jaggedGrid, pattern);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_WhenPatternIsJagged() {
        String[] grid = {
                "123",
                "456",
                "789"
        };
        String[] jaggedPattern = {
                "12",
                "123"
        };

        solver.solveGrid(grid, jaggedPattern);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_WhenGridContainsNullRow() {
        String[] brokenGrid = {
                "123",
                null,
                "789"
        };
        String[] pattern = { "12" };

        solver.solveGrid(brokenGrid, pattern);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_WhenPatternContainsNullRow() {
        String[] grid = {
                "123",
                "456"
        };
        String[] brokenPattern = {
                "12",
                null
        };

        solver.solveGrid(grid, brokenPattern);
    }

    @Test
    public void shouldReturnFalse_WhenGridOrPatternIsEmpty() {
        assertFalse(solver.solveGrid(new String[] {}, new String[] { "123" }));
        assertFalse(solver.solveGrid(new String[] { "123" }, new String[] {}));
    }

    @Test
    public void shouldReturnFalse_WhenPatternIsTallerThanGrid() {
        String[] grid = {
                "123",
                "456"
        };
        String[] pattern = {
                "12",
                "34",
                "56"
        };

        assertFalse(solver.solveGrid(grid, pattern));
    }

    @Test
    public void shouldReturnFalse_WhenPatternIsWiderThanGrid() {
        String[] grid = {
                "123",
                "456"

        };
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
    public void shouldReturnTrue_WhenPatternIsAtTopLeftCorner() {
        String[] grid = {
                "123",
                "456",
                "789"
        };
        String[] pattern = {
                "12",
                "45"
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

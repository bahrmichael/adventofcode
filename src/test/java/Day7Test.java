import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Day7Test {

    @Test
    void should_extract_object_with_children() {
        final TowerElement te = Day7.extractObject("dihjv (2158) -> gausx, ncdmp, hozgrub");

        assertEquals("dihjv", te.getName());
        assertEquals(2158, te.getWeight().intValue());
        assertArrayEquals(new String[]{"gausx", "ncdmp", "hozgrub"}, te.getChildren());
    }

    @Test
    void should_extract_object() {
        final TowerElement te = Day7.extractObject("hozgrub (10)");

        assertEquals("hozgrub", te.getName());
        assertEquals(10, te.getWeight().intValue());
        assertNull(te.getChildren());
    }

    @Test
    void should_return_parent_for_single_parent() {
        final String result = Day7.solve("dihjv (2158) -> gausx, ncdmp, hozgrub");
        assertEquals("dihjv", result);
    }

    @Test
    void should_return_parent_for_single_element() {
        final String result = Day7.solve("hozgrub (10)");
        assertEquals("hozgrub", result);
    }

    @Test
    void should_return_parent_for_multiple_parents() {
        final String result = Day7.solve("dihjv (2158) -> gausx, ncdmp, hozgrub\n"
                                         + "bert (1) -> john\n"
                                         + "john (10) -> dihjv");
        assertEquals("bert", result);
    }

    @Test
    void solve() {
        System.out.println("1: " + Day7.solve(Day7.PUZZLE));
    }
}

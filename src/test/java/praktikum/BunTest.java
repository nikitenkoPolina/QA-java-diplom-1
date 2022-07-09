package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void initObject() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void getNameTest() {
        String actual = bun.getName();
        String expected = "black bun";
        assertEquals("Failed to get bun name", expected, actual);
    }

    @Test
    public void getPriceTest() {
        Float actual = bun.getPrice();
        Float expected = 100f;
        assertEquals("Failed to get bun price", expected, actual);
    }
}

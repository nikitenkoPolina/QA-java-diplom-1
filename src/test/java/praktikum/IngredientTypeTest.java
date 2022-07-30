package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void getSauceEnumTest() {

        assertEquals("Ingredient type Sauce is not recognized", "SAUCE", SAUCE.name());
    }

    @Test
    public void getFillingEnumTest() {
        assertEquals("Ingredient type Filling is not recognized", "FILLING", FILLING.name());
    }

    @Test
    public void checkIngredientsTypesCount() {
        int expected = 2;
        assertEquals("Wrong amount of ingredients", expected, IngredientType.values().length);
    }
}
package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        super();
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void initObject() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getIngredientParam() {
        return new Object[][]{
                {SAUCE, "chili sauce", 300f},
                {FILLING, "dinosaur", 200f},
        };
    }

    @Test
    public void getPriceTest() {
        float actual = ingredient.getPrice();
        assertEquals("Failed to get ingredient price", price, actual, 0.0);
    }

    @Test
    public void getNameTest() {
        String actual = ingredient.getName();
        assertEquals("Failed to get ingredient name", name, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType actual = ingredient.getType();
        assertEquals("Failed to get ingredient type", type, actual);
    }
}
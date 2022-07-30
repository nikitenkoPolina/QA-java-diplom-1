package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Before
    public void initObject() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("Failed to set buns for burger", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertTrue("Failed to add an ingredient", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);
        assertTrue("Failed to remove an ingredient", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Failed to move an ingredient", ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        float expected = 250f;
        float actual = burger.getPrice();
        assertEquals("Failed to get burger price", expected, actual, 0.0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);

        burger.ingredients.add(ingredient1);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient1.getPrice()).thenReturn(300f);

        burger.ingredients.add(ingredient2);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);

        String expected = "(==== white bun ====)" +
                "\r\n= sauce chili sauce =" +
                "\r\n= filling dinosaur =" +
                "\r\n(==== white bun ====)\r\n" +
                "\r\nPrice: 900,000000\r\n";

        assertEquals("Failed to get burger receipt", expected, burger.getReceipt());
    }
}
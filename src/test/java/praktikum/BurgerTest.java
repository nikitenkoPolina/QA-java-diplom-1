package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

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
        burger.moveIngredient(0,1);
        assertEquals("Failed to move an ingredient", ingredient1, burger.ingredients.get(1));
    }
}

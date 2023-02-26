import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    private Ingredient mockSauce;
    @Mock
    private Ingredient mockFilling1;
    @Mock
    private Ingredient mockFilling2;
    @Mock
    private Bun mockBun1;
    @Mock
    private Bun mockBun2;
    @Spy
    private Burger burger = new Burger();

    @Before
    public void createBurger() {
        burger.setBuns(mockBun1);
        burger.addIngredient(mockFilling1);
        burger.addIngredient(mockSauce);
    }

    @Test
    public void checkBunSetting() {
        burger.setBuns(mockBun2);
        assertEquals("ты взял не ту булочку", mockBun2, burger.getBun());
    }

    @Test
    public void checkIngredientsAdding() {
        int i = burger.getIngredients().size();
        burger.addIngredient(mockFilling2);
        assertEquals("что-то не доложили", i + 1, burger.getIngredients().size());
        assertEquals("это не тот ингредиент", mockFilling2, burger.getIngredients().get(i));
    }

    @Test
    public void checkIngredientsRemoving() {
        burger.addIngredient(mockFilling2);
        int ingredientsCount = burger.getIngredients().size();
        burger.removeIngredient(ingredientsCount - 2);

        assertEquals(burger.getIngredients().size(), ingredientsCount - 1);
        assertEquals(burger.getIngredients().get(ingredientsCount - 2), mockFilling2);
    }

    @Test
    public void checkIngredientsMoving() {
        int i = burger.getIngredients().size();
        Ingredient ingredient2 = burger.ingredients.get(i - 1);
        Ingredient ingredient1 = burger.ingredients.get(i - 2);
        burger.moveIngredient(i - 1, i - 2);

        assertEquals(burger.getIngredients().size(), i);
        assertEquals(burger.getIngredients().get(i - 1), ingredient1);
        assertEquals(burger.getIngredients().get(i - 2), ingredient2);
    }

    @Test
    public void checkBurgerPrice() {
        Mockito.when(mockBun1.getPrice()).thenReturn(3f);
        Mockito.when(mockFilling1.getPrice()).thenReturn(10f);
        Mockito.when(mockSauce.getPrice()).thenReturn(10f);
        assertEquals("дайте калькулятор!", 3 * 2 + 10+10, burger.getPrice(), 0.00f);
    }

    @Test
    public void checkBurgerReceipt() {
        Mockito.when(mockBun1.getName()).thenReturn("булочка");
        Mockito.when(mockFilling1.getName()).thenReturn("вкусняшечка");
        Mockito.when(mockFilling1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockSauce.getName()).thenReturn("соусец");
        Mockito.when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(burger.getPrice()).thenReturn(100500F);

        String expected =
                        "(==== булочка ====)\n" +
                        "= filling вкусняшечка =\n" +
                        "= sauce соусец =\n" +
                        "(==== булочка ====)\n" +
                        "\n" +
                        "Price: 100500,000000\n";

        assertEquals("вроде не то заказывали",  expected, burger.getReceipt());
    }
}

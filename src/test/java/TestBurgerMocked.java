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
public class TestBurgerMocked {
    @Mock
    Ingredient mockIngredient;
    @Mock
    Bun mockBun;
    @Spy
    Burger burger = new Burger();

    @Before
    public void createBurger() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
    }

    @Test
    public void checkBurgerPrice() {

        Mockito.when(mockBun.getPrice()).thenReturn(3f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(20f);
        assertEquals("дайте калькулятор!", 3 * 2 + 20, burger.getPrice(), 0.00f);
    }

    @Test
    public void checkBurgerReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("булочка");
        Mockito.when(mockIngredient.getName()).thenReturn("вкусняшечка");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(burger.getPrice()).thenReturn(100500F);

        String expected =
                "(==== булочка ====)\n" +
                "= filling вкусняшечка =\n" +
                "(==== булочка ====)\n" +
                "\n" +
                "Price: 100500,000000\n";

        assertEquals("вроде не то заказывали",  expected, burger.getReceipt());
    }
}
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredient {
    private Ingredient ingredient;
    private final IngredientType ingredType;
    private final String ingredName = "someName";
    private final float ingredPrice = (float) 13.0987;

    @Before
    public void preset() {
        ingredient = new Ingredient(ingredType, ingredName, ingredPrice);
    }

    public TestIngredient(IngredientType ingredType) {
        this.ingredType = ingredType;
    }

    @Parameterized.Parameters(name = "Ингредиент {0} {1}")
    public static Object[][] getIngredientTypeForTest() {
        return new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE}
        };
    }

    @Test
    public void checkIngredientType() {
        assertEquals("Тип несовпадает!", ingredType, ingredient.getType());
    }

    @Test
    public void checkIngredientName() {
        assertEquals("Называется по-другому!", ingredName, ingredient.getName());
    }

    @Test
    public void checkIngredientPrice() {
        assertEquals("Цена не та!", ingredPrice, ingredient.getPrice(), 0.0f);
    }
}
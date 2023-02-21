import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredient {
    private final IngredientType ingredType;

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
    public void test1() {
        String ingredName = "someName";
        float ingredPrice = (float) 13.0987;
        Ingredient ingredient = new Ingredient(ingredType, ingredName, ingredPrice);
        System.out.println(ingredType);
        assertEquals("тип проверь", ingredient.getType(), ingredType);
        System.out.println(ingredName);
        assertEquals("имя проверь", ingredient.getName(), ingredName);
        System.out.println(ingredPrice);
        assertEquals("цену проверь", ingredient.getPrice(), ingredPrice, 0.0f);

    }
}

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestBurger {
    Burger burger = new Burger();
    Bun bun = new Bun("с кунжутом", 3.25F);
    Bun bun2 = new Bun("с отрубями", 2.75F);
    Ingredient souce = new Ingredient(IngredientType.SAUCE, "кетченез", 1.5F);
    Ingredient filling1 = new Ingredient(IngredientType.FILLING, "мяско", 30F);
    Ingredient filling2 = new Ingredient(IngredientType.FILLING, "огурчик", 5F);

    @Before
    public void createBurger() {
        burger.setBuns(bun);
        burger.addIngredient(souce);
        burger.addIngredient(filling1);
        System.out.println(burger.getReceipt());
        System.out.println(burger.getPrice());
    }

    @Test
    public void checkBunSetting() {
        burger.setBuns(bun2);
        assertEquals("ты взял не ту булочку", burger.getBun(), bun2);
    }

    @Test
    public void checkIngredientsAdding() {
        int i = burger.getIngredients().size();
        burger.addIngredient(filling2);
        assertEquals("что-то не доложили", burger.getIngredients().size(), i + 1);
        assertEquals("это не тот ингредиент", burger.getIngredients().get(i), filling2);
    }

    @Test
    public void checkIngredientsRemoving() {
        burger.addIngredient(filling2);
        int ingredientsCount = burger.getIngredients().size();
        burger.removeIngredient(ingredientsCount - 2);

        assertEquals(burger.getIngredients().size(), ingredientsCount - 1);
        assertEquals(burger.getIngredients().get(ingredientsCount - 2), filling2);
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
        assertEquals("дайте калькулятор!", burger.getPrice(), 38, 0.00f);
    }

    @Test
    public void checkBurgerReceipt() {
        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : burger.getIngredients()) {
            expected.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("вроде не то заказывали", burger.getReceipt(), expected.toString());
    }
}

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestBun {
    private Bun bun;
    private final String bunName = "bunny";
    private final float bunPrice = (float) 14.56;
    @Before
    public void preset() {
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void checkBunHasGivenName() {
        assertEquals("Булочка зовется чужим именем", bunName, bun.getName());
    }

    @Test
    public void checkBunHasGivenPrice() {
        assertEquals("Галя, отмена! Тут не та цена", bunPrice, bun.getPrice(), 0.0f);
    }
}


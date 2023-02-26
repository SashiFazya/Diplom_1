import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestBun {

    @Test
    public void checkBunHasGivenName() {
        String bunName = "bunny";
        float bunPrice = (float) 14.56;
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Булочка зовется чужим именем", bunName, bun.getName());
    }

    @Test
    public void checkBunHasGivenPrice() {
        String bunName = "bunny";
        float bunPrice = (float) 14.56;
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Галя, отмена! Тут не та цена", bunPrice, bun.getPrice(), 0.0f);
    }
}


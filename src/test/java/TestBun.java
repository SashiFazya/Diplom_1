import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestBun {
    @Before
    public void preset() {

    }

    @Test
    public void checkBunHasGivenName() {
        String bunName = "bunny";
        float bunPrice = (float) 14.56;
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Булочка зовется чужим именем", bun.getName(), bunName);
    }

    @Test
    public void checkBunHasGivenPrice() {
        String bunName = "bunny";
        float bunPrice = (float) 14.56;
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Галя, отмена! Тут не та цена", bun.getPrice(), bunPrice, 0.0f);
    }

    @After
    public void cleanUp() {

    }

}


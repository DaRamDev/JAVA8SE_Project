package test.java.mylab.order.di.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// main 패키지에 있는 클래스들을 가져옵니다.
import main.java.mylab.order.di.xml.OrderService;
import main.java.mylab.order.di.xml.ShoppingCart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private OrderService orderService;

    @Test
    public void testShoppingCart() {
        assertNotNull(shoppingCart);
        assertEquals(2, shoppingCart.getProducts().size());
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
    }

    @Test
    public void testOrderService() {
        assertNotNull(orderService);
        assertNotNull(orderService.getShoppingCart());
        assertEquals(950000.0, orderService.calculateOrderTotal(), 0.0);
    }
}
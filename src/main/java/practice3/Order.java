package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public List<OrderLineItem> getOrderLineItemList(){
        return this.orderLineItemList;
    }

    public List<BigDecimal> getDiscounts(){
        return this.discounts;

    }

    public BigDecimal getTax(){
        return this.tax;
    }

    public BigDecimal calculate() {
        return new PriceCaculator(this).calTotal();
    }
}

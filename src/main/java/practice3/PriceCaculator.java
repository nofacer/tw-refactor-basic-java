package practice3;

import java.math.BigDecimal;

public class PriceCaculator {
    private Order order;

    public PriceCaculator(Order order){
        this.order=order;
    }

    public BigDecimal calTotal(){
        BigDecimal subTotal = new BigDecimal(0);

        // Total up line items
        for (OrderLineItem lineItem : this.order.getOrderLineItemList()) {
            subTotal = subTotal.add(lineItem.getPrice());
        }

        // Subtract discounts
        for (BigDecimal discount : this.order.getDiscounts()) {
            subTotal = subTotal.subtract(discount);
        }

        // calculate tax
        BigDecimal tax = subTotal.multiply(this.order.getTax());

        // calculate GrandTotal
        BigDecimal grandTotal = subTotal.add(tax);

        return grandTotal;
    }


}

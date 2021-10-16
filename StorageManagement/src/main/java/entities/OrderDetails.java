package entities;

public class OrderDetails
{
    private int id,ordersId,productId,number;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getOrdersId()
    {
        return ordersId;
    }

    public void setOrdersId(int ordersId)
    {
        this.ordersId = ordersId;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
}

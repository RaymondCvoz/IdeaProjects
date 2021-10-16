package entity;

public class Products
{
    private String id;
    private String name;
    private String value;
    private String time;

    public Products(String id,String name,String value,String time)
    {
        this.id = id;
        this.name = name;
        this.value = value;
        this.time = time;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
}

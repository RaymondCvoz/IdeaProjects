package entities;

public class User
{
    private int id;
    String name,password,date;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

//    public String getDate()
//    {
//        return date;
//    }
//
//    public void setDate(String date)
//    {
//        this.date = date;
//    }
}

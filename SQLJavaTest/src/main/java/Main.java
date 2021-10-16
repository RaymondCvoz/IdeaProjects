import entity.Products;
import tools.ConnectionKit;
import tools.DBOperation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ConnectionKit connectionKit = new ConnectionKit();
        Connection connection = connectionKit.getConnection();
        Scanner scanner = new Scanner(System.in);
        DBOperation dbOperation = new DBOperation();
        int num;
        num = scanner.nextInt();
        ArrayList<String> key = new ArrayList<>();
        ArrayList<String> value = new ArrayList<>();
        System.out.println("请输入要查询的键：");
        for(int i = 0;i < num;i++)
        {
            key.add(scanner.next());
        }
        System.out.println("请输入要查询的值：");
        {
            for(int i = 0;i < num;i++)
            {
                value.add(scanner.next());
            }
        }
        ArrayList<Products> result;
        result = dbOperation.queryProduct(key,value);
        for(Products products: result)
        {
            System.out.println(products.getId() + " " + products.getName()
                    + " " + products.getValue() + " " + products.getTime());
        }
    }
}

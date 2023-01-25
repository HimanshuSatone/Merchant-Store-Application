package com.example.utopianstore;

public class Order {

    //Functionality to insert order details into order table
    public static boolean placeOrder(String customerEmail, Product product, String productId){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("INSERT INTO `order` ( `customerid`, `%s`) VALUES ((select customerid from customer where email ='%s') , '%s')",productId,customerEmail,product.getId());
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }
}

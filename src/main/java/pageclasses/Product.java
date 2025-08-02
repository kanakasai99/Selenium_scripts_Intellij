package pageclasses;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String ProductName;
    private int price;

    public Product(String productName, int price) {
        this.ProductName = productName;
        this.price = price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
public List<String> getProductList(){

List<String> productList=new ArrayList<>();
    productList.add("apple mac pro");
    productList.add("apple iphone pro");
    productList.add("Apple pro mac");
    return productList;
}

}

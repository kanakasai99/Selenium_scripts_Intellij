package pageclasses;

public class Search {

    public String displayProductName(Product product) {
        if (product.getProductList().contains(product.getProductName())) {
            return product.getProductName();
        }
        return null;
    }
}

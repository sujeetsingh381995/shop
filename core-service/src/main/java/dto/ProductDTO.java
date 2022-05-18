package dto;


import com.ziletech.shop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private double price;

    public void copyFromEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public void copyToEntity(Product product) {
        product.setName(this.getName());
        product.setPrice(this.getPrice());

    }


}

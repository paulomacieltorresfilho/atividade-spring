package placeti.atividadespring.requests;

import lombok.Data;

@Data
public class ProductPutRequestBody{
    private Long id;
    private String name;
    private double price;
    private int quantity;
}

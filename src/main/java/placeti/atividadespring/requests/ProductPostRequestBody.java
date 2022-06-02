package placeti.atividadespring.requests;

import lombok.Data;

@Data
public class ProductPostRequestBody {
    private String name;
    private double price;
    private int quantity;
}

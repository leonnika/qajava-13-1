package ru.netology.domain;

        import lombok.Data;
        import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TShirt extends Product {
    private String color;
    private String size;

    public TShirt() {
    }

    public TShirt(int id, String name, int price, String color, String size) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }
}

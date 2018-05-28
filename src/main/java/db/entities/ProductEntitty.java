package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "tests",schema = "rozetka")
public class ProductEntitty {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="product_name")
    private String prouct_name;

    @Column(name="product_cost")
    private Integer product_cost;


    public ProductEntitty() {
    }

    public ProductEntitty(String prouct_name, Integer product_cost) {
        this.prouct_name = prouct_name;
        this.product_cost = product_cost;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getProuct_name() {
        return prouct_name;
    }
    public void setProuct_name(String prouct_name) {
        this.prouct_name = prouct_name;
    }

    public Integer getProduct_cost() {
        return product_cost;
    }
    public void setProduct_cost(Integer product_cost) {
        this.product_cost = product_cost;
    }
}

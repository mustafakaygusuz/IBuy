package kodlamaio.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data      //lombok getter setter
@Entity    //Spring için Entity katmanını belirtiyor
@Table(name="products")
@AllArgsConstructor  //tüm argümanlar constructora parametre oalrak ekleniyor
@NoArgsConstructor   //argümansız constructor
public class Product {

    @Id                   //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)       //++1
    @Column(name="product_id")
    private int id;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;



}


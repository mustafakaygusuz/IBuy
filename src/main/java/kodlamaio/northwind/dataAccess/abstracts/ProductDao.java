package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    
     Product getByProductName(String productName);

     Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

     List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

     List<Product> getByCategoryIn(List<Integer> categories);

     List<Product> getByProductNameContains(String productName);

     List<Product> getByProductNameStartsWith(String productName);

     //JPQL
    @Query("From Product where productName=:productName and category.categoryId=:categoryId ")
     List<Product> getByNameAndCategory(String productName, int categoryId);

    //from ile başlamak tüm alanları çeker bazı alanlar için select ile başlanır
    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p ")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //üç alanı ProductWithCategoryDto'ya aktarıyoruz
    // select p.productId, p.productName, c.categoryName from Category c inner join Product p
    // on c.categoryId = p.categoryId

    //JPQL de one to many şeklinde yazmak kolaylık sağlar (base tablodan gitmek daha kullanışlı)
}

package es.deusto.ingenieria.sd.org.datanucleus.jdo.dao;

import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Shelf;

public interface IProductDAO {
	public void storeProduct(Product product);
	public List<Product> getProducts();
	public List<Book> getBooks();
	public Shelf getShelf(String name);
	public Product getProduct(String name);
	public void updateProduct(Product product);
	public void deleteAllProducts();

}

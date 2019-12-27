package es.deusto.ingenieria.sd.datanucleus.jdo.remote;

import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.ingenieria.sd.org.datanucleus.jdo.dao.IProductDAO;
import es.deusto.ingenieria.sd.org.datanucleus.jdo.dao.ProductDAO;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Shelf;


public class ProductFinderServer extends UnicastRemoteObject implements IProductFinder {
	private IProductDAO dao;

	private static final long serialVersionUID = 1L;
	public ProductFinderServer()throws RemoteException {
		super();
		dao = new ProductDAO();
		Product product1 = new Product("iPad", "A standard iPad from Apple", 300d);
		dao.storeProduct(product1);
		Book book1 = new Book("Dracula", "First Edition", 500d, "Bram Stoker", "0-342-232345-0", "Dover Publishing");
		Shelf shelf= new Shelf("First Shelf");
		book1.addCopy("30", "Perfect, almost new", shelf);
		book1.addCopy("45", "Scratches on front cover", shelf);
		dao.storeProduct(book1);

	}
	
	@Override
	public List<Product> getProducts() throws RemoteException {
		// TODO Auto-generated method stub
		List<Product> products = dao.getProducts();
		System.out.println("Returning Products to client ....");
		return products;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("Attention: arguments missing");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IProductFinder server = new ProductFinderServer();
			Naming.rebind(name, server);
			System.out.println("Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("Product Finder Exception: " + e.getMessage());
			e.printStackTrace();
		}

	}

}

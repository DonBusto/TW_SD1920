package es.deusto.ingenieria.sd.datanucleus.client;


import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Copy;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Shelf;


public class ClientController {
	
      
    public static void main(String[] args)  throws RemoteException {
        
    	RMIServiceLocator rsl = new RMIServiceLocator();
    	rsl.setService(args[0],args[1],args[2]);
    	List<Product> products = rsl.getService().getProducts();
		System.out.println("Mixture of Products and Books ...");
    
		for (Product p: products){
			System.out.println(p);
		
			if (p instanceof Book){
				for (Copy c: ((Book)p).getCopies()){
					System.out.println ("Copy details: " + c.getCopyNum() + ", " + c.getState());
					System.out.println ("In Shelf: " + c.getShelf().getIdentifier());
				}
			}

		}
    }
}

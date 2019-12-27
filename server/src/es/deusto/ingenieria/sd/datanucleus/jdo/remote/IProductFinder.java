package es.deusto.ingenieria.sd.datanucleus.jdo.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.Product;

public interface IProductFinder extends Remote {

	public List<Product> getProducts() throws RemoteException;
}

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Adder {

	public Server() throws RemoteException
	{
		
	}
	public int[] add(int arr[])throws RemoteException 
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<(arr.length-1); j++)
				
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;		
	}
	
	public static void main(String args[]) throws AlreadyBoundException
	{
		try
		{
			Registry reg = LocateRegistry.createRegistry(1000);
			reg.bind("hi server", new Server());
			System.out.println("Server is Ready: ");
		}
		catch(RemoteException e)
		{
			System.out.println("exception "+e);
		}
	}
		
}

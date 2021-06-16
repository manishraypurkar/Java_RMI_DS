import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util .Scanner;

public class Client {
	public static void main(String args[]) throws RemoteException
	{
		Client c = new Client();
		c.connectRemote(); 
	}
	private void connectRemote()throws RemoteException
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			Registry reg = LocateRegistry.getRegistry("localHost",1000);
			Adder ad = (Adder)reg.lookup("hi server");
			//System.out.println("Enter the two numbers: ");
			System.out.println("Enter the size of array: ");
			int N = sc.nextInt();
			int arr[] = new int[N];
			System.out.println("Enter the elements of array: ");
			for(int i=0; i<arr.length; i++)
			{
				arr[i] = sc.nextInt();
			}
			//int a = sc.nextInt();
			//int b = sc.nextInt();
			
			int[] arr1 = new int[N];
			for(int i=0; i<arr.length; i++)
			{
				arr1[i]= ad.add(arr);
			}
			
			
		}
		catch(NotBoundException |RemoteException e)
		{
			System.out.println("exception "+e);
		}
	}
}

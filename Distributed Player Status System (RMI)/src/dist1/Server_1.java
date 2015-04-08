package dist1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;


public class Server_1 implements Common_Interface{
	Hashtable< String, Hashtable<String, Player>> _main=new Hashtable<String,Hashtable<String, Player>>();
	Hashtable< String, Player> _hash=new Hashtable<String,Player>();
	Hashtable< String, Boolean> _status=new Hashtable<String,Boolean>();
	@Override //Return input text as-is.
	public Boolean CreatePlayerAccount(String f_name,String l_name,String age,String u_name,String password,String ipaddress)
	{
		String _initial=u_name.substring(0,1);
		//Hashtable< String, Player> _hash=new Hashtable<String,Player>();
		_hash.put(u_name, new Player(f_name,l_name,age,u_name,password,ipaddress));
		return true;
	}
	@Override
	public Boolean player_signin(String u_name,String password)
	{
		boolean _check=false;
		Player p=_hash.get(u_name);
		if(p!=null)
		{
			if(p.password.equals(password))
			{
				_check=true;
				Set_Status(u_name);
			}
			else
			{
				_check=false;
			}
		}
		else
		{
			_check=false;
		}
		
		return _check;
	}
	@Override
	public Boolean player_signout(String u_name)
	{
		_status.remove(u_name);
		return true;
	}
	@Override
	public Boolean Set_Status(String u_name)
	{
		_status.put(u_name,true);
		return true;
	}
	@Override
	public Boolean Check_User(String u_name)
	{
		Boolean _bool=false;
		Player p=_hash.get(u_name);
		if(p!=null)
		{
			_bool=false;
		}
		else
		{
			_bool=true;
		}
		return _bool;
	}
	@Override
	public String getPlayerStatus ()
	{
		int totalPlayer=_hash.size();
		int onlineplayer=_status.size();
		return "Number of Online players in Server 1 is "+onlineplayer+"\n and Number of Offline players in Server 2 is "+(totalPlayer-onlineplayer);
	}
	public void _exportServer() throws Exception
	{
		Remote obj=UnicastRemoteObject.exportObject(this,2020);
		Registry r=LocateRegistry.createRegistry(2020);
		r.rebind("server_1", obj);
	}
	public static void main(String[] args)
	{
		try
		{
			(new Server_1())._exportServer();
			System.out.println("Server is Up and Running");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}

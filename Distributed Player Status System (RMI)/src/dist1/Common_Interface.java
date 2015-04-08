package dist1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Common_Interface extends Remote{
	public Boolean CreatePlayerAccount(String f_name,String l_name,String age,String u_name,String password,String ipaddress) throws RemoteException;
	public Boolean player_signin(String u_name,String password) throws RemoteException;
	public Boolean player_signout(String u_name) throws RemoteException;
	public Boolean Set_Status(String u_name) throws RemoteException;
	public String getPlayerStatus () throws RemoteException;
	public Boolean Check_User (String u_name) throws RemoteException;

}

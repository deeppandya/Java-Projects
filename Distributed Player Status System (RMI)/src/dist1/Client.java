package dist1;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.sql.CommonDataSource;


public class Client {
	static String f_name, l_name, age, u_name, password, ipaddress;
	static Common_Interface _interface=null;
	//Return basic menu.
	public static void showMenu()
	{
		System.out.println("\n****Welcome to Distributed Player Status System (DPSS)****\n");
		System.out.println("Please select an option (1-3)");
		System.out.println("1. Create player account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	public static void showsignin()
	{
		System.out.println("\n****User successfully signed in...****\n");
		System.out.println("Please select an option (1-2)");
		System.out.println("1. Sign Out");
		System.out.println("2. Exit");
	}
	public static void showadmin()
	{
		System.out.println("\n****Admin successfully signed in...****\n");
		System.out.println("Please select an option (1-2)");
		System.out.println("1. Get Player Status");
		System.out.println("2. Sign Out");
	}
	public static Common_Interface GetIp(String ipaddress) throws MalformedURLException, RemoteException, NotBoundException
	{
		Common_Interface inter_face=null;
		if(ipaddress.substring(0, 3).equals("132"))
		{
			inter_face = (Common_Interface)Naming.lookup("rmi://localhost:2020/server_1");
		}
		else if(ipaddress.substring(0, 2).equals("93"))
		{
			inter_face = (Common_Interface)Naming.lookup("rmi://localhost:2020/server_2");
		}
		else if(ipaddress.substring(0, 3).equals("182"))
		{
			inter_face = (Common_Interface)Naming.lookup("rmi://localhost:2020/server_3");
		}
		else
		{
			inter_face=null;
		}
		return inter_face;
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException, UnknownHostException {
		
		//Create an instance of the server -- to be replaced with RMIRegistry lookup.
		try
		{
		System.setSecurityManager(new RMISecurityManager());
		ipaddress=InetAddress.getLocalHost().toString();
		
		
		int _choice=0;
		Scanner _scan = new Scanner(System.in);
		
		showMenu();
		
		while(true)
		{
			Boolean valid = false;
			
			// Enforces a valid integer input.
			while(!valid)
			{
				try{
					_choice=_scan.nextInt();
					valid=true;
				}
				catch(Exception e)
				{
					System.out.println("Invalid Input, please enter an Integer");
					valid=false;
					_scan.nextLine();
				}
			}
			
			// Manage user selection.
			switch(_choice)
			{
			case 1: 
				Boolean _check=false;
				Boolean _user=false;
				Boolean _ip=false;
				String Pass="";
				String user="";
				String Ip="";
				System.out.println("First Name : ");
				f_name=_scan.next();
				System.out.println("Last Name : ");
				l_name=_scan.next();
				System.out.println("Age : ");
				age=_scan.next();
				System.out.println("User Name : ");
				while(!_user)
				{
					user=_scan.next();
					if(!_interface.Check_User(user))
					{
						System.out.println("Please Enter Different Username");
					}
					else
					{
						_user=true;
					}
					
				}
				u_name=user;
				System.out.println("Password : ");
				while(!_check)
				{
					Pass=_scan.next();
					if(Pass.length()<6 || Pass.length()>15)
					{
						System.out.println("Please Enter password between 6 to 15 characters");
					}
					else
					{
						_check=true;
					}
					
				}
				password=Pass;
				System.out.println("IPADDRESS : ");
				Common_Interface inter=null;
				while(!_ip)
				{
					Ip=_scan.next();
					inter=GetIp(Ip);
					if(inter!=null)
					{
						_ip=true;
					}
					else
					{
						System.out.println("Please Enter different IPaddress");
					}
					
				}
				ipaddress=Ip;
				_interface= inter;
					if(_interface.CreatePlayerAccount(f_name, l_name, age, u_name, password, ipaddress))
					{
						System.out.println("Player account is created successfully...");
					}
					else
					{
						System.out.println("Please consult administrator...");
					}
				showMenu();
				break;
			case 2:
				Boolean _ipaddress=false;
				String Ipaddress="";
				System.out.println("User Name : ");
				String username=_scan.next();
				System.out.println("Password : ");
				String password=_scan.next();
				System.out.println("IPADDRESS : ");
				Common_Interface intr=null;
				while(!_ipaddress)
				{
					Ipaddress=_scan.next();
					inter=GetIp(Ipaddress);
					if(inter!=null)
					{
						_ipaddress=true;
					}
					else
					{
						System.out.println("Please Enter different IPaddress");
					}
					
				}
				ipaddress=Ipaddress;
				_interface= intr;
				if(!username.equals("Admin"))
				{
					if(_interface.player_signin(username, password))
						{
							showsignin();
							int choice= _scan.nextInt();
							switch(_choice)
							{
							case 1: 
								if(_interface.player_signout(username))
								{
									System.out.println("Player successfully signed out");
									showMenu();
									
								}
								else
								{
									System.out.println("Plaese try with different username and password");
								}
								break;
							case 2:
								if(_interface.player_signout(username))
								{
									System.out.println("Player successfully signed out");
									System.out.println("Have a nice day!");
									//_scan.close();
									//System.exit(0);
								}
								break;
							default:
								System.out.println("Invalid Input, please try again.");
							}
						}
				}
				else
				{
					if(password.equals("Admin"))
					{
						showadmin();
						int choice= _scan.nextInt();
						switch(choice)
						{
						case 1: 
							String _ServerStatus=_interface.getPlayerStatus();
							System.out.println(_ServerStatus);
							showadmin();
							break;
						case 2:
								System.out.println("Admin successfully signed out");
								System.out.println("Have a nice day!");
								//_scan.close();
								//System.exit(0);
						default:
							System.out.println("Invalid Input, please try again.");
						}

					}
				}
				showMenu();
				break;
			case 3:
				System.out.println("Have a nice day!");
				_scan.close();
				System.exit(0);
			default:
				System.out.println("Invalid Input, please try again.");
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
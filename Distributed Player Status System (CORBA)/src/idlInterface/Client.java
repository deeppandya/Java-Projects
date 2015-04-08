package idlInterface;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;


public class Client {

	static String f_name, l_name, age, u_name, password, ipaddress;
	static Scanner _scan = new Scanner(System.in);
	static Log _log=new Log("client");
	static DPSS _call;
	static float _servercode=0;
	
	public static void main(String[] args) throws NotFound, CannotProceed, InvalidName, org.omg.CORBA.ORBPackage.InvalidName, MalformedURLException, RemoteException, NotBoundException {
		try{
			Client _client=new Client();
			ORB orb = ORB.init(args, null); //creates and initializes the ORB
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService"); //resolve_initial_references method used to find services such as the Naming Service and the root POA 
			NamingContext ncRef = NamingContextHelper.narrow(objRef);
			
			//ipaddress=_scan.next();
			//NameComponent nc = _client.GetIp(ipaddress);
			//NameComponent path [] = { nc };
			//DPSS _call =DPSSHelper.narrow(ncRef.resolve(path));
			_client.Callrun(ncRef);
			
			} 
			catch(org.omg.CORBA.SystemException e) {e.getMessage();}

	}
	
	public static void showMenu(NamingContext _name) throws MalformedURLException, RemoteException, NotBoundException, NotFound, CannotProceed, InvalidName
	{
		System.out.println("\n****Welcome to Distributed Player Status System (DPSS)****\n");
		System.out.println("Please enter IP address : \n");
		ipaddress=_scan.next();
		NameComponent nc = GetIp(ipaddress);
		NameComponent path [] = { nc };
		_call =DPSSHelper.narrow(_name.resolve(path));
		System.out.println("Please select an option (1-3)");
		System.out.println("1. Create player account");
		System.out.println("2. Login");
		System.out.println("3. Exit\n");
	}
	
	//Return Player Menu
	public static void showsignin()
	{
		System.out.println("\n****User successfully signed in...****\n");
		System.out.println("Please select an option (1-2)");
		System.out.println("1. Sign Out");
		System.out.println("2. Exit\n");
	}
	
	//Show Admin Menu
	public static void showadmin()
	{
		System.out.println("\n****Admin successfully signed in...****\n");
		System.out.println("Please select an option (1-3)");
		System.out.println("1. Get Player Status");
		System.out.println("2. Suspend User Account");
		System.out.println("3. Sign Out\n");
	}
	public static NameComponent GetIp(String ipaddress) throws MalformedURLException, RemoteException, NotBoundException
	{
		NameComponent namecomponent=null;
		_log.Info("Requesting for registry...");
		//Registry _registry=LocateRegistry.getRegistry("localhost");
//		Registry _registry=LocateRegistry.getRegistry("192.168.173.1");
		if(ipaddress.substring(0, 3).equals("132"))
		{
			namecomponent = new NameComponent("DPSSserver_1", "");
			_servercode=1;
		}
		else if(ipaddress.substring(0, 2).equals("93"))
		{
			namecomponent = new NameComponent("DPSSserver_2", "");
			_servercode=2;
		}
		else if(ipaddress.substring(0, 3).equals("182"))
		{
			namecomponent = new NameComponent("DPSSserver_2", "");
			_servercode=3;
		}
		else
		{
			namecomponent=null;
			_log.Info("Request for registry failed...");
		}
		_log.Info("Registry found...");
		return namecomponent;
	}
	public void Callrun(NamingContext _name)
	{
		try
		{
		int _choice=0;
		_log.Info("Client started...");
		showMenu(_name);
		
		while(true)
		{
			Boolean valid = false;
			
			// Enforces a valid integer input.
			while(!valid)
			{
				try{
					_choice=_scan.nextInt();
					valid=true;
					_log.Info("Entered valid Home menu choice: "+_choice);
				}
				catch(Exception e)
				{
					System.out.println("Invalid Input, please enter valid value\n");
					valid=false;
					_log.logger.log(Level.WARNING, "Invalid input for home menu selection");
					_scan.nextLine();
				}
			}
			
			// Manage user selection.
			switch(_choice)
			{
			//Register Player
			case 1: 
				_log.Info("Regestering new Player...");
				Boolean _check=false;
				Boolean _user=false;
				String Pass="";
				String user="";
				System.out.println("\nFirst Name : ");
				f_name=_scan.next();
				System.out.println("Last Name : ");
				l_name=_scan.next();
				System.out.println("Age : ");
				age=_scan.next();
				System.out.println("User Name : ");
				while(!_user)
				{
					user=_scan.next();
					if(!_call.Check_User(user))
					{
						System.out.println("Please Enter Different Username\n");
						_log.logger.log(Level.WARNING, "Existing Username Entered...");
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
						System.out.println("Please Enter password between 6 to 15 characters\n");
						_log.logger.log(Level.WARNING, "Invalid password...");
					}
					else
					{
						_check=true;
					}
					
				}
				password=Pass;
					if(_call.CreatePlayerAccount(f_name, l_name, age, u_name, password, ipaddress))
					{
						System.out.println("Player account is created successfully...\n");
						_log.Info("Player successfully Registered..."+u_name);
					}
					else
					{
						System.out.println("Account Registration failed\n");
						_log.logger.log(Level.SEVERE, "Account Registration failed..."+u_name+"...Please consult administrator...");
					}
				showMenu(_name);
				break;
				//SignIn
			case 2:
				System.out.println("User Name : ");
				String username=_scan.next();
				System.out.println("Password : ");
				String password=_scan.next();
				
				if(!username.equals("Admin"))
				{
					if(_call.player_signin(username, password))
						{
							_log.Info("Player logged in..."+username); 
							showsignin();
							int choice= _scan.nextInt();
							
							switch(choice)
							{
							case 1: 
								if(_call.player_signout(username))
								{
									System.out.println("Player successfully signed out");
									_log.Info("Player successfully signed out..."+username);
									//showMenu();
									
								}
								else
								{
									System.out.println("Problem signing out...Consult Admin...");
									_log.logger.log(Level.SEVERE, "Sign out problem..."+username);
								}
								break;
							case 2:
								if(_call.player_signout(username))
								{
									System.out.println("Player successfully signed out");
									System.out.println("Have a nice day!");
									_log.Info("Player successfully signed out..."+username);
									//_scan.close();
									//System.exit(0);
								}
								else
								{
									System.out.println("Problem Exiting...Consult Admin...");
									_log.logger.log(Level.SEVERE, "Exit problem..."+username);
								}
								break;
							default:
								System.out.println("Invalid Input, please try again.");
								_log.logger.log(Level.SEVERE, "Invalid Input for Player Menu...");
								
							}
						}
					
					else
					{
						System.out.println("Wrong Username or Password.../n Please try again...");
						_log.logger.log(Level.SEVERE, "Wrong Username or Password entered..."+username);
						//showMenu();
					}
				}
				else
				{
					if(password.equals("Admin"))
					{
						_log.Info("Admin logged in ..");
						showadmin();
						int choice= _scan.nextInt();
						switch(choice)
						{
						case 1:
							_log.Info("Requesting for player status...");
							String _ServerStatus=_call.getPlayerStatus(_servercode);
							System.out.println(_ServerStatus);
							_scan.nextLine();
							break;
						case 2:
							_log.Info("Request to suspend user account...");
							System.out.println("Please enter username to suspend ");
							String name=_scan.next();
							if(_call.suspendAccount(name))
							{
								System.out.println("User account has been suspended");
								_log.Info("User account has been suspended");
							}
							else
							{
								System.out.println("Please try again with different username ");
								_log.logger.log(Level.SEVERE, "Please try again with different username");
							}
							break;
						case 3:
								System.out.println("Admin successfully signed out");
								System.out.println("Have a nice day!");
								_log.Info("Admin successfully signed out...");
								_log.Info("Have a nice day");
								//_scan.close();
								//System.exit(0);
						default:
							System.out.println("Invalid Input, please try again.");
							_log.logger.log(Level.SEVERE, "Invalid Input");
							_scan.nextLine();
						}

					}
				}
				showMenu(_name);
				break;
			case 3:
				System.out.println("Have a nice day!");
				_log.Info("System Exit done successfully...");
				_scan.close();
				System.exit(0);
			default:
				System.out.println("Invalid Input, please try again.");
				_log.logger.log(Level.SEVERE, "Invalid Input");
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			_log.logger.log(Level.SEVERE, e.getMessage());
		}
	}

}

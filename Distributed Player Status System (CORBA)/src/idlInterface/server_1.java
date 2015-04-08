package idlInterface;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Level;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;



public class server_1 {
	static serverImpl SLSRef=null;
	public static void main(String[] args)
	{
		try{
			//Properties _prop=new Properties();
			//_prop.put("org.omg.CORBA.ORBInitialPort", "1050");
			ORB orb = ORB.init(args, null); //creates and initializes the ORB
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA")); //gets a reference to the root POA
			rootpoa.the_POAManager().activate(); // and activates the POAManager.
			SLSRef = new serverImpl(); //creates an instance of ShapeListServant, which is a Java object 
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(SLSRef); //makes this instance into a CORBA object by registering it with POA
			DPSS SLRef = DPSSHelper.narrow(ref); //the norrow method in ShapeListHelper casts down to class ShapeList
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContext ncRef = NamingContextHelper.narrow(objRef); //Servers using the Naming Service get a root naming context
			NameComponent nc = new NameComponent("DPSSserver_1", ""); //then make a NameComponent
			NameComponent path[] = {nc}; //define a path
			ncRef.rebind(path, SLRef); //use the rebind method to register the name and remote object reference
			//System.out.println("Server_1 is running...");
			UDPConnection();
			orb.run(); //waits for incoming client requests
			
			}
			catch (Exception e) { e.getMessage(); }
	}
	public static void UDPConnection()
	{
		Log log = new Log("NA");
		
		try {
			
			System.out.println("Server_1 is up and running");
			log.Info("Server started.");
			
			DatagramSocket _socket = null;
			try {
				_socket = new DatagramSocket(1234);
				log.Info("Socket created for Receiving status request from other servers at 1234...");
				
				while (true) {
					byte[] in = new byte[1000];

					DatagramPacket _packet = new DatagramPacket(in, in.length);
					_socket.receive(_packet);
					log.Info("Status request Received from server located at..."
							+ _packet.getAddress().toString());

					byte[] _out = SLSRef.playerStatus().getBytes();
					DatagramPacket _reply = new DatagramPacket(_out,
							_out.length, _packet.getAddress(),
							_packet.getPort());
					_socket.send(_reply);
					log.Info("Status request Sent to server located at..."
							+ _packet.getAddress().toString());

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				log.logger.log(Level.SEVERE,
						"Problem opening socket at port 1234...", e);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.logger.log(Level.SEVERE, "RMI Registry Binding problem...", e);

		}
	}
}

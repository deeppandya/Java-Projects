package idlInterface;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;

public class serverImpl extends DPSSPOA {

	Hashtable<String, ArrayList<Player>> _hash = new Hashtable<String, ArrayList<Player>>();
	Hashtable<String, Boolean> _status = new Hashtable<String, Boolean>();
	static Log log = new Log("NA");

	@Override
	public boolean CreatePlayerAccount(String f_name, String l_name,
			String age, String u_name, String password, String ipaddress) {
		String _initial = u_name.substring(0, 1).toUpperCase();
		boolean flag = false;
		ArrayList<Player> _templist = new ArrayList<Player>();
		ArrayList<Player> _playerlist = new ArrayList<Player>();

		try {
			if (_hash.get(_initial) != null) {

				synchronized (_hash.get(_initial)) {
					_templist = _hash.get(_initial);
					if (_templist != null) {

						_templist.add(new Player(f_name, l_name, age, u_name,
								password, ipaddress));
						_hash.put(_initial, _templist);
						log.Info("Player has been registered..." + u_name);
						flag = true;
					}
				}

			} else {
				_playerlist.add(new Player(f_name, l_name, age, u_name,
						password, ipaddress));
				_hash.put(_initial, _playerlist);
				log.Info("Player has been registered..." + u_name);
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
			log.logger.log(Level.SEVERE,
					"Problem Registering Player in hashtable...", e);
		}
		return flag;
	}

	@Override
	public boolean player_signin(String u_name, String password) {
		boolean _check = false;
		Player p = null;
		Player temp = null;
		ArrayList<Player> _list = null;

		if (_hash.get(u_name.substring(0, 1).toUpperCase()) != null) {

			synchronized (_hash.get(u_name.substring(0, 1).toUpperCase())) {
				_list = _hash.get(u_name.substring(0, 1).toUpperCase());
				Iterator<Player> i = _list.iterator();
				while (i.hasNext()) {
					temp = i.next();
					if ((temp.u_name).equals(u_name)) {
						p = temp;
						break;
					}
				}
			}
		}
		if (p != null) {
			if (p.password.equals(password)) {
				_check = true;
				Set_Status(u_name);
				log.Info("Player has signed in(online)..." + u_name);
			} else {
				_check = false;
				log.Warning("failed sign in attempt(password incorrect)..."
						+ u_name);
			}
		} else {
			_check = false;
			log.Warning("failed sign in attempt(user doesn't exist)...");
		}

		return _check;
	}

	@Override
	public boolean player_signout(String u_name) {
		_status.remove(u_name);
		log.Info("Player signed out(offline)..." + u_name);
		return true;
	}

	@Override
	public boolean Set_Status(String u_name) {
		_status.put(u_name, true);
		return true;
	}
	@Override
	public boolean suspendAccount(String u_name)
	{
		boolean _check = false;
		Player p = null;
		Player temp = null;
		ArrayList<Player> _list = null;
		
		if (_hash.get(u_name.substring(0, 1).toUpperCase()) != null) {

			synchronized (_hash.get(u_name.substring(0, 1).toUpperCase())) {
				_list = _hash.get(u_name.substring(0, 1).toUpperCase());
				Iterator<Player> i = _list.iterator();
				while (i.hasNext()) {
					temp = i.next();
					if ((temp.u_name).equals(u_name)) {
						//p = temp;
						i.remove();
						_check=true;
						break;
					}
				}
			}
		}
		else
		{
			_check=false;
		}
		return _check;
	}

	@Override
	public String getPlayerStatus(float servercode) {
		
		DatagramSocket _socket = null;
		String result = "";
		String j = "";
		String _own="";

		try {
			_socket = new DatagramSocket();
			log.Info("Socket created for sendind status request to other servers...");
			InetAddress _address = InetAddress.getByName("localhost");
			
			if(servercode==1)
			{
				_own="North America";
				for (int i = 0; i < 2; i++) {

					byte[] msg = "getplayer: ".getBytes();
					DatagramPacket _request = null;
					DatagramPacket _reply = null;

					if (i == 0) {
						_request = new DatagramPacket(msg, msg.length, _address,
								5678);
						j = "Europe";

					} else {
						_request = new DatagramPacket(msg, msg.length, _address,
								6789);
						j = "Asia";
					}

					_socket.send(_request);
					log.Info("Request sent to " + j
							+ " Server for status of player(Online and offline count)");
					
					byte[] _buffer = new byte[1000];
					_reply = new DatagramPacket(_buffer, _buffer.length);
					_socket.receive(_reply);
					log.Info("Reply received from " + j
							+ " Server for status of player.(Online and offline count)");
					
					String rep = new String(_reply.getData()).trim();
					String[] str = rep.split(",");
					result = result + "Online Players in " + j + " Server are: "
							+ str[0] + " Offline Players in " + j + " Server are: "
							+ str[1] + "\n";
					}
			}
				else if(servercode==2)
				{
					_own="Europe";
					for (int i = 0; i < 2; i++) {

						byte[] msg = "getplayer: ".getBytes();
						DatagramPacket _request = null;
						DatagramPacket _reply = null;

						if (i == 0) {
							_request = new DatagramPacket(msg, msg.length, _address,
									1234);
							j = "NA";

						} else {
							_request = new DatagramPacket(msg, msg.length, _address,
									6789);
							j = "Asia";
						}

						_socket.send(_request);
						log.Info("Request sent to " + j
								+ " Server for status of player(Online and offline count)");
						
						byte[] _buffer = new byte[1000];
						_reply = new DatagramPacket(_buffer, _buffer.length);
						_socket.receive(_reply);
						log.Info("Reply received from " + j
								+ " Server for status of player.(Online and offline count)");
						
						String rep = new String(_reply.getData()).trim();
						String[] str = rep.split(",");
						result = result + "Online Players in " + j + " Server are: "
								+ str[0] + " Offline Players in " + j + " Server are: "
								+ str[1] + "\n";	
				}
				}
				else if(servercode==3)
				{
					_own="Asia";
					for (int i = 0; i < 2; i++) {

						byte[] msg = "getplayer: ".getBytes();
						DatagramPacket _request = null;
						DatagramPacket _reply = null;

						if (i == 0) {
							_request = new DatagramPacket(msg, msg.length, _address,
									1234);
							j = "NA";

						} else {
							_request = new DatagramPacket(msg, msg.length, _address,
									5678);
							j = "Europe";
						}

						_socket.send(_request);
						log.Info("Request sent to " + j
								+ " Server for status of player(Online and offline count)");
						
						byte[] _buffer = new byte[1000];
						_reply = new DatagramPacket(_buffer, _buffer.length);
						_socket.receive(_reply);
						log.Info("Reply received from " + j
								+ " Server for status of player.(Online and offline count)");
						
						String rep = new String(_reply.getData()).trim();
						String[] str = rep.split(",");
						result = result + "Online Players in " + j + " Server are: "
								+ str[0] + " Offline Players in " + j + " Server are: "
								+ str[1] + "\n";
				}
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			log.logger.log(Level.SEVERE,
					"Problem sending request to another servers...", e);
		}
		_socket.close();
		log.Info("Socket closed...");
		String[] ownstring = playerStatus().split(",");
		return result + "Online Players in " +_own+ "Server are : " + ownstring[0]
				+ " Offline Players in " +_own+ " Server are:" + (ownstring[1]) + "\n";
	}

	public String playerStatus() {

		int totalPlayer = 0;
		int onlineplayer = 0;
		int count = 0;
		ArrayList<Player> _list = null;

		synchronized (_hash) {

			for (String i : _hash.keySet()) {
				_list = _hash.get(i);
				Iterator<Player> p = _list.iterator();
				while (p.hasNext()) {
					p.next();
					count++;
				}
			}
			totalPlayer = count;
		}

		synchronized (_status) {
			onlineplayer = _status.size();
		}

		String res = onlineplayer + "," + (totalPlayer - onlineplayer);
		return res;
	}

	@Override
	public boolean Check_User(String u_name) {
		Boolean _bool = false;
		Player p = null;
		Player temp = null;
		ArrayList<Player> _list = null;

		if (_hash.get(u_name.substring(0, 1).toUpperCase()) != null) {

			synchronized (_hash.get(u_name.substring(0, 1).toUpperCase())) {
				// p = _hash.get(u_name);
				_list = _hash.get(u_name.substring(0, 1).toUpperCase());
				Iterator<Player> i = _list.iterator();
				while (i.hasNext()) {
					temp = i.next();
					if (temp.u_name.equals(u_name)) {
						p = temp;
						break;
					}

				}
			}
		}
		if (p != null) {
			_bool = false;
			log.Warning("failed Registration(username already exist)...");
		} else {
			_bool = true;
		}

		return _bool;
	}

}

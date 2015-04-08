/**
 * @author Deep Pandya(Id#) and Harsh Shah(Id#6715591)
 * @date 26/05/2014
 * COMP 6231 - Assignment-1, Distributed Player Status System using Java RMI
 */


package idlInterface;


public class Player {
	public String f_name;
	public String l_name;
	public String age;
	public String u_name;
	public String password;
	public String ipaddress;
	public Player(String f_name,String l_name,String age,String u_name,String password,String ipaddress)
	{
		this.f_name=f_name;
		this.l_name=l_name;
		this.age=age;
		this.u_name=u_name;
		this.password=password;
		this.ipaddress=ipaddress;
	}
	
}

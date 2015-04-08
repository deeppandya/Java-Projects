package idlInterface;

/**
 * Interface definition: DPSS.
 * 
 * @author OpenORB Compiler
 */
public interface DPSSOperations
{
    /**
     * Operation CreatePlayerAccount
     */
    public boolean CreatePlayerAccount(String f_name, String l_name, String age, String u_name, String password, String ipaddress);

    /**
     * Operation player_signin
     */
    public boolean player_signin(String u_name, String password);

    /**
     * Operation player_signout
     */
    public boolean player_signout(String u_name);

    /**
     * Operation Set_Status
     */
    public boolean Set_Status(String u_name);

    /**
     * Operation getPlayerStatus
     */
    public String getPlayerStatus(float servercode);

    /**
     * Operation Check_User
     */
    public boolean Check_User(String u_name);

    /**
     * Operation suspendAccount
     */
    public boolean suspendAccount(String u_name);

}

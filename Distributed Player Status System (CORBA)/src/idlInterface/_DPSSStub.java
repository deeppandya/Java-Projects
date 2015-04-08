package idlInterface;

/**
 * Interface definition: DPSS.
 * 
 * @author OpenORB Compiler
 */
public class _DPSSStub extends org.omg.CORBA.portable.ObjectImpl
        implements DPSS
{
    static final String[] _ids_list =
    {
        "IDL:idlInterface/DPSS:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = idlInterface.DPSSOperations.class;

    /**
     * Operation CreatePlayerAccount
     */
    public boolean CreatePlayerAccount(String f_name, String l_name, String age, String u_name, String password, String ipaddress)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("CreatePlayerAccount",true);
                    _output.write_string(f_name);
                    _output.write_string(l_name);
                    _output.write_string(age);
                    _output.write_string(u_name);
                    _output.write_string(password);
                    _output.write_string(ipaddress);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("CreatePlayerAccount",_opsClass);
                if (_so == null)
                   continue;
                idlInterface.DPSSOperations _self = (idlInterface.DPSSOperations) _so.servant;
                try
                {
                    return _self.CreatePlayerAccount( f_name,  l_name,  age,  u_name,  password,  ipaddress);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation player_signin
     */
    public boolean player_signin(String u_name, String password)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("player_signin",true);
                    _output.write_string(u_name);
                    _output.write_string(password);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("player_signin",_opsClass);
                if (_so == null)
                   continue;
                idlInterface.DPSSOperations _self = (idlInterface.DPSSOperations) _so.servant;
                try
                {
                    return _self.player_signin( u_name,  password);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation player_signout
     */
    public boolean player_signout(String u_name)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("player_signout",true);
                    _output.write_string(u_name);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("player_signout",_opsClass);
                if (_so == null)
                   continue;
                idlInterface.DPSSOperations _self = (idlInterface.DPSSOperations) _so.servant;
                try
                {
                    return _self.player_signout( u_name);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation Set_Status
     */
    public boolean Set_Status(String u_name)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("Set_Status",true);
                    _output.write_string(u_name);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("Set_Status",_opsClass);
                if (_so == null)
                   continue;
                idlInterface.DPSSOperations _self = (idlInterface.DPSSOperations) _so.servant;
                try
                {
                    return _self.Set_Status( u_name);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getPlayerStatus
     */
    public String getPlayerStatus(float servercode)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPlayerStatus",true);
                    _output.write_float(servercode);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPlayerStatus",_opsClass);
                if (_so == null)
                   continue;
                idlInterface.DPSSOperations _self = (idlInterface.DPSSOperations) _so.servant;
                try
                {
                    return _self.getPlayerStatus( servercode);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation Check_User
     */
    public boolean Check_User(String u_name)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("Check_User",true);
                    _output.write_string(u_name);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("Check_User",_opsClass);
                if (_so == null)
                   continue;
                idlInterface.DPSSOperations _self = (idlInterface.DPSSOperations) _so.servant;
                try
                {
                    return _self.Check_User( u_name);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation suspendAccount
     */
    public boolean suspendAccount(String u_name)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("suspendAccount",true);
                    _output.write_string(u_name);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("suspendAccount",_opsClass);
                if (_so == null)
                   continue;
                idlInterface.DPSSOperations _self = (idlInterface.DPSSOperations) _so.servant;
                try
                {
                    return _self.suspendAccount( u_name);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}

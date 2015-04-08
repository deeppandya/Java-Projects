package idlInterface;

/**
 * Interface definition: DPSS.
 * 
 * @author OpenORB Compiler
 */
public abstract class DPSSPOA extends org.omg.PortableServer.Servant
        implements DPSSOperations, org.omg.CORBA.portable.InvokeHandler
{
    public DPSS _this()
    {
        return DPSSHelper.narrow(_this_object());
    }

    public DPSS _this(org.omg.CORBA.ORB orb)
    {
        return DPSSHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:idlInterface/DPSS:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("Check_User")) {
                return _invoke_Check_User(_is, handler);
        } else if (opName.equals("CreatePlayerAccount")) {
                return _invoke_CreatePlayerAccount(_is, handler);
        } else if (opName.equals("Set_Status")) {
                return _invoke_Set_Status(_is, handler);
        } else if (opName.equals("getPlayerStatus")) {
                return _invoke_getPlayerStatus(_is, handler);
        } else if (opName.equals("player_signin")) {
                return _invoke_player_signin(_is, handler);
        } else if (opName.equals("player_signout")) {
                return _invoke_player_signout(_is, handler);
        } else if (opName.equals("suspendAccount")) {
                return _invoke_suspendAccount(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_CreatePlayerAccount(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        String arg4_in = _is.read_string();
        String arg5_in = _is.read_string();

        boolean _arg_result = CreatePlayerAccount(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in, arg5_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_player_signin(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        boolean _arg_result = player_signin(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_player_signout(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = player_signout(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_Set_Status(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = Set_Status(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPlayerStatus(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        float arg0_in = _is.read_float();

        String _arg_result = getPlayerStatus(arg0_in);

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_Check_User(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = Check_User(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_suspendAccount(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = suspendAccount(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

}

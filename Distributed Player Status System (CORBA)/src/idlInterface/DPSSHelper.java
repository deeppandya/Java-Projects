package idlInterface;

/** 
 * Helper class for : DPSS
 *  
 * @author OpenORB Compiler
 */ 
public class DPSSHelper
{
    /**
     * Insert DPSS into an any
     * @param a an any
     * @param t DPSS value
     */
    public static void insert(org.omg.CORBA.Any a, idlInterface.DPSS t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract DPSS from an any
     *
     * @param a an any
     * @return the extracted DPSS value
     */
    public static idlInterface.DPSS extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return idlInterface.DPSSHelper.narrow( a.extract_Object() );
        }
        catch ( final org.omg.CORBA.BAD_PARAM e )
        {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the DPSS TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "DPSS" );
        }
        return _tc;
    }

    /**
     * Return the DPSS IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:idlInterface/DPSS:1.0";

    /**
     * Read DPSS from a marshalled stream
     * @param istream the input stream
     * @return the readed DPSS value
     */
    public static idlInterface.DPSS read(org.omg.CORBA.portable.InputStream istream)
    {
        return(idlInterface.DPSS)istream.read_Object(idlInterface._DPSSStub.class);
    }

    /**
     * Write DPSS into a marshalled stream
     * @param ostream the output stream
     * @param value DPSS value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, idlInterface.DPSS value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to DPSS
     * @param obj the CORBA Object
     * @return DPSS Object
     */
    public static DPSS narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof DPSS)
            return (DPSS)obj;

        if (obj._is_a(id()))
        {
            _DPSSStub stub = new _DPSSStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to DPSS
     * @param obj the CORBA Object
     * @return DPSS Object
     */
    public static DPSS unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof DPSS)
            return (DPSS)obj;

        _DPSSStub stub = new _DPSSStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

package idlInterface;

/**
 * Holder class for : DPSS
 * 
 * @author OpenORB Compiler
 */
final public class DPSSHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal DPSS value
     */
    public idlInterface.DPSS value;

    /**
     * Default constructor
     */
    public DPSSHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DPSSHolder(idlInterface.DPSS initial)
    {
        value = initial;
    }

    /**
     * Read DPSS from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DPSSHelper.read(istream);
    }

    /**
     * Write DPSS into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DPSSHelper.write(ostream,value);
    }

    /**
     * Return the DPSS TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DPSSHelper.type();
    }

}

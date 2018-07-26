// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.7.1
//
// <auto-generated>
//
// Generated from file `bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Model;

public class PersonDetails implements java.lang.Cloneable,
                                      java.io.Serializable
{
    public String firstName;

    public String surname;

    public String pesel;

    public PersonDetails()
    {
        this.firstName = "";
        this.surname = "";
        this.pesel = "";
    }

    public PersonDetails(String firstName, String surname, String pesel)
    {
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PersonDetails r = null;
        if(rhs instanceof PersonDetails)
        {
            r = (PersonDetails)rhs;
        }

        if(r != null)
        {
            if(this.firstName != r.firstName)
            {
                if(this.firstName == null || r.firstName == null || !this.firstName.equals(r.firstName))
                {
                    return false;
                }
            }
            if(this.surname != r.surname)
            {
                if(this.surname == null || r.surname == null || !this.surname.equals(r.surname))
                {
                    return false;
                }
            }
            if(this.pesel != r.pesel)
            {
                if(this.pesel == null || r.pesel == null || !this.pesel.equals(r.pesel))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::Model::PersonDetails");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, firstName);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, surname);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, pesel);
        return h_;
    }

    public PersonDetails clone()
    {
        PersonDetails c = null;
        try
        {
            c = (PersonDetails)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.firstName);
        ostr.writeString(this.surname);
        ostr.writeString(this.pesel);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.firstName = istr.readString();
        this.surname = istr.readString();
        this.pesel = istr.readString();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, PersonDetails v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public PersonDetails ice_read(com.zeroc.Ice.InputStream istr)
    {
        PersonDetails v = new PersonDetails();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<PersonDetails> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, PersonDetails v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<PersonDetails> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(PersonDetails.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final PersonDetails _nullMarshalValue = new PersonDetails();

    public static final long serialVersionUID = 1396276053L;
}
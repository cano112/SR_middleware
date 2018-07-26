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

package pl.edu.agh.wiet.sr.banking.generated.services;

public class CreditEnquiryResponse implements java.lang.Cloneable,
                                              java.io.Serializable
{
    public pl.edu.agh.wiet.sr.banking.generated.model.Currency baseCurrency;

    public double valueInBaseCurrency;

    public double commissionInBaseCurrency;

    public pl.edu.agh.wiet.sr.banking.generated.model.Currency creditCurrency;

    public double valueInCreditCurrency;

    public double commissionInCreditCurrency;

    public CreditEnquiryResponse()
    {
        this.baseCurrency = pl.edu.agh.wiet.sr.banking.generated.model.Currency.USD;
        this.creditCurrency = pl.edu.agh.wiet.sr.banking.generated.model.Currency.USD;
    }

    public CreditEnquiryResponse(pl.edu.agh.wiet.sr.banking.generated.model.Currency baseCurrency, double valueInBaseCurrency, double commissionInBaseCurrency, pl.edu.agh.wiet.sr.banking.generated.model.Currency creditCurrency, double valueInCreditCurrency, double commissionInCreditCurrency)
    {
        this.baseCurrency = baseCurrency;
        this.valueInBaseCurrency = valueInBaseCurrency;
        this.commissionInBaseCurrency = commissionInBaseCurrency;
        this.creditCurrency = creditCurrency;
        this.valueInCreditCurrency = valueInCreditCurrency;
        this.commissionInCreditCurrency = commissionInCreditCurrency;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        CreditEnquiryResponse r = null;
        if(rhs instanceof CreditEnquiryResponse)
        {
            r = (CreditEnquiryResponse)rhs;
        }

        if(r != null)
        {
            if(this.baseCurrency != r.baseCurrency)
            {
                if(this.baseCurrency == null || r.baseCurrency == null || !this.baseCurrency.equals(r.baseCurrency))
                {
                    return false;
                }
            }
            if(this.valueInBaseCurrency != r.valueInBaseCurrency)
            {
                return false;
            }
            if(this.commissionInBaseCurrency != r.commissionInBaseCurrency)
            {
                return false;
            }
            if(this.creditCurrency != r.creditCurrency)
            {
                if(this.creditCurrency == null || r.creditCurrency == null || !this.creditCurrency.equals(r.creditCurrency))
                {
                    return false;
                }
            }
            if(this.valueInCreditCurrency != r.valueInCreditCurrency)
            {
                return false;
            }
            if(this.commissionInCreditCurrency != r.commissionInCreditCurrency)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::pl::edu::agh::wiet::sr::banking::generated::services::CreditEnquiryResponse");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, baseCurrency);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, valueInBaseCurrency);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, commissionInBaseCurrency);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, creditCurrency);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, valueInCreditCurrency);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, commissionInCreditCurrency);
        return h_;
    }

    public CreditEnquiryResponse clone()
    {
        CreditEnquiryResponse c = null;
        try
        {
            c = (CreditEnquiryResponse)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        pl.edu.agh.wiet.sr.banking.generated.model.Currency.ice_write(ostr, this.baseCurrency);
        ostr.writeDouble(this.valueInBaseCurrency);
        ostr.writeDouble(this.commissionInBaseCurrency);
        pl.edu.agh.wiet.sr.banking.generated.model.Currency.ice_write(ostr, this.creditCurrency);
        ostr.writeDouble(this.valueInCreditCurrency);
        ostr.writeDouble(this.commissionInCreditCurrency);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.baseCurrency = pl.edu.agh.wiet.sr.banking.generated.model.Currency.ice_read(istr);
        this.valueInBaseCurrency = istr.readDouble();
        this.commissionInBaseCurrency = istr.readDouble();
        this.creditCurrency = pl.edu.agh.wiet.sr.banking.generated.model.Currency.ice_read(istr);
        this.valueInCreditCurrency = istr.readDouble();
        this.commissionInCreditCurrency = istr.readDouble();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, CreditEnquiryResponse v)
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

    static public CreditEnquiryResponse ice_read(com.zeroc.Ice.InputStream istr)
    {
        CreditEnquiryResponse v = new CreditEnquiryResponse();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<CreditEnquiryResponse> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, CreditEnquiryResponse v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<CreditEnquiryResponse> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(CreditEnquiryResponse.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final CreditEnquiryResponse _nullMarshalValue = new CreditEnquiryResponse();

    public static final long serialVersionUID = 1216063775L;
}

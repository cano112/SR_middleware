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

public class StandardAccount extends Account
{
    public StandardAccount()
    {
        super();
    }

    public StandardAccount(long accountId, PersonDetails owner, double declaredIncome, double balance)
    {
        super(accountId, owner, declaredIncome, balance);
    }

    public StandardAccount clone()
    {
        return (StandardAccount)super.clone();
    }

    public static String ice_staticId()
    {
        return "::Model::StandardAccount";
    }

    @Override
    public String ice_id()
    {
        return ice_staticId();
    }

    public static final long serialVersionUID = -583057498L;

    @Override
    protected void _iceWriteImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice(ice_staticId(), -1, false);
        ostr_.endSlice();
        super._iceWriteImpl(ostr_);
    }

    @Override
    protected void _iceReadImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
        super._iceReadImpl(istr_);
    }
}

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

package pl.edu.agh.wiet.sr.banking.generated.model;

public class PremiumAccount extends Account
{
    public PremiumAccount()
    {
        super();
    }

    public PremiumAccount(long accountId, PersonDetails owner, double declaredIncome, double balance, String password)
    {
        super(accountId, owner, declaredIncome, balance, password);
    }

    public PremiumAccount clone()
    {
        return (PremiumAccount)super.clone();
    }

    public static String ice_staticId()
    {
        return "::pl::edu::agh::wiet::sr::banking::generated::model::PremiumAccount";
    }

    @Override
    public String ice_id()
    {
        return ice_staticId();
    }

    public static final long serialVersionUID = -163031962L;

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
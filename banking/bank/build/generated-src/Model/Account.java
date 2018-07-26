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

public class Account extends com.zeroc.Ice.Value
{
    public Account()
    {
        this.owner = new PersonDetails();
    }

    public Account(long accountId, PersonDetails owner, double declaredIncome, double balance)
    {
        this.accountId = accountId;
        this.owner = owner;
        this.declaredIncome = declaredIncome;
        this.balance = balance;
    }

    public long accountId;

    public PersonDetails owner;

    public double declaredIncome;

    public double balance;

    public Account clone()
    {
        return (Account)super.clone();
    }

    public static String ice_staticId()
    {
        return "::Model::Account";
    }

    @Override
    public String ice_id()
    {
        return ice_staticId();
    }

    public static final long serialVersionUID = 1485410923L;

    @Override
    protected void _iceWriteImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice(ice_staticId(), -1, true);
        ostr_.writeLong(accountId);
        PersonDetails.ice_write(ostr_, owner);
        ostr_.writeDouble(declaredIncome);
        ostr_.writeDouble(balance);
        ostr_.endSlice();
    }

    @Override
    protected void _iceReadImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        accountId = istr_.readLong();
        owner = PersonDetails.ice_read(istr_);
        declaredIncome = istr_.readDouble();
        balance = istr_.readDouble();
        istr_.endSlice();
    }
}
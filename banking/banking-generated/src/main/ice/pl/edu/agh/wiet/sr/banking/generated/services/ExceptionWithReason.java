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

public class ExceptionWithReason extends com.zeroc.Ice.UserException
{
    public ExceptionWithReason()
    {
        this.reason = "";
    }

    public ExceptionWithReason(Throwable cause)
    {
        super(cause);
        this.reason = "";
    }

    public ExceptionWithReason(String reason)
    {
        this.reason = reason;
    }

    public ExceptionWithReason(String reason, Throwable cause)
    {
        super(cause);
        this.reason = reason;
    }

    public String ice_id()
    {
        return "::pl::edu::agh::wiet::sr::banking::generated::services::ExceptionWithReason";
    }

    public String reason;

    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::pl::edu::agh::wiet::sr::banking::generated::services::ExceptionWithReason", -1, true);
        ostr_.writeString(reason);
        ostr_.endSlice();
    }

    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        reason = istr_.readString();
        istr_.endSlice();
    }

    public static final long serialVersionUID = 1250068470L;
}

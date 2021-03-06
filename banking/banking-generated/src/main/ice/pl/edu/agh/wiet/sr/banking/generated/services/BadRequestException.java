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

public class BadRequestException extends ExceptionWithReason
{
    public BadRequestException()
    {
        super();
    }

    public BadRequestException(Throwable cause)
    {
        super(cause);
    }

    public BadRequestException(String reason)
    {
        super(reason);
    }

    public BadRequestException(String reason, Throwable cause)
    {
        super(reason, cause);
    }

    public String ice_id()
    {
        return "::pl::edu::agh::wiet::sr::banking::generated::services::BadRequestException";
    }

    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::pl::edu::agh::wiet::sr::banking::generated::services::BadRequestException", -1, false);
        ostr_.endSlice();
        super._writeImpl(ostr_);
    }

    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
        super._readImpl(istr_);
    }

    public static final long serialVersionUID = -661621879L;
}

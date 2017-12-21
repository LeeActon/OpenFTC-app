package org.firstinspires.ftc.robotcore.internal.webserver;

import fi.iki.elonen.NanoHTTPD;

public interface WebHandlerFilter extends WebHandler
{
    public boolean wantToHandle(NanoHTTPD.IHTTPSession session);
}

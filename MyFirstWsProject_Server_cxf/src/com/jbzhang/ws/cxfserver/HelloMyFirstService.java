package com.jbzhang.ws.cxfserver;

import javax.jws.WebService;

@WebService
public interface HelloMyFirstService {
   String Hello(String name);
}

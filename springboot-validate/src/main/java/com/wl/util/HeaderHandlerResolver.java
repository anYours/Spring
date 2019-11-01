package com.wl.util;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class HeaderHandlerResolver implements HandlerResolver {

	private RequesterCredentials requesterCredentials;
	
	public HeaderHandlerResolver(RequesterCredentials requesterCredentials){
		this.requesterCredentials=requesterCredentials;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getHandlerChain(PortInfo portInfo) {
		return Arrays.asList(requesterCredentials);
	}

}

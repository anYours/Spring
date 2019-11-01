package com.wl.util;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class RequesterCredentials implements SOAPHandler<SOAPMessageContext> {
	
	private static final String gjgxjhpt_rid = "f9e001b4-592d-4745-858b-6ae599d4e1cd@2399";
	private static final String gjgxjhpt_sid = "s_1200000900000_2108";
	private String gjgxjhpt_rTime;
	public static String gjgxjhpt_sign = null;
	
	public RequesterCredentials() {
		this.gjgxjhpt_rTime = ""+System.currentTimeMillis();
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		addRequesterCredentials(context);
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void addRequesterCredentials(SOAPMessageContext context) {
		try {
			Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			
			if (outboundProperty.booleanValue()) {
				SOAPMessage message = context.getMessage();

				SOAPHeader header = message.getSOAPHeader();
				if (header == null) {
					message.getSOAPPart().getEnvelope().addHeader();
					header = message.getSOAPHeader();
				}
				SOAPElement authenticationToken = header.addChildElement("tongtechheader", "", "");
				authenticationToken.addChildElement("gjgxjhpt_rid").addTextNode(gjgxjhpt_rid);
				authenticationToken.addChildElement("gjgxjhpt_sid").addTextNode(gjgxjhpt_sid);
				authenticationToken.addChildElement("gjgxjhpt_rTime").addTextNode(gjgxjhpt_rTime);
				authenticationToken.addChildElement("gjgxjhpt_sign").addTextNode(gjgxjhpt_sign);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * OperatorNotificationServiceMessageReceiverInOut.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 2.0.1
 */
package com.telecom.operator;

/** OperatorNotificationServiceMessageReceiverInOut message receiver */
public class OperatorNotificationServiceMessageReceiverInOut
    extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {

  public void invokeBusinessLogic(
      org.apache.axis2.context.MessageContext msgContext,
      org.apache.axis2.context.MessageContext newMsgContext)
      throws org.apache.axis2.AxisFault {

    try {

      // get the implementation class for the Web Service
      Object obj = getTheImplementationObject(msgContext);

      OperatorNotificationServiceSkeleton skel = (OperatorNotificationServiceSkeleton) obj;
      // Out Envelop
      org.apache.axiom.soap.SOAPEnvelope envelope = null;
      // Find the axisOperation that has been set by the Dispatch phase.
      org.apache.axis2.description.AxisOperation op =
          msgContext.getOperationContext().getAxisOperation();
      if (op == null) {
        throw new org.apache.axis2.AxisFault(
            "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
      }

      java.lang.String methodName;
      if ((op.getName() != null)
          && ((methodName =
                  org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                      op.getName().getLocalPart()))
              != null)) {

        if ("notifyOperator".equals(methodName)) {

          com.telecom.operator.NotifyAck notifyAck5 = null;
          com.telecom.operator.NotifyOperator wrappedParam =
              (com.telecom.operator.NotifyOperator)
                  fromOM(
                      msgContext.getEnvelope().getBody().getFirstElement(),
                      com.telecom.operator.NotifyOperator.class);

          notifyAck5 = skel.notifyOperator(wrappedParam);

          envelope =
              toEnvelope(
                  getSOAPFactory(msgContext),
                  notifyAck5,
                  false,
                  new javax.xml.namespace.QName("http://telecom.com/operator", "NotifyAck"));

        } else {
          throw new java.lang.RuntimeException("method not found");
        }

        newMsgContext.setEnvelope(envelope);
      }
    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  //
  private org.apache.axiom.om.OMElement toOM(
      com.telecom.operator.NotifyOperator param, boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          com.telecom.operator.NotifyOperator.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      com.telecom.operator.NotifyAck param, boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          com.telecom.operator.NotifyAck.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      com.telecom.operator.NotifyAck param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {
    try {
      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

      emptyEnvelope
          .getBody()
          .addChild(param.getOMElement(com.telecom.operator.NotifyAck.MY_QNAME, factory));

      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private com.telecom.operator.NotifyAck wrapnotifyOperator() {
    com.telecom.operator.NotifyAck wrappedElement = new com.telecom.operator.NotifyAck();
    return wrappedElement;
  }

  /** get the default envelope */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
    return factory.getDefaultEnvelope();
  }

  private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type)
      throws org.apache.axis2.AxisFault {

    try {

      if (com.telecom.operator.NotifyAck.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result = com.telecom.operator.NotifyAck.Factory.parse(reader);
        reader.close();
        return result;
      }

      if (com.telecom.operator.NotifyOperator.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result = com.telecom.operator.NotifyOperator.Factory.parse(reader);
        reader.close();
        return result;
      }

    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }

  private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
    org.apache.axis2.AxisFault f;
    Throwable cause = e.getCause();
    if (cause != null) {
      f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
    } else {
      f = new org.apache.axis2.AxisFault(e.getMessage());
    }

    return f;
  }
} // end of class

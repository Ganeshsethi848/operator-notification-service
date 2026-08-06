package com.telecom.operator.service;

import org.apache.axis2.AxisFault;

import com.telecom.operator.NotifyAck;
import com.telecom.operator.NotifyOperator;

public interface OperatorNotificationService {

    NotifyAck notifyOperator(NotifyOperator request) throws AxisFault;

}
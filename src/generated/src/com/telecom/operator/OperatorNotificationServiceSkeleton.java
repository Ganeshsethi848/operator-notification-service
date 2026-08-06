
package com.telecom.operator;

import org.apache.axis2.AxisFault;

import com.telecom.operator.service.OperatorNotificationService;
import com.telecom.operator.service.OperatorNotificationServiceImpl;

public class OperatorNotificationServiceSkeleton {

	private final OperatorNotificationService service = new OperatorNotificationServiceImpl();

	public NotifyAck notifyOperator(NotifyOperator notifyOperator) throws AxisFault {

		return service.notifyOperator(notifyOperator);
	}
}

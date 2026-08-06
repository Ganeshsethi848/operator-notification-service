package com.telecom.operator.service;

import org.apache.axis2.AxisFault;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.telecom.operator.NotifyAck;
import com.telecom.operator.NotifyOperator;
import com.telecom.operator.builder.AckResponseBuilder;

import com.telecom.operator.dao.UserDao;
import com.telecom.operator.security.EncryptionUtil;

public class OperatorNotificationServiceImpl implements OperatorNotificationService {

	private static final Logger logger = LogManager.getLogger(OperatorNotificationServiceImpl.class);

	private final UserDao userDao = new UserDao();

	private final AckResponseBuilder ackResponseBuilder = new AckResponseBuilder();

	@Override
	public NotifyAck notifyOperator(NotifyOperator request) throws AxisFault {

		try {

			logger.info("PORT_ID={} - Processing operator notification", request.getPortId());

			logger.debug("PORT_ID={} - Decrypting password.", request.getPortId());

			String decryptedPassword = EncryptionUtil.decrypt(request.getPassword());

			logger.debug("PORT_ID={} - Password decrypted successfully.", request.getPortId());

			if (!userDao.authenticate(request.getUsername(), decryptedPassword)) {

				throw new AxisFault("Invalid username or password.");
			}

			logger.info("PORT_ID={} - Password authentication successful", request.getPortId());

			NotifyAck response = ackResponseBuilder.buildAcceptedResponse(request.getPortId());

			logger.info("PORT_ID={} - Operator notification completed successfully", request.getPortId());

			return response;

		} catch (RuntimeException ex) {

			logger.error("PORT_ID={} - Database authentication failed",
					request != null ? request.getPortId() : "UNKNOWN", ex);

			throw new AxisFault("DATABASE_UNAVAILABLE", ex);
		} catch (AxisFault ex) {

			throw ex;
		} catch (Exception ex) {

			logger.error("PORT_ID={} - Operator notification failed", request != null ? request.getPortId() : "UNKNOWN",
					ex);

			throw new AxisFault("INTERNAL_SERVER_ERROR", ex);
		}
	}
}

package com.telecom.operator.builder;

import com.telecom.operator.NotifyAck;

public class AckResponseBuilder {

    public NotifyAck buildAcceptedResponse(String portId) {

        NotifyAck response = new NotifyAck();

        response.setPortId(portId);
        response.setAckStatus("ACCEPTED");

        return response;
    }

}
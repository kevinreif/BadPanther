package com.example.application.holders;

import com.example.application.data.entity.ClientInfo;
import com.example.application.data.entity.Observation;

public class FormHolders {
    static ClientInfo clientInfoHolder;
    static Observation observationHolder;


    //Holds Client Info
    public static void setClientInfoHolder(ClientInfo clientInfo) {
        clientInfoHolder = clientInfo;
    }

    public static ClientInfo getClientInfoHolder() {
        return clientInfoHolder;
    }

    //Holds Observation
    public static void setObservation(Observation observation) {
        observationHolder = observation;
    }

    public static Observation getObservationHolder() {
        return observationHolder;
    }
}

package com.redhat.serverless;

import com.redhat.serverless.handler.Handler;
import com.redhat.serverless.handler.Logger;
import org.apache.camel.Exchange;

public class Processor implements org.apache.camel.Processor {
    private final Handler messageHandler;

    public Processor() {
        messageHandler = new Logger();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String message = exchange.getMessage().getBody(String.class);
        if (message != null) {
            messageHandler.handle(message);
        }
    }
}

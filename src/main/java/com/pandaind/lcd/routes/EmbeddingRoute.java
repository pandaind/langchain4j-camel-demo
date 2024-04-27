package com.pandaind.lcd.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmbeddingRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:tick?fixedRate=true&period=5s")
                .routeId("EMBEDDING_ROUTE")
                .setBody(constant("Hello world!"))
                .to("langchain-embeddings:foo")
                .log("${body}");
    }
}

package com.example.currencyconverterservice.config;

import com.example.currencyconverterservice.endpoint.CurrencyConverterEndpoint;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {
    private final Bus bus;
    private final CurrencyConverterEndpoint currencyConverterEndpoint;
    public WebServiceConfig(Bus bus, CurrencyConverterEndpoint currencyConverterEndpoint) {
        this.bus = bus;
        this.currencyConverterEndpoint = currencyConverterEndpoint;
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, currencyConverterEndpoint);
        endpoint.publish("/currency");
        return endpoint;
    }
}

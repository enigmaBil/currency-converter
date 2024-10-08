package com.example.currencyconverterservice.endpoint;

import com.example.currencyconverterservice.currency.CurrencyConvertRequest;
import com.example.currencyconverterservice.currency.CurrencyConvertResponse;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@Service
@WebService(
        serviceName = "CurrencyConvertService",
        portName = "CurrencyConvertPort",
        targetNamespace = "http://www.example.com/currencyconverterservice/currency",
        endpointInterface = "com.example.currencyconverterservice.currency.CurrencyConvertPortType"
)
public class CurrencyConverterEndpoint implements com.example.currencyconverterservice.currency.CurrencyConvertPortType
{
    @Override
    public CurrencyConvertResponse currencyConvert(CurrencyConvertRequest request) {
        CurrencyConvertResponse response = new CurrencyConvertResponse();
        // Taux de conversion fictif de 0,9 pour la démonstration
        double conversionRate = 0.9;
        double convertedAmount = request.getAmount() * conversionRate;
        response.setConvertedAmount(convertedAmount);
        return response;
    }
}

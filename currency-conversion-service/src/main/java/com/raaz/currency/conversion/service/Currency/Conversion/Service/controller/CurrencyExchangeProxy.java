package com.raaz.currency.conversion.service.Currency.Conversion.Service.controller;

import com.raaz.currency.conversion.service.Currency.Conversion.Service.bean.ConversionCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="currency-exchange-service", url="currency-exchange-microservice:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ConversionCurrency retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}

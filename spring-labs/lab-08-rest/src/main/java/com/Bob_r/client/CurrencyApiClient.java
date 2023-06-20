package com.Bob_r.client;

import com.Bob_r.dto.CurrencyApiResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(url = "http://apilayer.net/api",name = "currencyApiClient")
public interface CurrencyApiClient {
    //http://apilayer.net/api --> baseUrl
// /live --> endpoint
// ?
// access_key=483b1ef51d63928d3aeb7079d3bd5557
// &currencies=EUR,TRY
// &source=USD
// &format=1
    @GetMapping("/live")
    CurrencyApiResponse getCurrencyRates(@RequestParam("access_key") String accessKey,
                                         @RequestParam("currencies") String currencies,
                                         @RequestParam("source") String source,
                                         @RequestParam("format") int format);
}
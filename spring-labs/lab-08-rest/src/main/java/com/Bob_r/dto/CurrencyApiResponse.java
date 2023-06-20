package com.Bob_r.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.stream.Stream;

@Getter
@Setter
public class CurrencyApiResponse {
private boolean success;
private String terms;
private String privacy;
private Long timestamp;
private String source;

private Map <String,Double> quotes;
}

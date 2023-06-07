package com.Bob_r.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCodeWrapper {
    private boolean success;
    private String message ;
    private Integer code;
    private Object date;

    public ResponseCodeWrapper(String message, Object date) {
        this.success = true;
        this.code = HttpStatus.OK.value();
        this.message = message;
        this.date = date;
    }

        public ResponseCodeWrapper(String message) {
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
    }

}
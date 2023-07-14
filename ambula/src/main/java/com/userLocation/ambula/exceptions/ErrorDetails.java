package com.userLocation.ambula.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
//This class is created to give a systamatic manner to throw exception.So that user able to know
// main reason of exception and handle exception acording to their need.
public class ErrorDetails {

    private LocalDateTime timestamp;

    private String message;

    private String details;

    ErrorDetails(LocalDateTime timestamp , String message ,String details){
        this.details=details;
        this.message=message;
        this.timestamp=timestamp;
    }

}

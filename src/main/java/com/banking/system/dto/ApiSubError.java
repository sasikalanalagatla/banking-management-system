package com.banking.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiSubError {
    private String string;
    private String field;
    private String rejectedValue;
    private String message;
}

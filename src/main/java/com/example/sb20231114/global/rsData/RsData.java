package com.example.sb20231114.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    private String resultCode, msg;
    private T data;
}

package com.ll.sb202311.global.rsData.RsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {            // 제너릭 사용
    private String resultCode;
    private String msg;
    private T data;
}

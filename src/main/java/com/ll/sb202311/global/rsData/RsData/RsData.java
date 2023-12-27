package com.ll.sb202311.global.rsData.RsData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class RsData<T> {            // 제너릭 사용
    private final String resultCode;
    private final String msg;
    private T data;
}

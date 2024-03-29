package com.ll.sb202311.global.rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RequestScope  // 하나의 http요청이  빈의 생명주기
@Component
@RequiredArgsConstructor
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public String redirect(String path, String msg) {
        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);
        return "redirect:" + path + "?msg" + msg;
    }
}

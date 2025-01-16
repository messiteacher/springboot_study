package com.example.demo.domain.wiseSaying.controller;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import com.example.demo.domain.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WiseSayingController {

    private final WiseSayingService wiseSayingService;

    @GetMapping("/wiseSayings")
    public List<WiseSaying> getWiseSayings() {
        return wiseSayingService.getAllItems();
    }

    @GetMapping("/wiseSaying/write")
    public WiseSaying writeWiseSaying(String content, @RequestParam(defaultValue = "no name") String author) {

        System.out.println("content = " + content);
        System.out.println("author = " + author);

        return wiseSayingService.write("명언1", "작가1");
    }

    @GetMapping("/wiseSayings/1")
    public WiseSaying getItem1() {
        return wiseSayingService.getItem(1).orElse(null);
    }

    @GetMapping("/wiseSayings/2")
    public WiseSaying getItem2() {
        return wiseSayingService.getItem(2).orElse(null);
    }
}

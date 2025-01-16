package com.example.demo.domain.wiseSaying.service;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WiseSayingService {

    List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingService() {
        this.wiseSayingList = new ArrayList<>();
        this.lastId = 0;

        WiseSaying w1 = WiseSaying.builder()
                .id(++lastId)
                .content("삶이 있는 한 희망은 있다.")
                .author("키케로")
                .build();

        WiseSaying w2 = WiseSaying.builder()
                .id(++lastId)
                .content("나에게 죽음을 알리지 말라.")
                .author("이순신")
                .build();

        wiseSayingList.add(w1);
        wiseSayingList.add(w2);
    }

    public Optional<WiseSaying> getItem(int id) {

        return wiseSayingList.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingList;
    }

    public WiseSaying write(String content, String author) {

        WiseSaying wiseSaying = WiseSaying.builder()
                .id(++lastId)
                .content(content)
                .author(author)
                .build();

        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }

    public boolean delete(int id) {
        return wiseSayingList.removeIf(w -> w.getId() == id);
    }
}

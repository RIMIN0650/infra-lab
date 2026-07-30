package com.example.infralab.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardRegReq {
        private String title;
        private String contents;

        public static Board toEntity(BoardRegReq dto) {
            return Board.builder()
                    .title(dto.title)
                    .contents(dto.contents)
                    .build();
        }
    }

}

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

    @Getter
    @Builder
    public static class BoardReqRes {
        private Long id;
        private String title;
        private String contents;

        public static BoardDto.BoardReqRes from(Board entity) {
            return BoardReqRes.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }

}

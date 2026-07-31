package com.example.infralab.board;

import com.example.infralab.board.model.Board;
import com.example.infralab.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<Boolean> upload(@RequestBody BoardDto.BoardRegReq dto) {
        boolean isSuccess = boardService.upload(dto);

        if (isSuccess) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardDto.BoardReqRes>> getBoardList() {
        return ResponseEntity.ok(boardService.getBoardList());
    }


}

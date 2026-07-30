package com.example.infralab.board;

import com.example.infralab.board.model.Board;
import com.example.infralab.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public boolean upload(BoardDto.BoardRegReq dto) {
        Board board = boardRepository.save(BoardDto.BoardRegReq.toEntity(dto));
        return board.getId() != null;
    }
}

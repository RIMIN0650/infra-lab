package com.example.infralab.board;

import com.example.infralab.board.model.Board;
import com.example.infralab.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public boolean upload(BoardDto.BoardRegReq dto) {
        Board board = boardRepository.save(BoardDto.BoardRegReq.toEntity(dto));
        return board.getId() != null;
    }

    public List<BoardDto.BoardReqRes> getBoardList() {

        List<Board> boardList = boardRepository.findAll();
        List<BoardDto.BoardReqRes> boardReqResList = new ArrayList<>();

        for (Board board : boardList) {
            boardReqResList.add(BoardDto.BoardReqRes.from(board));
        }

        return boardReqResList;
    }
}

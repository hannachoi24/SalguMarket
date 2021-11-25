package com.ApricotMarket.controller;

import com.ApricotMarket.domain.Board;
import com.ApricotMarket.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    // BordRepository를 이용해서 테이블의 데이터를 가져옴
    @Autowired // 의존성 주입을 통해 서버가 기동될 때 boardRepository에 instance가 들어옴
    private BoardRepository boardRepository;

    @GetMapping("/list-board")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll(); // 조회 및 데이터 가져옴
        model.addAttribute("boards", boards); // 모델에 담긴 데이터들은 타임리프를통해 사용
        // (boards 라는 key 값에, boards 라는 data 를 준다.)
        return "board/list-board"; // template
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        // 수정
        if(id == null) {
            model.addAttribute("board", new Board()); // form 호출
        }
        else {
            Board board = boardRepository.findById(id).orElse(null); // 없으면 null
            model.addAttribute("board", board);
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String formSubmit(@Valid Board board, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/form";
        }
        boardRepository.save(board);
        return "redirect:/board/list-board";
    }
}
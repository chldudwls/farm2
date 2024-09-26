package com.farmstory.controller.apicontroller;

import com.farmstory.requestdto.TestRequestDto;
import com.farmstory.responsedto.CommentResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ApiCommentController {

    @GetMapping("/comments")
    public ResponseEntity<CommentResponseDto> getComments(
            @RequestParam int boardIdx
    ) {
        CommentResponseDto responseDto = new CommentResponseDto();
        responseDto.setTest1("text1");
        responseDto.setTest2("text2");

        return ResponseEntity.ok().body(responseDto);

    }

    @PostMapping("/comment")
    public ResponseEntity<String> createComment(
            @RequestBody TestRequestDto request
    ){
        Long boardIdx = request.getBoardIdx();
        String path = "api/client/comments?boardIdx=boardIdx";

        return ResponseEntity.ok(path);
    }

    @PutMapping("/comment")
    public ResponseEntity<String> putBoard(
            @RequestBody TestRequestDto request
    ){
        Long boardIdx = request.getBoardIdx();
        String path = "api/client/comments?boardIdx=boardIdx";

        return ResponseEntity.ok().body(path);
    }

    @DeleteMapping("/comment")
    public ResponseEntity<String> deleteBoard(
            @RequestParam Long boardIdx
    ){
        String path = "api/client/comments?boardIdx="+boardIdx;

        return ResponseEntity.ok().body(path);
    }
}

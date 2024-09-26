package com.farmstory.controller.apicontroller;

import com.farmstory.requestdto.TestRequestDto;
import com.farmstory.responsedto.CommentResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ApiBoardController {

    @PostMapping("/board")
    public ResponseEntity<String> postBoard(
            @RequestBody TestRequestDto request
            ){
        String section = request.getSection();
        String type = request.getType();
        String path = "/client/boards?section=" + section + "&type=" + type;

        return ResponseEntity.ok(path);
    }

    @PutMapping("/board")
    public ResponseEntity<String> putBoard(
            @RequestBody TestRequestDto request
    ){
        String section = request.getSection();
        String type = request.getType();
        String path = "/client/boards?section=" + section + "&type=" + type;

        return ResponseEntity.ok().body(path);
    }

    @DeleteMapping("/board")
    public ResponseEntity<String> deleteBoard(
            @RequestParam String section,
            @RequestParam String type,
            @RequestParam Long boardIdx
    ){
        String path = "/client/boards?section=" + section + "&type=" + type;

        return ResponseEntity.ok().body(path);
    }

    @GetMapping("/board")
    public ResponseEntity<CommentResponseDto> getBoard(
            @RequestParam int boardIdx
    ){
        CommentResponseDto responseDto = new CommentResponseDto();
        responseDto.setTest1("text1");
        responseDto.setTest2("text2");

        return ResponseEntity.ok().body(responseDto);
    }
}

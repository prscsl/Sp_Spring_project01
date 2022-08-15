package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.SysexMessage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

//    @Getmapping("/api/memos/{id}")
//    public Optional<Mamo> getMemo(@PathVariable long id){
//        return memoRepository.findById(id);
//    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Optional<Memo> memo = memoRepository.findById(id);
        if(memo.isPresent()){
            if(memo.get().getPswd().equals(requestDto.getPswd())){
                memoRepository.deleteById(id);
            }else {
                System.out.println("비밀번호 오류");
                return 0L;
            }
        }
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        Optional<Memo> memo = memoRepository.findById(id);
        if(memo.isPresent()){
            if(memo.get().getPswd().equals(requestDto.getPswd())){
                memoService.update(id, requestDto);
            }else {
                System.out.println("비밀번호 오류");
                return 0L;
            }
        }
        return id;
    }

}
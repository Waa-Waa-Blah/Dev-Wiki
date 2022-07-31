package com.wwb.devwiki.domain.board.service;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.board.dto.BoardReqDto;
import com.wwb.devwiki.domain.board.repository.BoardRepository;
import com.wwb.devwiki.domain.file.service.FileService;
import com.wwb.devwiki.domain.member.domain.Member;
import com.wwb.devwiki.domain.member.service.MemberService;
import com.wwb.devwiki.domain.record.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final MemberService memberService;
    private final RecordService recordService;
    private final FileService fileService;

    @Value("${file.dir}")
    private String dirPath;

    @Override
    @Transactional
    public Board writeBoard(BoardReqDto boardReqDto, Long loginUserId, List<MultipartFile> files) throws IOException {
        Member member = memberService.findMemberById(loginUserId);
        Board board = boardReqDto.toBoard();
        board.addAuthor(member);
        if(files.size()>0) {
            List<File> fileList = new ArrayList<>();
            for (MultipartFile file : files) {
                File saveFile = new File(dirPath + file.getOriginalFilename());
                saveFile.createNewFile();
                fileList.add(saveFile);
            }
            List<com.wwb.devwiki.domain.file.domain.File> fileEntityList = new ArrayList<>();
            for (File file : fileList) {
                com.wwb.devwiki.domain.file.domain.File fileEntity = com.wwb.devwiki.domain.file.domain.File.of(file.getName(), file.getAbsolutePath(), UUID.randomUUID() + file.getName());
                fileEntityList.add(fileEntity);
                fileEntity.addBoard(board);
            }
            fileService.saveFiles(fileEntityList);
        }
        recordService.createRecord(board.getTitle(), board.getContent(), board.getHit(), 0L, board);
        return boardRepository.save(board);
    }

    @Override
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).get();
    }

    @Override
    public List<Board> findBoards() {
        return boardRepository.findAll();
    }
}

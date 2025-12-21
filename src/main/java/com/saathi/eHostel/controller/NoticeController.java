package com.saathi.eHostel.controller;

import com.saathi.eHostel.dto.NoticeDTO;
import com.saathi.eHostel.service.INoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notices")
public class NoticeController {

    private final INoticeService noticeService;

// Opore @RequiredArgsConstructor eta lekha ache bole alada bhabe conatructor injection korte hbe na
//    public NoticeController(INoticeService noticeService) {
//        this.noticeService = noticeService;
//    }

    @GetMapping
    public List<NoticeDTO> getAllNotices() throws Exception {
        return noticeService.getAllNotices();
    }

    @PostMapping("/warden/{wardenId}/publish")
    public NoticeDTO createNotice(@PathVariable Long wardenId, @RequestBody NoticeDTO noticeDTO) throws Exception {
        noticeDTO.setCreatedByWardenId(wardenId);
        return noticeService.createNotice(noticeDTO);
    }

    @GetMapping("/{noticeId}")
    public NoticeDTO getSpecificNotice(@PathVariable Long noticeId) throws Exception {
        return noticeService.getNoticeById(noticeId);
    }

    @GetMapping("/{noticeId}/warden")
    public NoticeDTO getNoticeByIdForWarden(@PathVariable Long noticeId) throws Exception {
        return noticeService.getNoticeById(noticeId);
    }

    @DeleteMapping("/warden/{noticeId}")
    public String deleteNotice(@PathVariable Long noticeId) throws Exception {
        noticeService.deleteNotice(noticeId);
        return "Notice deleted successfully";
    }
}
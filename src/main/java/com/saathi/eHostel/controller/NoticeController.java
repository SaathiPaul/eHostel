package com.saathi.eHostel.controller;

import com.saathi.eHostel.dto.NoticeDTO;
import com.saathi.eHostel.service.INoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    private final INoticeService noticeService;

    public NoticeController(INoticeService noticeService) {
        this.noticeService = noticeService;
    }


    @PostMapping("/warden/{wardenId}")
    public NoticeDTO createNotice(
            @PathVariable Long wardenId,
            @RequestBody NoticeDTO noticeDTO) throws Exception {

        noticeDTO.setCreatedByWardenId(wardenId);
        return noticeService.createNotice(noticeDTO);
    }


    @GetMapping("/student")
    public List<NoticeDTO> getAllNotices() throws Exception {
        return noticeService.getAllNotices();
    }


    @GetMapping("/{noticeId}/student")
    public NoticeDTO getNoticeByIdForStudent(
            @PathVariable Long noticeId) throws Exception {

        return noticeService.getNoticeById(noticeId);
    }

    @GetMapping("/{noticeId}/warden")
    public NoticeDTO getNoticeByIdForWarden(
            @PathVariable Long noticeId) throws Exception {

        return noticeService.getNoticeById(noticeId);
    }




    @DeleteMapping("/{noticeId}/warden")
    public String deleteNotice(@PathVariable Long noticeId) throws Exception {
        noticeService.deleteNotice(noticeId);
        return "Notice deleted successfully";
    }
}

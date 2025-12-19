package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.NoticeDTO;

import java.util.List;

public interface INoticeService {

    NoticeDTO createNotice(NoticeDTO noticeDTO) throws Exception;

    List<NoticeDTO> getAllNotices() throws Exception;

    NoticeDTO getNoticeById(Long noticeId) throws Exception;

    void deleteNotice(Long noticeId) throws Exception;
}

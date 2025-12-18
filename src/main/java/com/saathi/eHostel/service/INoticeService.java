package com.saathi.eHostel.service;

import java.util.List;
import com.saathi.eHostel.dto.NoticeDTO;

public interface INoticeService {
    List<NoticeDTO> getAllNotices();
}
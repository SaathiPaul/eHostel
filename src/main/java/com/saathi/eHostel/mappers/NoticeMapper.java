package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.NoticeDTO;
import com.saathi.eHostel.entity.Notice;

public class NoticeMapper {

    public static NoticeDTO toDTO(Notice notice) {
        if (notice == null) return null;

        return NoticeDTO.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .body(notice.getBody())
                .createdByWardenId(notice.getCreatedByWardenId())
                .createdAt(notice.getCreatedAt())
                .build();
    }

    public static Notice toEntity(NoticeDTO noticeDTO) {
        if (noticeDTO == null) return null;

        return Notice.builder()
                // .id(noticeDTO.getId())
                .title(noticeDTO.getTitle())
                .body(noticeDTO.getBody())
                .createdByWardenId(noticeDTO.getCreatedByWardenId())
                .createdAt(noticeDTO.getCreatedAt())
                .build();
    }
}


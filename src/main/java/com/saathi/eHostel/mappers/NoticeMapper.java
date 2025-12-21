package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.NoticeDTO;
import com.saathi.eHostel.entity.Notice;

public class NoticeMapper {

    private NoticeMapper() {
        // prevent instantiation
    }

    public static NoticeDTO toDTO(Notice notice) {
        if (notice == null) return null;

        return NoticeDTO.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .body(notice.getBody())
                .createdAt(notice.getCreatedAt())
                .createdByWardenId(
                        notice.getCreatedByWarden() != null ? notice.getCreatedByWarden().getId() : null
                )
                .build();
    }

    public static Notice toEntity(NoticeDTO noticeDTO) {
        if (noticeDTO == null) return null;

        return Notice.builder()
                .title(noticeDTO.getTitle())
                .body(noticeDTO.getBody())
                .build();
    }
}
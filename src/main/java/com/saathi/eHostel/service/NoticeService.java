package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.NoticeDTO;
import com.saathi.eHostel.entity.Notice;
import com.saathi.eHostel.mappers.NoticeMapper;
import com.saathi.eHostel.repository.NoticeRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService implements INoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public NoticeDTO createNotice(NoticeDTO noticeDTO) throws Exception{
        Notice notice = NoticeMapper.toEntity(noticeDTO);
        Notice saved = noticeRepository.save(notice);
        NoticeDTO savedToDTO = NoticeMapper.toDTO(saved);
        return savedToDTO;

    }


    @Override
    public List<NoticeDTO> getAllNotices() throws Exception{
        List<Notice> allNoticeEntities = noticeRepository.findAll();
        List<NoticeDTO> entitiesToDTO = new ArrayList<>();

        for (int i = 0; i < allNoticeEntities.size(); i++) {
            Notice n = allNoticeEntities.get(i);
            NoticeDTO converted = NoticeMapper.toDTO(n);
            entitiesToDTO.add(converted);
        }
        return entitiesToDTO;
    }



    @Override
    public NoticeDTO getNoticeById(Long noticeId) throws Exception{
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new RuntimeException("Notice not found with id: " + noticeId));

        return NoticeMapper.toDTO(notice);
    }

    @Override
    public void deleteNotice(Long noticeId) throws Exception{
        if (!noticeRepository.existsById(noticeId)) {
            throw new RuntimeException("Notice not found with id: " + noticeId);
        }
        noticeRepository.deleteById(noticeId);
    }
}

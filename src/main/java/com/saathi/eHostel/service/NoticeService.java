package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.NoticeDTO;
import com.saathi.eHostel.entity.Notice;
import com.saathi.eHostel.entity.Warden;
import com.saathi.eHostel.mappers.NoticeMapper;
import com.saathi.eHostel.repository.NoticeRepository;
import com.saathi.eHostel.repository.WardenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService implements INoticeService {

    private final NoticeRepository noticeRepository;
    private final WardenRepository wardenRepository;

    @Override
    @Transactional
    public NoticeDTO createNotice(NoticeDTO noticeDTO) throws Exception {
        Notice notice = NoticeMapper.toEntity(noticeDTO);
        Warden warden = wardenRepository.findById(noticeDTO.getCreatedByWardenId())
                .orElseThrow(() -> new RuntimeException("Warden Not Found"));
        notice.setCreatedByWarden(warden);
        Notice saved = noticeRepository.save(notice);
        NoticeDTO savedToDTO = NoticeMapper.toDTO(saved);
        return savedToDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public NoticeDTO getNoticeById(Long noticeId) throws Exception {
        Notice notice = noticeRepository.findByIdWithWarden(noticeId)
                .orElseThrow(() -> new RuntimeException("Notice not found with id: " + noticeId));
        return NoticeMapper.toDTO(notice);
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
    public void deleteNotice(Long noticeId) throws Exception {
        if (!noticeRepository.existsById(noticeId)) {
            throw new RuntimeException("Notice not found with id: " + noticeId);
        }
        noticeRepository.deleteById(noticeId);
    }
}
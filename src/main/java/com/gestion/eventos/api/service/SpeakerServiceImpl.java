package com.gestion.eventos.api.service;

import com.gestion.eventos.api.domain.Speaker;
import com.gestion.eventos.api.dto.SpeakerRequestDto;
import com.gestion.eventos.api.exception.ResourceNotFoundException;
import com.gestion.eventos.api.mapper.SpeakerMapper;
import com.gestion.eventos.api.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeakerServiceImpl implements SpeakerService{

    private final SpeakerRepository speakerRepository;
    private final SpeakerMapper speakerMapper;


    @Override
    @Transactional
    public Speaker save(SpeakerRequestDto requestDto) {

        Speaker speaker = speakerMapper.toEntity(requestDto);

        return speakerRepository.save(speaker);
    }


    @Override
    @Transactional(readOnly = true)
    public Speaker findById(Long id) {
        return speakerRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Ponente no encontrado con ID: "+ id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    @Override
    @Transactional
    public Speaker update(Long id, SpeakerRequestDto requestDto) {

        Speaker existtingSpeaker = speakerRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Ponente no encontrado con ID: "+ id));

        speakerMapper.updateSpeakerFromDto(requestDto, existtingSpeaker);

        return speakerRepository.save(existtingSpeaker);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteById(Long id) {

        if (!speakerRepository.existsById(id)){
            throw new ResourceNotFoundException("Ponente no encontrado con ID: "+ id);
        }

        speakerRepository.deleteById(id);

    }
}

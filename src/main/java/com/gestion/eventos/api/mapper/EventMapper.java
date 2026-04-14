package com.gestion.eventos.api.mapper;

import com.gestion.eventos.api.domain.Event;
import com.gestion.eventos.api.dto.EventRequestDto;
import com.gestion.eventos.api.dto.EventResponseDto;
import com.gestion.eventos.api.dto.EventSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    //Mapeo de entrada - Request Dto
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "speaker", ignore = true)
    @Mapping(target = "attendedUser", ignore = true)
    Event toEntity(EventRequestDto eventRequestDto);

    //Mapeo de salida - Request Dto
    EventResponseDto toResponseDto(Event event);
    List<EventResponseDto> toEventResponseDtoList(List<Event> events);

    //Metodo para actualizar una Entidad Existente
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "speaker", ignore = true)
    @Mapping(target = "attendedUser", ignore = true)
    void updateEventFromDto(EventRequestDto dto, @MappingTarget Event event);

    EventSummaryDto toSummaryDto(Event event);
    List<EventSummaryDto> tSummaryDtoList(List<Event> events);

}

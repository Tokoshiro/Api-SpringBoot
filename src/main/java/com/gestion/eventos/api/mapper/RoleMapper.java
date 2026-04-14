package com.gestion.eventos.api.mapper;

import com.gestion.eventos.api.domain.Role;
import com.gestion.eventos.api.dto.RoleDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);
    Role toEntity(Role roleDto);
    List<RoleDto> toDtoList(List<Role> roles); // Pra userResponseDto

}

package com.joao.dataprovider.gateway;

import com.joao.core.domain.AgendaDomain;
import com.joao.dataprovider.entity.AgendaEntity;
import com.joao.dataprovider.mapper.AgendaMapper;
import com.joao.dataprovider.repository.AgendaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith ( MockitoExtension.class )
class AgendaGatewayImplTest {

    @InjectMocks
    private AgendaGatewayImpl agendaGateway;

    @Mock
    private AgendaRepository agendaRepository;

    @Mock
    private AgendaMapper agendaMapper;

    @Test
    void must_save_a_agenda() {
        final var agendaDomain = AgendaDomain.builder().build();
        var agendaEntity = new AgendaEntity();

        when(agendaMapper.toEntity(agendaDomain)).thenReturn(agendaEntity);

        agendaGateway.save(agendaDomain);

        verify(agendaRepository).save(any(AgendaEntity.class));
        verify(agendaMapper).toEntity(any(AgendaDomain.class));

    }

    @Test
    void search_for_a_staff_by_id() {
        final var agendaId = UUID.randomUUID();
        final var agendaDomain = AgendaDomain.builder().id(agendaId).build();
        var agendaEntity = new AgendaEntity(agendaId, null, null, null, null);

        when(agendaMapper.toDomain(agendaEntity)).thenReturn(agendaDomain);
        when(agendaRepository.findById(agendaId)).thenReturn(Optional.of(agendaEntity));

        agendaGateway.findById(agendaId);

        verify(agendaRepository).findById(anyLong());
        verify(agendaMapper).toDomain(any(AgendaEntity.class));
    }
}
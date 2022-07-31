package com.joao.entrypoint.restapi;

import com.joao.dataprovider.dto.in.VoteInDTO;
import com.joao.dataprovider.dto.out.VoteResultOutDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("v1/votes")
public class VoteControllerImpl implements VoteController {

    @Override
    @PostMapping
    public void vote(@RequestBody @Valid final VoteInDTO voteInDTO) {

    }

    @Override
    @GetMapping("total-votes/{session_id}/session-id/{agenda_id}/agenda-id")
    public VoteResultOutDTO totalVotes(@PathVariable("session_id") @NotNull final Long SessionId, @PathVariable("agenda_id") @NotNull final Long AgendaId) {
        return null;
    }
}
package ru.stuff.coworking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stuff.coworking.model.FreeDayModel;
import ru.stuff.coworking.model.TicketsModel;
import ru.stuff.coworking.repositories.TicketsRepositories;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServices {

    private final TicketsRepositories ticketsRepositories;

    public List<TicketsModel> showTickets(){
        return ticketsRepositories.findAll();
    }

    public TicketsModel searchTicketById(int id){
        Optional<TicketsModel> ticketsModel = ticketsRepositories.findById(id);
        return ticketsModel.orElse(null);
    }

    public void createTicket(TicketsModel ticketsModel){
        ticketsRepositories.save(ticketsModel);
    }
}

package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.mock.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToParticipant implements Converter<String, Participant> {
    private FilmServiceBouchon filmService;
    @Autowired
    public StringToParticipant(FilmServiceBouchon filmService) {
        this.filmService = filmService;
    }

    @Override
    public Participant convert(String source) {
        return filmService.consulterParticipantParId(Integer.parseInt(source));
    }
}

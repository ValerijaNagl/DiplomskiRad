package servisi.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import servisi.api.model.OdgovorDTO;
import servisi.security.CheckSecurity;
import servisi.services.impl.PitanjeOdgovorServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200/**")
@RequestMapping("/api/qa")
public class PitanjeOdgovorController {

    private final PitanjeOdgovorServiceImpl pitanjeOdgovorService;

    public PitanjeOdgovorController(PitanjeOdgovorServiceImpl pitanjeOdgovorService) {
        this.pitanjeOdgovorService = pitanjeOdgovorService;
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/questions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getQuestionsByType(@RequestHeader("Authorization") String authorization,
                                                @RequestParam("tipPitanja") String tipPitanja) {
        return ResponseEntity.ok(pitanjeOdgovorService.getQuestionsByType(tipPitanja));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @RequestMapping(value = "/unianswers", method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<?> saveAnswersAboutUni(@RequestHeader("Authorization") String authorization,
                                                 @RequestBody List<OdgovorDTO> answersAboutUni) {
        return ResponseEntity.ok(pitanjeOdgovorService.saveAnswersAboutUni(answersAboutUni));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @PostMapping(value = "/profanswers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAnswersAboutProfessors(@RequestHeader("Authorization") String authorization,
                                                        @RequestBody List<OdgovorDTO> profAnswers) {
        return ResponseEntity.ok(pitanjeOdgovorService.saveAnswersAboutProf(profAnswers));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @PostMapping(value = "/subanswers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAnswersAboutSubjects(@RequestHeader("Authorization") String authorization,
                                                      @RequestBody List<OdgovorDTO> subAnswers) {
        return ResponseEntity.ok(pitanjeOdgovorService.saveAnswersAboutSub(subAnswers));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/answers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAnswersAboutByType(@RequestHeader("Authorization") String authorization,
                                                   @RequestParam("studentId") int studentId,
                                                   @RequestParam("semestarId") int semestarId,
                                                   @RequestParam("predmetId") int predmetIliDrziPredmetId,
                                                   @RequestParam("tipPitanja") String tipPitanja) {
        if(tipPitanja.trim().equals("fakultet"))
            return ResponseEntity.ok(pitanjeOdgovorService.getsAllAnswersAboutUni(studentId, semestarId));
        if(tipPitanja.trim().equals("predmet"))
            return ResponseEntity.ok(pitanjeOdgovorService.getsAllAnswersAboutSubjects(studentId,semestarId,predmetIliDrziPredmetId));
        else
            return ResponseEntity.ok(pitanjeOdgovorService.getsAllAnswersAboutProfessors(studentId, semestarId,predmetIliDrziPredmetId));
    }


    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/anonymous", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> makeAnswersAnonymous(@RequestHeader("Authorization") String authorization,
                                                  @RequestParam("studentId") int studentId,
                                                  @RequestParam("semestarId") int semestarId) {
        return ResponseEntity.ok(pitanjeOdgovorService.makeAnswersAnonymous(studentId,semestarId));
    }


    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/unianswers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAnswersAboutUni(@RequestHeader("Authorization") String authorization,
                                                @RequestParam("studentId") int studentId,
                                                @RequestParam("semestarId") int semestarId) {
        return ResponseEntity.ok(pitanjeOdgovorService.getsAllAnswersAboutUni(studentId, semestarId));
    }

}
package servisi.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servisi.security.CheckSecurity;
import servisi.services.impl.NastavnikServiceImpl;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RequestMapping("/api/professors")
public class NastavnikController {

    private final NastavnikServiceImpl nastavnikService;

    public NastavnikController(NastavnikServiceImpl nastavnikService) {
        this.nastavnikService = nastavnikService;
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/teachesSubject", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTeachesSubjectById(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id) {
        return ResponseEntity.ok(nastavnikService.getDrziPredmetById(id));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/professors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findProfessorsBySubjectAndSemester(@RequestHeader("Authorization") String authorization,
                                                                @RequestParam("predmetId") int predmetId,
                                                                @RequestParam("semestarId") int semestarId) {
        return ResponseEntity.ok(nastavnikService.findProfessorsBySubjectAndSemester(predmetId,semestarId));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findProfessorsById(@RequestHeader("Authorization") String authorization,@RequestParam("drziPredmetId") int drziPredmetId) {
        return ResponseEntity.ok(nastavnikService.getProfessorById(drziPredmetId));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/professor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfessorBySubjectAndSemester(@RequestHeader("Authorization") String authorization,
                                                              @RequestParam("nastavnikId") int nastavnikId,
                                                              @RequestParam("predmetId") int predmetId,
                                                              @RequestParam("semestarId") int semestarId) {
        return ResponseEntity.ok(nastavnikService.getProfessorBySubjectAndSemester(predmetId,semestarId,nastavnikId));
    }

}

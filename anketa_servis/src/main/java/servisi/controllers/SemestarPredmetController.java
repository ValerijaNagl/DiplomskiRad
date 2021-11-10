package servisi.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servisi.security.CheckSecurity;
import servisi.services.SemestarPredmetService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RequestMapping("/api/semestarAndSubjects")
public class SemestarPredmetController {

    private final SemestarPredmetService semestarPredmetService;

    public SemestarPredmetController(SemestarPredmetService semestarPredmetService) {
        this.semestarPredmetService = semestarPredmetService;
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/semester", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSemesterById(@RequestHeader("Authorization") String authorization,
                                             @RequestParam("id") int id) {
        return ResponseEntity.ok(semestarPredmetService.getSemestarById(id));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/maxsemestar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMaxSemestar(@RequestHeader("Authorization") String authorization) {
        return ResponseEntity.ok(semestarPredmetService.getMaxSemestar());
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findSubjects(@RequestHeader("Authorization") String authorization,
                                          @RequestParam("username") String username,
                                          @RequestParam("semestarId") int semestarId) {
        return ResponseEntity.ok(semestarPredmetService.getStudentsSubjectsInSemestar(username,semestarId));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/subject", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubjectById(@RequestHeader("Authorization") String authorization,
                                            @RequestParam("id") int predmetId) {
        return ResponseEntity.ok(semestarPredmetService.getSubjectById(predmetId));
    }

}


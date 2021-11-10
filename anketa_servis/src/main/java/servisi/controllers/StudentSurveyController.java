package servisi.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servisi.api.model.ZakljucenaDTO;
import servisi.security.CheckSecurity;
import servisi.services.impl.StudentSurveyServiceImpl;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RequestMapping("/api/students")
public class StudentSurveyController {

    private final StudentSurveyServiceImpl studentService;

    public StudentSurveyController(StudentSurveyServiceImpl studentService) {
        this.studentService = studentService;
    }

    //studenti
    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/username", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentByUsername(@RequestHeader("Authorization") String authorization,
                                                  @RequestParam("username") String username) {
        return ResponseEntity.ok(studentService.findStudentByUsername(username));
    }

    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentById(@RequestHeader("Authorization") String authorization,
                                            @RequestParam("id") int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // anketa
    @CheckSecurity(roles = {"ROLE_USER"})
    @GetMapping(value = "/filledsurvey", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isSurveyFilledOut(@RequestHeader("Authorization") String authorization,
                                               @RequestParam("studentId") int studentId,
                                               @RequestParam("semestarId") int semestarId) {
        return ResponseEntity.ok(studentService.isSurveyFilledOut(studentId,semestarId));
    }


    @CheckSecurity(roles = {"ROLE_USER"})
    @PostMapping(value = "/finishsurvey", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> finishSurvey(@RequestHeader("Authorization") String authorization,
                                          @RequestBody ZakljucenaDTO zakljucenaDTO) {
        return ResponseEntity.ok(studentService.finishSurvey(zakljucenaDTO.getStudentId(), zakljucenaDTO.getSemestarId()));
    }


    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestParam("username") String username) {
        return ResponseEntity.ok(studentService.login(username));
    }


}

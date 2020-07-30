package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.service.JobsDailyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class JobsDailyStatusController {

    @Autowired
    private JobsDailyStatusService jobsDailyStatusService;

    @PostMapping(value = "run-status")
    public ResponseEntity<Void> runStatus() {
        HttpHeaders headers = new HttpHeaders();

        String result = jobsDailyStatusService.runStatus();

        if (result.equals("SUCCESS")) {
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAIL", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }
}

package com.app.springreact.controller;

import com.app.springreact.model.request.MeetupRequest;
import com.app.springreact.model.response.MeetupResponse;
import com.app.springreact.service.MeetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/meetup")
public class MeetupController {

    @Autowired
    MeetupService meetupService;

    @PostMapping
    public String createMeetup(@RequestBody MeetupRequest request) {
        meetupService.addMeetup(request);
        return "Successfully added";
    }


    @GetMapping
    public List<MeetupResponse> getMeetups() {
        return meetupService.getMeetups();
    }
}

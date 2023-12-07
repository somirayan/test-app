package com.app.springreact.service;

import com.app.springreact.model.request.MeetupRequest;
import com.app.springreact.model.response.MeetupResponse;

import java.util.List;

public interface MeetupService {

    void addMeetup(MeetupRequest request);

    List<MeetupResponse> getMeetups();
}

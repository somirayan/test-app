package com.app.springreact.service;

import com.app.springreact.model.entity.Meetup;
import com.app.springreact.model.request.MeetupRequest;
import com.app.springreact.model.response.MeetupResponse;
import com.app.springreact.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MeetupServiceImpl implements MeetupService {

    @Autowired
    MeetupRepository meetupRepository;

    @Override
    public void addMeetup(MeetupRequest request) {
        Meetup newMeetup = new Meetup();

        newMeetup.setTitle(request.getTitle());
        newMeetup.setImage(request.getImage());
        newMeetup.setAddress(request.getAddress());
        newMeetup.setDescription(request.getDescription());

        meetupRepository.save(newMeetup);

    }

    @Override
    public List<MeetupResponse> getMeetups() {
        List<Meetup> meetups = meetupRepository.findAll();

        List<MeetupResponse> meetupResponseList = new ArrayList<>();

        meetups.forEach(m -> {
            MeetupResponse response = new MeetupResponse();
            response.setId(m.getId());
            response.setTitle(m.getTitle());
            response.setImage(m.getImage());
            response.setAddress(m.getAddress());
            response.setDescription(m.getDescription());

            meetupResponseList.add(response);
        });
        return meetupResponseList;
    }
}

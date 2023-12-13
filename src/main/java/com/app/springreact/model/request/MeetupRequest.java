package com.app.springreact.model.request;

import lombok.Data;

@Data
public class MeetupRequest {

    private String title;

    private String address;

    private String image;

    private String description;
}

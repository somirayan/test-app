package com.app.springreact.model.response;

import lombok.Data;

@Data
public class MeetupResponse {

    private long id;

    private String title;

    private String address;

    private String image;

    private String description;
}

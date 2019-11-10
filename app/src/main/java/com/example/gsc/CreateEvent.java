package com.example.gsc;

public class CreateEvent {

    private String EventName, EventDate;

    public CreateEvent(String eventName, String eventDate) {
        EventName = eventName;
        EventDate = eventDate;
    }

    public String getEventName() {
        return EventName;
    }

    public String getEventDate() {
        return EventDate;
    }
}

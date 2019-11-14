package com.example.gsc;


public class CreateEvent {

     private String EventName, EventDate,EventDisc,EventTime,EventVenue;

    public CreateEvent(String eventName, String eventDate, String eventDisc, String eventTime,String eventVenue) {
        EventName = eventName;
        EventDate = eventDate;
        EventDisc= eventDisc;
        EventTime= eventTime;
        EventVenue=eventVenue;

    }

    public String getEventName() {
        return EventName;
    }

    public String getEventDate() {
        return EventDate;
    }

    public String getEventDisc() {return EventDisc; }

    public String getEventTime() {return EventTime; }

    public String getEventVenue() {return EventVenue; }

}

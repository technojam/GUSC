package com.example.gsc;


public class CreateEvent {

     private String ImageUrl, EventName, EventDate,EventDisc,EventTime,EventVenue;

     public CreateEvent(){

     }

    public CreateEvent(String eventName, String eventDate, String eventDisc, String eventTime,String eventVenue,String imageUrl) {
         EventName = eventName;
         EventDate = eventDate;
         EventDisc= eventDisc;
         EventTime= eventTime;
         EventVenue=eventVenue;
         ImageUrl = imageUrl;
    }

    public CreateEvent(String eventName, String imageUrl){
         EventName = eventName;
         ImageUrl = imageUrl;
    }

    public String getImageUrl(){
         return ImageUrl;
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

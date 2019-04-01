# Parkyou
DAI Project.

## Business cases
1. I am a user and I want to reserve a parking spot.
2. I am a user and I want to report an event. 

## Business cases considerations
* A user is identified by e-mail address only. No auth required.
1. The parking spot automatically expires after 8 hours.
2. A user cannot reserve a parking spot for the future. 
3. A user can report an event which is at most available for 8 hours.
4. A user can reserve only one parking spot. 
5. A user can report as many events as he wants.

## Database specifications - MongoDB
- Has TimeToLive
- 2 tables: parking_spots / events

## Parking APIs required
1. Reserve parking spot.
    - `POST /parking/spots`
    - RequestParam: userEmail, parkingSpot, duration
2. Find available parking spots.
    - `GET /parking/spots`
3. Find details about a specific parking spot
    - `GET /parking/spots/{spotId}`
4. Find my single parking spot.
    - `GET /parking/spots`
    - RequestParam: userEmail

## Events APIs required
1. Create an event
    - `POST /events`
    - RequestParam: userEmail, eventName, eventDescription, duration
2. Find all events
    - `GET /events`
3. Find a specific event
    - `GET /events/eventId`
4. Find all my events
    - `GET /events`
    - RequestParam: userEmail

## Frontend - React
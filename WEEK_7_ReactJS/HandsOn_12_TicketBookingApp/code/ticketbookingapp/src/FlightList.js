import React from "react";
import "./FlightList.css"; // Import styles

import flight1 from "./flights/flight1.jpg";
import flight2 from "./flights/flight2.jpg";
import flight3 from "./flights/flight3.jpg";

const flights = [
    { id: 1, from: "Chennai", to: "Delhi", time: "10:00 AM", image: flight1 },
    { id: 2, from: "Mumbai", to: "Bangalore", time: "1:30 PM", image: flight2 },
    { id: 3, from: "Hyderabad", to: "Kolkata", time: "6:45 PM", image: flight3 },
    ];

    function FlightList({ canBook }) {
    return (
        <div className="flight-container">
        <h3>Available Flights</h3>
        <div className="flight-grid">
            {flights.map((flight) => (
            <div key={flight.id} className="flight-card">
                <img src={flight.image} alt="Flight" className="flight-image" />
                <div className="flight-details">
                <p><strong>{flight.from}</strong> to <strong>{flight.to}</strong></p>
                <p>Departure: {flight.time}</p>
                {canBook ? (
                    <button className="book-btn">Book</button>
                ) : (
                    <p className="disabled-msg">(Login to book)</p>
                )}
                </div>
            </div>
            ))}
        </div>
        </div>
    );
}

export default FlightList;

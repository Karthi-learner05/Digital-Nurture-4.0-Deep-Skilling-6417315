import React from "react";
import FlightList from "./FlightList";

function GuestPage() {
    return (
        <div>
        <h2>Please Signup</h2>
        <p>You can only browse flight details.</p>
        <FlightList canBook={false} />
        </div>
    );
}

export default GuestPage;

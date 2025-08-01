import React from "react";
import FlightList from "./FlightList";

function UserPage() {
    return (
        <div>
        <h2>Welcome Back</h2>
        <p>You can now book your flight tickets.</p>
        <FlightList canBook={true} />
        </div>
    );
}

export default UserPage;

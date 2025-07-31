import React from "react";

    const players = [
    { name: "Rohit", score: 88 },
    { name: "Virat", score: 65 },
    { name: "Gill", score: 70 },
    { name: "Rahul", score: 45 },
    { name: "Pant", score: 72 },
    { name: "Hardik", score: 50 },
    { name: "Jadeja", score: 90 },
    { name: "Ashwin", score: 30 },
    { name: "Shami", score: 75 },
    { name: "Bumrah", score: 60 },
    { name: "Surya", score: 95 },
    ];

    const ListofPlayers = () => {
    const below70 = players.filter((player) => player.score < 70);

    return (
        <div>
        <h2>All Players</h2>
        <ul>
            {players.map((player, idx) => (
            <li key={idx}>
                {player.name} - {player.score}
            </li>
            ))}
        </ul>

        <h2>Players with score below 70</h2>
        <ul>
            {below70.map((player, idx) => (
            <li key={idx}>
                {player.name} - {player.score}
            </li>
            ))}
        </ul>
        </div>
    );
};

export default ListofPlayers;


import React from 'react';

const T20players = ['Rohit', 'Virat', 'Surya', 'Hardik'];
const RanjiTrophy = ['Jaiswal', 'Sarfaraz', 'Iyer'];

const IndianPlayers = () => {
    const allPlayers = [...T20players, ...RanjiTrophy];

    const oddPlayers = allPlayers.filter((_, i) => i % 2 === 1);
    const evenPlayers = allPlayers.filter((_, i) => i % 2 === 0);
    return (
        <div>
        <h2>All Players (Merged)</h2>
        <ul>
            {allPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>

        <h3>Odd Team Players</h3>
        <ul>
            {oddPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>

        <h3>Even Team Players</h3>
        <ul>
            {evenPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>
        </div>
    );
};

export default IndianPlayers;

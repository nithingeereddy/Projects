import React from 'react';
import './About.css'
import { Link } from "react-router-dom";

function About() {
return ( 
    <div className="about">
       <Link to="/About">
          <img className="login_logo" src="logo1.png" width="140" height="140" alt="logo1" />
       </Link>
       <div className="top1">
     <h1>About</h1>
     <h3>A Getit! is a Web Application which helps to serve us to get our things from any place within the city instantly, We can get them delivered within time by placing a request in the application and providing pick up and destination information. If a person request for an item the nearest delivery person is going to pick that item and the delivery executive will be responsible for safety of the things and to deliver them to right place at right time. Getit! Can Deliver the things which you wanted to send to others.
        It provides good convenience for users to overcome various emergency situations due to the unique safety feature.
</h3>

     <h3>
•	Getit! takes a request from the user which contains the pickup and drop locations of the user and the item location.<br></br>
•	Once the booking is accepted the items are picked up from the location and the items are placed in a bad which is enclosed using a safety sticker.<br></br>
•	Then the items are delivered to the drop location and if any one tries to open the bag the user is aware of it as the sticker is compromised.
</h3>
       </div>
    </div>
);
}
export default About;
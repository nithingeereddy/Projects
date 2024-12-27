import React from 'react';
import './Home.css';
import { Link } from "react-router-dom";
function Home() {
return (
<div class="logo-intro">
<div class="left1">
         <img class="logo" src="logo1.png" width="190" height="190" alt="logo"></img>
         <div class="intro">
         <h2>Hi, Welcome to Getit!</h2> 
         <h3>Forgot Something?</h3>
         <h4>Don't Worry get it within no time</h4>   
         <div class="del">
             <img src="fast1.png" width="250" height="250" alt="fast-delivery" ></img>
         </div>
         </div>
         </div>
         <h3>Track your Requested Thing's any time Anywhere Just do Getit! </h3>
<div class="right1">
<Link to="/signup">
<button className="createA">Create Account ></button>
 </Link>
<img src="LogoR.png" width="390" height="390" alt="logo"></img>
    </div>         
</div> 
);
}
export default Home; 
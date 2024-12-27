import React from 'react';
import './Request.css'
import { Link } from "react-router-dom";
function Request()  {
   return (
      <div className="Request-container">
          <Link to="/">
          <img className="login_logo" src="logo1.png" width="140" height="140" alt="logo1" />
       </Link>
       <form className="request-things" method="post">
       <div class="request-box">
<h1>Request for your things</h1>
<br />
<input type="text" placeholder="Your Name" />
<br />
<input type="text" placeholder="Pickup Address" />
<br />
<input type="text" placeholder="Sender's Phone Number" />
<br />
<h3>Select size of items</h3>
<br />
<div class="radio-group">
<input type="radio" id="option-one" name="selector" />
<label for="option-one">Mini</label>
<input type="radio" id="option-two" name="selector" />
    <label for="option-two">Medium</label>
 <input type="radio" id="option-three" name="selector" />
    <label for="option-three">Large</label>
 </div>
 </div>
 </form>

<form className="receiver-things" method="post">
<div className="receiver-box">
<h1>Receiver's address</h1>
<br />
<input type="text" placeholder="Receiver's Name" />
<br />
<input type="text" placeholder="Drop Address" />
<br />
<input type="text" placeholder="Recevier's Phone Number" />
<br />
<button className="submit">Submit</button>
</div>
</form>
</div> 
      
   );
}
export default Request;
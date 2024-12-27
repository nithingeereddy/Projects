import React from 'react';
import './Signup.css'
import { Link } from "react-router-dom";

function Contact() {
return ( 
    <div className="signup">
        <img className="login_logo" src="logo1.png" width="140" height="140" alt="logo1" />
       <div className="Signup_container">
           <h1>Sign Up</h1>
           <form>
               <h5>User Name</h5>
               <input type="text" placeholder="User Name"/>
               <h5>E-mail</h5>
               <input type="email" placeholder="E-mail"/>
               <h5>Password</h5>
               <input type="password" placeholder="Password"/>
               <button className="CreateA">Create Account</button>
               <h3>Already a Member?</h3>
               <Link to="/login">
               <h3>Login</h3>
               </Link>
           </form>
       </div>
    </div>
);
}
export default Contact;
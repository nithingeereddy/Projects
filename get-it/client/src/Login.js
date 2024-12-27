import React from 'react';
import './Login.css'
import { Link } from "react-router-dom";
import axios from 'axios';
function Login(props) {
return ( 
    <div className="login">
       <Link to="/">
          <img className="login_logo" src="logo1.png" width="140" height="140" alt="logo1" />
       </Link>
       <div className="login_container">
           <h1>Sign In</h1>
           <form onSubmit={(e) => login(e)}>
               <h5>E-mail</h5>
               <input type="email" id="exampleInputEmail1" placeholder="E-mail"/>
               <h5>Password</h5>
               <input type="password" id="exampleInputPassword1" placeholder="Password"/>
               <button className="login_signInButton">Sign In</button>
           <p>By signing-in you agree to Getit! Conditions of use & Delivery</p>
          <Link to="/Signup.js"> <button 
  className="login_registerButton" 
  type="button"
>
  Create your Getit! Account
</button></Link>

           </form>
       </div>
    </div>
);
}
function login(e) {
    e.preventDefault();
    let request= {
        email: document.getElementById('exampleInputEmail1').value,
        password: document.getElementById('exampleInputPassword1').value
    }
    axios.post('http://localhost:3000/login',request)
    .then(resp => {
        alert(resp.data.message);
    })
    .catch( err =>{
        console.log(err);
    })
}
export default Login;
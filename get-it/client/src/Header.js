import React from 'react';
import "./Header.css";
import { Link } from "react-router-dom"

function Header() {
    return <nav className="header">
        <html>
        <body>
   <div className="header_nav">    
       <Link to="/" className="header_link1">
        <div className="header_option">
       <span id="active">Home</span>
       </div>
       </Link>
       <Link to="/about" className="header_link">
        <div className="header_option">
       <span>About</span>
       </div>
       </Link>
       <Link to="/" className="header_link">
        <div className="header_option">
       <span>Contact</span>
       </div>
       </Link>
       <Link to="/" className="header_link">
        <div className="header_option">
       <span>Account</span>
       </div>
       </Link>
       <Link to="/checkout" className="header_link">
        <div className="header_option">
       <span>Requested Things</span>
       </div>
       </Link>
       <Link to="/login" className="header_link">
        <div className="header_option">
       <span>Login</span>
       </div> 
       </Link>
       <Link to="/signup" className="header_link">
        <div className="header_option">
       <span>Sign Up</span> 
       </div> 
       </Link>
   </div> 
   </body>
   </html>
    </nav>
}

export default Header

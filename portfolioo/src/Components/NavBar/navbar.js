import React from 'react';
import './navbar.css';
import logo from '../../Assets/Nithin.jpeg';
import {Link} from 'react-router-dom';
import contactImg from '../../Assets/contact.png';
const Navbar = () => {
  return (
   <nav className='navbar'>
     <img src={logo} alt='Logo' className='logo' width="50" />
     <div className='menu'>
     <Link to="/" className='menuListItem'>Home</Link>
     <Link to="/About" className='menuListItem'>About</Link>
     <Link to="/Projects" className='menuListItem'>Projects</Link>
     <Link to="/Skills" className='menuListItem'>Skills</Link>
     </div>
     <Link to="/EmailForm" className="MM"><button className='menuBtn'><img src={contactImg} alt='' className='menuImg' />Contact Me</button></Link>

   </nav>
  )
}

export default Navbar;
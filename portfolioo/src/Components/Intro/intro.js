import React from 'react';
import './intro.css';
import imgBg from '../../Assets/proff.png';
import { Link } from 'react-scroll';
import imgBtn from '../../Assets/hireme.png';

const Intro = () => {
  return (
    <section id="intro" className="intro-container">
      <div className='introContent'>
        <span className="hello">Hello,</span>
        <span className='introText'>I'm <span className='introName'>Nithin</span> <br />Full Stack Developer</span>
        <p className='introPara'>I am a highly skilled Full Stack Developer<br /> I excel in the art of crafting visually appealing and user-friendly websites<br /> that seamlessly integrate both front-end and back-end technologies.</p>
        <Link to="hire-me" smooth={true} duration={500}><button className="btn"><img src={imgBtn} alt='Hire Me' className='btnImg'/>Hire Me</button></Link>
      </div>
      <img src={imgBg} alt='Profile' className='bg' />
    </section>
  )
}

export default Intro;

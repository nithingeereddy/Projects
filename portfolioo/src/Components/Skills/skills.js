import React from 'react'
import './skills.css';
import UIDesign from '../../Assets/ui-design.png';
import WebDesign from '../../Assets/website-design.png';
import AppDesign from '../../Assets/app-design.png';
import reactImg from '../../Assets/React.png';
import nodeImg from '../../Assets/Node.png';
import springImg from '../../Assets/Spring.png';
import javaImg from '../../Assets/Java.png';

const Skill = () => {
  return (
    <section id='skills'>
        <span className='skillTitle'>What I do</span>
        <span className='skillDesc'>I am a highly skilled Full Stack Developer with a proven track record,<br></br> I excel in the art of crafting visually appealing and user-friendly websites<br></br> that seamlessly integrate both front-end and back-end technologies.</span>
       <div className='skillBars'>
        <div className='skillBar'>
          <img src={UIDesign} alt='UIDesign' className='skillBarImg' />
          <div className='skillBarText'>
            <h2>UI/UX Design</h2>
            <p>Elevating user experiences through thoughtful design.</p>
          </div>
        </div>
        <div className='skillBar'>
          <img src={WebDesign} alt='WebDesign' className='skillBarImg' />
          <div className='skillBarText'>
            <h2>Website Design</h2>
          </div>
        </div>
        <div className='skillBar'>
          <img src={AppDesign} alt='AppDesign' className='skillBarImg' />
          <div className='skillBarText'>
            <h2>App Design</h2>
            <p>Bringing intuitive mobile experiences to life on iOS and Android.</p>
          </div>
        </div>
        <div className='skillBar'>
          <img src={reactImg} alt='React.js' className='skillBarImg' />
          <div className='skillBarText'>
            <h2>React.js</h2>
          </div>
        </div>
        <div className='skillBar'>
          <img src={nodeImg} alt='React.js' className='skillBarImg' />
          <div className='skillBarText'>
            <h2>Node.js</h2>
          </div>
        </div>
        <div className='skillBar'>
          <img src={javaImg} alt='Java' className='skillBarImg' />
          <div className='skillBarText'>
            <h2>Java</h2>
          </div>
          </div>
        <div className='skillBar'>
          <img src={springImg} alt='Spring Boot' className='skillBarImg' />
          <div className='skillBarText'>
            <h2>Spring Boot</h2>
          </div>
        </div>
        </div>
    </section>
  );
}

export default Skill;
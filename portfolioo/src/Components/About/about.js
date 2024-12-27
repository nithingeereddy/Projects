import React, { useState } from 'react';
import './about.css';
import Apic from '../../Assets/apic.jpg';

const About = () => {
  const [activeTab, setActiveTab] = useState('skills');

  const openTab = (tabName) => {
    const tabLinks = document.querySelectorAll('.tab-links');
    const tabContents = document.querySelectorAll('.tab-contents');

    tabLinks.forEach((tabLink) => {
      tabLink.classList.remove('active-link');
    });

    tabContents.forEach((tabContent) => {
      tabContent.classList.remove('active-tab');
    });

    const clickedTab = document.getElementById(tabName);
    if (clickedTab) {
      clickedTab.classList.add('active-tab');
    }

    setActiveTab(tabName);
  };

  return (
    <div className='about'>
      <div className='container'>
        <div className='row'>
          <div className='about-col1'>
            <img src={Apic} alt='Nithin Reddy Geereddy' className='Apic' />
          </div>
          <div className='about-col2'>
            <h1 className='sub-title'>About Me</h1>
            <p>
              I'm Nithin Geereddy, a Master's student at the University of
              Central Missouri. With a year of IT experience,<br></br> I'm skilled in
              Java, Node.js, React, SQL, data analysis, and Python. Actively
              seeking internships to apply<br></br> and expand my skills. Looking forward
              to discussing how I can contribute
            </p>
            <div className='tab-titles'>
              <p
                className={`tab-links ${activeTab === 'skills' && 'active-link'}`}
                onClick={() => openTab('skills')}
              >
                Skills
              </p>
              <p
                className={`tab-links ${activeTab === 'experience' && 'active-link'}`}
                onClick={() => openTab('experience')}
              >
                Experience
              </p>
              <p
                className={`tab-links ${activeTab === 'education' && 'active-link'}`}
                onClick={() => openTab('education')}
              >
                Education
              </p>
            </div>
            <div className='tab-contents' id='skills'>
              {activeTab === 'skills' && (
                <ul>
                  <li>
                    <span>Java</span>
                  </li>
                  <li>
                    <span>Node.js</span>
                  </li>
                  <li>
                    <span>React</span>
                  </li>
                  <li>
                    <span>SQL</span>
                  </li>
                  <li>
                    <span>Data Analysis</span>
                  </li>
                  <li>
                    <span>Python</span>
                  </li>
                </ul>
              )}
            </div>
            <div className='tab-contents' id='experience'>
              {activeTab === 'experience' && (
                <ul>
                  <li>
                    <span>Advanced App Engineer Associate, Accenture Pvt Ltd                              Jan 2023 – Aug 2023</span>
                    <br></br>• Developed interactive and responsive web interfaces using HTML, CSS, and JavaScript.
                    <br></br>         • Created dynamic user experiences with React for improved website interactivity.
                    <br></br>         • Implemented server-side scripting and API development with Node.js and Express.js.
                    <br></br>         • Designed, developed, and managed databases using MySQL for efficient data handling.
                  </li>
                  <br></br>
                  <li>
                    <span>Full Stack Developer Intern, Virtusa Consulting Services Pvt Ltd                 Jan 2022 - Apr 2022   </span>
                    <br></br>• Developed a Course Management Application using the MEAN stack (MongoDB, Express.js, AngularJS, Node.js), demonstrating proficiency in full-stack development.              
                    <br></br>•	Implemented robust user login validations and authentication processes, ensuring secure access to the platform and safeguarding user data.                                                                              
                    <br></br>•	Designed and created an intuitive admin page, enabling efficient user management in accordance with client specifications and enhancing overall application usability.
                  </li>
                  <br></br>
                  <li>
                    <span>Cyber Security Intern, Indian servers Software Development Company               Aug 2020 - Sep 2020</span>
                    <br></br>• Developed a MEAN stack Course Management Application, proficient in MongoDB, Express.js, AngularJS, and Node.js, optimizing user experience and client satisfaction.
                    <br></br>• Implemented user login validations, authentication procedures, and an admin page for seamless user management, ensuring secure access and client-specific functionality.
                    <br></br>• Received commendation from clients for exceeding requirements, highlighting strong problem-solving abilities and a client-centric approach to development.
                  </li>
                </ul>
              )}
            </div>
            <div className='tab-contents' id='education'>
              {activeTab === 'education' && (
                <ul>
                  <li>
                    <span>Master’s in Big Data Analytics and Information Technology       (Aug 2023 - Present)</span>
                    <br></br>University of Central Missouri, Lee’s Summit, MO
                  </li>
                  <li>
                    <span>Bachelor of Technology in Information                          (June 2018 - May 2022 )</span>
                    <br></br>CMR Technical Campus, Hyd, India
                  </li>

                </ul>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default About;

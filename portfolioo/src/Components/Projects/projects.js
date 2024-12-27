import React from 'react';
import './projects.css';
import pro1 from '../../Assets/Getit pro1.png';
import pro2 from '../../Assets/pro2.png';
import pro3 from '../../Assets/pro3.jpeg';

const projects = [
  {
    id: 1,
    title: 'Getit!',
    description: 'Get your Packages Delivered Instantly',
    imageUrl: pro1, // Corrected the imageUrl value to use the imported image directly
    link: '#',
  },
  {
    id: 2,
    title: 'Hybrid abnormal activity detection',
    description: 'Crime Detection using CNN',
    imageUrl: pro2, // You can use the same image or change it to another imported image
    link: '#',
  },
  {
    id: 3,
    title: 'Smart voice Assistant using python',
    description: 'Get your things done just by giving voice commands',
    imageUrl: pro3, // You can use the same image or change it to another imported image
    link: '#',
  },
  
  // Add more projects as needed
];

function Projects() { // Changed function name from App to Projects
  return (
    <div className="App">
      <header>
        <h1>My Projects</h1>
      </header>

      <section className="projects">
        {projects.map((project) => (
          <div className="project" key={project.id}>
            <img src={project.imageUrl} alt={project.title} />
            <h3>{project.title}</h3>
            <p>{project.description}</p>
            <a href={project.link}>Learn More</a>
          </div>
        ))}
      </section>

      <footer>
        <p>&copy; 2024 Nithin Reddy Geereddy</p>
      </footer>
    </div>
  );
}

export default Projects; // Exporting Projects component instead of App

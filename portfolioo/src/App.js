// App.js
import React from 'react';
import Navbar from './Components/NavBar/navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Intro from './Components/Intro/intro';
import Projects from './Components/Projects/projects';
import About from './Components/About/about';
import Skills from './Components/Skills/skills';
import EmailForm from './Components/EmailForm';


function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Switch>
          <Route path="/About">
            <About />
          </Route>
          <Route path="/Projects">
            <Projects />
          </Route>
          <Route path="/Skills">
            <Skills />
          </Route>
          <Route path="/EmailForm">
            <EmailForm />
          </Route>
          <Route path="/">
            <Intro />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;

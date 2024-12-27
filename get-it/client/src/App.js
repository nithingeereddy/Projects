import React from 'react';
import {BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Header from "./Header";
import Login from "./Login";
import Home from "./Home";
import Request from "./Request";
import About from "./About";
import Signup from "./Signup";
import Footer from "./Footer";
function App() {
  return (
  
    <Router>
    <div className="app">
      <Switch>
      <Route path="/login">
        <Header />
        <Login />
        <Footer />
      </Route>
      <Route path="/signup">
        <Header />
        <Signup />
        <Footer />
      </Route>
       <Route path="/about">
        <Header />
        <About />
        <Footer />
      </Route>
      <Route path="/checkout">
        <Header />
        <Request />
        <Footer />
      </Route>
      <Route path="/">
       <Header />
       <Home />
       <Footer />
      </Route>
    </Switch>
    </div>
    </Router>
  );
}

export default App;

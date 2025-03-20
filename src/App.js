import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NavBar from "./components/NavBar";
import ScanReceipts from "./components/ScanReceipts";
import About from "./components/About";
import DataAnalysis from "./components/DataAnalysis";

function App() {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route path="/" element={<ScanReceipts />} />
        <Route path="/about" element={<About />} />
        <Route path="/scan" element={<h1>Extract Data Page</h1>} />
        <Route path="/analysis" element={<DataAnalysis />} />
        <Route path="/contact" element={<h1>Contact Page</h1>} />
      </Routes>
    </Router>
  );
}

export default App;

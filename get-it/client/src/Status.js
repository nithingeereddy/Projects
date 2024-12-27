import React from "react";
import useLocalStorage from "./hooks/useLocalStorage";
import useNetworkStatus from "./hooks/useNetworkStatus";
import "./status.css";

function Status() {
  const [isDark, setIsDark] = useLocalStorage("isDark", false);
  console.log(isDark);
  const status = useNetworkStatus();
  return ( 
    <div className={`App ${isDark ? "dark" : ""}`}>
      <h1>Custom Hook Series</h1>
      <h2>Let's create some useful hooks in React.JS!</h2>
      <div className="container">
        <span className={`status ${status ? "online" : "offline"}`}>
          {status ? "Online" : "Offline"}
        </span>
      </div>
      <br />
      <button onClick={() => setIsDark(!isDark)}>Toggle Theme </button>
    </div>
  );
}
export default Status;
import React, { useState } from "react";
import "./SpeedTest.css"; // Import CSS for styling
import { FaTachometerAlt } from "react-icons/fa"; // Speedometer Icon

const SpeedTest = () => {
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);

  const runSpeedTest = async () => {
    setLoading(true);
    setResult(null); // Clear previous result

    try {
      const response = await fetch("http://localhost:8080/api/speedtest/run");
      const data = await response.json();
      setResult(data);
    } catch (error) {
      console.error("Error running speed test:", error);
    }

    setLoading(false);
  };

  return (
    <div className="container">
      <h1 className="title">
        <FaTachometerAlt className="icon" /> Speed Test
      </h1>

      <div className="card">
        <button className="start-button" onClick={runSpeedTest} disabled={loading}>
          {loading ? <div className="spinner"></div> : "GO"}
        </button>

        {result && (
          <div className="results">
            <h2>Results:</h2>
            <p>📥 Download: <span>{result.download.toFixed(2)} Mbps</span></p>
            <p>📤 Upload: <span>{result.upload.toFixed(2)} Mbps</span></p>
            <p>⚡ Ping: <span>{result.ping} ms</span></p>
            <p>📍 Location: <span>{result.location}</span></p>
            <p>🌐 IP: <span>{result.ip}</span></p>
            <p>🏢 Provider: <span>{result.provider}</span></p>
            <p>🚀 ISP: <span>{result.isp}</span></p>
          </div>
        )}
      </div>
    </div>
  );
};

export default SpeedTest;

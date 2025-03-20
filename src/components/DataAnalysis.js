import React, { useEffect, useState } from 'react';
import axios from 'axios';
import SalesChart from './SalesChart';
import './DataAnalysis.css';

function DataAnalysis() {
  const [weeklyData, setWeeklyData] = useState(null); // Initialize to null
  const [monthlyData, setMonthlyData] = useState(null); // Initialize to null
  const [loading, setLoading] = useState(true);
  const [view, setView] = useState('weekly');
  const [error, setError] = useState(null); // State to hold errors

  useEffect(() => {
    const fetchSalesData = async () => {
      try {
        const weekResponse = await axios.get('http://localhost:8080/sales/average/week');
        const monthResponse = await axios.get('http://localhost:8080/sales/average/month');

        setWeeklyData(formatChartData(weekResponse.data, 'Weekly'));
        setMonthlyData(formatChartData(monthResponse.data, 'Monthly'));
        setLoading(false);
      } catch (err) {
        console.error('Error fetching sales data:', err);
        setError(err); // Set the error state
        setLoading(false); // Ensure loading is set to false even on error
      }
    };

    fetchSalesData();
  }, []);

  const formatChartData = (data, label) => {
    if (!data) {
      console.warn("Data is null or undefined in formatChartData");
      return null;  // Return null if data is invalid
    }

    // Prepare data arrays for chart
    const productTitles = [];
    const ratings = [];
    const reviewCounts = [];

    // Loop through data to extract product title, rating, and review count
    Object.keys(data).forEach((key) => {
      if (Array.isArray(data[key])) {
        data[key].forEach((item) => {
          productTitles.push(item.productTitle);
          ratings.push(item.rating);
          reviewCounts.push(item.reviewCount);
        });
      } else {
        console.warn(`Data for key ${key} is not an array.`);
      }
    });

    return {
      labels: productTitles,
      datasets: [
        {
          label: `${label} Rating`,
          data: ratings,
          borderColor: 'rgba(75,192,192,1)',
          backgroundColor: 'rgba(75,192,192,0.2)',
          tension: 0.4,
          fill: false,
        },
        {
          label: `${label} Review Count`,
          data: reviewCounts,
          borderColor: 'rgba(153,102,255,1)',
          backgroundColor: 'rgba(153,102,255,0.2)',
          tension: 0.4,
          fill: false,
        },
      ],
    };
  };

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;  // Display error message

  const chartData = view === 'weekly' ? weeklyData : monthlyData;

  return (
    <div className="data-analysis">
      <h2>Sales Data Analysis</h2>
      <div className="toggle-buttons">
        <button onClick={() => setView('weekly')} className={view === 'weekly' ? 'active' : ''}>
          Weekly
        </button>
        <button onClick={() => setView('monthly')} className={view === 'monthly' ? 'active' : ''}>
          Monthly
        </button>
      </div>
      <div className="chart-container">
        {chartData ? (
          <SalesChart chartData={chartData} />
        ) : (
          <p>No data available.</p>
        )}
      </div>
    </div>
  );
}

export default DataAnalysis;

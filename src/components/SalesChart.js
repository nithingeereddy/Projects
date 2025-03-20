// SalesChart.js
import React from 'react';
import { Line } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

function SalesChart({ chartData }) {
  if (!chartData || Object.keys(chartData).length === 0) {
    return <p>No data to display.</p>; // Handle case where chartData is empty or null
  }

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: 'Sales Data',
      },
    },
  };

  return <Line options={options} data={chartData} />;
}

export default SalesChart;

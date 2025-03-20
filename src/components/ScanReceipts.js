import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FaSearch, FaTrash, FaEdit, FaSave, FaTimes } from 'react-icons/fa';
import { Bar } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';
import './ScanReceipts.css';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

function ScanReceipts() {
    const [customers, setCustomers] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [folderPath, setFolderPath] = useState('');
    const [scanning, setScanning] = useState(false);
    const [editingId, setEditingId] = useState(null);
    const [editForm, setEditForm] = useState({});

    const fetchCustomers = async () => {
        setLoading(true);
        try {
            const response = await axios.get('http://localhost:8080/api/get-all-data');
            setCustomers(response.data);
        } catch (err) {
            setError('Error fetching customer data: ' + err.message);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchCustomers();
    }, []);

    const handleClearAll = async () => {
        if (window.confirm("Are you sure you want to delete all records? This action cannot be undone.")) {
            try {
                await axios.delete('http://localhost:8080/api/deleteAll');
                setCustomers([]);
            } catch (err) {
                setError('Error deleting all customer data: ' + err.message);
            }
        }
    };

    const handleScan = async () => {
        setScanning(true);
        setError(null);
        try {
            await axios.get(`http://localhost:8080/api/process-folder?folderPath=${encodeURIComponent(folderPath)}`);
            await fetchCustomers();
        } catch (err) {
            setError('Error scanning documents: ' + err.message);
        } finally {
            setScanning(false);
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/api/delete/${id}`);
            await fetchCustomers();
        } catch (err) {
            setError('Error deleting customer data: ' + err.message);
        }
    };

    const handleEdit = (customer) => {
        setEditingId(customer.id);
        setEditForm(customer);
    };

    const handleUpdate = async () => {
        try {
            await axios.put(`http://localhost:8080/api/update/${editingId}`, editForm);
            await fetchCustomers();
            setEditingId(null);
        } catch (err) {
            setError('Error updating customer data: ' + err.message);
        }
    };

    const handleChange = (e) => {
        setEditForm({ ...editForm, [e.target.name]: e.target.value });
    };

    const getRatingClass = (rating) => {
        if (rating >= 4.5) return { classification: 'Excellent', color: 'green' };
        if (rating >= 3.5) return { classification: 'Good', color: 'orange' };
        return { classification: 'Bad', color: 'red' };
    };

    const getFirstTwoWords = (text) => {
        if (!text) return '';
        const words = text.split(' ');
        return words.slice(0, 2).join(' ');
    };

    // Prepare chart data
    const getChartData = () => {
        const ratings = customers.map(customer => customer.rating);
        const reviewCounts = customers.map(customer => customer.reviewCount || 0);

        return {
            labels: customers.map(customer => getFirstTwoWords(customer.name)),
            datasets: [
                {
                    label: 'Customer Ratings',
                    data: ratings,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                },
                {
                    label: 'Review Count',
                    data: reviewCounts,
                    backgroundColor: 'rgba(153, 102, 255, 0.2)',
                    borderColor: 'rgba(153, 102, 255, 1)',
                    borderWidth: 1
                }
            ]
        };
    };

    return (
        <div className="scan-receipts">
            <h1>Scan Receipts</h1>

            <div className="scan-container">
                <input
                    type="text"
                    value={folderPath}
                    onChange={(e) => setFolderPath(e.target.value)}
                    placeholder="Enter folder path"
                />
                <button onClick={handleScan} disabled={scanning || !folderPath}>
                    {scanning ? <span className="loading-dots">Scanning</span> : <><FaSearch /> Scan Documents</>}
                </button>
                <button onClick={handleClearAll} className="clear-all-btn"><FaTrash /> Clear All Data</button>
            </div>

            {error && (
                <div className="toast error">
                    <p>{error}</p>
                    <button onClick={() => setError(null)}><FaTimes /></button>
                </div>
            )}
            <h2>Customer Data Analysis</h2>
            <div className="chart-container">
                <Bar data={getChartData()} options={{ responsive: true }} />
            </div>
            <h2>Customer Data</h2>

            {loading ? (
                <div className="loading-spinner"></div>
            ) : customers.length === 0 ? (
                <div className="no-data">
                    <p>No customer data available.</p>
                </div>
            ) : (
                <div className="table-container">
                    <table className="customer-table">
                        <thead>
                            <tr>
                                <th>Receipt Number</th>
                                <th>Customer Name</th>
                                <th>Date</th>
                                <th>Location</th>
                                <th>Product</th>
                                <th>Tax</th>
                                <th>Total Amount</th>
                                <th>Rating</th>
                                <th>Classification</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {customers.map((customer) => {
                                const { classification, color } = getRatingClass(customer.rating);
                                return (
                                    <tr key={customer.id}>
                                        {
                                            editingId === customer.id ? (
                                                <>
                                                    <td><input name="receiptNo" value={editForm.receiptNo} onChange={handleChange} /></td>
                                                    <td><input name="name" value={editForm.name} onChange={handleChange} /></td>
                                                    <td><input name="date" value={editForm.date} onChange={handleChange} /></td>
                                                    <td><input name="location" value={editForm.location} onChange={handleChange} /></td>
                                                    <td><input name="productName" value={editForm.productName} onChange={handleChange} /></td>
                                                    <td><input name="tax" value={editForm.tax} onChange={handleChange} /></td>
                                                    <td><input name="total" value={editForm.total} onChange={handleChange} /></td>
                                                    <td><input name="rating" value={editForm.rating} onChange={handleChange} /></td>
                                                    <td>{classification}</td>
                                                    <td>
                                                        <button onClick={handleUpdate}><FaSave /></button>
                                                        <button onClick={() => setEditingId(null)}><FaTimes /></button>
                                                    </td>
                                                </>
                                            ) : (
                                                <>
                                                    <td>{customer.receiptNo}</td>
                                                    <td>{customer.name}</td>
                                                    <td>{customer.date}</td>
                                                    <td>{customer.location}</td>
                                                    <td>{getFirstTwoWords(customer.productName)}</td>
                                                    <td>{customer.tax}</td>
                                                    <td>{customer.total}</td>
                                                    <td style={{ color: color }}>{customer.rating}</td>
                                                    <td style={{ color: color }}>{classification}</td>
                                                    <td>
                                                        <button onClick={() => handleEdit(customer)}><FaEdit /></button>
                                                        <button onClick={() => handleDelete(customer.id)}><FaTrash /></button>
                                                    </td>
                                                </>
                                            )
                                        }
                                    </tr>
                                );
                            })}
                        </tbody>
                    </table>
                </div>
            )}

            {/* Data Analysis Section */}
            
        </div>
    );
}

export default ScanReceipts;

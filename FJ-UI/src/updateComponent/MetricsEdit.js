import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import service from "../service";
import "./MetricsEdit.css";
import img1 from "../images/fitness-logo.jpg";

const MetricsEdit = ({ onSubmit, onCancel, MechanicId }) => {
    const { id } = useParams();
    const [metricsData, setMetricsData] = useState({
        kilograms: 0.0,
        centimeters: 0.0,
        age: 0,
        gender: '',
    });
    const navigate = useNavigate();

    useEffect(() => {
        const fetchMetric = async () => {
            const response = await service.getMetricsById(id);
            setMetricsData(response);
        };

        fetchMetric();
    }, [id]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const updatedMetricsData = {
            kilograms: +metricsData.kilograms,
            centimeters: +metricsData.centimeters,
            age: +metricsData.age,
            gender: metricsData.gender
        };
        await service.updateMetrics(id, updatedMetricsData);
        navigate('/');
    };

    return (
        <div>
            <header>
                <h2 className="header-name-2">Edit Metrics</h2>
                <img className="logo" src={img1} alt="logo"/>
            </header>

            <form className="formStyle2" onSubmit={handleSubmit}>
                <label>
                    Kilograms:
                    <input
                        type="text"
                        value={metricsData.kilograms}
                        onChange={(e) => setMetricsData({...metricsData, kilograms: e.target.value})}
                    />
                </label>

                <label>
                    Centimeters:
                    <input
                        type="text"
                        value={metricsData.centimeters}
                        onChange={(e) => setMetricsData({...metricsData, centimeters: e.target.value})}
                    />
                </label>

                <label>
                    Age:
                    <input
                        type="text"
                        value={metricsData.age}
                        onChange={(e) => setMetricsData({...metricsData, age: e.target.value})}
                    />
                </label>

                <label>
                    Gender:
                    <input
                        type="text"
                        value={metricsData.gender}
                        onChange={(e) => setMetricsData({...metricsData, gender: e.target.value})}
                    />
                </label>

                <button type="submit">Update</button>
            </form>
            <footer className="metricsFooter">&copy; A.A.</footer>
        </div>
    );
};

export default MetricsEdit;
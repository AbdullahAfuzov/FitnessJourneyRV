// YourComponent.js
import React, { useState, useEffect } from 'react';
import apiService from './service.js';
import "./Main.css";
import img1 from './images/fitness-logo.jpg';
import {Link} from "react-router-dom";

const Main = () => {

    const [metricsData, setMetricsData] = useState({
        kilograms: 0.0,
        centimeters: 0.0,
        age: 0,
        gender: '',
    });

    const [exUserData, setExUserData] = useState({
        userExerciseName: '',
        rep: 0,
    });

    const [foodUserData, setFoodUserData] = useState({
        usersFoodName: '',
        usersGrams: 0.0,
    });

    const [metrics, setMetrics] = useState([]);
    const [exUsers, setExUsers] = useState([]);
    const [foodUsers, setFoodUsers] = useState([]);
    const [caloriesBM, setCaloriesBM] = useState([]);
    const [caloriesBurned, setCaloriesBurned] = useState([]);
    const [calories, setCalories] = useState([]);

    // CRUD methods
    const handleGetMetrics = async () => {
        try {
            const metricsData = await apiService.getMetrics();
            // Ensure that metricsData is an array before setting state
            if (Array.isArray(metricsData)) {
                setMetrics(metricsData);
            } else {
                console.error('Metrics data is not an array:', metricsData);
            }
        } catch (error) {
            console.error('Error fetching metrics:', error);
        }
    };

    const handleAddMetrics = async (e) => {
        e.preventDefault()
        try {
            const date = await apiService.addMetrics(metricsData);
            handleCaloriesBM(date.id);
            handleGetMetrics();
            // Clear form fields
            setMetricsData({
                kilograms: 0.0,
                centimeters: 0.0,
                age: 0,
                gender: '',
            });
        } catch (error) {
            console.error('Error adding metrics:', error);
        }
    };

    const handleDeleteMetrics = async (id) => {
        try {
            await apiService.deleteMetrics(id);
            handleGetMetrics();
        } catch (error) {
            console.error('Error deleting metrics:', error);
        }
    };

    const handleGetExUsers = async () => {
        try {
            const exUsersData = await apiService.getExUsers();
            setExUsers(exUsersData);
        } catch (error) {
            console.error('Error fetching exercise users:', error);
        }
    };

    const handleAddExUser = async (e) => {
        e.preventDefault()
        try {
            await apiService.addExUser(exUserData);
            handleGetExUsers();
            // Clear form fields
            setExUserData({
                userExerciseName: '',
                rep: 0,
            });
        } catch (error) {
            console.error('Error adding exercise user:', error);
        }
        handleCaloriesBurned();
    };

    const handleDeleteExUser = async (id) => {
        try {
            await apiService.deleteExUser(id);
            handleGetExUsers();
        } catch (error) {
            console.error('Error deleting exercise user:', error);
        }
    };

    const handleGetFoodUsers = async () => {
        try {
            const foodUsersData = await apiService.getFoodUser();
            setFoodUsers(foodUsersData);
        } catch (error) {
            console.error('Error fetching food users:', error);
        }
    };

    const handleAddFoodUser = async (e) => {
        e.preventDefault();
        try {
            await apiService.addFoodUser(foodUserData);
            handleGetFoodUsers();
            // Clear form fields
            setFoodUserData({
                usersFoodName: '',
                usersGrams: 0.0,
            });
        } catch (error) {
            console.error('Error adding food user:', error);
        }
        handleCalories();
    };

    const handleDeleteFoodUser = async (id) => {
        try {
            await apiService.deleteFoodUser(id);
            handleGetFoodUsers();
        } catch (error) {
            console.error('Error deleting food user:', error);
        }
    };

    const handleCaloriesBM = async (id) => {
        try {
            const date = await apiService.getMetricsById(id);
            console.log(date);
            setCaloriesBM(date.caloriesBM);
        } catch(error) {
            console.error('No Metrics!', error);
        }
    };
    const handleCaloriesBurned = async () => {
        try {
            const date = await apiService.getExUsers();
            console.log(date);
            let calories = 0;
            date.map (exercise => {
                calories = calories + exercise.caloriesBurned;
            });
            setCaloriesBurned(calories);
        } catch (error) {
            console.error('No exercise', error);
        }
    };

    const handleCalories = async () => {
        try {
            const date = await apiService.getFoodUser();
            console.log(date);
            let calories = 0;
            date.map (food => {
                calories = calories + food.calories;
            });
            setCalories(calories);
        } catch (error) {
            console.error('No food', error);
        }
    };

    useEffect(() => {
        handleGetMetrics();
        handleGetExUsers();
        handleGetFoodUsers();
    }, []);

    return (
        <div>
            <header className="headerStyle">
                <h1 className="header-name">FitnessJourney</h1>
                <img className="logo" src={img1} alt="logo"/>
            </header>

            <nav className="tableStyle">
                {/* Metrics Data */}
                <table className="tableMetrics">
                    <thead>
                    <tr className="trStyle">
                        <th>Kilograms</th>
                        <th>Centimeters</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {metrics.map((metric) => (
                        <tr id={metric.id}>
                            <td>{metric.kilograms}</td>
                            <td>{metric.centimeters}</td>
                            <td>{metric.age}</td>
                            <td>{metric.gender}</td>
                            <td>
                                <Link className="update" to={`/metrics/edit/${metric.id}`}>Update</Link>
                                <button onClick={() => handleDeleteMetrics(metric.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>

                {/* Exercise User Data */}
                <table>
                    <thead>
                    <tr>
                        <th>Exercise Name</th>
                        <th>Reps</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {exUsers.map((exUsers) => (
                        <tr id={exUsers.id}>
                            <td>{exUsers.userExerciseName}</td>
                            <td>{exUsers.rep}</td>
                            <td>
                                <button onClick={() => handleDeleteExUser(exUsers.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>

                {/* Food User Data */}
                <table>
                    <thead>
                    <tr>
                        <th>Food Name</th>
                        <th>usersGrams</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {foodUsers.map((foodUser) => (
                        <tr key={foodUser.id}>
                            <td>{foodUser.usersFoodName}</td>
                            <td>{foodUser.usersGrams}</td>
                            <td>
                                <button onClick={() => handleDeleteFoodUser(foodUser.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </nav>

            <nav className="formCalcBMImage">
                {/* Add Metrics Form */}
                <form className="formStyle" onSubmit={handleAddMetrics}>
                    <label>
                        Kilograms:
                        <input
                            type="number"
                            step="0.1"
                            value={metricsData.kilograms}
                            onChange={(e) => setMetricsData({...metricsData, kilograms: parseFloat(e.target.value)})}
                        />
                    </label>
                    <label>
                        Centimeters:
                        <input
                            type="number"
                            step="0.1"
                            value={metricsData.centimeters}
                            onChange={(e) => setMetricsData({...metricsData, centimeters: parseFloat(e.target.value)})}
                        />
                    </label>
                    <label>
                        Age:
                        <input
                            type="number"
                            value={metricsData.age}
                            onChange={(e) => setMetricsData({...metricsData, age: parseInt(e.target.value)})}
                        />
                    </label>
                    <label>
                        Gender:
                        <input
                            type="text"
                            placeholder="M/F"
                            value={metricsData.gender}
                            onChange={(e) => setMetricsData({...metricsData, gender: e.target.value})}
                        />
                    </label>
                    <button type="submit">Add Metrics</button>
                </form>
                <img className="imgForm" src={img1} alt="img"/>
                <label className="calcBM">
                    B.M.
                    <h3>{caloriesBM}</h3>
                </label>
            </nav>

            <nav className="form2W3">
                {/* Add Exercise User Form */}
                <form className="formEx" onSubmit={handleAddExUser}>
                    <label>
                        Exercise Name:
                        <input
                            type="text"
                            placeholder="*"
                            value={exUserData.userExerciseName}
                            onChange={(e) => setExUserData({...exUserData, userExerciseName: e.target.value})}
                        />
                    </label>
                    <label>
                        Reps:
                        <input
                            type="number"
                            value={exUserData.rep}
                            onChange={(e) => setExUserData({...exUserData, rep: parseInt(e.target.value)})}
                        />
                    </label>
                    <button type="submit">Add Exercise</button>
                    <label className="labelCALB">
                        Calories-BURNED
                        <h3>
                            {caloriesBurned}
                        </h3>
                    </label>
                </form>

                {/* Add Food User Form */}
                <form className="formFood" onSubmit={handleAddFoodUser}>
                    <label>
                        Food Name:
                        <input
                            type="text"
                            placeholder="*"
                            value={foodUserData.usersFoodName}
                            onChange={(e) => setFoodUserData({...foodUserData, usersFoodName: e.target.value})}
                        />
                    </label>
                    <label>
                        usersGrams:
                        <input
                            type="number"
                            step="0.1"
                            value={foodUserData.usersGrams}
                            onChange={(e) => setFoodUserData({...foodUserData, usersGrams: parseFloat(e.target.value)})}
                        />
                    </label>
                    <button type="submit">Add Food</button>
                    <label className="labelCALF">
                        Calories
                        <h3>
                            {calories}
                        </h3>
                    </label>
                </form>
            </nav>
            <footer>&copy; A.A.</footer>
        </div>
    );
};

export default Main;

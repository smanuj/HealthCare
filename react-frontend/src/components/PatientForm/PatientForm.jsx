import React, { useState } from 'react';
import './PatientForm.css';

const PatientForm = () => {
    const [patient, setPatient] = useState({
        name: '',
        age: '',
        gender: ''
    });

    const handleChange = (event) => {
        setPatient({
            ...patient,
            [event.target.name]: event.target.value
        });
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        // Code to submit the form data to the backend goes here
    }

    return (
        <form className="patient-form" onSubmit={handleSubmit}>
            <h2>Patient Registration</h2>
            <label>
                Name:
                <input type="text" name="name" value={patient.name} onChange={handleChange} required />
            </label>
            <label>
                Age:
                <input type="number" name="age" value={patient.age} onChange={handleChange} required />
            </label>
            <label>
                Gender:
                <select name="gender" value={patient.gender} onChange={handleChange} required>
                    <option value="" disabled>Select Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </label>
            <button type="submit">Register</button>
        </form>
    );
}

export default PatientForm;

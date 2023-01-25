import React, { useState } from 'react';
import './PatientForm.css';

const PatientForm = () => {
    const [patient, setPatient] = useState({
        aId: '',
        bg: '',
        pr: '',
        oxy:'',
        temp:'',
        disease:'',
        pincode:''
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
        <div className="app">
        <form className="patient-form" onSubmit={handleSubmit}>
            <h2>Patient Details</h2>
            <label>
                Aadhar number:
                <input type="text" name="aId" value={patient.aId} onChange={handleChange} required />
            </label>
            <label>
                Blood Group:
                <input type="text" name="bg" value={patient.bg} onChange={handleChange} required />
            </label>
            <label>
                Pulse Rate:
                <input type="text" name="pr" value={patient.pr} onChange={handleChange} required />
            </label>
            <label>
                Oxygen Level:
                <input type="text" name="oxy" value={patient.oxy} onChange={handleChange} required />
            </label>
            <label>
                Body Temperature:
                <input type="text" name="temp" value={patient.temp} onChange={handleChange} required />
            </label>
            <label>
                Disease:
                <select name="disease" value={patient.disease} onChange={handleChange} required>
                    <option value="" disabled selected>Select Medical Condition</option>
                    <option value="gPhy">General medical issue</option>
                    <option value="heart">Heart issue</option>
                    <option value="skin">Skin issue</option>
                    <option value="ortho">Fracture</option>
                    <option value="pulmo">Breathing problem</option>
                </select>
            </label>
            <label>
                Pincode :
                <input type="text" name="pincode" value={patient.pincode} onChange={handleChange} required />
            </label>
            <button type="submit" className='button'>Register</button>
        </form>
        </div>
    );
}

export default PatientForm;

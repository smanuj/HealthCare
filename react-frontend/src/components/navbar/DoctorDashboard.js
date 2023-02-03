import React, { useState, useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import './DoctorDashboard.css';
import axios from 'axios';


function DoctorDashboard() {
  let {id: doctorId} = useParams();
  const [doctor, setDoctor] = useState({});
  const [patients, setPatients] = useState([])
  
  useEffect(() => {
    // Fetch doctor data from database
    axios.get(`http://localhost:8006/api/doctor/${doctorId}`)
      .then(res => {
        setDoctor(res.data);
      })
      .catch(err => {
        console.log(err);
      });

    // Fetch patient data from database
    
    axios.get(`http://localhost:8006/api/patientslist/${doctorId}`)
      .then(res => {
        setPatients(res.data);
      })
      .catch(err => {
        console.log(err);
      });
   
  }, [doctorId]);

  

  return (
    <div className="container">
      <div className="back-button">
    <Link to="/Login">
      <button>Logout</button>
    </Link>
  </div>
      <h1>Hello Dr. {doctor.name}</h1>
      <h1>Patient List</h1>
      <table>
        <thead>
          <tr>
            <th>Patient ID</th>
            <th>Patient Name</th>
            <th>Patient Status</th>
          </tr>
        </thead>
        <tbody>
          {patients.map((patient) => (
            <tr key={patient.id}>
              <td>{patient.id}</td>
              <td>{patient.aId.name}</td>
              <td>{patient.status ? 'Treatment Complete' : 'Treatment Incomplete'}</td>
              <td>
              <Link to={`/patientDetails/${patient.id}`}>
  <button>View Patient</button>
</Link>
                </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DoctorDashboard;
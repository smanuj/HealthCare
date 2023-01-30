import React, { useState, useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import './DoctorDashboard.css';


function DoctorDashboard() {
  let {doctorId} = useParams();
  const [doctor, setDoctor] = useState({});
  const [patients, setPatients] = useState([])
  
  useEffect(() => {
    // Fetch doctor data from database
    fetch('http://localhost:8006/api/doctor/${doctorId}')
      .then(res => res.json())
      .then(data => setDoctor(data));

    // Fetch patient data from database
    fetch('http://localhost:8006/api/patientslist/${doctorId}')
      .then(res => res.json())
      .then(data => setPatients(data));
   
  }, [doctorId]);

  

  return (
    <div className="container">
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

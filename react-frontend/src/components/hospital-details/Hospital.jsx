import React from 'react'
import { useLocation } from 'react-router-dom';
export default function Hospital() {
    let location = useLocation();
  return (
    <div>
         {console.log(location.state)}
      Jayadeva
    </div>
  )
}
//To connect the patient registration form in React.js to the Spring Boot backend, you can use the fetch() API or a library like Axios to make a HTTP POST request to the Spring Boot endpoint when the form is submitted.
// Here's an example of how to do that:



// const handleSubmit = async (event) => {
//   event.preventDefault();
//   try {
//       await axios.post('http://localhost:8080/patients', patient);
//       alert('Patient created successfully');
//   } catch (error) {
//       console.error(error);
//   }
// }

// patient-input form css:

// .patient-form {
//   width: 400px;
//   margin: 0 auto;
//   padding: 20px;
//   border: 1px solid #ccc;
//   border-radius: 10px;
// }

// .patient-form h2 {
//   text-align: center;
//   margin-bottom: 30px;
// }

// .patient-form label {
//   display: block;
//   margin-bottom: 10px;
// }

// .patient-form input[type="text"],
// .patient-form input[type="number"],
// .patient-form select {
//   width: 100%;
//   padding: 12px 20px;
//   margin: 8px 0;
//   box-sizing: border-box;
//   border: 1px solid #ccc;
//   border-radius: 4px;
// }

// .patient-form input[type="text"]:focus,
// .patient-form input[type="number"]:focus,
// .patient-form select:focus {
//   border: 1px solid #555;
// }

// .patient-form button[type="submit"] {
//   width: 100%;
//   background-color: #
// }

// patient-input form jsx:
// import React, { useState } from 'react';
// import './PatientForm.css';

// const PatientForm = () => {
//     const [patient, setPatient] = useState({
//         name: '',
//         age: '',
//         gender: ''
//     });

//     const handleChange = (event) => {
//         setPatient({
//             ...patient,
//             [event.target.name]: event.target.value
//         });
//     }

//     const handleSubmit = (event) => {
//         event.preventDefault();
//         // Code to submit the form data to the backend goes here
//     }

//     return (
//         <form className="patient-form" onSubmit={handleSubmit}>
//             <h2>Patient Registration</h2>
//             <label>
//                 Name:
//                 <input type="text" name="name" value={patient.name} onChange={handleChange} required />
//             </label>
//             <label>
//                 Age:
//                 <input type="number" name="age" value={patient.age} onChange={handleChange} required />
//             </label>
//             <label>
//                 Gender:
//                 <select name="gender" value={patient.gender} onChange={handleChange} required>
//                     <option value="" disabled>Select Gender</option>
//                     <option value="male">Male</option>
//                     <option value="female">Female</option>
//                 </select>
//             </label>
//             <button type="submit">Register</button>
//         </form>
//     );
// }

// export default PatientForm;

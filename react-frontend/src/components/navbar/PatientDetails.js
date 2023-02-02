import './PatientDetails.css';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import jsPDF from 'jspdf';
import moment from 'moment';


function PatientDetails() {
  let { patientId } = useParams();
  const [patients, setPatient] = useState({});
  const [isCommentAdded, setIsCommentAdded] = useState(false);
  const [comments, setComment] = useState("");
  const [patientComments, setPatientComments] = useState([]);
  const [isTreatmentComplete, setIsTreatmentComplete] = useState({}); // new state variable to store comments data
  const age = patients.aId && patients.aId.dob && patients.aId.dob.length > 0 ? new Date().getFullYear() - moment(patients.aId.dob, "DD-MM-YYYY").year() : "DOB not provided";


  useEffect(() => {
    // Fetch patient data from the database using the patient ID
    axios.get(`http://localhost:8006/api/patientdetails/${patientId}`)
      .then(res => {
        setPatient(res.data);
      })
      .catch(err => {
        console.log(err);
      });

  }, [patientId]);
  useEffect(() => {
    // Fetch patient data from the database using the patient ID
    axios.get(`http://localhost:8006/api/status/${patientId}`)
      .then(res => {
        setIsTreatmentComplete(res.data);
      })
      .catch(err => {
        console.log(err);
      });

  }, [patientId]);

  useEffect(() => {
    // Fetch patient comments from the database using the patient ID
    axios.get(`http://localhost:8006/api/commentsbypatientid/${patientId}`)
      .then(res => {
        setPatientComments(res.data);
      })
      .catch(err => {
        console.log(err);
      });

  }, [patientId]);

  const handleOpenComment = () => {
    setIsCommentAdded(true);
  }
  const handleSaveComment = () => {
    axios.post(`http://localhost:8006/api/savecomments`, { comments, patients })
      .then(res => {
        console.log("Comment saved successfully");
        setIsCommentAdded(false);
        // fetch the latest comments after saving the comment
        axios.get(`http://localhost:8006/api/commentsbypatientid/${patientId}`)
          .then(res => {
            setPatientComments(res.data);
          })
          .catch(err => {
            console.log(err);
          });
      })
      .catch(err => {
        console.log(err);
      });
  }
  const handleTreatmentComplete = () => {
    axios.put(`http://localhost:8006/api/updatePatientStatus/${patientId}`)
      .then(response => {
        console.log(response);
        setIsTreatmentComplete(true);
        // code to handle the success response
      })
      .catch(error => {
        console.log(error);
        // code to handle the error
      });
  }
  const handleDownloadPdf = () => {
    const pdf = new jsPDF();
    pdf.setFontSize(30);
    pdf.text(20, 10, "Patient Condition");
    pdf.setFontSize(15);
    pdf.text(20, 20, `Pulse Rate: ${patients.pulse_rate}`);
    pdf.text(20, 30, `Oxygen Level: ${patients.oxygenlevel}`);
    pdf.text(20, 40, `Temperature: ${patients.temperature}`);
    pdf.text(20, 50, `Disease: ${patients.disease}`);
    pdf.text(20, 60, `Status: ${patients.status ? 'Complete' : 'Incomplete'}`);
    pdf.setFontSize(30);
    pdf.text(120, 10, "Patient Details");
    pdf.setFontSize(15);
    pdf.text(120, 20, `Patient ID: ${patients.id}`);
    pdf.text(120, 30, `Patient Name: ${patients.aId.name}`);
    pdf.text(120, 40, `Patient Aadhar Number: ${patients.aId.aadharNo}`);
    pdf.text(120, 50, `Patient Blood Group: ${patients.bloodgroup}`);
    pdf.text(120, 60, `Patient Mobile: ${patients.aId.phoneno}`);
    if (patients.aId.dob) {
      var dob = moment(patients.aId.dob, 'DD-MM-YYYY');
      var age = moment().diff(dob, 'years');
      pdf.text(120, 70, `Patient Age: ${age}`);
    }
    pdf.text(120, 80, `Patient Address: ${patients.aId.address}`);
    pdf.text(120, 90, `Patient Pincode: ${patients.pincode}`);
    pdf.setFontSize(30);
    pdf.text(20, 120, "Comments");
    pdf.setFontSize(15);
    let y = 130; // starting y position for comments
    patientComments.forEach(comment => {
      pdf.text(20, y, `Comment: ${comment.comments}`);
      y += 10; // increment y position for next comment
    });
    pdf.setFontSize(30);
    pdf.text(120, 120, "Nurse Details");
    pdf.setFontSize(15);
    pdf.text(120, 130, `Nurse ID: ${patients.nurseId.id}`);
    pdf.text(120, 140, `Nurse Name: ${patients.nurseId.name}`);
    pdf.text(120, 150, `Nurse Mobile: ${patients.nurseId.pnumber}`);



    pdf.save(`patient-${patientId}.pdf`);

  }

  let doctorId = null;

  if (patients && patients.doctorId) {
    doctorId = patients.doctorId.doctorId;
  }



  // Render the patient details
  return (
    <div >
      <div><Link to={`/doctor/${doctorId}`}>
        <button>Back</button>
      </Link></div>
      <div className="back-button">
        <Link to="/Login">
          <button>Logout</button>
        </Link>
      </div>
      <h1 className='h1'>Patient Details</h1>
      {patients ? (
        <div class="main-container">

          <div className='patient-details-container'>
            <h5>Patient Condition</h5>
            <div className='patient-detail'>Blood Group: {patients.bloodgroup}</div>
            <div className='patient-detail'>Pulse Rate: {patients.pulse_rate}</div>
            <div className='patient-detail'>Oxygen Level: {patients.oxygenlevel}</div>
            <div className='patient-detail'>Temperature: {patients.temperature}</div>
            <div className='patient-detail'>Disease: {patients.disease}</div>
            <div className='patient-detail'>Status: {patients.status ? 'Complete' : 'Incomplete'}</div>
          </div>
          {patients.aId ? (
            <div className='aadhar-details-container'>
              <h4>Patient Personal Details</h4>
              <div className='aadhar-detail'>Patient ID: {patients.id}</div>
              <div className='aadhar-detail'>Patient Aadhar Number: {patients.aId.aadharNo}</div>
              <div className='aadhar-detail'>Patient Name: {patients.aId.name}</div>
              <div className='aadhar-detail'>Patient Phone Number: {patients.aId.phoneno}</div>
              <div className='aadhar-detail'>Patient Age: {age}</div>
              <div className='aadhar-detail'>Patient Address: {patients.aId.address}</div>
              <div className='aadhar-detail'>Pincode: {patients.pincode}</div>
            </div>
          ) : (
            <div>Aadhar Information Not Available</div>
          )}
          <div className='patient-comments-container' >
            {patientComments.length > 0 &&
              <div className='patient-comments-container h3'>
                <h3 >Comments</h3>
                <ul className='patient-comments-container ul'>
                  {patientComments.map((comment, index) => (
                    <li className='patient-comments-container li' key={index}>{comment.comments}</li>
                  ))}
                </ul>
              </div>
            }
          </div>
          {isTreatmentComplete ?
            <div className={`complete ${isTreatmentComplete ? 'center bold' : ''}`}>Treatment Completed</div>


            : (
              <div>
                <button onClick={() => handleTreatmentComplete()}>Complete Treatment</button>
                {!isCommentAdded ? (
                  <button id="add-comment-button" onClick={handleOpenComment}>Add Comment</button>
                ) : (
                  <div>
                    <textarea id="comment-box" value={comments} onChange={e => setComment(e.target.value)}></textarea>
                    <button id="save-button" onClick={handleSaveComment}>Save Comment</button>
                  </div>
                )}</div>)}
          <div><button id='downloadpdf' onClick={handleDownloadPdf}>Download PDF</button></div>
        </div>
      ) : (
        <div>Loading...</div>
      )}
    </div>

  );
}

export default PatientDetails;
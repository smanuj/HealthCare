import React, { useState } from 'react';
import './PatientForm.css';
import axios from 'axios';
import { Alert, Form } from "react-bootstrap";


class PatientForm extends React.Component{ 
    // const [patient, setPatient] = useState('');
    // const [aId, setAadharNumber] = useState('');
    // const [bg, setBloodGroup] = useState('');
    // const [pr, setPulseRate] = useState('');
    // const [oxy, setOxygenLevel] = useState('');
    // const [temp, setBodyTemperature] = useState('');
    // const [disease, setDisease] = useState('');
    // const [pincode, setPincode] = useState('');

    //     aId: '',
    //     bg: '',
    //     pr: '',
    //     oxy:'',
    //     temp:'',
    //     disease:'',
    //     pincode:''
    // });


    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={
          
        };
    }


    initiaLSTATE={
        aId:"",
        bg:"",
        pr:"",
        oxy:"",
        temp:"",
        disease:"",
        pincode:"",
        

    };

    handleChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
          
          
        });
      };

    handleSubmit = (event) => {
      
        // const patientData = { aId, bg, pr, oxy, temp, disease, pincode };
        // axios.post('http://localhost:8009/api/patients/create', patientData)
        // .then(response => console.log(response))
        // .catch(error => console.log(error));
        alert(this.state.aId)
   
        const patient ={
            aId:{

                "aadharNo": this.state.aId

            },
            bloodgroup:this.state.bloodgroup,
            pulse_rate: this.state.pulse_rate,
            oxygenlevel:this.state.oxygenlevel,
            temperature:this.state.temperature,
            disease:this.state.disease,
            pincode:this.state.pincode
        }

        axios.post('http://localhost:8009/api/patients/create',patient).then(Response => alert(Response.data))
    }


     
    render(){
    return (
        <div className="app">
        <Form className="patient-form" onSubmit={this.handleSubmit}>
            <h2>Patient Registration</h2>

            <label>
                Aadhar number:
                <input type="number" placeholder="Enter the Aadhar number" name="aId" value={this.state.aId} onChange={this.handleChange} required />
            </label>
            {/* <label>
                Blood Group:
                <input type="text" name="bloodgroup" value={this.state.bloodgroup} onChange={this.handleChange} required />
            </label> */}
            <label>
                Pulse Rate:
            <input type="text" placeholder="Enter the pulse rate" name="pulse_rate" value={this.state.pulse_rate}  pattern="([1-9]|[1-9][0-9]|1[0-9]{2}|200)" onChange={this.handleChange} required />
            </label>
            <label>
                Oxygen Level:
                <input type="text" placeholder="Enter the oxygen level" name="oxygenlevel" value={this.state.oxygenlevel} pattern="(5[0-9]|[6-9][0-9]|100)" onChange={this.handleChange} required />
            </label>
            <label>
                Body Temperature:
                <input type="text" placeholder="Enter in fahrenheit" name="temperature" value={this.state.temperature} pattern="(7[5-9]|[89][0-9]|10[0-9]|11[0-5])" onChange={this.handleChange} required />
            </label>
          
            <label>
                Blood Group:
                <select name="bloodgroup" value={this.state.bloodgroup} onChange={this.handleChange} required>
                    <option value="" disabled selected>Select Blood Group</option>
                    <option value="A+">A+</option>
                    <option value="A-">A-</option>
                    <option value="B+">B+</option>
                    <option value="B-">B-</option>
                    <option value="AB+">AB+</option>
                    <option value="AB-">AB-</option>
                    <option value="O+">O+</option>
                    <option value="O-">O-</option>
                </select>
            </label>
            <label>
                Disease:
                <select name="disease" value={this.state.disease} onChange={this.handleChange} required>
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
                <input type="text" placeholder="Enter the pincode" name="pincode" value={this.state.pincode} onChange={this.handleChange} required />
            </label>

            <button type="submit">Register</button>

        </Form>
        </div>
    );
    }
    
}

export default PatientForm;

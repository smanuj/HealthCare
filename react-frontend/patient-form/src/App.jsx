import { useState } from "react";
import "./App.css"
import FormInput from "./components/FormInputs";

const App = () => {
    const [values, setValues] = useState({
        aadhar:"",
        bloodg:"",
        pulser:"",
        oxy:"",
        temp:"",
        disease:"",
        pincode:""    
    });

    const input = [
        {
            id:1,
            name:"aadhar",
            type:"text",
            placeholder:"Aadhar number",
            errorMessage:"Invalid Aadhar number",
            label:"Aadhar",
            required:true
        },
        {
            id:2,
            name:"bloodg",
            type:"text",
            placeholder:"Blood Group",
            errorMessage:"Please Select a Blood group",
            label:"Blood Group",
            required:true
        },
        {
            id:3,
            name:"pulser",
            type:"text",
            placeholder:"Pulse rate",
            errorMessage:"Enter Pulse Rate correctly",
            label:"Pulse",
            required:true
        },
        {
            id:4,
            name:"oxy",
            type:"text",
            placeholder:"Oxygen level",
            errorMessage:"Enter Correct O2 readings",
            label:"Oxygen",
            required:true
        },
        {
            id:5,
            name:"temp",
            type:"text",
            placeholder:"Body Temperature",
            errorMessage:"Enter correct body temperature",
            label:"Temperature",
            required:true
        },
        {
            id:6,
            name:"disease",
            type:"text",
            placeholder:"Disease/Medical Condition",
            errorMessage:"...",
            label:"Disease"
        },
        {
            id:7,
            name:"pincode",
            type:"text",
            placeholder:"Pickup Pincode",
            errorMessage:"Invalid Pincode",
            label:"Pincode",
            required:true
        }
    ];

    const handleSubmit = (e)=>{
        e.preventDefault();
    };

    const onChange = (e) => {
        setValues({...values, [e.target.name]: e.target.value});
    };

    console.log(values);

    return (
    <div className="app">
        <form onSubmit={handleSubmit}>
            <h1>Upload Patient Details</h1>
            {input.map((input) => (
                <FormInput key={input.id} 
                {...input} 
                value={values[input.name]} 
                onChange={onChange}
                />
            ))}
            <button>Submit</button>
        </form>
    </div>
    );
};

export default App;
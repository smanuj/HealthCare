import "./listofpatient.css"



export default function PatientDetails() {
    return (
      <div className="LPdetails">
        <table class="table table-striped table-hover">

    <thead>
      <tr>
        <th scope="col">Health details</th>
      </tr>
    </thead>

    <tbody>
    <tr>
        <td>Name:Ramesh</td>
      </tr>


      <tr>
        <td>Age:25</td>
      </tr>

      <tr>  
        <td>Bloodgroup:A+ve</td>
      </tr>
     
      <tr>
        <td>PhoneNo:8965321546</td>
      </tr>

      <tr>  
        <td>Disease:Maleria</td>
      </tr>
     
    </tbody>
  </table>
      </div>
    )
  }
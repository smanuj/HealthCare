import "./patientDiv.css"

export default function PatientDiv() {
  return (
    <div className="patient">
      <table class="table table-striped table-hover">
  <thead>
    <tr>
   
      <th scope="col">Division</th>
      <th scope="col">Patients Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      
      <td>Cardiology</td>
    
      <td>4</td>
    </tr>
    <tr>
      
      <td>Dermatology</td>
    
      <td>3</td>
    </tr>
    <tr>
      
      <td>Gynaecology</td>
    
      <td>3</td>
    </tr>
    <tr>
      
      <td>Neurology</td>
    
      <td>3</td>
    </tr>
    <tr>
      
      <td>Oncology</td>
    
      <td>2</td>
    </tr>
    <tr>
      
      <td>Orthopaedics</td>
    
      <td>3</td>
    </tr>
    <tr>
      
      <td>Surgery</td>
     
      <td>4</td>
    </tr>
   
  </tbody>
</table>
    </div>
  )
}

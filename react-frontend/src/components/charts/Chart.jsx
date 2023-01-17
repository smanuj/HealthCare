import "./chart.css"
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

export default function Chart() {

    const data = [
        {
          name: 'Cardiology',
          uv: 4,
         
        },
        {
          name: 'Dermatology',
          uv: 3,
        
        },
        {
          name: 'Gynaecology',
          uv: 2,
          
        },
        {
          name: 'Neurology',
          uv: 5,
        
        },
        {
          name: 'Oncology',
          uv: 7,
          
        },
        {
          name: 'Orthopaedics',
          uv: 8,
          
        },
        {
          name: 'Surgery',
          uv: 3,
          
        },
      ];



  return (
    <div className="chart">
      
        <h3 className="chartTitle">Doctor Specialization</h3>

        <ResponsiveContainer width="100%" height="100%">
        <BarChart
          width={500}
          height={300}
          data={data}
          margin={{
            top: 5,
            right: 30,
            left: 20,
            bottom: 5,
          }}
        >
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="name" />
          <YAxis />
          <Tooltip />
          <Legend />
          <Bar dataKey="fields" fill="#8884d8" />
          <Bar dataKey="uv" fill="#3cc5c9" />
        </BarChart>

        </ResponsiveContainer>
      
    </div>
  )
}

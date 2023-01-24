package com.doctor.service.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.service.entity.Comments;
import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.NurseDetails;
import com.doctor.service.entity.PatientDetails;
import com.doctor.service.service.CommentsService;
import com.doctor.service.service.DoctorDetailsService;
import com.doctor.service.service.NurseDetailsService;
import com.doctor.service.service.PatientDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
	
	@Autowired
	private DoctorDetailsService doctorDetailsService;
	
	@Autowired
	private PatientDetailsService patientDetailsService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private NurseDetailsService nurseDetailsService;
	
	@PostMapping("/api/savecomments")
	public Comments saveComments(@RequestBody Comments comments){
		 return commentsService.createComment(comments);
	}
	
	@GetMapping("/api/comments/{id}")
	public Comments getComments(@PathVariable ("id") int id) {
		return commentsService.getCommentsById(id);
	}
	
	@GetMapping("api/patientslist/{id}")
	public List<PatientDetails> getPatientList(@PathVariable ("id") DoctorDetails doctorId){
		return patientDetailsService.getAllPatientsByDoctorId(doctorId);
	}
	
	@GetMapping("api/patientdetails/{id}")
	public PatientDetails getPatientList(@PathVariable ("id") int id){
		return patientDetailsService.getPatientDetailsById(id);
	}
	
	@GetMapping("api/doctor/{id}")
	public DoctorDetails getdoctor(@PathVariable ("id") int id){
		return doctorDetailsService.getDoctorsById(id);
	}
	
	@GetMapping("api/specializeddoctor/{specialization}")
	public List<DoctorDetails> getdoctor(@PathVariable ("specialization") String specialization){
		return doctorDetailsService.getAllDoctorsBySpecialization(specialization);
	}
	
	@GetMapping("api/nurse/{id}")
	public NurseDetails getnurse(@PathVariable ("id") int id){
		return nurseDetailsService.getNurseById(id);
	}
	
	@GetMapping("/download-pdf/{id}")
    public void downloadPDF(HttpServletResponse response,@PathVariable ("id") int id) throws IOException,DocumentException {
        // Create a new PDF document
    	PatientDetails patients = patientDetailsService.getPatientDetailsById(id);
    	ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(patients);
		String newLine=json.replace(',','\n');
		String s=newLine.replaceAll("[{}]", " "); 
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();

        // Write the JSON data to the PDF
        document.add(new Paragraph(s));

        // Close the document
        document.close();

        // Set the content type and attachment header.
        response.addHeader("Content-Disposition", "attachment; filename=my_pdf.pdf");
        response.setContentType("application/pdf");

        // Write the PDF to the response.
        response.getOutputStream().write(baos.toByteArray());
    }
	
	
	
}

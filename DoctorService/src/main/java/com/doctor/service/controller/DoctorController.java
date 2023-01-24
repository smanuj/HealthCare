package com.doctor.service.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> downloadErrorData(@PathVariable ("id") int id) throws Exception {
		PatientDetails employees = patientDetailsService.getPatientDetailsById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(employees);
		byte[] isr = json.getBytes();
		String fileName = "employees.pdf";
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentLength(isr.length);
		respHeaders.setContentType(new MediaType("text", "json"));
		respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		return new ResponseEntity<byte[]>(isr, respHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/download-patient-details-json/{id}")
	public ResponseEntity<Resource> downloadPatientDetailsJSON(@PathVariable ("id") int id) throws IOException {
		PatientDetails patients = patientDetailsService.getPatientDetailsById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(patients);
		byte[] data = json.getBytes();
		File file = new File("patient_details.json");
		FileUtils.writeByteArrayToFile(file, data);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=patient_details.json");
		return ResponseEntity.ok()
				.headers(headers)
				.contentLength(data.length)
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(resource);
	}
	
	@GetMapping("/downloaddetails/{id}")
	public ResponseEntity<PDDocument> download(@PathVariable ("id") int id) throws Exception {
		PatientDetails employees = patientDetailsService.getPatientDetailsById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(employees);
		
		String[] strings = json.split(System.lineSeparator());

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(25, 725);
        for (String string : strings) {
            contentStream.showText(string);
            // add line manually
            contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();

        document.save("pdfBoxHelloWorld.pdf");
        document.close();
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(document);
		
	}
	
	
	
}

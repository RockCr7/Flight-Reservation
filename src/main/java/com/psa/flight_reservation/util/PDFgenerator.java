package com.psa.flight_reservation.util;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.psa.flight_reservation.entities.reservation;

@Component  //beans creation during runtime is managed by Spring IOC
public class PDFgenerator {
	
	public void generateItinerary(reservation res,String filePath) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(res));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private PdfPTable generateTable(reservation res){
		
		PdfPTable table=new PdfPTable(2);
		PdfPCell cell;
		
		cell=new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell=new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(res.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(res.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(res.getFlight().getFlightNumber());
		
		table.addCell("Operating Airlines");
		table.addCell(res.getFlight().getOperatingAirlines());
		
		table.addCell("Departure Date");
		table.addCell(res.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Departure Time");
		table.addCell(res.getFlight().getEstimatedDepartureTime().toString());
		
		cell=new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(res.getPsngr().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(res.getPsngr().getLastName());
		
		table.addCell("Middle Name");
		table.addCell(res.getPsngr().getMiddleName());
		
		table.addCell("Email");
		table.addCell(res.getPsngr().getEmail());
		
		table.addCell("Phone");
		table.addCell(res.getPsngr().getPhone());
		
		return table;
	}
                   
}

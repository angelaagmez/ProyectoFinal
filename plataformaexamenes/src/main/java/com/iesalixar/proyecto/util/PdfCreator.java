package com.iesalixar.proyecto.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.iesalixar.proyecto.model.Examen;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * The Class PdfCreator.
 */
@Component("examenes")
public class PdfCreator extends AbstractPdfView{
	

	/**
	 * Builds the pdf document.
	 *
	 * @param model the model
	 * @param document the document
	 * @param writer the writer
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		
		List<Examen> examenes = (List<Examen>) model.get("examenes");
		
		document.setPageSize(PageSize.A4);
		document.open();
		
		Image imagen = Image.getInstance("/home/angela/Documents/workspace-spring-tool-suite-4-4.13.1.RELEASE/plataformaexamenes/src/main/resources/static/img/logo&slogan.png");
		imagen.setAlignment(Element.ALIGN_LEFT);
		imagen.scalePercent(30);
		imagen.setSpacingAfter(10);
		
		document.add(imagen);
		

		
		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		Font fuenteT = FontFactory.getFont("montserrat",16,Color.WHITE);
		
		celda = new PdfPCell(new Phrase("EXAMEN",fuenteT));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(237,128,116));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(25);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaCabeceras = new PdfPTable(5);
//		tablaCabeceras.setWidths(new float[] {0.8f,2f,2f,2.2f,2f});
		PdfPCell celda1 = null;
		
		celda1 = new PdfPCell(new Phrase("ID",FontFactory.getFont("montserrar",12,Color.black)));
		celda1.setBackgroundColor(Color.LIGHT_GRAY);
		celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda1.setVerticalAlignment(Element.ALIGN_CENTER);
		celda1.setPadding(10);
		tablaCabeceras.addCell(celda1);
		
		celda1 = new PdfPCell(new Phrase("Numero de preguntas",FontFactory.getFont("montserrar",12,Color.black)));
		celda1.setBackgroundColor(Color.LIGHT_GRAY);
		celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda1.setVerticalAlignment(Element.ALIGN_CENTER);
		celda1.setPadding(10);
		tablaCabeceras.addCell(celda1);
		
		celda1 = new PdfPCell(new Phrase("Fecha creacion",FontFactory.getFont("montserrar",12,Color.black)));
		celda1.setBackgroundColor(Color.LIGHT_GRAY);
		celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda1.setVerticalAlignment(Element.ALIGN_CENTER);
		celda1.setPadding(10);
		tablaCabeceras.addCell(celda1);
		
		celda1 = new PdfPCell(new Phrase("Asignatura",FontFactory.getFont("montserrar",12,Color.black)));
		celda1.setBackgroundColor(Color.LIGHT_GRAY);
		celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda1.setVerticalAlignment(Element.ALIGN_CENTER);
		celda1.setPadding(10);
		tablaCabeceras.addCell(celda1);
		
		celda1 = new PdfPCell(new Phrase("Profesor",FontFactory.getFont("montserrar",12,Color.black)));
		celda1.setBackgroundColor(Color.LIGHT_GRAY);
		celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda1.setVerticalAlignment(Element.ALIGN_CENTER);
		celda1.setPadding(10);
		tablaCabeceras.addCell(celda1);
		
		PdfPTable tablaExamenes = new PdfPTable(5);
		
		examenes.forEach(examen ->{
			tablaExamenes.addCell(examen.getId().toString());
			tablaExamenes.addCell(Integer.toString(examen.getNum_preguntas()));
			tablaExamenes.addCell(examen.getFecha_creacion().toString());
			tablaExamenes.addCell(examen.getAsignatura().getNombre());
			tablaExamenes.addCell(examen.getUsuario().getNombre()+" "+examen.getUsuario().getApellidos());
		});
		
		document.add(tablaTitulo);
		document.add(tablaCabeceras);
		document.add(tablaExamenes);
		
		PdfPTable tablaPreguntas = new PdfPTable(1);
		tablaPreguntas.setSpacingBefore(30);
		PdfPCell celda2 = null;
		
		celda2 = new PdfPCell(new Phrase("Preguntas",fuenteT));
		celda2.setBorder(0);
		celda2.setBackgroundColor(new Color(237,128,116));
		celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda2.setVerticalAlignment(Element.ALIGN_CENTER);
		celda2.setPadding(10);
		
		tablaPreguntas.addCell(celda2);
		
		examenes.forEach(examen ->{
			tablaPreguntas.addCell("Examen "+examen.getId().toString()+": "+examen.getPreguntas().toString());
		});
		
		document.add(tablaPreguntas);
		
		imagen.setAlignment(Element.ALIGN_BOTTOM);
		document.add(imagen);
	}

}

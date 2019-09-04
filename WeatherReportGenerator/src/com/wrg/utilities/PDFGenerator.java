package com.wrg.utilities;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;;

public class PDFGenerator {

	private static String FILE = "/Users/madbabu/Documents/Eclipse_Workspaces/Workspace_Apr19/FirstPdf.pdf";
	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

	public static void main(String[] args) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			// addMetaData(document);
			// addTitlePage(document);
			addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document) {
		document.addTitle("Weather Report");
		document.addSubject("Generated");
	}

	private static void addTitlePage(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Indian - Pollution Report - City-wise", catFont));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Generated on : " + new Date(), smallBold));

		document.add(preface);
		// Start a new page
		// document.newPage();
	}

	private static void addContent(Document document) throws DocumentException {

		// Second parameter is the number of the chapter
		Chapter catPart = new Chapter(new Paragraph(), 1);
		


		// add a list
		Paragraph paragraph = new Paragraph();
		paragraph.add(new Paragraph("Indian - Pollution Report - City-wise", catFont));
		addEmptyLine(paragraph, 1);
		paragraph.add(new Paragraph("Generated on : " + new Date(), smallBold));

		Section subCatPart = catPart.addSection(paragraph);
		addEmptyLine(paragraph, 5);

		// add a table
		createTable(subCatPart);



		// now add all this to the document
		document.add(catPart);

	}

	private static void createTable(Section subCatPart) throws BadElementException {
		PdfPTable table = new PdfPTable(3);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);

		PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 2"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 3"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		table.addCell("1.0");
		table.addCell("1.1");
		table.addCell("1.2");
		table.addCell("2.1");
		table.addCell("2.2");
		table.addCell("2.3");

		subCatPart.add(table);

	}


	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
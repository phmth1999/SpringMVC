package com.springmvc.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.springmvc.Dto.BillDto;
import com.springmvc.Dto.CartDto;

public class GenerateBill {
	public static void generate(BillDto bill, String hoadon, HashMap<Integer, CartDto> cart, double total) {
		Locale lc = new Locale("vi", "VN");
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
		// tao file pdf hoa don
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(hoadon)));
			// open
			document.open();

			Paragraph p = new Paragraph();
			p.add("BILLS");
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);

			document.add(new Paragraph("FullName: " + bill.getFullname()));
			document.add(new Paragraph("Address: " + bill.getAddress()));
			document.add(new Paragraph("Phone: " + bill.getPhone()));
			document.add(new Paragraph("Date: " + java.time.LocalDate.now()));

			PdfPTable t = new PdfPTable(3);
			t.setSpacingBefore(25);
			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Quantity"));
			t.addCell(c1);
			PdfPCell c2 = new PdfPCell(new Phrase("Name"));
			t.addCell(c2);
			PdfPCell c3 = new PdfPCell(new Phrase("Price"));
			t.addCell(c3);

			for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
				t.addCell("" + itemCart.getValue().getQuanty());
				t.addCell("" + itemCart.getValue().getProduct().getName());
				t.addCell("" + numf.format(itemCart.getValue().getTotalPrice()));
			}
			document.add(t);

			Paragraph tong = new Paragraph();
			tong.add("Toatal: " + numf.format(total));
			tong.setAlignment(Element.ALIGN_RIGHT);
			document.add(tong);

			document.add(new Paragraph(" "));

			Paragraph n = new Paragraph();
			n.add("Day...Month...Year");
			n.add("                                                                                                ");
			n.add("Day...Month...Year");
			document.add(n);

			Paragraph m = new Paragraph();
			m.add("          Buyer");
			m.add("                                                                                                ");
			m.add("                     Seller");
			document.add(m);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

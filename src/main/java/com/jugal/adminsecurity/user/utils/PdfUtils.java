package com.jugal.adminsecurity.user.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.jugal.adminsecurity.user.model.Student;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//http://zetcode.com/articles/springbootpdfreport/
public class PdfUtils {
    public static String check(float x){
        String gp;
        if(x>=90){
            gp= "A+";
        }else if (x>=80){ gp= "A";
        }else if(x>=70){ gp= "B+";
        }else if(x>=60){ gp= "B";
        }else if(x>=50){ gp= "C+";
        }else if(x>=40){ gp= "C";}else if(x>=30){gp= "D+";}
        else if(x>=20){gp= "D";}else{gp= "E";}

        return gp;

    }
    public static String gpa(Double x){
        String gp;
        if(x>3.6){
            gp= "A+";
        }else if (x>3.2){ gp= "A";
        }else if(x>2.8){ gp= "B+";
        }else if(x>2.4){ gp= "B";
        }else if(x>2.0){ gp= "C+";
        }else if(x>1.6){ gp= "C";}else if(x>1.2){gp= "D+";}
        else if(x>=0.8){gp= "D";}else{gp= "E";}

        return gp;

    }
    public static String totgp(float x){
        String tp = null;

        if(x>=90){
            tp= "4";
        }else if (x>=80){ tp="3.6";
        }else if(x>=70){  tp="3.2";
        }else if(x>=60){ tp="2.8";
        }else if(x>=50){ tp="2.4";
        }else if(x>=40){tp="2.0"; }else if(x>=30){ tp="1.6";}
        else if(x>=20){tp="1.2";}else{ tp="0.8";}

        return tp;

    }
    public static float thcal(float y){
        float x;
        x=y*100/75;
        return x;
    }
    public static float prcal(float y){
        float x;
        x=y*100/25;
        return x;
    }
    public static float oh(float y){
        float x;
        x=y*100/50;
        return x;
    }
    public static float moral(float y){
        float x;
        x=y*100/25;
        return x;
    }
    public static float helth(float y){
        float x;
        x=y*100/30;
        return x;
    }
    public static float helpr(float y){
        float x;
        x=y*100/20;
        return x;
    }

    public static ByteArrayInputStream citiesReport(List<Student> student) {
        DateFormat dateFormat=new SimpleDateFormat("EEE, d MMM yyyy");
        Date date=new Date();
        Rectangle layout = new Rectangle(PageSize.A4);

        //layout.setBackgroundColor(new BaseColor(100, 200, 180)); //Background color
        layout.setBorderColor(BaseColor.DARK_GRAY);  //Border color
        layout.setBorderWidth(6);      //Border width
        layout.setBorder(Rectangle.BOX);
        Document document = new Document(layout);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {


            // Document document = new Docu
            //PdfWriter.getInstance(document, new FileOutputStream("e:/pp.pdf"));
            PdfWriter pdfWriter=PdfWriter.getInstance(document, out);
            document.open();
            for(Student prt : student) {
                //URL imageUrl = getClass().getResource("/resources/assets/images/logo.png");
                Image img1 = Image.getInstance("D:/r.png");
                pdfWriter.getDirectContentUnder().addImage(img1, 78, 0, 0, 70, 35, 750);
                Image img2 = Image.getInstance("D:/n.png");
                pdfWriter.getDirectContentUnder().addImage(img2, 78, 0, 0, 70, 35, 72);
                Font font = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.BLACK);
                //document.add(new Phrase("Hi People!! This is an exaple to demostrate Watermark in using Itext",font));
                PdfContentByte canvas = pdfWriter.getDirectContentUnder();
                Phrase watermark = new Phrase("RURAL MUNICIPALITY LEVEL EXAMINATION BOARD", new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.LIGHT_GRAY));
                ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 337, 500, 45);

                Font black = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);

                Chunk blackText = new Chunk("RURAL MUNICIPALITY LEVEL EXAMINATION BOARD"
                        + "\n BASIC LEVEL EXAMINATION, 2074", black);
                Paragraph ppp = new Paragraph(blackText);

                ppp.setAlignment(Element.ALIGN_CENTER);
                document.add(ppp);

                Paragraph para = new Paragraph("Jugal Rural Municipality State 3, Nepal");

                para.setAlignment(Element.ALIGN_CENTER);

                document.add(para);
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                Font black1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDEFINED, BaseColor.BLACK);
                Chunk chunk1 = new Chunk("This is certify that Mr. | Miss.        " + prt.getName().toUpperCase() + "\nson|daughter of Mr.     "
                        + prt.getFatherName().toUpperCase() + "\nand Mrs.     " + prt.getMotherName().toUpperCase() + "\nthe student of  " + prt.getSchoolName().toUpperCase() +
                        "\nhas appeared in the Annual Examination of class Eight of sambat   " + prt.getRollNo()
                        + "    and Completed Basic Level. According to school register his/her date"
                        + " of Birth is       " + prt.getDoB() + " BS.", black1);
                Paragraph p22 = new Paragraph(chunk1);
                document.add(p22);
                document.add(new Paragraph("\n"));
                Paragraph pot = new Paragraph("Sym/Roll No.: " + prt.getSymbolNo() + ""
                        + "                                        MARK-SHEET");
                document.add(pot);
                //document.add(new Paragraph("This is certify that Mr. | Miss: " +d));

                /* document.add(new Paragraph("\n\n")); */
                PdfPTable table1 = new PdfPTable(7);
                table1.setWidthPercentage(100);
                table1.setSpacingBefore(7f);
                table1.setSpacingAfter(7f);
                float[] colwi = {1f, 3.5f, 1f, 1f, 1f, 1f, 1.5f};
                table1.setWidths(colwi);

                PdfPCell cell;
                cell = new PdfPCell(new Phrase("S/N"));
                cell.setRowspan(2);
                table1.addCell(cell);
                cell = new PdfPCell(new Phrase("SUBJECTS"));
                cell.setRowspan(2);
                table1.addCell(cell);
                cell = new PdfPCell(new Phrase("MARK OBTAINED"));
                cell.setColspan(2);
                table1.addCell(cell);
                cell = new PdfPCell(new Phrase("FINAL GRADE"));
                cell.setRowspan(2);
                table1.addCell(cell);
                cell = new PdfPCell(new Phrase("GRADE POINT"));
                cell.setRowspan(2);
                table1.addCell(cell);
                cell = new PdfPCell(new Phrase("REMARK"));
                cell.setRowspan(2);
                table1.addCell(cell);
                table1.addCell("TH.");
                table1.addCell("PR.");

                table1.addCell("1.");
                table1.addCell("English");
                table1.addCell(check(thcal(prt.getEnglishTh())));
                table1.addCell(check(prcal(prt.getEnglishPr())));
                table1.addCell(check(prt.getEnglishTh() + prt.getEnglishPr()));
                table1.addCell(totgp(prt.getEnglishTh() + prt.getEnglishPr()));
                table1.addCell("");
                table1.addCell("2.");
                table1.addCell("Nepali");
                table1.addCell(check(thcal(prt.getNepaliTh())));
                table1.addCell(check(thcal(prt.getNepaliPr())));
                table1.addCell(check(prt.getNepaliTh() + prt.getNepaliPr()));
                table1.addCell(totgp(prt.getNepaliTh() + prt.getNepaliPr()));
                table1.addCell("");
                table1.addCell("3.");
                table1.addCell("Mathematics");
                table1.addCell(check(prt.getMathTh()));
                table1.addCell("");
                table1.addCell(check(prt.getMathTh()));
                table1.addCell(totgp(prt.getMathTh()));
                table1.addCell("");
                table1.addCell("4.");
                table1.addCell("Science");
                table1.addCell(check(thcal(prt.getScienceTh())));
                table1.addCell(check(thcal(prt.getSciencePr())));
                table1.addCell(check(prt.getScienceTh() + prt.getSciencePr()));
                table1.addCell(totgp(prt.getScienceTh() + prt.getNepaliPr()));
                table1.addCell("");
                table1.addCell("5.");
                table1.addCell("Social Studies");
                table1.addCell(check(prt.getSocialTh()));
                table1.addCell(check(prt.getSocialPr()));
                table1.addCell(check(prt.getSocialTh() + prt.getSocialPr()));
                table1.addCell(totgp(prt.getSocialTh() + prt.getSocialPr()));
                table1.addCell("");
                table1.addCell("6.");
                table1.addCell("Occ., Buis. & Tec. Edu");
                table1.addCell(check(oh(prt.getObtTh())));
                table1.addCell(check(oh(prt.getObtPr())));
                table1.addCell(check(prt.getObtTh() + prt.getObtPr()));
                table1.addCell(totgp(prt.getObtTh() + prt.getObtPr()));
                table1.addCell("");
                table1.addCell("7.");
                table1.addCell("Health & Phy. Edu");
                table1.addCell(check(helth(prt.getHealthTh())));
                table1.addCell(check(helpr(prt.getHealthPr())));
                table1.addCell(check(oh(prt.getHealthTh() + prt.getHealthPr())));
                table1.addCell(totgp(oh(prt.getHealthTh()) + prt.getHealthPr()));
                table1.addCell("");
                table1.addCell("8.");
                table1.addCell("Moral Education.");
                table1.addCell(check(moral(prt.getMoralTh())));
                table1.addCell(check(moral(prt.getMoralPr())));
                table1.addCell(check(oh(prt.getMoralTh() + prt.getMoralPr())));
                table1.addCell(totgp(oh(prt.getMoralTh() + prt.getMoralPr())));
                table1.addCell("");
                table1.addCell("9.");
                table1.addCell("Computer/Sanskrit/Others");
                table1.addCell(check(oh(prt.getOptTh())));
                table1.addCell(check(oh(prt.getOptPr())));
                table1.addCell(check(oh(prt.getOptTh() + prt.getOptPr())));
                table1.addCell(totgp(prt.getOptTh() + prt.getOptPr()));
                table1.addCell("");
                document.add(table1);
                PdfPTable table2 = new PdfPTable(1);
                table2.setWidthPercentage(100);
                table2.setSpacingBefore(7f);
                table2.setSpacingAfter(7f);
                PdfPCell cell8 = new PdfPCell(new Paragraph(" \nGRADE POINT AVERAGE (GPA):  " + "gpa" + ""
                        + "\nAVERAGE GRADE:   " + "ag" + "\n"));
                // cell8.addElement(Integer.ALIGN_CENTER);
                table2.addCell(cell8);

                document.add(table2);
                document.add(new Paragraph("1. TH: Theory, PR: Practical"));
                document.add(new Paragraph("\n\n"));
                document.add(new Paragraph(dateFormat.format(date)));
                document.add(new Paragraph("......................                                      "
                        + "......................                                      ......................"
                        + "                                      "));
                document.add(new Paragraph("     Date                                           "
                        + "     Secretary                               Chief Administrative Officer     "
                        + "                                      "));

                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("                                                         "
                        + "                                                      ............................"
                        + "                                      "));
                document.add(new Paragraph("  School Stamp                      "
                        + "                                                               Head Teacher/Principal     "
                        + "                                      "));
                document.newPage();

            }
            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(PdfUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

/*

public static ByteArrayInputStream studentReport(Student prt) {
    DateFormat dateFormat=new SimpleDateFormat("EEE, d MMM yyyy");
    Date date=new Date();
    Rectangle layout = new Rectangle(PageSize.A4);

    //layout.setBackgroundColor(new BaseColor(100, 200, 180)); //Background color
    layout.setBorderColor(BaseColor.DARK_GRAY);  //Border color
    layout.setBorderWidth(6);      //Border width
    layout.setBorder(Rectangle.BOX);
    Document document = new Document(layout);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {


        // Document document = new Docu
        //PdfWriter.getInstance(document, new FileOutputStream("e:/pp.pdf"));
        PdfWriter pdfWriter=PdfWriter.getInstance(document, out);
        document.open();
            //URL imageUrl = getClass().getResource("/resources/assets/images/logo.png");
            Image img1 = Image.getInstance("D:/r.png");
            pdfWriter.getDirectContentUnder().addImage(img1, 78, 0, 0, 70, 35, 750);
            Image img2 = Image.getInstance("D:/n.png");
            pdfWriter.getDirectContentUnder().addImage(img2, 78, 0, 0, 70, 35, 72);
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.BLACK);
            //document.add(new Phrase("Hi People!! This is an exaple to demostrate Watermark in using Itext",font));
            PdfContentByte canvas = pdfWriter.getDirectContentUnder();
            Phrase watermark = new Phrase("RURAL MUNICIPALITY LEVEL EXAMINATION BOARD", new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.LIGHT_GRAY));
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 337, 500, 45);

            Font black = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);

            Chunk blackText = new Chunk("RURAL MUNICIPALITY LEVEL EXAMINATION BOARD"
                    + "\n BASIC LEVEL EXAMINATION, 2074", black);
            Paragraph ppp = new Paragraph(blackText);

            ppp.setAlignment(Element.ALIGN_CENTER);
            document.add(ppp);

            Paragraph para = new Paragraph("Jugal Rural Municipality State 3, Nepal");

            para.setAlignment(Element.ALIGN_CENTER);

            document.add(para);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            Font black1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDEFINED, BaseColor.BLACK);
            Chunk chunk1 = new Chunk("This is certify that Mr. | Miss.        " + prt.getName().toUpperCase() + "\nson|daughter of Mr.     "
                    + prt.getFatherName().toUpperCase() + "\nand Mrs.     " + prt.getMotherName().toUpperCase() + "\nthe student of  " + prt.getSchoolName().toUpperCase() +
                    "\nhas appeared in the Annual Examination of class Eight of sambat   " + prt.getRollNo()
                    + "    and Completed Basic Level. According to school register his/her date"
                    + " of Birth is       " + prt.getDoB() + " BS.", black1);
            Paragraph p22 = new Paragraph(chunk1);
            document.add(p22);
            document.add(new Paragraph("\n"));
            Paragraph pot = new Paragraph("Sym/Roll No.: " + prt.getSymbolNo() + ""
                    + "                                        MARK-SHEET");
            document.add(pot);
            //document.add(new Paragraph("This is certify that Mr. | Miss: " +d));

            // document.add(new Paragraph("\n\n"));
            PdfPTable table1 = new PdfPTable(7);
            table1.setWidthPercentage(100);
            table1.setSpacingBefore(7f);
            table1.setSpacingAfter(7f);
            float[] colwi = {1f, 3.5f, 1f, 1f, 1f, 1f, 1.5f};
            table1.setWidths(colwi);

            PdfPCell cell;
            cell = new PdfPCell(new Phrase("S/N"));
            cell.setRowspan(2);
            table1.addCell(cell);
            cell = new PdfPCell(new Phrase("SUBJECTS"));
            cell.setRowspan(2);
            table1.addCell(cell);
            cell = new PdfPCell(new Phrase("MARK OBTAINED"));
            cell.setColspan(2);
            table1.addCell(cell);
            cell = new PdfPCell(new Phrase("FINAL GRADE"));
            cell.setRowspan(2);
            table1.addCell(cell);
            cell = new PdfPCell(new Phrase("GRADE POINT"));
            cell.setRowspan(2);
            table1.addCell(cell);
            cell = new PdfPCell(new Phrase("REMARK"));
            cell.setRowspan(2);
            table1.addCell(cell);
            table1.addCell("TH.");
            table1.addCell("PR.");

            table1.addCell("1.");
            table1.addCell("English");
            table1.addCell(check(thcal(prt.getEnglishTh())));
            table1.addCell(check(prcal(prt.getEnglishPr())));
            table1.addCell(check(prt.getEnglishTh() + prt.getEnglishPr()));
            table1.addCell(totgp(prt.getEnglishTh() + prt.getEnglishPr()));
            table1.addCell("");
            table1.addCell("2.");
            table1.addCell("Nepali");
            table1.addCell(check(thcal(prt.getNepaliTh())));
            table1.addCell(check(thcal(prt.getNepaliPr())));
            table1.addCell(check(prt.getNepaliTh() + prt.getNepaliPr()));
            table1.addCell(totgp(prt.getNepaliTh() + prt.getNepaliPr()));
            table1.addCell("");
            table1.addCell("3.");
            table1.addCell("Mathematics");
            table1.addCell(check(prt.getMathTh()));
            table1.addCell("");
            table1.addCell(check(prt.getMathTh()));
            table1.addCell(totgp(prt.getMathTh()));
            table1.addCell("");
            table1.addCell("4.");
            table1.addCell("Science");
            table1.addCell(check(thcal(prt.getScienceTh())));
            table1.addCell(check(thcal(prt.getSciencePr())));
            table1.addCell(check(prt.getScienceTh() + prt.getSciencePr()));
            table1.addCell(totgp(prt.getScienceTh() + prt.getNepaliPr()));
            table1.addCell("");
            table1.addCell("5.");
            table1.addCell("Social Studies");
            table1.addCell(check(prt.getSocialTh()));
            table1.addCell(check(prt.getSocialPr()));
            table1.addCell(check(prt.getSocialTh() + prt.getSocialPr()));
            table1.addCell(totgp(prt.getSocialTh() + prt.getSocialPr()));
            table1.addCell("");
            table1.addCell("6.");
            table1.addCell("Occ., Buis. & Tec. Edu");
            table1.addCell(check(oh(prt.getObtTh())));
            table1.addCell(check(oh(prt.getObtPr())));
            table1.addCell(check(prt.getObtTh() + prt.getObtPr()));
            table1.addCell(totgp(prt.getObtTh() + prt.getObtPr()));
            table1.addCell("");
            table1.addCell("7.");
            table1.addCell("Health & Phy. Edu");
            table1.addCell(check(helth(prt.getHealthTh())));
            table1.addCell(check(helpr(prt.getHealthPr())));
            table1.addCell(check(oh(prt.getHealthTh() + prt.getHealthPr())));
            table1.addCell(totgp(oh(prt.getHealthTh()) + prt.getHealthPr()));
            table1.addCell("");
            table1.addCell("8.");
            table1.addCell("Moral Education.");
            table1.addCell(check(moral(prt.getMoralTh())));
            table1.addCell(check(moral(prt.getMoralPr())));
            table1.addCell(check(oh(prt.getMoralTh() + prt.getMoralPr())));
            table1.addCell(totgp(oh(prt.getMoralTh() + prt.getMoralPr())));
            table1.addCell("");
            table1.addCell("9.");
            table1.addCell("Computer/Sanskrit/Others");
            table1.addCell(check(oh(prt.getOptTh())));
            table1.addCell(check(oh(prt.getOptPr())));
            table1.addCell(check(oh(prt.getOptTh() + prt.getOptPr())));
            table1.addCell(totgp(prt.getOptTh() + prt.getOptPr()));
            table1.addCell("");
            document.add(table1);
            PdfPTable table2 = new PdfPTable(1);
            table2.setWidthPercentage(100);
            table2.setSpacingBefore(7f);
            table2.setSpacingAfter(7f);
            PdfPCell cell8 = new PdfPCell(new Paragraph(" \nGRADE POINT AVERAGE (GPA):  " + "gpa" + ""
                    + "\nAVERAGE GRADE:   " + "ag" + "\n"));
            // cell8.addElement(Integer.ALIGN_CENTER);
            table2.addCell(cell8);

            document.add(table2);
            document.add(new Paragraph("1. TH: Theory, PR: Practical"));
            document.add(new Paragraph("\n\n"));
            document.add(new Paragraph(dateFormat.format(date)));
            document.add(new Paragraph("......................                                      "
                    + "......................                                      ......................"
                    + "                                      "));
            document.add(new Paragraph("     Date                                           "
                    + "     Secretary                               Chief Administrative Officer     "
                    + "                                      "));

            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("                                                         "
                    + "                                                      ............................"
                    + "                                      "));
            document.add(new Paragraph("  School Stamp                      "
                    + "                                                               Head Teacher/Principal     "
                    + "                                      "));
            document.newPage();

        document.close();

    } catch (DocumentException ex) {

        Logger.getLogger(PdfUtils.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return new ByteArrayInputStream(out.toByteArray());
}
 */

}

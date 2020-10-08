package servlets;

import java.io.*;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;

public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        //to read files
        BufferedReader br = new BufferedReader (new FileReader(new File(path)));    
  
        String titleFile = br.readLine();
        String contentFile = br.readLine();
        
        request.setAttribute("title", titleFile);
        request.setAttribute("content", contentFile);
        
//        Note note = new Note(titleFile, contentFile);
//        request.setAttribute("note", note);
//        Note note = new Note();
//        note.setTitle(titleFile);
//        note.setContents(contentFile);
//        request.setAttribute("note", note);
        
        br.close();
        
        String editParam = request.getParameter("edit");
        
        if (editParam == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);   
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // to write to a file
        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter(path, false)));
        
        String newTitle = request.getParameter("title_field");
        String newContent = request.getParameter("content_field");
        
        pw.println(newTitle);
        pw.println(newContent);
        pw.close();
          
//        Note note = new Note();
//        note.setTitle(newTitle);
//        note.setContents(newContent);
//        request.setAttribute("note", note);

        request.setAttribute("title", newTitle);
        request.setAttribute("content", newContent);
     
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);   
    }
}

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
        
//        // to write to a file
//        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter(path, false)));
//        
  
        String titleFile = br.readLine();
        String contentFile = br.readLine();
        
        request.setAttribute("title", titleFile);
        request.setAttribute("content", contentFile);
                
//        Note note = new Note(titleFile, contentFile);
//        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("firstname");
        String content = request.getParameter("lastname");
        
//        if (firstname == null || firstname.equals("") ||
//                lastname == null || lastname.equals("")) {
//            request.setAttribute("fname", firstname);
//            request.setAttribute("lname", lastname);
//            request.setAttribute("invalid", true);
//            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldJSP.jsp").forward(request, response);
//            return;
//        }
        
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp").forward(request, response);   
    }
}

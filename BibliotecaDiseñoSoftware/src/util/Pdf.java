/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Controlador.ControladorGenero;
import Controlador.ControladorLibro;
import Controlador.ControladorPrestamoDevolucion;
import Controlador.ControladorUsuario;
import Modelo.Genero;
import Modelo.Historiales;
import Modelo.Libro;
import Modelo.PrestamoDevolucion;
import Modelo.Usuario;
import Vista.Historial;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author val
 */
public class Pdf {

    ControladorUsuario controladorUsuario;
    ControladorLibro controladorLibro;
    ControladorPrestamoDevolucion controladorPrestamoDevolucion;
    ControladorGenero controladorGenero;

    public Pdf() {
        controladorUsuario = new ControladorUsuario();
        controladorLibro = new ControladorLibro();
        controladorPrestamoDevolucion = new ControladorPrestamoDevolucion();
        controladorGenero = new ControladorGenero();
    }

    //pdfs de prestamos generales
    public void pdfPrestamoDevolucionGeneral(ArrayList<PrestamoDevolucion> lista, String tipo) {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdf" + tipo + "General.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre Usuario");
            tabla.addCell("Cedula Usuario");
            tabla.addCell("Nombre libro");
            //cambia de columna en caso de que sea un prestamo o una devolución
            if (tipo.equals("Prestamo")) {
                tabla.addCell("Fecha Prestamo");
            } else {
                tabla.addCell("Fecha Devuelto");
            }
            tabla.addCell("Categoria");

            for (int i = 0; i < lista.size(); i++) {
                //id para buscar
                int cedulaUsuario = lista.get(i).getCedulaUsuario();
                int idLibro = lista.get(i).getDetallesLibro();
                int idPrestamoDevolucion = lista.get(i).getId();

                Usuario usuario = controladorUsuario.buscarUsuarioCedula(cedulaUsuario);
                Libro libro = controladorLibro.buscarLibro(idLibro);
                Genero genero = controladorGenero.buscarGenero(libro.getIdGenero());

                //variables necesarias para el registro
                String nombreUsuario = usuario.getNombre();
                String nombreLibro = libro.getNombre();
                String nombreGenero = genero.getNombre();

                tabla.addCell(nombreUsuario);
                tabla.addCell(String.valueOf(cedulaUsuario));
                tabla.addCell(nombreLibro);
                //en el caso de que sea un prestamo, muestra la fecha en que se prestó y en el caso de que sea una devolución, muestra la fecha en que se devolvió
                if (tipo.equals("Prestamo")) {
                    tabla.addCell(String.valueOf(lista.get(i).getFechaPrestamoActual()));
                } else {
                    tabla.addCell(controladorPrestamoDevolucion.buscarFechaDevuelto(idPrestamoDevolucion));
                }
                tabla.addCell(nombreGenero);
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdf" + tipo + "General.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pdfPrestamoDevolucionIndividual(ArrayList<PrestamoDevolucion> lista, String tipo, int cedula) {

        boolean tienePrestamo = false;

        for (PrestamoDevolucion pd : lista) {
            if (tipo.equals("Prestamo") && pd.getEstado().equals(PrestamoDevolucion.PRESTADO)) {
                tienePrestamo = true;
                break;
            } else if (tipo.equals("Devolucion") && pd.getEstado().equals(PrestamoDevolucion.DEVUELTO)) {
                tienePrestamo = true;
                break;
            }
        }

        if (!tienePrestamo) {
            JOptionPane.showMessageDialog(null, "No se puede generar PDF ya que el usuario no cuenta con préstamo o devolución.");
            return; // Salir de la función si no hay préstamo
        } 
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdf" + tipo + "Individual" + cedula + ".pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre Usuario");
            tabla.addCell("Cedula Usuario");
            tabla.addCell("Nombre libro");
            if (tipo.equals("Prestamo")) {
                tabla.addCell("Fecha Prestamo");
            } else {
                tabla.addCell("Fecha Devuelto");
            }
            tabla.addCell("Categoria");

            for (int i = 0; i < lista.size(); i++) {
                //id para buscar
                int cedulaUsuario = lista.get(i).getCedulaUsuario();
                int idLibro = lista.get(i).getDetallesLibro();
                int idPrestamoDevolucion = lista.get(i).getId();

                Usuario usuario = controladorUsuario.buscarUsuarioCedula(cedulaUsuario);
                Libro libro = controladorLibro.buscarLibro(idLibro);
                Genero genero = controladorGenero.buscarGenero(libro.getIdGenero());

                //variables necesarias para el registro
                String nombreUsuario = usuario.getNombre();
                String nombreLibro = libro.getNombre();
                String nombreGenero = genero.getNombre();

                tabla.addCell(nombreUsuario);
                tabla.addCell(String.valueOf(cedulaUsuario));
                tabla.addCell(nombreLibro);
                //en el caso de que sea un prestamo, muestra la fecha en que se prestó y en el caso de que sea una devolución, muestra la fecha en que se devolvió
                if (tipo.equals("Prestamo")) {
                    tabla.addCell(String.valueOf(lista.get(i).getFechaPrestamoActual()));
                } else {
                    tabla.addCell(controladorPrestamoDevolucion.buscarFechaDevuelto(idPrestamoDevolucion));
                }
                tabla.addCell(nombreGenero);
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado con el nombre: pdf" + tipo + "Individual" + cedula + ".pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    //pdfs usuarios
    
    public void pdfUsuariosCreados (ArrayList<Historiales> lista) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfUsuariosCreados.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre usuario que lo creó");
            tabla.addCell("Cedula Usuario que lo creó");
            tabla.addCell("Cedula Usuario creado");
            tabla.addCell("Fecha creado");
            tabla.addCell("Hora creado");

            for (int i = 0; i < lista.size(); i++) {
                String nombreUsuarioCreo = lista.get(i).getNombreUsuario();
                int cedulaUsuarioCreo = lista.get(i).getId_usuario();
                LocalDate fechaCreado = lista.get(i).getFecha();
                LocalTime horaCreado = lista.get(i).getHora();
                
                //para el usuario que se creó
                String[] separacion = lista.get(i).getAccion().split(": ");
                int cedulaUsuarioCreado = Integer.parseInt(separacion[1]);
                
                tabla.addCell(nombreUsuarioCreo);
                tabla.addCell(String.valueOf(cedulaUsuarioCreo));
                tabla.addCell(String.valueOf(cedulaUsuarioCreado));
                tabla.addCell(String.valueOf(fechaCreado));
                tabla.addCell(String.valueOf(horaCreado));
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdfUsuariosCreados.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } 
    }   
    
        public void pdfUsuariosModificados (ArrayList<Historiales> lista) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfUsuariosModificados.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre usuario que lo modificó");
            tabla.addCell("Cedula Usuario que lo modificó");
            tabla.addCell("Cedula Usuario modificado");
            tabla.addCell("Fecha modificado");
            tabla.addCell("Hora modificado");

            for (int i = 0; i < lista.size(); i++) {
                String nombreUsuarioCreo = lista.get(i).getNombreUsuario();
                int cedulaUsuarioCreo = lista.get(i).getId_usuario();
                LocalDate fechaCreado = lista.get(i).getFecha();
                LocalTime horaCreado = lista.get(i).getHora();
                
                //para el usuario que se creó
                String[] separacion = lista.get(i).getAccion().split(": ");
                int cedulaUsuarioCreado = Integer.parseInt(separacion[1]);
                
                tabla.addCell(nombreUsuarioCreo);
                tabla.addCell(String.valueOf(cedulaUsuarioCreo));
                tabla.addCell(String.valueOf(cedulaUsuarioCreado));
                tabla.addCell(String.valueOf(fechaCreado));
                tabla.addCell(String.valueOf(horaCreado));
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdfUsuariosModificados.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } 
    } 
        
    public void pdfUsuariosEliminados (ArrayList<Historiales> lista) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfUsuariosEliminados.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre usuario que lo eliminó");
            tabla.addCell("Cedula Usuario que lo eliminó");
            tabla.addCell("Cedula Usuario elliminado");
            tabla.addCell("Fecha elminado");
            tabla.addCell("Hora eliminado");

            for (int i = 0; i < lista.size(); i++) {
                String nombreUsuarioCreo = lista.get(i).getNombreUsuario();
                int cedulaUsuarioCreo = lista.get(i).getId_usuario();
                LocalDate fechaCreado = lista.get(i).getFecha();
                LocalTime horaCreado = lista.get(i).getHora();
                
                //para el usuario que se creó
                String[] separacion = lista.get(i).getAccion().split(": ");
                int cedulaUsuarioCreado = Integer.parseInt(separacion[1]);
                
                tabla.addCell(nombreUsuarioCreo);
                tabla.addCell(String.valueOf(cedulaUsuarioCreo));
                tabla.addCell(String.valueOf(cedulaUsuarioCreado));
                tabla.addCell(String.valueOf(fechaCreado));
                tabla.addCell(String.valueOf(horaCreado));
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdfUsuariosEliminados.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }    
    
    public void pdfUsuariosLogueados (ArrayList<Historiales> lista) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfUsuariosLogueados.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(4);

            tabla.addCell("Nombre usuario que logueó");
            tabla.addCell("Cedula Usuario que logueó");
            tabla.addCell("Fecha en que logueó");
            tabla.addCell("Hora en que logueó");

            for (int i = 0; i < lista.size(); i++) {
                String nombreUsuarioCreo = lista.get(i).getNombreUsuario();
                int cedulaUsuarioCreo = lista.get(i).getId_usuario();
                LocalDate fechaCreado = lista.get(i).getFecha();
                LocalTime horaCreado = lista.get(i).getHora();
                
                tabla.addCell(nombreUsuarioCreo);
                tabla.addCell(String.valueOf(cedulaUsuarioCreo));
                tabla.addCell(String.valueOf(fechaCreado));
                tabla.addCell(String.valueOf(horaCreado));
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdfUsuariosLogueados.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }
    
    //pdfs de los libros
    
    public void pdfLibrosAgregados (ArrayList<Historiales> lista) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfLibrosAgregados.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre usuario que lo agregó");
            tabla.addCell("Cedula Usuario que lo agregó");
            tabla.addCell("id libro agregado");
            tabla.addCell("Fecha elminado");
            tabla.addCell("Hora eliminado");

            for (int i = 0; i < lista.size(); i++) {
                String nombreUsuarioCreo = lista.get(i).getNombreUsuario();
                int cedulaUsuarioCreo = lista.get(i).getId_usuario();
                LocalDate fechaCreado = lista.get(i).getFecha();
                LocalTime horaCreado = lista.get(i).getHora();
                
                //para el usuario que se creó
                String[] separacion = lista.get(i).getAccion().split(": ");
                int idLibro = Integer.parseInt(separacion[1]);
                
                tabla.addCell(nombreUsuarioCreo);
                tabla.addCell(String.valueOf(cedulaUsuarioCreo));
                tabla.addCell(String.valueOf(idLibro));
                tabla.addCell(String.valueOf(fechaCreado));
                tabla.addCell(String.valueOf(horaCreado));
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdfLibrosAgregados.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }
    
    public void pdfLibrosModificados (ArrayList<Historiales> lista) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfLibrosModificados.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre usuario que lo modificó");
            tabla.addCell("Cedula Usuario que lo modificó");
            tabla.addCell("id libro modificado");
            tabla.addCell("Fecha modificado");
            tabla.addCell("Hora modificado");

            for (int i = 0; i < lista.size(); i++) {
                String nombreUsuarioCreo = lista.get(i).getNombreUsuario();
                int cedulaUsuarioCreo = lista.get(i).getId_usuario();
                LocalDate fechaCreado = lista.get(i).getFecha();
                LocalTime horaCreado = lista.get(i).getHora();
                
                //para el usuario que se creó
                String[] separacion = lista.get(i).getAccion().split(": ");
                int idLibro = Integer.parseInt(separacion[1]);
                
                tabla.addCell(nombreUsuarioCreo);
                tabla.addCell(String.valueOf(cedulaUsuarioCreo));
                tabla.addCell(String.valueOf(idLibro));
                tabla.addCell(String.valueOf(fechaCreado));
                tabla.addCell(String.valueOf(horaCreado));
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdfLibrosModificados.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }
    
    public void pdfLibrosEliminados (ArrayList<Historiales> lista) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfLibrosEliminados.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre usuario que lo eliminó");
            tabla.addCell("Cedula Usuario que lo eliminó");
            tabla.addCell("id libro eliminado");
            tabla.addCell("Fecha eliminado");
            tabla.addCell("Hora eliminado");

            for (int i = 0; i < lista.size(); i++) {
                String nombreUsuarioCreo = lista.get(i).getNombreUsuario();
                int cedulaUsuarioCreo = lista.get(i).getId_usuario();
                LocalDate fechaCreado = lista.get(i).getFecha();
                LocalTime horaCreado = lista.get(i).getHora();
                
                //para el usuario que se creó
                String[] separacion = lista.get(i).getAccion().split(": ");
                int idLibro = Integer.parseInt(separacion[1]);
                
                tabla.addCell(nombreUsuarioCreo);
                tabla.addCell(String.valueOf(cedulaUsuarioCreo));
                tabla.addCell(String.valueOf(idLibro));
                tabla.addCell(String.valueOf(fechaCreado));
                tabla.addCell(String.valueOf(horaCreado));
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdfLibrosEliminados.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }
}



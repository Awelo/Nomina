/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import conexion.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author awelo
 */
public class Reporte {
    Conexion conec;
    
    

    public void ReporteEmpleado() throws JRException {
        JasperReport chuchita=null;
        chuchita = (JasperReport) JRLoader.loadObjectFromLocation("//home//awelo//git//Nomina//Nomina//src//reportes//reporteIndividual.jrxml");
        JasperPrint ima= JasperFillManager.fillReport(chuchita, null, conec.conectar());
        JasperViewer ver= new JasperViewer(ima);
        ver.setTitle("Reporte");
        ver.setVisible(true);
    }
}

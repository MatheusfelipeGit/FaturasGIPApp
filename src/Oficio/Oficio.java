    package Oficio;

import DAO.ConexaoGipDAO;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

public class Oficio implements ActionListener {

    private JTextField AnoTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JTextField TipoTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JTextField MesTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JTextField AtrasadasTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JTextField OficioNumbTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JTextField DataVencTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio

    public Oficio(JTextField AnoTxt, JTextField TipoTxt, JTextField MesTxt, JTextField OficioNumbTxt, JTextField DataVencTxt, JTextField AtrasadasTxt ) {

        this.AnoTxt = AnoTxt;
        this.TipoTxt = TipoTxt;
        this.MesTxt = MesTxt;
        this.AtrasadasTxt = AtrasadasTxt;
        this.OficioNumbTxt = OficioNumbTxt;
        this.DataVencTxt = DataVencTxt;

        // aqui ele declara que tudo que tem dentro dele é dele 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            geraRelatorio(); // esse é meu método, onde que chamo ele para gerar
        } catch (IOException ex) {
            Logger.getLogger(Oficio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void geraRelatorio() throws FileNotFoundException, IOException {
        

        String anoref = AnoTxt.getText();
        String tipo = TipoTxt.getText();
        String mesref = MesTxt.getText();
        String Oficio = OficioNumbTxt.getText();
        String datavenc = DataVencTxt.getText();
        String atrasadas = AtrasadasTxt.getText();

        String base = "C:\\Users\\jateixeira\\JaspersoftWorkspace\\FaturasGip\\";
         //aqui é onde está o projeto que querem gerar

        HashMap<String, Object> param = new HashMap<String, Object>();

        param.put("SUBREPORT_DIR", base);   
        param.put("Ano_ref", anoref);
        param.put("Tipo", tipo);
        param.put("Mes_ref", mesref);
        param.put("Oficio", Oficio);
        param.put("DataVenc", datavenc);
        param.put("Atrasadas", atrasadas);

        byte[] bytes = null;

        try {

    // 🔥 COMPILA O SUBRELATÓRIO (ESSENCIAL)
    net.sf.jasperreports.engine.JasperCompileManager
        .compileReportToFile(base + "relacao.jrxml");

    // 🔥 COMPILA O RELATÓRIO PRINCIPAL
    JasperReport relatorio =
        net.sf.jasperreports.engine.JasperCompileManager
        .compileReport(base + "oficios.jrxml");

    bytes = JasperRunManager.runReportToPdf(
        relatorio, param, new ConexaoGipDAO().conectaBD()
    );

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    String timestamp = dateFormat.format(new Date());

    File arq = new File(
        "C:\\Users\\jateixeira\\Desktop\\oficiosExport",
        tipo + Oficio + ".pdf"
    );

    FileOutputStream fos = new FileOutputStream(arq);
    fos.write(bytes);
    fos.flush();
    fos.close();

    Desktop desk = Desktop.getDesktop();
    desk.open(arq);

} catch (JRException e) {
    e.printStackTrace();
}

    }
}
 
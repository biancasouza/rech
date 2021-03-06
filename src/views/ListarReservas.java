/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import config.Conexao;
import java.awt.Toolkit;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.DAO.AmbienteDAO;
import model.DAO.ListarReservasDAO;
import model.DAO.PessoaDAO;
import model.DAO.ReservaDAO;
import model.bean.Ambiente;
import model.bean.Pessoa;
import model.bean.Reserva;
/**
 *
 * @author biank
 */
public class ListarReservas extends javax.swing.JFrame {
    
    String nome;
    int status;
    String descricao;
    String sit;
    /**
     * Creates new form ListarReservas
     */
    public ListarReservas() throws ParseException, SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTableReservas.getModel();
        jTableReservas.setRowSorter(new TableRowSorter (modelo));
        readJTable();
       
        
    }
    private void readJTable() throws ParseException, SQLException{
        DefaultTableModel modelo = (DefaultTableModel) jTableReservas.getModel();
        modelo.setNumRows(0);
        ListarReservasDAO dao = new ListarReservasDAO();
  
        for(model.bean.ListarReservas l : dao.read() ){
            modelo.addRow(new Object[]{
                l.getReserva().getCod_reserva(),
                converteData2(l.getReserva().getData_evento()),
                l.getAmbiente().getSetor(),
                retornaSit(l.getAmbiente().getStatus()),
                l.getPessoa().getNome()
                
//                

            });
       
        }
        
    }
    
        
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rech = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservas = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECH - Listar Reservas de Ambientes");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C://Users/biank/Documents/NetBeansProjects/Rech/src/rech/img/li2.png"));

        Rech.setBackground(new java.awt.Color(255, 255, 255));
        Rech.setToolTipText("");
        Rech.setName("RECH"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(97, 180, 83));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESERVAS DE AMBIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jTableReservas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jTableReservas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},

            },
            new String [] {
                "CÓDIGO",  "DATA RESERVADA", "DESCRIÇÃO","STATUS", "RESPONSÁVEL"
            }
        ));
        jTableReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableReservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableReservas);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel24)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RechLayout = new javax.swing.GroupLayout(Rech);
        Rech.setLayout(RechLayout);
        RechLayout.setHorizontalGroup(
            RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RechLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        RechLayout.setVerticalGroup(
            RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RechLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Rech, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Rech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String converteData2(Date data) throws ParseException {
        String dtString = new SimpleDateFormat("dd/MM/yyyy").format(data);
        return dtString;
    }
    public String retornaSit(int status){
         String s = null;
        switch (status) {
            case 0:
                s = "Disponível";
                break;
            case 1:
                s = "Reservado";
                break;
          
            default:
                break;
        }
         return s;
     
     }
    private void jTableReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReservasMouseClicked
        
    }//GEN-LAST:event_jTableReservasMouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        if(jTableReservas.getSelectedRow()!= -1){
            String valor = null;
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            stmt = con.prepareStatement("SELECT pessoa.cpf FROM pessoa,ambiente, reserva WHERE ambiente.numero = reserva.numero AND pessoa.cpf = reserva.cpf AND ambiente. setor = ?");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro!");
        }

        try {
            valor = (String) jTableReservas.getValueAt(jTableReservas.getSelectedRow(), 2);
            stmt.setString(1,valor);
        } catch (SQLException ex) {
            Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                if (rs.next()){
                    int cpf = rs.getInt("pessoa.cpf");
                    EditarReserva er = new EditarReserva(cpf,valor);
                    er.setVisible(true);
                    this.dispose();
                    
                }   } catch (SQLException ex) {
                Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jLabel24MouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ListarReservas().setVisible(true);
//                } catch (ParseException ex) {
//                    Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Rech;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReservas;
    // End of variables declaration//GEN-END:variables

    
}

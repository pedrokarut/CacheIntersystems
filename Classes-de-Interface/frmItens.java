package ClassesDeInterface;
import User.Coleta;
import User.ItensColeta;
import User.Material;
import com.intersys.objects.CacheException;
import com.intersys.objects.Id;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class frmItens extends javax.swing.JFrame {

    
    frmMaterial frmMat;
    frmColeta frmCol;
    ItensColeta i;
    Coleta c;
    Material m;
    Conexao con;
   
    public frmItens() {
        initComponents();
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }
    
    
     private void LimpaCampos()
    {
        txtCodColeta.setText(null);
        txtCodItem.setText(null);
        txtCodMaterial.setText(null);
        txtQuantidade.setText(null);
    }
    
     private void LimpaJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTableItens.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
     
        jTableItens.setModel(model);
    }
    
    private void PreencheJTable()
    {
       String[] cabecalhos = {"Código da Coleta", "Código do Agente", "Código do Ponto", "Data da Coleta"};
        DefaultTableModel model = (DefaultTableModel) jTableItens.getModel();
        model.setColumnIdentifiers(cabecalhos);
        
        try
        {
            con = new Conexao();
            i =  new ItensColeta(con.getDbconnection());
            Iterator iter =  i.openByQuery(con.getDbconnection(), null, null);
                       
            Object[][] objects = new Object[500][4];
            int j = 0;         
            
            while(iter.hasNext())
            {
                    i = new ItensColeta(con.getDbconnection());
                    i = (ItensColeta) iter.next();
                
                    objects[j][0]= i.getcodItem();
                    objects[j][1]= i.getcodMaterial().getcodMaterial();
                    objects[j][2]= i.getcodColeta().getcodColeta();
                    objects[j][3]= i.getquantidade();
                    
                    model.addRow(new Object[]{objects[j][0], objects[j][1], objects[j][2], objects[j][3]});
            }
        }
        catch(CacheException ex)
        {
            Logger.getLogger(frmAgenteAmbiental.class.getName()).log(Level.SEVERE, null, ex);
        }       
                jTableItens.setModel(model);
    
    }      

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodItem = new javax.swing.JTextField();
        txtCodMaterial = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAdicionarMaterial = new javax.swing.JButton();
        btEditar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableItens = new javax.swing.JTable();
        txtCodColeta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btImportarColeta = new javax.swing.JButton();

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/item64.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Itens");

        jLabel3.setText("Código Item:");

        jLabel4.setText("Códico Material:");

        jLabel5.setText("Quantidade:");

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/draw.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAdicionarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btAdicionarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarMaterialActionPerformed(evt);
            }
        });

        btEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/broom.png"))); // NOI18N
        btEditar1.setText("Limpar");
        btEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar1ActionPerformed(evt);
            }
        });

        jTableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableItensMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableItens);

        jLabel6.setText("Código Coleta:");

        btImportarColeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btImportarColeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportarColetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtCodMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(266, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(121, 121, 121)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btCadastrar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btAdicionarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCodColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btImportarColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodItem)
                                .addGap(82, 82, 82)))
                        .addComponent(btEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodColeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImportarColeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btCadastrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarMaterialActionPerformed
        frmMat = new frmMaterial();
        frmMat.setLocationRelativeTo(null);
        frmMat.setVisible(true);
    }//GEN-LAST:event_btAdicionarMaterialActionPerformed

    private void btImportarColetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportarColetaActionPerformed
        frmCol = new frmColeta();
        frmCol.setLocationRelativeTo(null);
        frmCol.setVisible(true);
    }//GEN-LAST:event_btImportarColetaActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        con = new Conexao();
        try 
        {
            i = new ItensColeta(con.getDbconnection());
            i.setcodItem(Integer.parseInt(txtCodItem.getText()));
            m = (Material) Material._open(con.getDbconnection(), new Id(txtCodMaterial.getText()));
            i.setcodMaterial(m);
            c = (Coleta) Coleta._open(con.getDbconnection(), new Id(txtCodColeta.getText()));
            i.setcodColeta(c);
            i.setquantidade(Integer.parseInt(txtQuantidade.getText()));
            i.save();
            JOptionPane.showMessageDialog(null, "Item de Coleta cadastrado com sucesso!");
            LimpaCampos();
            LimpaJTable();
            PreencheJTable();
        } 
        catch (CacheException ex)
        {
            Logger.getLogger(frmItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        con = new Conexao();
        try 
        {
            i = (ItensColeta) ItensColeta._open(con.getDbconnection(), new Id(txtCodItem.getText()));
            m = (Material) Material._open(con.getDbconnection(), new Id(txtCodMaterial.getText()));
            i.setcodMaterial(m);
            c = (Coleta) Coleta._open(con.getDbconnection(), new Id(txtCodColeta.getText()));
            i.setcodColeta(c);
            i.setquantidade(Integer.parseInt(txtQuantidade.getText()));
            i.save();
            JOptionPane.showMessageDialog(null, "Item de Coleta editado com sucesso!");
            LimpaCampos();
            LimpaJTable();
            PreencheJTable();
        } 
        catch (CacheException ex)
        {
            Logger.getLogger(frmItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        con = new Conexao();
        try 
        {
            i = (ItensColeta) ItensColeta._open(con.getDbconnection(), new Id(txtCodItem.getText()));
            i.delete();
            JOptionPane.showMessageDialog(null, "Item de Coleta deletado com sucesso!");
            LimpaCampos();
            LimpaJTable();
            PreencheJTable();
        } 
        catch (CacheException ex)
        {
            Logger.getLogger(frmItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void jTableItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableItensMouseClicked
        int linha = jTableItens.getSelectedRow();
        txtCodItem.setText(String.valueOf(jTableItens.getValueAt(linha, 0)));
        txtCodMaterial.setText(String.valueOf(jTableItens.getValueAt(linha, 1)));
        txtCodColeta.setText(String.valueOf(jTableItens.getValueAt(linha, 2)));
        txtQuantidade.setText(String.valueOf(jTableItens.getValueAt(linha, 3)));
    }//GEN-LAST:event_jTableItensMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(frmMaterial.codMat != 0)
        {
            txtCodMaterial.setText(String.valueOf(frmMaterial.codMat));
        }
        if(frmColeta.codColeta != 0)
        {
            txtCodColeta.setText(String.valueOf(frmColeta.codColeta));
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void btEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar1ActionPerformed
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btEditar1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmItens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarMaterial;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEditar1;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImportarColeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableItens;
    private javax.swing.JTextField txtCodColeta;
    private javax.swing.JTextField txtCodItem;
    private javax.swing.JTextField txtCodMaterial;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}

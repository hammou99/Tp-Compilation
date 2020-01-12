/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_compilation;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author hammou999
 */
public class tp extends javax.swing.JFrame {

    /**
     * Creates new form tp
     */
    public tp(){
        initComponents();
        Token[0][0]="Start_Program";Token[0][1]="Mot réservé Début d'un Programme";
        Token[1][0]="Int_Number";Token[1][1]="Mot réservé Déclaration d'un Entier";
        Token[2][0]="Real_Number";Token[2][1]="Mot réservé Déclaration d'un Réel";
        Token[3][0]="[0-9]+";;Token[3][1]="Valeur Entier";
        Token[4][0]="[0-9]+\\.[0-9]+";;Token[4][1]="Valeur Réel";
        Token[5][0]=":";Token[5][1]="Caractére réservé deux points";
        Token[6][0]=",";Token[6][1]="Caractére réservé Virgule";
        Token[7][0]="Give";Token[7][1]="Mot réservé pour un Affectation";
        Token[8][0]="If";Token[8][1]="Mot réservé pour une Condition";
        Token[9][0]="--";Token[9][1]="Mot réservé pour une Condition";
        Token[10][0]="Else";Token[10][1]="Mot réservé pour une Condition";
        Token[11][0]="Start";Token[11][1]="Mot réservé Début d'un Block";
        Token[12][0]="Affect";Token[12][1]="Mot réservé pour un Affectation";
        Token[13][0]="to";Token[13][1]="Mot réservé pour un Affectation";
        Token[14][0]="Finish";Token[14][1]="Mot réservé fin d'un Block";
        Token[15][0]="ShowMes";Token[15][1]="Mot réservé Affichage d'un message";
        Token[16][0]="\".*\"";Token[16][1]="Chaine Caractere";
        Token[17][0]="ShowVal";Token[17][1]="Mot réservé Affichage d'un variable";
        Token[18][0]="//.*";Token[18][1]="Mot réservé Debut Commentaire";
        Token[19][0]="End_Program";Token[19][1]="Mot réservé fin Programme";
        Token[20][0]="[a-zA-Z](_?([a-zA-Z]|[0-9])+)*";Token[20][1]="id";
        Token[21][0]="[a-zA-Z](_?([a-zA-Z]|[0-9])+)*(,[a-zA-Z](_?([a-zA-Z]|[0-9])+)*)*";Token[21][1]="ids";        
        Token[22][0]=".*(<|>|<=|>=|=|!=).*";Token[22][1]="Condition";
        Token[23][0]=";;";Token[23][1]="fin ligne";
        String TE0="[ \t]*";
        String TE1="[ \t]*";
        String DI="^";
        String FI="$";
        String Stringg="String";
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jButton1.setText("analyse sémantique");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 440, 250, 110);

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jButton2.setText("Charger un fichier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 50, 250, 110);

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jButton3.setText("Analyse lexicale");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 180, 250, 110);

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 22)); // NOI18N
        jButton4.setText("Analayse syntaxique");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 310, 250, 110);

        jEditorPane1.setEditable(false);
        jEditorPane1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 10, 500, 540);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    String CONDITION="(<|>|<=|>=|=|!=)";
    String SATRTPROGRAM="Start_Program",ENDPROGRAM="End_Program";
    String[][] Token = new String[24][2];
    String text;
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            FileDialog dialog = new FileDialog((Frame)null, "Choisissiez un fichier");
            dialog.setMultipleMode(false);
            dialog.setFile("*.compila");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);
            if(dialog.getFile()!=null){
            String NameFile = dialog.getDirectory()+dialog.getFile();
            
            File file = new File(NameFile);
            Scanner sc = new Scanner(file);
            jEditorPane1.setText("");
            while (sc.hasNextLine())
                jEditorPane1.setText(jEditorPane1.getText()+sc.nextLine()+"\n"); 
        
        text=jEditorPane1.getText();
        }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(tp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(text!=null && !text.equals("")){
        String[] ar =text.replaceAll("//[.].*","//.").replaceAll("\n"," ").replaceAll("[ \t]+"," ").replaceAll("^[ \t]+","").replace("[ \t]+$","").replaceAll("//\\..*","//\\.").replaceAll("\".*\"","\"String\"").split(" ");        
        jEditorPane1.setText("");
        int j;
        for(int i=0;i<ar.length;i++){
            for(j=0;j<Token.length;j++)
                if(Pattern.compile(Token[j][0]).matcher(ar[i]).matches())
                    break;
            if(j<Token.length)
                jEditorPane1.setText(jEditorPane1.getText()+ar[i]+" : "+Token[j][1]+"\n");
            else
                jEditorPane1.setText(jEditorPane1.getText()+ar[i]+" : N'est pas reconner \n");
        }}
    }//GEN-LAST:event_jButton3ActionPerformed
public class variable{
    public variable(String nom,String type,String valeur){
        this.nom=nom;
        this.type=type;
        this.valeur=valeur;
    }
    String nom,type,valeur;
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(text!=null && !text.equals("")){
        length=text.replaceAll("\t+"," ").replaceAll(" +"," ").replaceAll("([ \t]*\n+[ \t]*)+","\n").replaceAll("^[ \t]*\n*","").replaceAll("[ \t]*\n*$","").split("\n").length;
        ligne=new String[][]{text.replaceAll("\t+"," ").replaceAll(" +"," ").replaceAll("([ \t]*\n+[ \t]*)+","\n").replaceAll("^[ \t]*\n*","").replaceAll("[ \t]*\n*$","").split("\n"),new String[length]};
        ArrayList<variable> ListVar = new ArrayList<variable>(); 
        int i=0,j=0;
        jEditorPane1.setText("");
        while(i<length){
            if(Pattern.compile("Int_Number : "+Token[21][0]+" ;;").matcher(ligne[0][i]).matches())
                {ligne[1][i]="Déclaration Entier";
                for(String s :ligne[0][i].replaceAll("Int_Number : ","").replaceAll(" ;;", "").split(","))
                ListVar.add(new variable(s,"int",null));
                }
            if(Pattern.compile("Real_Number : "+Token[21][0]+" ;;").matcher(ligne[0][i]).matches())
                {ligne[1][i]="Déclaration Réel";
                for(String s :ligne[0][i].replaceAll("Real_Number : ","").replaceAll(" ;;", "").split(",")){
                ListVar.add(new variable(s,"real",null));}
                }
           if(Pattern.compile("Give "+Token[20][0]+" : "+Token[3][0]+" ;;").matcher(ligne[0][i]).matches()){
                for(j=0;j<ListVar.size();j++)
                    if(ListVar.get(j).nom.equals(ligne[0][i].replaceAll("Give ","").replaceAll(" : .*","")))
                        break;
                if(j<ListVar.size())
                         if(!ListVar.get(j).type.equals("int"))
                             ligne[1][i]="Erreur de type";
                         else { ListVar.get(j).valeur=ligne[0][i].replaceAll(".* : ","").replaceAll(" ;;","");ligne[1][i]=ListVar.get(j).nom+"="+ListVar.get(j).valeur;}
                else ligne[1][i]="Variable non déclaré";
           }   
           if(Pattern.compile("Give "+Token[20][0]+" : "+Token[4][0]+" ;;").matcher(ligne[0][i]).matches()){
               for(j=0;j<ListVar.size();j++)
                    if(ListVar.get(j).nom.equals(ligne[0][i].replaceAll("Give ","").replaceAll(" : .*","")))
                        break; 
               if(j<ListVar.size())
                        if(!ListVar.get(j).type.equals("real"))
                            ligne[1][i]="Erreur de type";
                         else {ListVar.get(j).valeur=ligne[0][i].replaceAll(".* : ","").replaceAll(" ;;","");ligne[1][i]=ListVar.get(j).nom+"="+ListVar.get(j).valeur;}
                else ligne[1][i]="Variable non déclaré";  
           }
           
            if(Pattern.compile("Affect "+Token[20][0]+" to "+Token[20][0]+" ;;").matcher(ligne[0][i]).matches()){
                for(j=0;j<ListVar.size();j++)    
                    if(ligne[0][i].replaceAll("Affect ","").replaceAll(" to .*","").equals(ListVar.get(j).nom))
                        break;
                if(j<ListVar.size()){
                    int k;
                    for(k=0;k<ListVar.size();k++)    
                    if(ligne[0][i].replaceAll(".* to ","").replaceAll(" ;;","").equals(ListVar.get(k).nom))
                            break;
                    if(k<ListVar.size()){
                        if(ListVar.get(j).type.equals(ListVar.get(k).type)){
                           ListVar.get(k).valeur=ListVar.get(j).valeur;
                           ligne[1][i]=ListVar.get(j).nom + "="+ListVar.get(k).valeur;
                        }else  ligne[1][i]="Erreur de type";
                    }else  ligne[1][i]="Variable non déclaré";
                }else  ligne[1][i]="Variable non déclaré";  
            }
            i++;        
                           
                            
        }
        
        for(i=0;i<length;i++){
            if(ligne[1][i]==null)
                 jEditorPane1.setText(jEditorPane1.getText()+ligne[0][i]+"\n");
            else jEditorPane1.setText(jEditorPane1.getText()+ligne[0][i]+" : "+ligne[1][i]+"\n");
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
String[][] ligne;
int j=1;
int length=0;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(text!=null && !text.equals("")){
        length=text.replaceAll("\t+"," ").replaceAll(" +"," ").replaceAll("([ \t]*\n+[ \t]*)+","\n").replaceAll("^[ \t]*\n*","").replaceAll("[ \t]*\n*$","").split("\n").length;
        ligne=new String[][]{text.replaceAll("\t+"," ").replaceAll(" +"," ").replaceAll("([ \t]*\n+[ \t]*)+","\n").replaceAll("^[ \t]*\n*","").replaceAll("[ \t]*\n*$","").split("\n"),new String[length]};
        if(length>0){
            j=1;
            if(!SATRTPROGRAM.equals(ligne[0][0])){
                ligne[1][0]="Erreur Syntaxique Start_Program non trouvé";
                j=1;
            }
            else{
                ligne[1][0]="Debut programme";
            }
            while(j<length-1){
                isAction();
            }
            if(!ENDPROGRAM.equals(ligne[0][length-1]))
               if(ligne[1][length-1]==null) ligne[1][length-1]="\n fin programme non trouve";
               else                    ligne[1][length-1]="fin programme non trouve"+ligne[1][length-1];
            else if(ligne[1][length-1]==null) ligne[1][length-1]="fin programme";
               else                    ligne[1][length-1]="fin programme"+ligne[1][length-1];
        
        jEditorPane1.setText("");
        for(int i=0;i<length;i++){
            if(ligne[1][i]==null)
                 jEditorPane1.setText(jEditorPane1.getText()+ligne[0][i]+" : Erreur"+"\n");
            else jEditorPane1.setText(jEditorPane1.getText()+ligne[0][i]+" : "+ligne[1][i]+"\n");
        }}}
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public void isAction(){
                if(Pattern.compile("Int_Number : "+Token[21][0]+" ;;").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Déclaration Entier";
                if(Pattern.compile("Give "+Token[20][0]+" : "+Token[3][0]+" ;;").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Affectation_entier";
                if(Pattern.compile("Give "+Token[20][0]+" : "+Token[4][0]+" ;;").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Affectation_réel";
                if(Pattern.compile("Real_Number : "+Token[21][0]+" ;;").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Déclaration Réel";
                if(Pattern.compile("Affect "+Token[20][0]+" to "+Token[20][0]+" ;;").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Affectation var to var";
                if(Pattern.compile("ShowMes : \".*\" ;;").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Affichage message";
                if(Pattern.compile("ShowVal : "+Token[20][0]+" ;;").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Affichage valeur";
                if(Pattern.compile("//.*").matcher(ligne[0][j]).matches())
                    ligne[1][j]="Commentaire";
                if(Pattern.compile("If -- "+Token[20][0]+"(<|>|<=|>=|=|!=)"+Token[20][0]+" --").matcher(ligne[0][j]).matches())
                    isIf();
                j++;
    }
    public void isIf(){
            ligne[1][j]="Si";
            j++;
            if(Pattern.compile("Start").matcher(ligne[0][j]).matches()){
                ligne[1][j++]="Debut block";
                while(j<length && !Pattern.compile("Finish").matcher(ligne[0][j]).matches())
                    isAction();
                if(j<length)
                    ligne[1][j]="fin block";
                else if(ligne[1][j-1]==null)ligne[1][j-1]="\nfin blok non trouve";
                             else           ligne[1][j-1]=ligne[1][j-1]+"\nfin blok non trouve";
                }
            else isAction();
            if(Pattern.compile("Else").matcher(ligne[0][j]).matches()){
                    ligne[1][j]="Sinon";
                    if(Pattern.compile("Start").matcher(ligne[0][++j]).matches()){
                        ligne[1][j]="Debut block";
                        while(j<length && !Pattern.compile("Finish").matcher(ligne[0][j]).matches())
                            isAction();
                        if(j<length){
                            ligne[1][j]="fin block";
                        }
                        else if(ligne[1][j-1]==null)ligne[1][j-1]="\nfin block non trouvé";
                             else                   ligne[1][j-1]=ligne[1][j-1]+"\nfin block non trouve";
                    }
            }   else j--;
                
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Kalistrik {
    private JTextField textTegangan;
    private JTextField textKuatArus;
    private JTextField textHambatan;
    private JTextField textDaya;
    private JButton hitungButton;
    private JButton bersihkanButton;
    private JTextField textHasil;
    private JPanel panel;
    private JLabel labelTegangan;
    private JLabel labelKuatArus;
    private JLabel labelHambatan;
    private JLabel labelDaya;
    private JLabel satuanTegangan;
    private JLabel satuanKuatArus;
    private JLabel satuanHambatan;
    private JLabel satuanDaya;
    private JButton yaButton;
    private JButton tidakButton;
    private JTextField textHasilAkhir;
    private JTextField textBarang;
    private JLabel labelBarang;
    static JFrame frame = new JFrame("KaListrik (Kalkulator Listrik)");


    public Kalistrik() {
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer.parseInt(textKuatArus.getText());
                Integer.parseInt(textHambatan.getText());
                Integer.parseInt(textTegangan.getText());
                Integer.parseInt(textDaya.getText());
                String input = textBarang.getText();
                Stack <String> stk = new Stack<>();
                stk.push(input);
                if (!input.isEmpty()){
                    textHasilAkhir.setText("");
                    textHasil.setText("\nBarang = " + stk + "\tHasil Tegangan =  " + hasilTegangan() + "\nVolt" + "\tHasil Daya =  " + hasilDaya() + "\nWatt" +
                            "\tHasil Kuat Arus =  " + hasilKuatArus() + "\nAmpere" + "\tHasil Hambatan = " + hasilHambatan() + "\nOhm");
                }
                else {
                    textHasil.setText("Masukkan nama barang terlebih dahulu");
                }
            }
        });

        yaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textHasil.setText("");
                textTegangan.setText("");
                textKuatArus.setText("");
                textDaya.setText("");
                textHambatan.setText("");
                textBarang.setText("");
                textHasilAkhir.setText("Silakan masukkan input kembali");
            }
        });

        tidakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {frame.dispose();}
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new Kalistrik().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public String hasilTegangan() {
        double perhitungan = Double.parseDouble(textHambatan.getText()) * Double.parseDouble(textKuatArus.getText());
        String hasil = String.valueOf(perhitungan);
        return hasil;
    }

    public String hasilDaya() {
        double perhitungan = Double.parseDouble(textKuatArus.getText()) * Double.parseDouble(textTegangan.getText());
        String hasil = String.valueOf(perhitungan);
        return hasil;
    }

    public String hasilKuatArus() {
        double perhitungan = Double.parseDouble(textTegangan.getText()) / Double.parseDouble(textHambatan.getText());
        String hasil;
        if(Double.isInfinite(perhitungan)){
            hasil = String.valueOf(0);
        }
        else{
            hasil = String.valueOf(perhitungan);
        }
        return hasil;
    }

    public String hasilHambatan() {
        double perhitungan = Double.parseDouble(textTegangan.getText()) / Double.parseDouble(textKuatArus.getText());
        String hasil;
        if(Double.isInfinite(perhitungan)){
            hasil = String.valueOf(0);
        }
        else{
            hasil = String.valueOf(perhitungan);
        }
        return hasil;
    }
}

//Stack <String> stk = new Stack<>();
//boolean hasil = stk.empty();
//String Tegangan, Daya, KuatArus;
//Tegangan = String.valueOf(hasilTegangan());
//Daya = String.valueOf(hasilDaya());
                        //KuatArus = String.valueOf(hasilKuatArus());
                        //stk.push (Tegangan);
                        //stk.push (Daya);
                        //stk.push (KuatArus);







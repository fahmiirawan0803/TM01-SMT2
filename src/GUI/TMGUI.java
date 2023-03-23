package GUI;

import javax.swing.*;

import Connect.ConnectURI;
import Model.ResponseModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TMGUI extends JFrame{

    private JTextArea taNamaObat;
    private JTextArea taHargaObat;
    private JButton submitButton;
    private JButton cancelButton;
    private JTextField tfJmlhTotalNama;
    private JPanel mainPanel;
    private JTextField tfJmlhTotalHarga;
    private JTextField tfTotalNamaHarga;
    private JTextArea taTotalJmlhNama;
    private JTextArea taTotalJmlhHarga;


    public TMGUI() throws IOException {
        setContentPane(mainPanel);
        setTitle("Daftar Obat");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL
                ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);


        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responseModel = new ArrayList<>();
        for (int i = 0; i < responseJSON.length(); i++) {
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);

            resModel.setName(myJSONObject.getString("i_name"));
            resModel.setSell(Integer.parseInt(myJSONObject.getString("i_sell")));

            responseModel.add(resModel);
        }

        //cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("\nResponse are : ");
                System.out.println("Nama Obat yang Berawalan Huruf S dan Harganya dibawah 7000 : \n");

                ArrayList<ArrayList<ResponseModel>> totalNamaHarga = new ArrayList<>();
                ArrayList<ArrayList<ResponseModel>> totalNama = new ArrayList<>();
                ArrayList<ArrayList<ResponseModel>> totalHarga = new ArrayList<>();


                System.out.println("\n"+ "Barang yang Namanya Berawalan Huruf S : ");
                for (int i =0; i < responseModel.size(); i++) {

                    if (responseModel.get(i).getName().startsWith("S")) {
                        totalNama.add(responseModel);
                        System.out.println(totalNama.toArray().length + " " + responseModel.get(i).getName());
                        taNamaObat.setText(responseModel.get(i).getName());
                        tfJmlhTotalNama.setText(String.valueOf(totalNama.size()));


                    }
                }

                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("\n"+ "Barang yang Harganya dibawah 7000 : ");
                for (int o=0; o < responseModel.size(); o++){
                    if (responseModel.get(o).getSell() <= 7000){
                        totalHarga.add(responseModel);
                        System.out.println(totalHarga.toArray().length + " " + responseModel.get(o).getSell());
                        taHargaObat.setText(String.valueOf(responseModel.get(o).getSell()));
                        tfJmlhTotalHarga.setText(String.valueOf(totalHarga.size()));

                    }
                }

                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("\n"+ "Barang yang Berawalan Huruf S dan Harganya dibawah 7000 : ");

                for (int u = 0; u< responseModel.size(); u++){
                    if (responseModel.get(u).getName().startsWith("S") && responseModel.get(u).getSell() <= 7000){
                        totalNamaHarga.add(responseModel);
                        System.out.println(totalNamaHarga.toArray().length + " "
                                + responseModel.get(u).getName() + " " + responseModel.get(u).getSell());
                        tfTotalNamaHarga.setText(String.valueOf(totalNamaHarga.size()));
                    }
                }

                System.out.println("\n" + "----------------------------------------------------------------------------------");
                System.out.println("Jadi Total Nama Barang yang Berawalan Huruf S ada : "
                        + "\n" +  totalNama.size() + " Barang");
                System.out.println("\n" + "----------------------------------------------------------------------------------");
                System.out.println("Jadi Total  Barang yang Harganya Dibawah 7000 ada : "
                        + "\n" +  totalHarga.size() + " Barang");
                System.out.println("\n" + "----------------------------------------------------------------------------------");
                System.out.println("Jadi Total Nama Barang yang Berawalan Huruf S dan Harganya Dibawah 7000 ada : "
                        + "\n" +  totalNamaHarga.size() + " Barang");

            }
        });
    }

    public static void main(String[] args) throws IOException {
        TMGUI myFrame = new TMGUI();
    }

}

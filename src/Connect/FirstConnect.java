package Connect;

import Model.ResponseModel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL
                ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        //System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responseModel = new ArrayList<>();
        for (int i = 0; i < responseJSON.length(); i++) {
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);

            resModel.setName(myJSONObject.getString("i_name"));
            resModel.setSell(myJSONObject.getInt("i_sell"));

            responseModel.add(resModel);
        }
        //Respon
        System.out.println("\nResponse are : ");
        System.out.println("Nama Obat yang Berawalan Huruf S : \n");

        //Array untuk menyimpan nama obat
        ArrayList<ArrayList<ResponseModel>> totalNama = new ArrayList<>();

        //Mencari nama obat yang berawalan huruf S
        for (int i =0; i < responseModel.size(); i++) {

            if (responseModel.get(i).getName().startsWith("S") && responseModel.get(i).getSell() <= 7000) {
                totalNama.add(responseModel);
                System.out.println(totalNama.toArray().length + " " +
                        responseModel.get(i).getName() + " " + responseModel.get(i).getSell());
            }
        }
        //Menampilkan jumlah nama obat yang berawalan huruf S
        System.out.println("\n" + "Jadi Total Nama Obat yang Berawalan Huruf S" +
                " dan harga Max 7000 ada : " + "\n" +  totalNama.size() + " Obat");

    }

}


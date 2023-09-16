/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.currencyconvertor;

/**
 *
 * @author kali-i
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import org.json.JSONObject;

public class Currency {

    private static final String API_URL = "http://api.exchangeratesapi.io/v1/latest";
    JSONObject rates;
    ArrayList key=new ArrayList();
        String apiKey = "aa271d2719d5f1c1d1203163891c3082";
        
        public Currency(){
        try {
           
            URL url = new URL(API_URL + "?access_key=" + apiKey);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder response = new StringBuilder();

                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                
                 rates = jsonResponse.getJSONObject("rates");
                 
            }
            else {
                System.out.println("Failed to fetch exchange rates. Status code: " + responseCode);
            }
            
        
                } catch (IOException e) {
            e.printStackTrace();
        }
        
       
           
        }
            
        public double getExchange(double amount,String from,String to){         
              
                double fromRate = rates.getDouble(from);
                double ToRate = rates.getDouble(to);
                
                double result = ToRate / fromRate;
                DecimalFormat df=new DecimalFormat();
                df.applyPattern("#.##");
                return Double.parseDouble(df.format(result*amount));   
        }
    }


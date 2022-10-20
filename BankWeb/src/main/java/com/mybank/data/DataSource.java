//
package com.mybank.data;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author begonaolea
 */
public class DataSource {
    private File dataFile;

    public DataSource(String rutaFichero) {
        dataFile = new File(rutaFichero);
    }
    
    public void loadData() throws IOException{
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(dataFile);
            br = new BufferedReader(fr);
            //leo primera linea qeu me da un numero
            String linea = br.readLine();
            int numeroClientes = Integer.parseInt(linea);
            System.out.printf("Total clientes %d", numeroClientes);
            //leo linea en blanco
            linea =  br.readLine();
            for(int i = 0; i < numeroClientes; i++){
                
                //leo datos cliente
                 linea = br.readLine();
                // System.out.println(linea);
                Scanner sc = new Scanner(linea);
                String nom = sc.next();
                String ap = sc.next();
                int numeroCuentas = sc.nextInt();
                Bank.addCustomer(nom, ap);
                for(int j = 0; j < numeroCuentas; j++){
                    //leer cuentas
                    linea = br.readLine(); 
                    Scanner sc2 = new Scanner(linea);
                    sc2.useLocale(Locale.US);
                    String tipo = sc2.next();
                    double balance = sc2.nextDouble();
                    double interes = sc2.nextDouble();
                    Account ac= null;
                    if( tipo.equals("S")){
                        //new SA
                        ac = new SavingsAccount(balance, interes);
                    }else{
                        // new CA
                        ac = new CheckingAccount(balance, interes);
                    }
                   Customer c =  Bank.getCustomer(Bank.getNumOfCustomers()-1);
                   c.addAccount(ac);
                    
                }//fin recorrer cuentas
                linea = br.readLine(); 
            }//fin recorrer clientes
            
           // Scanner sc = new Scanner(linea)
           
         
        }finally{
           if(fr != null) fr.close();
           if(br != null) br.close();
        }
       
     
        
    }
            
    
    
}

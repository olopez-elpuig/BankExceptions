package Excepcions.ActivitatExceptions.Model;

import Excepcions.ActivitatExceptions.Control.OperacionsBanc;
import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainExceptions {
    public static void main(String[] args) throws Exception {
        CompteEstalvi cE = new CompteEstalvi("0000");
        CompteEstalvi cE2 = new CompteEstalvi("2222");
        CompteEstalvi cE3 = new CompteEstalvi("1111");
        cE.ingressar(1000);
        cE2.ingressar(200);
        Client client = null;
        List<CompteEstalvi> comptes = new ArrayList<>(Arrays.asList(cE,cE2));
        LlistaDeComptes.llistaDeComptes.addAll(comptes);


        //DNI Exception
        client = new Client("Oscar", "López", "52346273B");

        //Not User Account Exception
        try {
            cE.addUser(client);
            System.out.println(cE.getLlista_usuaris());
            cE.removeUser("52346273B");
            System.out.println(cE.getLlista_usuaris());
        } catch (BankAccountException e) {
            e.printStackTrace();
        }

        //Error transfer Exception
        try{
            OperacionsBanc.transferMoney(cE,cE2,40003);
        }catch (BankAccountException e){
            e.printStackTrace();
        }

        //non-existent account Exception
        try{
            OperacionsBanc.transferMoney(cE,cE3,300);
        }catch (BankAccountException e){
            e.printStackTrace();
        }
        //Account Exception
        try{
            cE2.treure(10500);
        } catch (BankAccountException e){
            e.printStackTrace();
        }
    }
}

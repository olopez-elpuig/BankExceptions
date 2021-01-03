package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;
import Excepcions.ActivitatExceptions.Model.Comptes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperacionsBanc {

    public static boolean verifyDNI(String dni) {
        boolean dniCorrecto = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(dni);

        if (matcher.matches()) {

            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);

            dniCorrecto = reference.equalsIgnoreCase(letra);
        }
        return dniCorrecto;
    }

    public static void transferMoney(CompteEstalvi compteEstalvi1, CompteEstalvi compteEstalvi2, double moneyToTransfer) throws BankAccountException {
        if (Comptes.llistaDeComptes.contains(compteEstalvi1) && Comptes.llistaDeComptes.contains(compteEstalvi2)) {
            if (compteEstalvi1.getSaldo() >= moneyToTransfer) {
                compteEstalvi1.treure(moneyToTransfer);
                compteEstalvi2.ingressar(moneyToTransfer);
            } else {
                throw new BankAccountException(ExceptionMessage.TRANSFER_ERROR);
            }
        } else {
            throw new BankAccountException(ExceptionMessage.ACCOUNT_NOT_FOUND);
        }

    }
}
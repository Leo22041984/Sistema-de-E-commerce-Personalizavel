package com.exemplo.ecommerce.util;

import java.text.NumberFormat;
import java.util.Locale;
//Método em JavaScript para a formatação do preço para salvar no banco de dados 
public class NumberFormatterUtil {
    public static String formatCurrency(double value) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return currencyFormat.format(value);
    }
}


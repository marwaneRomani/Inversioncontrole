package com.marwane;

import com.marwane.dao.DaoImpl;
import com.marwane.dao.IDao;
import com.marwane.metier.IMetier;
import com.marwane.metier.MetierImpl;

public class Main {
    public static void main(String[] args) {
        IDao dao = new DaoImpl();
        IMetier metier = new MetierImpl(dao);
        System.out.println("Résultat static : " + metier.calcul());
    }
}

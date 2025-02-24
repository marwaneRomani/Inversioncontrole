package com.marwane;

import com.marwane.dao.IDao;
import com.marwane.metier.IMetier;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainDynamic {
    public static void main(String[] args) throws Exception {
        // Load config.txt from resources
        InputStream inputStream = MainDynamic.class.getClassLoader().getResourceAsStream("config.txt");
        if (inputStream == null) {
            throw new RuntimeException("config.txt not found in resources folder!");
        }

        Scanner scanner = new Scanner(inputStream);
        String daoClassName = scanner.nextLine();
        String metierClassName = scanner.nextLine();
        scanner.close();

        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);
        setDaoMethod.invoke(metier, dao);

        System.out.println("Résultat dynamic : " + metier.calcul());
    }
}

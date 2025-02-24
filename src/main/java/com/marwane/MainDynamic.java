package com.marwane;

import com.marwane.dao.IDao;
import com.marwane.metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainDynamic {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        String metierClassName = scanner.nextLine();
        scanner.close();

        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);
        setDaoMethod.invoke(metier, dao);

        System.out.println("Résultat : " + metier.calcul());
    }
}

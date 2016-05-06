package dao.products;


import dao.cart.ShoppingCart;
import entity.orders.OrderProductEntity;
import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by grigacs on 4/21/2016.
 */
@Named
@ViewScoped
public class chartJava implements Serializable {

    private LineChartModel lineModel2;


    private static final Logger LOGGER = Logger.getLogger(chartJava.class.getSimpleName());
    private List<windowsClass> win7 = new ArrayList<>();
    private List<windowsClass> win8 = new ArrayList<>();
    private List<windowsClass> win10 = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        createLineModels();
    }


    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    private void createLineModels() {
        lineModel2 = initCategoryModel();
        lineModel2.setExtender("customExtender");
        lineModel2.setTitle("Annual sales breakdown (Operation Systems)");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.setAnimate(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        lineModel2.setSeriesColors("f1c40f,2980b9,2c3e50,F52F2F,A30303");
        lineModel2.setShadow(false);

        Axis yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Sold numbers");
        yAxis.setMin(0);
        yAxis.setMax(8);
    }


    public List<windowsClass> numPerYear(List<windowsClass> win, String name) {
        List<Object[]> results = entityManager.createQuery("select p.orderDate, p.productsName, count(p.orderDate) from OrderProductEntity p  group by p.orderDate, p.productsName order by p.orderDate asc").getResultList();

        String[] dateYear;
        String Year;
        for (Object[] result : results) {
            java.sql.Date sDate = (java.sql.Date) result[0];
            String pName = (String) result[1];
            int sProduct = ((Number) result[2]).intValue();
            dateYear = sDate.toString().split("\\-");
            Year = dateYear[0];
            LOGGER.info(sDate + " " + pName + " " + sProduct);
            if (pName.equals("Windows 7") && name.equals("Windows 7")) {
                win.add(new windowsClass(Year, pName, sProduct));
                LOGGER.info(sDate + " " + pName + " " + sProduct);
            }

            if (pName.equals("Windows 8.1") && name.equals("Windows 8")) {
                win.add(new windowsClass(Year, pName, sProduct));
                LOGGER.info(sDate + " " + pName + " " + sProduct);
            }

            if (pName.equals("Windows 10") && name.equals("Windows 10")) {
                win.add(new windowsClass(Year, pName, sProduct));
                LOGGER.info(sDate + " " + pName + " " + sProduct);
            }

        }
        return win;
    }

    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();


        ChartSeries windows7 = new ChartSeries();
        windows7.setLabel("windows 7");

        ChartSeries windows8 = new ChartSeries();
        windows8.setLabel("windows 8.1");


        ChartSeries windows10 = new ChartSeries();
        windows10.setLabel("windows 10");

        String curr = null;
        int currNum = 0;
        for (windowsClass query : numPerYear(win7, "Windows 7")) {
            if (curr != null && curr.equals(query.getDate()) && currNum != 0) {
                query.setCountNum(query.getCountNum() + currNum);
            }
            LOGGER.info(query.getDate() + " " + query.getCountNum());
            windows7.set(query.getDate(), query.getCountNum());
            curr = query.getDate();
            currNum = query.getCountNum();
        }

        for (windowsClass query : numPerYear(win8, "Windows 8")) {
            if (curr != null && curr.equals(query.getDate()) && currNum != 0) {
                query.setCountNum(query.getCountNum() + currNum);
            }
            LOGGER.info(query.getDate() + " " + query.getCountNum());
            windows8.set(query.getDate(), query.getCountNum());
            curr = query.getDate();
            currNum = query.getCountNum();
        }

        for (windowsClass query : numPerYear(win10, "Windows 10")) {
            if (curr != null && curr.equals(query.getDate()) && currNum != 0) {
                query.setCountNum(query.getCountNum() + currNum);
            }
            LOGGER.info(query.getDate() + " " + query.getCountNum());
            windows10.set(query.getDate(), query.getCountNum());
            curr = query.getDate();
            currNum = query.getCountNum();
        }


        model.addSeries(windows7);
        model.addSeries(windows8);
        model.addSeries(windows10);

        return model;
    }
}

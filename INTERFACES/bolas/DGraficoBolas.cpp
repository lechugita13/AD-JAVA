#include "DGraficoBolas.h"
#include <QColor>
#include<QDebug>
#include <QTimer>

#include <QWidget>
DGraficoBolas::DGraficoBolas(QVector<BolaYWidget*> *bolas,QWidget *parent){
     setupUi(this);
    QBarSet *set0 = new QBarSet("Jane");
   

    *set0 << 1 << 2 << 3 << 4 << 5 << 6;
    
    

     
    series = new QBarSeries();
    series->append(set0);

     chart = new QChart();
    chart->addSeries(series);
    chart->setTitle("Bolas");
    chart->setAnimationOptions(QChart::SeriesAnimations);



 
    categories << "Jan" << "Feb" << "Mar" << "Apr" << "May" << "Jun";
    QBarCategoryAxis *axisX = new QBarCategoryAxis();
    axisX->append(categories);
    chart->addAxis(axisX, Qt::AlignBottom);
    series->attachAxis(axisX);

    QValueAxis *axisY = new QValueAxis();
    axisY->setRange(0,15);
    chart->addAxis(axisY, Qt::AlignLeft);
    series->attachAxis(axisY);



    chart->legend()->setVisible(true);
    chart->legend()->setAlignment(Qt::AlignBottom);



    chartView = new QChartView(chart);
    chartView->setRenderHint(QPainter::Antialiasing);
     layout = new QHBoxLayout();
     
     layout->addWidget(chartView);
     setLayout(layout);
     resize(420, 300);
    
}